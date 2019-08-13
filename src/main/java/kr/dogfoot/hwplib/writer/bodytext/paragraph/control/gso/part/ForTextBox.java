package kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso.part;

import kr.dogfoot.hwplib.object.bodytext.control.bookmark.ParameterSet;
import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.ListHeaderForTextBox;
import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.TextBox;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.ForParagraphList;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.control.bookmark.ForParameterSet;

import java.io.IOException;

/**
 * 글상자를 쓰기 위한 객체
 *
 * @author 박성균
 */
public class ForTextBox {
    /**
     * 글상자를 쓴다.
     *
     * @param tb 글상자 객체
     * @param sw 스트림 라이터
     * @throws Exception
     */
    public static void write(TextBox tb, StreamWriter sw) throws Exception {
        if (tb == null) {
            return;
        }

        listHeader(tb.getListHeader(), sw);
        ForParagraphList.write(tb.getParagraphList(), sw);
    }

    /**
     * 글상자의 리스트 헤더 레코드를 쓴다.
     *
     * @param lh 글상자의 리스트 헤더 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void listHeader(ListHeaderForTextBox lh, StreamWriter sw)
            throws IOException {
        ParameterSet psFieldName = ParameterSet.createForFieldName(lh
                .getFieldName());

        recordHeader(psFieldName, sw);

        sw.writeSInt4(lh.getParaCount());
        sw.writeUInt4(lh.getProperty().getValue());
        sw.writeUInt2(lh.getLeftMargin());
        sw.writeUInt2(lh.getRightMargin());
        sw.writeUInt2(lh.getTopMargin());
        sw.writeUInt2(lh.getBottomMargin());
        sw.writeUInt4(lh.getTextWidth());
        sw.writeZero(8);
        if (lh.isEditableAtFormMode()) {
            sw.writeSInt4(1);
        } else {
            sw.writeSInt4(0);
        }

        if (psFieldName != null) {
            short flag = 0xff;
            sw.writeUInt1(flag);

            ForParameterSet.write(psFieldName, sw);
        } else {
            short flag = 0x0;
            sw.writeUInt1(flag);
        }
    }

    /**
     * 글상자의 리스트 헤더 레코드의 레코드 헤더를 쓴다.
     *
     * @param psFieldName 필드 이름을 위한 파라미터셋 객체
     * @param sw          스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(ParameterSet psFieldName, StreamWriter sw)
            throws IOException {
        sw.writeRecordHeader(HWPTag.LIST_HEADER, getSize(psFieldName));
    }

    /**
     * 글상자의 리스트 헤더 레코드의 크기를 반환한다.
     *
     * @param psFieldName 필드 이름을 위한 파라미터셋 객체
     * @return 글상자의 리스트 헤더 레코드의 크기
     */
    private static int getSize(ParameterSet psFieldName) {
        int size = 0;
        size += 32;
        if (psFieldName != null) {
            size += 1;
            size += ForParameterSet.getSize(psFieldName);
        } else {
            size += 1;
        }
        return size;
    }
}
