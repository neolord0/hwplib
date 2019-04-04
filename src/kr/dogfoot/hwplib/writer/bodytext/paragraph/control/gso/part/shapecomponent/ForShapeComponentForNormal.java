package kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso.part.shapecomponent;

import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.ShapeComponentNormal;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.lineinfo.LineInfo;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.shadowinfo.ShadowInfo;
import kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo.FillInfo;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;
import kr.dogfoot.hwplib.writer.docinfo.borderfill.ForFillInfo;

import java.io.IOException;

/**
 * 묶음 컨트롤이 아닌 일반 컨트롤의 객체 공통 속성 레코드을 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForShapeComponentForNormal {
    /**
     * 일반 컨트롤의 객체 공통 속성 레코드을 쓴다.
     *
     * @param scn 일반 컨트롤의 객체 공통 속성 레코드
     * @param sw  스트림 라이터
     * @throws IOException
     */
    public static void write(ShapeComponentNormal scn, StreamWriter sw)
            throws IOException {
        recordHeader(scn, sw);

        gsoCtrlId(scn, sw);
        CommonPart.write(scn, sw);
        lineInfo(scn.getLineInfo(), sw);
        fillInfo(scn.getFillInfo(), sw);
        shadowInfo(scn.getShadowInfo(), sw);
    }

    /**
     * 객체 공통 속성 레코드의 레코드 헤더를 쓴다.
     *
     * @param scn
     * @param sw
     * @throws IOException
     */
    private static void recordHeader(ShapeComponentNormal scn, StreamWriter sw)
            throws IOException {
        sw.writeRecordHeader(HWPTag.SHAPE_COMPONENT, getSize(scn));
    }

    /**
     * 객체 공통 속성 레코드의 크기를 반환한다.
     *
     * @param scn 객체 공통 속성 레코드
     * @return 객체 공통 속성 레코드의 크기
     */
    private static int getSize(ShapeComponentNormal scn) {
        int size = 0;
        size += 8;
        size += CommonPart.getSize(scn);
        if (scn.getLineInfo() != null) {
            size += 13;
        }
        if (scn.getFillInfo() != null) {
            size += ForFillInfo.getSize(scn.getFillInfo());
        }
        if (scn.getShadowInfo() != null) {
            size += 22;
        }

        return size;
    }

    /**
     * 그리기 객체 컨트롤 아이디를 쓴다.
     *
     * @param scn 객체 공통 속성 레코드
     * @param sw  스트림 라이터
     * @throws IOException
     */
    private static void gsoCtrlId(ShapeComponentNormal scn, StreamWriter sw)
            throws IOException {
        sw.writeUInt4(scn.getGsoId());
        sw.writeUInt4(scn.getGsoId());
    }

    /**
     * line 정보를 쓴다.
     *
     * @param li line 정보
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void lineInfo(LineInfo li, StreamWriter sw)
            throws IOException {
        if (li != null) {
            sw.writeUInt4(li.getColor().getValue());
            sw.writeSInt4(li.getThickness());
            sw.writeUInt4(li.getProperty().getValue());
            sw.writeUInt1(li.getOutlineStyle().getValue());
        }
    }

    /**
     * 배경 정보를 쓴다.
     *
     * @param fi 배경 정보
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void fillInfo(FillInfo fi, StreamWriter sw)
            throws IOException {
        if (fi != null) {
            ForFillInfo.write(fi, sw);
        }
    }

    /**
     * 그림자 정보를 쓴다.
     *
     * @param si 그림자 정보
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void shadowInfo(ShadowInfo si, StreamWriter sw)
            throws IOException {
        if (si != null) {
            sw.writeUInt4(si.getType().getValue());
            sw.writeUInt4(si.getColor().getValue());
            sw.writeSInt4(si.getOffsetX());
            sw.writeSInt4(si.getOffsetY());
            sw.writeZero(5);
            sw.writeUInt1(si.getTransparnet());
        }
    }

    /**
     * 묶음 컨트톨에 포함되어 있는 일반 컨트롤의 객체 공통 속성 레코드을 쓴다.
     *
     * @param scn 묶음 컨트톨에 포함되어 있는 일반 컨트롤의 객체 공통 속성 레코드
     * @param sw  스트림 라이터
     * @throws IOException
     */
    public static void writeInContainer(ShapeComponentNormal scn,
                                        StreamWriter sw) throws IOException {
        recordHeaderInContainer(scn, sw);

        gsoCtrlIdInContainer(scn, sw);
        CommonPart.write(scn, sw);
        lineInfo(scn.getLineInfo(), sw);
        fillInfo(scn.getFillInfo(), sw);
        shadowInfo(scn.getShadowInfo(), sw);
    }

    /**
     * 묶음 컨트톨에 포함되어 있는 일반 컨트롤의 객체 공통 속성 레코드의 레코드 헤더를 쓴다.
     *
     * @param scn 묶음 컨트톨에 포함되어 있는 일반 컨트롤의 객체 공통 속성 레코드
     * @param sw  스트림 라이터
     * @throws IOException
     */
    private static void recordHeaderInContainer(ShapeComponentNormal scn,
                                                StreamWriter sw) throws IOException {
        sw.writeRecordHeader(HWPTag.SHAPE_COMPONENT, getSize(scn) - 4);
    }

    /**
     * 묶음 컨트톨에 포함되어 있는 일반 컨트롤의 그리기 객체 컨트롤 아이디를 쓴다.
     *
     * @param scn 묶음 컨트톨에 포함되어 있는 일반 컨트롤의 객체 공통 속성 레코드
     * @param sw  스트림 라이터
     * @throws IOException
     */
    private static void gsoCtrlIdInContainer(ShapeComponentNormal scn,
                                             StreamWriter sw) throws IOException {
        sw.writeUInt4(scn.getGsoId());
    }
}
