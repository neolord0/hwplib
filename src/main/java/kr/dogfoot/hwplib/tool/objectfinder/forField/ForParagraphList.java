package kr.dogfoot.hwplib.tool.objectfinder.forField;

import kr.dogfoot.hwplib.object.bodytext.ParagraphListInterface;
import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.ControlField;
import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.bodytext.paragraph.charshape.CharPositionShapeIdPair;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPChar;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPCharType;
import kr.dogfoot.hwplib.tool.objectfinder.SetFieldResult;
import kr.dogfoot.hwplib.tool.objectfinder.TextBuffer;
import kr.dogfoot.hwplib.tool.objectfinder.forField.gettext.ForControl;
import kr.dogfoot.hwplib.tool.objectfinder.forField.gettext.ForControlWithAllField;
import kr.dogfoot.hwplib.tool.paragraphadder.ParaTextSetter;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractMethod;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * 문단리스트, 문단에서 필드 객체를 찾는 기능을 포함하는 클래스
 *
 * @author neolord
 */
public class ForParagraphList {
    /**
     * 문단리스트에서 필드 객체의 텍스트를 찾아 반환한다.
     *
     * @param paragraphList 문단리스트
     * @param fieldType     필드 타입
     * @param fieldName     필드 이름
     * @param temInField    필드 안에 텍스트의 텍스트 추출 방법
     * @return 필드 텍스트
     * @throws UnsupportedEncodingException
     */
    public static String getFieldText(ParagraphListInterface paragraphList, ControlType fieldType, String fieldName,
                                      TextExtractMethod temInField) throws UnsupportedEncodingException {
        if (paragraphList == null) {
            return null;
        }
        ArrayList<FindPosition> results = getFieldStartPosition(paragraphList, fieldType, fieldName, false);
        if (results.size() > 0) {
            if (getFieldEndPosition(paragraphList, results.get(0))) {
                return getText(paragraphList, results.get(0), temInField);
            }
        }
        return getFieldTextForControl(paragraphList, fieldType, fieldName, temInField);
    }

    /**
     * 문단리스트에서 필드 객체의 시작 위치를 반환한다.
     *
     * @param paragraphList 문단리스트
     * @param fieldType     필드 타입
     * @param fieldName     필드 이름
     * @param allField      이름이 같은 모든 필드를 찾을 것인지 여부
     * @return 찾은 필드의 위치 리스트
     * @throws UnsupportedEncodingException
     */
    private static ArrayList<FindPosition> getFieldStartPosition(ParagraphListInterface paragraphList, ControlType fieldType, String fieldName, boolean allField) {
        ArrayList<FindPosition> results = new ArrayList<>();
        int paraCount = paragraphList.getParagraphCount();
        for (int paraIndex = 0; paraIndex < paraCount; paraIndex++) {
            Paragraph p = paragraphList.getParagraph(paraIndex);
            int fieldCharIndex = findFieldCharIndex(p, fieldType, fieldName);
            if (fieldCharIndex != -1) {
                results.add(new FindPosition(paraIndex, fieldCharIndex));
                if (allField == false) {
                    return results;
                }
            }
        }
        return results;
    }

    /**
     * 문단내에서 필드 객체의 위치를 반환한다.
     *
     * @param p 문단
     * @param fieldType     필드 타입
     * @param fieldName     필드 이름
     * @return 찾은 필드의 문단 내부의 위치
     * @throws UnsupportedEncodingException
     */
    private static int findFieldCharIndex(Paragraph p, ControlType fieldType, String fieldName) {
        if (p.getControlList() == null) {
            return -1;
        }
        int ctrlCount = p.getControlList().size();
        for (int ctrlIndex = 0; ctrlIndex < ctrlCount; ctrlIndex++) {
            Control c = p.getControlList().get(ctrlIndex);
            if (c.getType() == fieldType) {
                ControlField cf = (ControlField) c;
                if (cf.getName() != null && cf.getName().equals(fieldName)) {
                    return p.getText().getCharIndexFromExtendCharIndex(ctrlIndex);
                }
            }
        }
        return -1;
    }

