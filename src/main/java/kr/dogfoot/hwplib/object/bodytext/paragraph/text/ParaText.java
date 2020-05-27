package kr.dogfoot.hwplib.object.bodytext.paragraph.text;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * 문단의 텍스트 레코드
 *
 * @author neolord
 */
public class ParaText {
    /**
     * 글자(Character) 리스트
     */
    private ArrayList<HWPChar> charList;

    /**
     * 생성자
     */
    public ParaText() {
        charList = new ArrayList<HWPChar>();
    }

    /**
     * 새로운 [일반 Character]를 생성하고 리스트에 추가한다.
     *
     * @return 새로 생성된 [일반 Character]
     */
    public HWPCharNormal addNewNormalChar() {
        HWPCharNormal nc = new HWPCharNormal();
        charList.add(nc);
        return nc;
    }

    /**
     * 새로운 [문자 컨트롤 Character]를 생성하고 리스트에 추가한다.
     *
     * @return 새로 생성된 [문자 컨트롤 Character]
     */
    public HWPCharControlChar addNewCharControlChar() {
        HWPCharControlChar ccc = new HWPCharControlChar();
        charList.add(ccc);
        return ccc;
    }

    /**
     * 새로운 [인라인 컨트롤 Character]를 생성하고 리스트에 추가한다.
     *
     * @return 새로 생성된 [인라인 컨트롤 Character]
     */
    public HWPCharControlInline addNewInlineControlChar() {
        HWPCharControlInline icc = new HWPCharControlInline();
        charList.add(icc);
        return icc;
    }

    /**
     * 새로운 [확장 컨트롤 Character]를 생성하고 리스트에 추가한다.
     *
     * @return 새로 생성된 [확장 컨트롤 Character]
     */
    public HWPCharControlExtend addNewExtendControlChar() {
        HWPCharControlExtend ecc = new HWPCharControlExtend();
        charList.add(ecc);
        return ecc;
    }

    /**
     * 글자(Character) 리스트를 반환한다.
     *
     * @return 글자(Character) 리스트
     */
    public ArrayList<HWPChar> getCharList() {
        return charList;
    }

    /**
     * 확장 컨트롤 Character 순번에 해당하는 글자의 문단 내의 순번을 반환한다.
     *
     * @param extendCharIndex 확장 컨트롤 Character 순번
     * @return 확장 컨트롤 Character 순번에 해당하는 글자의 문단 내의 순번
     */
    public int getCharIndexFromExtendCharIndex(int extendCharIndex) {
        int extendCharIndex2 = 0;
        int count = charList.size();
        for (int index = 0; index < count; index++) {
            if (charList.get(index).getType() == HWPCharType.ControlExtend) {
                if (extendCharIndex == extendCharIndex2) {
                    return index;
                }
                extendCharIndex2++;
            }
        }
        return -1;
    }

    /**
     * startIndex 순번부터 코드가 charCode인 인라인 컨트롤 character의 순번을 반환한다.
     *
     * @param startIndex 검색을 시작할 순번
     * @param charCode   찾을 인라인 컨트롤 character의 코드
     * @return 인라인 컨트롤 character의 순번
     */
    public int getInlineCharIndex(int startIndex, short charCode) {
        int count = charList.size();
        for (int index = startIndex; index < count; index++) {
            HWPChar ch = charList.get(index);
            if (ch.getType() == HWPCharType.ControlInline
                    && ch.getCode() == charCode) {
                return index;
            }
        }
        return -1;
    }

    /**
     * startIndex 순번 부터 endIndex 순번 까지의 일반 Character의 문자열을 반환한다.
     *
     * @param startIndex 시작 순번
     * @param endIndex   끝 순번
     * @return startIndex 순번 부터 endIndex 순번 까지의 일반 Character의 문자열
     * @throws UnsupportedEncodingException
     */
    public String getNormalString(int startIndex, int endIndex) throws UnsupportedEncodingException {
        if (startIndex == endIndex) {
            return "";
        }
        if (startIndex > endIndex) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        for (int index = startIndex; index <= endIndex; index++) {
            HWPChar ch = charList.get(index);
            if (ch.getType() == HWPCharType.Normal) {
                HWPCharNormal chn = (HWPCharNormal) ch;
                sb.append(chn.getCh());
            }
        }
        return sb.toString();
    }

