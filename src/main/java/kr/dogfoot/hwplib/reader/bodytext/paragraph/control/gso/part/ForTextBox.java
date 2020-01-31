package kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso.part;

import kr.dogfoot.hwplib.object.bodytext.control.bookmark.ParameterItem;
import kr.dogfoot.hwplib.object.bodytext.control.bookmark.ParameterSet;
import kr.dogfoot.hwplib.object.bodytext.control.bookmark.ParameterType;
import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.ListHeaderForTextBox;
import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.TextBox;
import kr.dogfoot.hwplib.reader.bodytext.ForParagraphList;
import kr.dogfoot.hwplib.reader.bodytext.paragraph.control.bookmark.ForParameterSet;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 글상자를 읽기 위한 객체
 *
 * @author neolord
 */
public class ForTextBox {
    /**
     * 글상자를 읽는다.
     *
     * @param textBox 글상자
     * @param sr      스트림 리더
     * @throws Exception
     */
    public static void read(TextBox textBox, StreamReader sr) throws Exception {
        listHeader(textBox.getListHeader(), sr);
        ForParagraphList.read(textBox.getParagraphList(), sr);
    }

    /**
     * 글상자의 문단 리스트 헤더 레코드를 읽는다.
     *
     * @param lh 글상자의 문단 리스트 헤더 레코드
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void listHeader(ListHeaderForTextBox lh, StreamReader sr)
            throws IOException {
        lh.setParaCount(sr.readSInt4());
        lh.getProperty().setValue(sr.readUInt4());
        lh.setLeftMargin(sr.readUInt2());
        lh.setRightMargin(sr.readUInt2());
        lh.setTopMargin(sr.readUInt2());
        lh.setBottomMargin(sr.readUInt2());
        lh.setTextWidth(sr.readUInt4());

        if (sr.isEndOfRecord() == false) {
            unknownBytes(8, sr);
        }

        if (sr.isEndOfRecord() == false) {
            int temp = sr.readSInt4();
            if (temp == 1) {
                lh.setEditableAtFormMode(true);
            } else {
                lh.setEditableAtFormMode(false);
            }

            short flag = sr.readUInt1();
            if (flag == 0xff) {
                fieldName(lh, sr);
            }
        }
    }

    /**
     * 알려지지 않은 n 바이트틀 처리한다.
     *
     * @param n  알려지지 않은 바이트 개수
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void unknownBytes(int n, StreamReader sr) throws IOException {
        sr.skip(n);
    }

    /**
     * 필드 이름을 읽는다.
     *
     * @param lh 글상자의 문단 리스트 헤더 레코드
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void fieldName(ListHeaderForTextBox lh, StreamReader sr)
            throws IOException {
        ParameterSet ps = new ParameterSet();
        ForParameterSet.read(ps, sr);

        if (ps.getId() == 0x21b) {
            for (ParameterItem pi : ps.getParameterItemList()) {
                if (pi.getId() == 0x4000
                        && pi.getType() == ParameterType.String) {
                    lh.setFieldName(pi.getValue_BSTR());
                }
            }
        }
    }
}