    /**
     * 문단 리스트에서 position에서 시작된 필드의 끝 위치를 반환한다.
     *
     * @param paragraphList 문단 리스트
     * @param position      찾을 필드의 위치
     * @return 필드 끝을 찾았는지 여부
     * @throws UnsupportedEncodingException
     */
    private static boolean getFieldEndPosition(ParagraphListInterface paragraphList, FindPosition position) {
        int depth = 0;
        int paraCount = paragraphList.getParagraphCount();
        for (int paraIndex = position.startParaIndex; paraIndex < paraCount; paraIndex++) {
            Paragraph p = paragraphList.getParagraph(paraIndex);
            if (p.getText() != null) {
                int startIndex = (paraIndex == position.startParaIndex) ? position.startCharIndex + 1 : 0;
                int charCount = p.getText().getCharList().size();
                for (int charIndex = startIndex; charIndex < charCount; charIndex++) {
                    HWPChar hwpChar = p.getText().getCharList().get(charIndex);
                    if (hwpChar.getCode() == 0x3/*field start*/) {
                        depth++;
                    } else if (hwpChar.getCode() == 0x4/*field end*/) {
                        if (depth == 0) {
                            position.endPosition(paraIndex, charIndex);
                            return true;
                        } else {
                            depth--;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * 문단 리스트에서 position 위치에 있는 문자열을 반환한다.
     *
     * @param paragraphList 문단 리스트
     * @param position      위치
     * @param temInField    필드 안에 텍스트의 텍스트 추출 방법
     * @return 필드 끝을 찾았는지 여부
     * @throws UnsupportedEncodingException
     */
    private static String getText(ParagraphListInterface paragraphList, FindPosition position, TextExtractMethod temInField) throws UnsupportedEncodingException {
        StringBuffer sb = new StringBuffer();
        for (int paraIndex = position.startParaIndex; paraIndex <= position.endParaIndex; paraIndex++) {
            int startCharIndex = (paraIndex == position.startParaIndex) ? position.startCharIndex : 0;
            int endCharIndex = (paraIndex == position.endParaIndex) ? position.endCharIndex : (paragraphList.getParagraph(paraIndex).getText() == null) ? 0 : paragraphList.getParagraph(paraIndex).getText().getCharList().size();
            kr.dogfoot.hwplib.tool.textextractor.ForParagraphList.extract(paragraphList.getParagraph(paraIndex), startCharIndex, endCharIndex, temInField, null, sb);
        }
        return sb.toString();
    }


    private static void deleteSegItmes(FindPosition result) {

    }


    /**
     * 문단 리스트에 포함된 컨트롤에서 필드 객체의 텍스트를 찾아 반환한다.
     *
     * @param paragraphList 문단 리스트
     * @param fieldType     필드 타입
     * @param fieldName     필드 이름
     * @param temInField    필드 안에 텍스트의 텍스트 추출 방법
     * @return 필드 텍스트
     * @throws UnsupportedEncodingException
     */
    private static String getFieldTextForControl(ParagraphListInterface paragraphList, ControlType fieldType,
                                                 String fieldName, TextExtractMethod temInField) throws UnsupportedEncodingException {
        for (Paragraph p : paragraphList) {
            ArrayList<Control> controlList = p.getControlList();
            if (controlList != null) {
                for (Control c : controlList) {
                    String text = ForControl.getFieldText(c, fieldType, fieldName, temInField);
                    if (text != null) {
                        return text;
                    }
                }
            }
        }
        return null;
    }

    //------------------------------------------------------------------------------------------------------------------

    /**
     * 문단리스트에서 이름이 같은 모든 필드 객체의 텍스트를 찾아 텍스트를 리스트에 추가한다.
     *
     * @param paragraphList 문단리스트
     * @param fieldType     필드 타입
     * @param fieldName     필드 이름
     * @param temInField    필드 안에 텍스트의 텍스트 추출 방법
     * @param textList      반환할 필드 텍스트 리스트
     */
    public static void getAllFieldText(ParagraphListInterface paragraphList, ControlType fieldType, String fieldName, TextExtractMethod temInField, ArrayList<String> textList) throws UnsupportedEncodingException {
        if (paragraphList == null) {
            return;
        }
        ArrayList<FindPosition> results = getFieldStartPosition(paragraphList, fieldType, fieldName, true);
        for (FindPosition result : results) {
            if (getFieldEndPosition(paragraphList, result)) {
                textList.add(getText(paragraphList, result, temInField));
                deleteSegItmes(result);
            }
        }
        getAllFieldTextForControl(paragraphList, fieldType, fieldName, temInField, textList);
    }

    /**
     * 문단 리스트에 포함된 컨트롤에서 이름이 같은 모든 필드 객체의 텍스트를 찾아 텍스트를 리스트에 추가한다.
     *
     * @param paragraphList 문단 리스트
     * @param fieldType     필드 타입
     * @param fieldName     필드 이름
     * @param temInField    필드 안에 텍스트의 텍스트 추출 방법
     * @param textList      반환할 필드 텍스트 리스트
     */
    private static void getAllFieldTextForControl(ParagraphListInterface paragraphList, ControlType fieldType, String fieldName, TextExtractMethod temInField, ArrayList<String> textList) throws UnsupportedEncodingException {
        for (Paragraph p : paragraphList) {
            ArrayList<Control> controlList = p.getControlList();
            if (controlList != null) {
                for (Control c : controlList) {
                    ForControlWithAllField.getFieldText(c, fieldType, fieldName, temInField, textList);
                }
            }
        }
    }

    /**
     * 문단리스트에 포함된 필드 객체의 텍스트를 설정한다.
     *
     * @param paragraphList 문단 리스트
     * @param fieldType     필드 타입
     * @param fieldName     필드 이름
     * @param textBuffer    텍스트
     * @return 필드 설정 결과값
     */
    public static SetFieldResult setFieldText(ParagraphListInterface paragraphList, ControlType fieldType,
                                              String fieldName, TextBuffer textBuffer) throws UnsupportedEncodingException {
        if (paragraphList == null) {
            return SetFieldResult.InProcess;
        }

        ArrayList<FindPosition> results = getFieldStartPosition(paragraphList, fieldType, fieldName, true);
        for (FindPosition result : results) {
            if (getFieldEndPosition(paragraphList, result)) {
                if (textBuffer.hasNext()) {
                    changeText(paragraphList, result, textBuffer.nextText());
                    deleteLineSeg(paragraphList, result);
                } else {
                    return SetFieldResult.NotEnoughText;
                }
            }
        }
        return setFieldTextForControls(paragraphList, fieldType, fieldName, textBuffer);
    }


    /**
     * 문단 리스트에 특정 위치에 문자열을 변경한다.
     *
     * @param paragraphList 문단 리스트
     * @param position      문단 내의 위치
     * @param text          텍스트
     */
    private static void changeText(ParagraphListInterface paragraphList, FindPosition position, String text) throws UnsupportedEncodingException {
        if (position.startParaIndex != position.endParaIndex) {
            Paragraph startPara = paragraphList.getParagraph(position.startParaIndex);
            Paragraph endPara = paragraphList.getParagraph(position.endParaIndex);
            deleteParaTextFrom(startPara, position.startCharIndex + 1);
            deleteParaTextTo(endPara, position.endCharIndex - 1);
            startPara.getText().addString(text);
            mergeParagraph(startPara, endPara);
            paragraphList.deleteParagraph(position.endParaIndex);

            if (position.endParaIndex - position.startParaIndex >= 2) {
                for (int deleteIndex = 0; deleteIndex < position.endParaIndex - position.startParaIndex - 1; deleteIndex++) {
                    paragraphList.deleteParagraph(position.startParaIndex + 1);
                }
            }
        } else {
            Paragraph para = paragraphList.getParagraph(position.startParaIndex);
            ParaTextSetter.changeText(para, position.startCharIndex + 1, position.endCharIndex - 1, text);
        }
    }

    private static void deleteLineSeg(ParagraphListInterface paragraphList, FindPosition result) {
        for (int paraIndex = result.startParaIndex; paraIndex <= result.endParaIndex; paraIndex++) {
            paragraphList.getParagraph(paraIndex).deleteLineSeg();;
        }
    }

    /**
     * 문단에 텍스트를 from 위치부터 삭제한다.
     *
     * @param p     문단
     * @param from  삭제할 시작 위치
     */
    private static void deleteParaTextFrom(Paragraph p, int from) {
        int leftCtrlCount = 0;
        int leftCharSize = 0;
        if (p.getText() != null) {
            for (int charIndex = 0; charIndex < from; charIndex++) {
                HWPChar hwpChar = p.getText().getCharList().get(charIndex);
                if (hwpChar.getType() == HWPCharType.ControlExtend) {
                    leftCtrlCount++;
                }
                leftCharSize += hwpChar.getCharSize();
            }
            int deleteCharCount = p.getText().getCharList().size() - from - 1;
            for(int index = 0; index < deleteCharCount; index++) {
                p.getText().getCharList().remove(from);
            }
        }
        if (p.getControlList() != null) {
            int deleteCtrlCount = p.getControlList().size() - leftCtrlCount;
            for (int index = 0; index < deleteCtrlCount; index++) {
                p.getControlList().remove(leftCtrlCount);
            }
        }

        ArrayList<CharPositionShapeIdPair> deleting = new ArrayList<>();
        for (CharPositionShapeIdPair cpsip : p.getCharShape().getPositonShapeIdPairList()) {
            if (cpsip.getPosition() > leftCharSize) {
                deleting.add(cpsip);
            }
        }
        for (CharPositionShapeIdPair cpsip : deleting) {
            p.getCharShape().getPositonShapeIdPairList().remove(cpsip);
        }
    }

    /**
     * 문단에 텍스트를 to 위치까지 삭제한다.
     *
     * @param p     문단
     * @param to    삭제할 끝 위치
     */
    private static void deleteParaTextTo(Paragraph p, int to) {
        int deleteCtrlCount = 0;
        int deleteCharSize = 0;
        if (p.getText() != null) {
            for (int charIndex = 0; charIndex < to - 1; charIndex++) {
                HWPChar hwpChar = p.getText().getCharList().get(charIndex);
                if (hwpChar.getType() == HWPCharType.ControlExtend) {
                    deleteCtrlCount++;
                }
            }

            for (int index = 0; index < to + 1; index++) {
                deleteCharSize += p.getText().getCharList().get(0).getCharSize();
                p.getText().getCharList().remove(0);
            }
        }
        if (p.getControlList() != null) {
            for (int index = 0; index < deleteCtrlCount; index++) {
                p.getControlList().remove(0);
            }
        }

        for (CharPositionShapeIdPair cpsip : p.getCharShape().getPositonShapeIdPairList()) {
            if (cpsip.getPosition() != 0) {
                if (cpsip.getPosition() < to + 1) {
                    p.getCharShape().getPositonShapeIdPairList().remove(cpsip);
                } else {
                    cpsip.setPosition(cpsip.getPosition() - deleteCharSize);
                }
            }
        }
    }

    /**
     * 문단 para1 끝에 문단 para2을 병합한다.
     *
     * @param para1    문단1
     * @param para2    문단2
     */
    private static void mergeParagraph(Paragraph para1, Paragraph para2) {
        int para1CharSize = para1.getText().getCharSize();
        para1.getText().getCharList().remove(para1.getText().getCharList().size() - 1);
        para1CharSize -= 1;


        if (para2.getText() != null && para2.getText().getCharList().size() > 0) {
            if (para1.getText() == null) {
                para1.createText();
            }
            for (HWPChar hwpChar : para2.getText().getCharList()) {
                para1.getText().getCharList().add(hwpChar);
            }
        }

        if (para2.getControlList() != null && para2.getControlList().size() > 0) {
            if (para1.getControlList() == null) {
                para1.createControlList();
            }
            for (Control control : para2.getControlList()) {
                para1.getControlList().add(control);
            }
        }

        if (para2.getCharShape() != null && para2.getCharShape().getPositonShapeIdPairList().size() > 0) {
            if (para1.getCharShape() == null) {
                para1.createCharShape();
            }
            for (CharPositionShapeIdPair cpsip : para2.getCharShape().getPositonShapeIdPairList()) {
                cpsip.setPosition(cpsip.getPosition() + para1CharSize);
                para1.getCharShape().getPositonShapeIdPairList().add(cpsip);
            }
        }
    }

    /**
     * 문단에 포함된 컨트롤에서 필드 객체의 텍스트를 설정한다.
     *
     * @param paragraphList 문단
     * @param fieldType     필드 타입
     * @param fieldName     필드 이름
     * @param textBuffer    텍스트 버퍼
     * @return 필드 설정 결과값
     */
    private static SetFieldResult setFieldTextForControls(ParagraphListInterface paragraphList, ControlType fieldType, String fieldName,
                                                          TextBuffer textBuffer) throws UnsupportedEncodingException {
        for (Paragraph p : paragraphList) {
            ArrayList<Control> controlList = p.getControlList();
            if (controlList != null) {
                for (Control c : controlList) {
                    if (kr.dogfoot.hwplib.tool.objectfinder.forField.settext.ForControl.setFieldText(c, fieldType,
                            fieldName, textBuffer) == SetFieldResult.NotEnoughText) {
                        return SetFieldResult.NotEnoughText;
                    }
                }
            }
        }
        return SetFieldResult.InProcess;
    }

    private static class FindPosition {
        int startParaIndex;
        int startCharIndex;
        int endParaIndex;
        int endCharIndex;

        public FindPosition(int startParaIndex, int startCharIndex) {
            this.startParaIndex = startParaIndex;
            this.startCharIndex = startCharIndex;
        }

        public void endPosition(int endParaIndex,int endCharIndex) {
            this.endParaIndex = endParaIndex;
            this.endCharIndex = endCharIndex;
        }

        public String toString() {
            return startParaIndex + ":" + startCharIndex + " ~ " + endParaIndex + ":" + endCharIndex;
        }
    }
}
