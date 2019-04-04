package kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso.part.shapecomponent;

import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.ShapeComponent;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.ShapeComponentContainer;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 묶음 컨트롤의 객체 공통 속성 레코드을 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForShapeComponentForContainer {
    /**
     * 묶음 컨트롤의 객체 공통 속성 레코드을 쓴다.
     *
     * @param scc 묶음 컨트롤의 객체 공통 속성 레코드
     * @param sw  스트림 라이터
     * @throws IOException
     */
    public static void write(ShapeComponentContainer scc, StreamWriter sw)
            throws IOException {
        recordHeader(scc, sw);

        gsoCtrlId(scc, sw);
        commonPart(scc, sw);
        childInfo(scc, sw);
        sw.writeZero(4);
    }

    /**
     * 객체 공통 속성 레코드의 레코드 헤더를 쓴다.
     *
     * @param scc 객체 공통 속성 레코드
     * @param sw  스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(ShapeComponentContainer scc,
                                     StreamWriter sw) throws IOException {
        sw.writeRecordHeader(HWPTag.SHAPE_COMPONENT, getSize(scc));
    }

    /**
     * 객체 공통 속성 레코드의 크기를 반환한다.
     *
     * @param scc 객체 공통 속성 레코드
     * @return객체 공통 속성 레코드의 크기
     */
    private static int getSize(ShapeComponentContainer scc) {
        int size = 0;
        size += 8;
        size += CommonPart.getSize(scc);

        size += 2;
        size += 4 * scc.getChildControlIdList().size();

        size += 4;
        return size;
    }

    /**
     * 그리기 객체 컨트롤 아이디를 쓴다.
     *
     * @param scc 객체 공통 속성 레코드
     * @param sw  스트림 라이터
     * @throws IOException
     */
    private static void gsoCtrlId(ShapeComponentContainer scc, StreamWriter sw)
            throws IOException {
        sw.writeUInt4(scc.getGsoId());
        sw.writeUInt4(scc.getGsoId());
    }

    /**
     * 객체 공통 속성 레코드의 공통 부분을 쓴다.
     *
     * @param sc 객체 공통 속성 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void commonPart(ShapeComponent sc, StreamWriter sw)
            throws IOException {
        CommonPart.write(sc, sw);
    }

    /**
     * 묶음 컨트톨이 포함하는 컨트롤들에 대한 정보를 쓴다.
     *
     * @param scc 객체 공통 속성 레코드
     * @param sw  스트림 라이터
     * @throws IOException
     */
    private static void childInfo(ShapeComponentContainer scc, StreamWriter sw)
            throws IOException {
        int count = scc.getChildControlIdList().size();
        sw.writeUInt2(count);

        for (long childId : scc.getChildControlIdList()) {
            sw.writeUInt4(childId);
        }
    }

    /**
     * 묶음 컨트톨에 포함되어 있는 묶음 컨트롤의 객체 공통 속성 레코드을 쓴다.
     *
     * @param scc 묶음 컨트톨에 포함되어 있는 묶음 컨트롤의 객체 공통 속성 레코드
     * @param sw  스트림 라이터
     * @throws IOException
     */
    public static void writeInContainer(ShapeComponentContainer scc,
                                        StreamWriter sw) throws IOException {
        recordHeaderInContainer(scc, sw);

        gsoCtrlIdInContainer(scc, sw);
        commonPart(scc, sw);
        childInfo(scc, sw);
        sw.writeZero(4);
    }

    /**
     * 묶음 컨트톨에 포함되어 있는 묶음 컨트롤의 객체 공통 속성 레코드의 레코드 헤더를 쓴다.
     *
     * @param scc 묶음 컨트톨에 포함되어 있는 묶음 컨트롤의 객체 공통 속성 레코드
     * @param sw  스트림 라이터
     * @throws IOException
     */
    private static void recordHeaderInContainer(ShapeComponentContainer scc,
                                                StreamWriter sw) throws IOException {
        sw.writeRecordHeader(HWPTag.SHAPE_COMPONENT, getSize(scc) - 4);
    }

    /**
     * 묶음 컨트톨에 포함되어 있는 묶음 컨트롤의 그리기 객체 컨트롤 아이디를 쓴다.
     *
     * @param scc 묶음 컨트톨에 포함되어 있는 묶음 컨트롤의 객체 공통 속성 레코드
     * @param sw  스트림 라이터
     * @throws IOException
     */
    private static void gsoCtrlIdInContainer(ShapeComponentContainer scc,
                                             StreamWriter sw) throws IOException {
        sw.writeUInt4(scc.getGsoId());
    }
}
