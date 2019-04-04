package kr.dogfoot.hwplib.writer.docinfo;

import kr.dogfoot.hwplib.object.docinfo.CharShape;
import kr.dogfoot.hwplib.object.docinfo.charshape.*;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.object.fileheader.FileVersion;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 글자 모양 레코드를 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForCharShape {
    /**
     * 글자 모양 레코드를 쓴다.
     *
     * @param cs 글자 모양 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    public static void write(CharShape cs, StreamWriter sw) throws IOException {
        recordHeader(sw);

        faceNameIds(cs.getFaceNameIds(), sw);
        ratios(cs.getRatios(), sw);
        charSpaces(cs.getCharSpaces(), sw);
        relativeSizes(cs.getRelativeSizes(), sw);
        charPositions(cs.getCharOffsets(), sw);

        sw.writeSInt4(cs.getBaseSize());
        sw.writeUInt4(cs.getProperty().getValue());
        sw.writeSInt1(cs.getShadowGap1());
        sw.writeSInt1(cs.getShadowGap2());
        sw.writeUInt4(cs.getCharColor().getValue());
        sw.writeUInt4(cs.getUnderLineColor().getValue());
        sw.writeUInt4(cs.getShadeColor().getValue());
        sw.writeUInt4(cs.getShadowColor().getValue());

        if (sw.getFileVersion().isOver(5, 0, 2, 1)) {
            sw.writeUInt2(cs.getBorderFillId());
        }
        if (sw.getFileVersion().isOver(5, 0, 3, 0)) {
            sw.writeUInt4(cs.getStrikeLineColor().getValue());
        }
    }

    /**
     * 글자 모양 레코드의 레코드 헤더를 쓴다.
     *
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(StreamWriter sw) throws IOException {
        sw.writeRecordHeader(HWPTag.CHAR_SHAPE, getSize(sw.getFileVersion()));
    }

    /**
     * 글자 모양 레코드의 크기를 반환한다.
     *
     * @param version 파일 버전
     * @return 글자 모양 레코드의 크기
     */
    private static int getSize(FileVersion version) {
        int size = 0;
        size += 14 + 7 + 7 + 7 + 7;
        size += 26;
        if (version.isOver(5, 0, 2, 1)) {
            size += 2;
        }
        if (version.isOver(5, 0, 3, 0)) {
            size += 4;
        }
        return size;
    }

    private static void faceNameIds(FaceNameIds fni, StreamWriter sw)
            throws IOException {
        for (int faceNameId : fni.getArray()) {
            sw.writeUInt2(faceNameId);
        }
    }

    private static void ratios(Ratios ratios, StreamWriter sw)
            throws IOException {
        for (short ratio : ratios.getArray()) {
            sw.writeUInt1(ratio);
        }
    }

    private static void charSpaces(CharSpaces charSpaces, StreamWriter sw)
            throws IOException {
        for (byte charSpace : charSpaces.getArray()) {
            sw.writeSInt1(charSpace);
        }
    }

    private static void relativeSizes(RelativeSizes rss, StreamWriter sw)
            throws IOException {
        for (short rs : rss.getArray()) {
            sw.writeUInt1(rs);
        }
    }

    private static void charPositions(CharOffsets cos, StreamWriter sw)
            throws IOException {
        for (byte co : cos.getArray()) {
            sw.writeSInt1(co);
        }
    }
}
