package kr.dogfoot.hwplib.writer.docinfo;

import kr.dogfoot.hwplib.object.docinfo.BorderFill;
import kr.dogfoot.hwplib.object.docinfo.borderfill.EachBorder;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;
import kr.dogfoot.hwplib.writer.docinfo.borderfill.ForFillInfo;

import java.io.IOException;

/**
 * 테두리/배경 레코드를 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForBorderFill {
    /**
     * 테두리/배경 레코드를 쓴다.
     *
     * @param bf 테두리/배경 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    public static void write(BorderFill bf, StreamWriter sw) throws IOException {
        recordHeader(bf, sw);

        sw.writeUInt2(bf.getProperty().getValue());

        eachBorder(bf.getLeftBorder(), sw);
        eachBorder(bf.getRightBorder(), sw);
        eachBorder(bf.getTopBorder(), sw);
        eachBorder(bf.getBottomBorder(), sw);
        diagonalLine(bf, sw);

        ForFillInfo.write(bf.getFillInfo(), sw);
    }

    /**
     * 테두리/배경 레코드의 레코드 헤더를 쓴다.
     *
     * @param bf 테두리/배경 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(BorderFill bf, StreamWriter sw)
            throws IOException {
        sw.writeRecordHeader(HWPTag.BORDER_FILL, getSize(bf));
    }

    /**
     * 테두리/배경 레코드의 크기를 반환한다.
     *
     * @param bf 테두리/배경 레코드
     * @return 테두리/배경 레코드의 크기
     */
    private static int getSize(BorderFill bf) {
        int size = 0;
        size += 2;
        size += (1 + 1 + 4) * 5;
        size += ForFillInfo.getSize(bf.getFillInfo());
        return size;
    }

    /**
     * 4방향의 테두리를 표현하는 각각의 선를 쓴다.
     *
     * @param eb 4방향의 테두리를 표현하는 각각의 선
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void eachBorder(EachBorder eb, StreamWriter sw)
            throws IOException {
        sw.writeUInt1(eb.getType().getValue());
        sw.writeUInt1(eb.getThickness().getValue());
        sw.writeUInt4(eb.getColor().getValue());
    }

    /**
     * 대각선 정보 부분를 쓴다.
     *
     * @param bf 테두리/배경 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void diagonalLine(BorderFill bf, StreamWriter sw)
            throws IOException {
        sw.writeUInt1(bf.getDiagonalSort().getValue());
        sw.writeUInt1(bf.getDiagonalThickness().getValue());
        sw.writeUInt4(bf.getDiagonalColor().getValue());
    }
}