    /**
     * startIndex 순번 부터 끝까지의 일반 Character의 문자열을 반환한다
     *
     * @param startIndex 시작 순번
     * @return startIndex 순번 부터 끝까지의 일반 Character의 일반 Character의 문자열
     * @throws UnsupportedEncodingException
     */
    public String getNormalString(int startIndex) throws UnsupportedEncodingException {
        return getNormalString(startIndex, charList.size() - 1);
    }

    /**
     * 문자열을 추가한다.
     *
     * @param str 추가할 문자열
     * @throws UnsupportedEncodingException
     */
    public void addString(String str) throws UnsupportedEncodingException {
        int len = str.length();
        for (int index = 0; index < len; index++) {
            HWPCharNormal ch = addNewNormalChar();
            ch.setCode((short) str.codePointAt(index));
        }
        processEndOfParagraph();
    }

    /**
     * 구역 정의 컨트롤를 추가하기 위한  확장 컨트롤 문자를 추가한다.
     */
    public void addExtendCharForSectionDefine() {
        HWPCharControlExtend chExtend = addNewExtendControlChar();
        chExtend.setCode((short) 0x0002);
        byte[] addition = new byte[12];
        addition[3] = 's';
        addition[2] = 'e';
        addition[1] = 'c';
        addition[0] = 'd';
        try {
            chExtend.setAddition(addition);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        processEndOfParagraph();
    }

    /**
     * 문단 끝을 나타내는 문자를 찾아서 마지막으로 보낸다.
     */
    private void processEndOfParagraph() {
        for (HWPChar ch : charList) {
            if (ch.getCode() == 0x0d/*para break*/) {
                charList.remove(ch);
                break;
            }
        }
        HWPCharNormal ch2 = addNewNormalChar();
        ch2.setCode((short) 0x0d);
    }

    /**
     * 단 정의 컨트롤를 추가하기 위한  확장 컨트롤 문자를 추가한다.
     */
    public void addExtendCharForColumnDefine() {
        HWPCharControlExtend chExtend = addNewExtendControlChar();
        chExtend.setCode((short) 0x0002);
        byte[] addition = new byte[12];
        addition[3] = 'c';
        addition[2] = 'o';
        addition[1] = 'l';
        addition[0] = 'd';
        try {
            chExtend.setAddition(addition);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        processEndOfParagraph();
    }


    /**
     * 표 컨트롤를 추가하기 위한  확장 컨트롤 문자를 추가한다.
     */
    public void addExtendCharForTable() {
        HWPCharControlExtend chExtend = addNewExtendControlChar();
        chExtend.setCode((short) 0x000b);
        byte[] addition = new byte[12];
        addition[3] = 't';
        addition[2] = 'b';
        addition[1] = 'l';
        addition[0] = ' ';
        try {
            chExtend.setAddition(addition);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        processEndOfParagraph();
    }

    /**
     * 그리기 개체 컨트롤를 추가하기 위한  확장 컨트롤 문자를 추가한다.
     */
    public void addExtendCharForGSO() {
        HWPCharControlExtend chExtend = addNewExtendControlChar();
        chExtend.setCode((short) 0x000b);
        byte[] addition = new byte[12];
        addition[3] = 'g';
        addition[2] = 's';
        addition[1] = 'o';
        addition[0] = ' ';
        try {
            chExtend.setAddition(addition);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        processEndOfParagraph();
    }

    /**
     * 하이퍼 링크의 시작을 위한 확장 컨트롤 문자를 추가한다.
     */
    public void addExtendCharForHyperlinkStart() {
        HWPCharControlExtend chExtend = addNewExtendControlChar();
        chExtend.setCode((short) 0x0003);
        byte[] addition = new byte[12];
        addition[3] = '%';
        addition[2] = 'h';
        addition[1] = 'l';
        addition[0] = 'k';
        try {
            chExtend.setAddition(addition);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        processEndOfParagraph();
    }

    /**
     * 하이퍼 링크의 끝을 위한 확장 컨트롤 문자를 추가한다.
     */
    public void addExtendCharForHyperlinkEnd() {
        HWPCharControlExtend chExtend = addNewExtendControlChar();
        chExtend.setCode((short) 0x0004);
        byte[] addition = new byte[12];
        addition[3] = '%';
        addition[2] = 'h';
        addition[1] = 'l';
        addition[0] = 'k';
        try {
            chExtend.setAddition(addition);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        processEndOfParagraph();
    }
}
