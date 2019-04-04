package kr.dogfoot.hwplib.reader.docinfo;

import kr.dogfoot.hwplib.object.docinfo.BorderFill;
import kr.dogfoot.hwplib.object.docinfo.borderfill.BorderFillProperty;
import kr.dogfoot.hwplib.object.docinfo.borderfill.BorderThickness;
import kr.dogfoot.hwplib.object.docinfo.borderfill.BorderType;
import kr.dogfoot.hwplib.object.docinfo.borderfill.EachBorder;
import kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo.FillInfo;
import kr.dogfoot.hwplib.reader.docinfo.borderfill.ForFillInfo;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 테두리/배경 레코드를 읽기 위한 객체
 *
 * @author neolord
 */
public class ForBorderFill {
    /**
     * 테두리/배경 레코드를 읽는다.
     *
     * @param bf 테두리/배경 레코드
     * @param sr 스트림 리더
     * @throws IOException
     */
    public static void read(BorderFill bf, StreamReader sr) throws IOException {
        property(bf.getProperty(), sr);
        eachBorder(bf.getLeftBorder(), sr);
        eachBorder(bf.getRightBorder(), sr);
        eachBorder(bf.getTopBorder(), sr);
        eachBorder(bf.getBottomBorder(), sr);
        diagonal(bf, sr);
        fillInfo(bf.getFillInfo(), sr);
    }

    /**
     * 속성 부분을 읽는다.
     *
     * @param p  테두리/배경 속성 부분 객체
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void property(BorderFillProperty p, StreamReader sr)
            throws IOException {
        p.setValue(sr.readUInt2());
    }

    /**
     * 4방향의 테두리를 표현하는 각각의 선를 읽는다.
     *
     * @param eb 4방향의 테두리를 표현하는 각각 선 객체
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void eachBorder(EachBorder eb, StreamReader sr)
            throws IOException {
        eb.setType(BorderType.valueOf((byte) sr.readUInt1()));
        eb.setThickness(BorderThickness.valueOf((byte) sr.readUInt1()));
        eb.getColor().setValue(sr.readUInt4());
    }

    /**
     * 대각선 정보 부분를 읽는다.
     *
     * @param bf 테두리/배경 레코드
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void diagonal(BorderFill bf, StreamReader sr)
            throws IOException {
        bf.setDiagonalSort(BorderType.valueOf((byte) sr.readUInt1()));
        bf.setDiagonalThickness(BorderThickness.valueOf((byte) sr.readUInt1()));
        bf.getDiagonalColor().setValue(sr.readUInt4());
    }

    /**
     * 배경 정보을 읽는다.
     *
     * @param fi 배경 정보 객체
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void fillInfo(FillInfo fi, StreamReader sr)
            throws IOException {
        ForFillInfo.read(fi, sr);
    }
}
