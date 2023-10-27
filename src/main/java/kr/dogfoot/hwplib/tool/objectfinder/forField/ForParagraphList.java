package kr.dogfoot.hwplib.tool.objectfinder.forField;

import kr.dogfoot.hwplib.object.bodytext.ParagraphListInterface;
import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.ControlField;
import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPChar;
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
            int fieldCharIndex = findFieldCharIndex(p, fieldType, fieldName, -1);
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
     * 문단리스트에서 필드 객체의 시작 위치를 반환한다.
     *
     * @param paragraphList  문단리스트
     * @param fieldType      필드 타입
     * @param fieldName      필드 이름
     * @param startParaIndex 찾기 시작할 문단 인덱스
     * @param startCharIndex 찾기 시작할 문자 인덱스
     * @return 찾은 필드의 위치. 없으면 null
     */
    private static FindPosition getFieldStartPosition(ParagraphListInterface paragraphList, ControlType fieldType, String fieldName, int startParaIndex, int startCharIndex) {
        int paraCount = paragraphList.getParagraphCount();
        for (int paraIndex = startParaIndex; paraIndex < paraCount; paraIndex++) {
            Paragraph p = paragraphList.getParagraph(paraIndex);
            int sci = startCharIndex;
            if (paraIndex != startParaIndex) {
                sci = 0;
            }
            int fieldCharIndex = findFieldCharIndex(p, fieldType, fieldName, sci);
            if (fieldCharIndex != -1) {
                return new FindPosition(paraIndex, fieldCharIndex);
            }
        }
        return null;
    }

    /**
     * 문단내에서 필드 객체의 위치를 반환한다.
     *
     * @param p         문단
     * @param fieldType 필드 타입
     * @param fieldName 필드 이름
     * @param startCharIndex 찾기 시작할 문자 인덱스
     * @return 찾은 필드의 문단 내부의 위치
     * @throws UnsupportedEncodingException
     */
    private static int findFieldCharIndex(Paragraph p, ControlType fieldType, String fieldName, int startCharIndex) {
        if (p.getControlList() == null) {
            return -1;
        }
        int ctrlCount = p.getControlList().size();
        for (int ctrlIndex = 0; ctrlIndex < ctrlCount; ctrlIndex++) {
            Control c = p.getControlList().get(ctrlIndex);
            if (c.getType() == fieldType) {
                ControlField cf = (ControlField) c;
                if (cf.getName() != null && cf.getName().equals(fieldName)) {
                    int charIndex = p.getText().getCharIndexFromExtendCharIndex(ctrlIndex);
                    if (charIndex == -1) {
                        return charIndex;
                    }
                    if (startCharIndex >= 0 && charIndex < startCharIndex) {
                        continue;
                    }
                    return charIndex;
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
            kr.dogfoot.hwplib.tool.textextractor.ForParagraph.extract(paragraphList.getParagraph(paraIndex),
                    startCharIndex, endCharIndex,
                    temInField,
                    null,
                    sb);
        }
        return sb.toString();
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

        FindPosition result = getFieldStartPosition(paragraphList, fieldType, fieldName, 0, 0);
        while (result != null) {
            if (getFieldEndPosition(paragraphList, result)) {
                if (textBuffer.hasNext()) {
                    changeText(paragraphList, result, textBuffer.nextText());
                    deleteLineSeg(paragraphList, result);
                } else {
                    return SetFieldResult.NotEnoughText;
                }
            }
            result = getFieldStartPosition(paragraphList, fieldType, fieldName, result.endParaIndex, result.endCharIndex + 1);
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
            ParaTextSetter.deleteParaTextFrom(startPara, position.startCharIndex + 1);
            startPara.getText().addString(text);

            Paragraph endPara = paragraphList.getParagraph(position.endParaIndex);
            ParaTextSetter.deleteParaTextTo(endPara, position.endCharIndex - 1);

            ParaTextSetter.mergeParagraph(startPara, endPara);

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
        // 필드의 텍스트를 변경시 end position변화 대응
        FindPosition nextPosition = new FindPosition(position.startParaIndex, position.startCharIndex + 1);
        if (getFieldEndPosition(paragraphList, nextPosition)) {
            position.endPosition(nextPosition.endParaIndex, nextPosition.endCharIndex);
        }
    }

    private static void deleteLineSeg(ParagraphListInterface paragraphList, FindPosition result) {
        for (int paraIndex = result.startParaIndex; paraIndex <= result.endParaIndex; paraIndex++) {
            paragraphList.getParagraph(paraIndex).deleteLineSeg();
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

        public void endPosition(int endParaIndex, int endCharIndex) {
            this.endParaIndex = endParaIndex;
            this.endCharIndex = endCharIndex;
        }

        public String toString() {
            return startParaIndex + ":" + startCharIndex + " ~ " + endParaIndex + ":" + endCharIndex;
        }
    }
}
