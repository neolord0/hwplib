package kr.dogfoot.hwplib.writer.bodytext.paragraph;

import kr.dogfoot.hwplib.object.bodytext.paragraph.charshape.CharPositionShapeIdPair;
import kr.dogfoot.hwplib.object.bodytext.paragraph.charshape.ParaCharShape;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 문단의 글자 모양 레코드를 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForParaCharShape {
    /**
     * 문단의 글자 모양 레코드를 쓴다.
     *
     * @param pcs 문단의 글자 모양 레코드
     * @param sw  스트림 라이터
     * @throws IOException
     */
    public static void write(ParaCharShape pcs, StreamWriter sw)
            throws IOException {
        if (pcs == null) {
            return;
        }

        recordHeader(pcs, sw);

        for (CharPositionShapeIdPair cpsip : pcs.getPositonShapeIdPairList()) {
            charPositonShapeIdPair(cpsip, sw);
        }
    }

    /**
     * 문단의 글자 모양 레코드의 레코드 헤더를 쓴다.
     *
     * @param pcs 문단의 글자 모양 레코드의 레코드 헤더
     * @param sw  스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(ParaCharShape pcs, StreamWriter sw)
            throws IOException {
        sw.writeRecordHeader(HWPTag.PARA_CHAR_SHAPE, getSize(pcs));
    }

    /**
     * 문단 글자 모양 레코드의 크기를 반환한다.
     *
     * @param pcs 문단 글자 모양 레코드
     * @return 문단 글자 모양 레코드의 크기
     */
    private static int getSize(ParaCharShape pcs) {
        return pcs.getPositonShapeIdPairList().size() * 8;
    }

    /**
     * 글자 모양 위치/글자 모양 아이디의 쌍을 쓴다.
     *
     * @param cpsip 글자 모양 위치/글자 모양 아이디의 쌍
     * @param sw    스트림 라이터
     * @throws IOException
     */
    private static void charPositonShapeIdPair(CharPositionShapeIdPair cpsip,
                                               StreamWriter sw) throws IOException {
        sw.writeUInt4(cpsip.getPosition());
        sw.writeUInt4(cpsip.getShapeId());
    }
}
