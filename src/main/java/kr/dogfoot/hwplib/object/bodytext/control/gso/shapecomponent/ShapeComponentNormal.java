package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent;

import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.lineinfo.LineInfo;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.shadowinfo.ShadowInfo;
import kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo.FillInfo;

/**
 * 일반 컨트롤을 위한 객체 공통 속성 레코드
 *
 * @author neolord
 */
public class ShapeComponentNormal extends ShapeComponent {
    /**
     * 테두리 선 정보
     */
    private LineInfo lineInfo;
    /**
     * 채움 정보
     */
    private FillInfo fillInfo;
    /**
     * 그림자 정보
     */
    private ShadowInfo shadowInfo;

    /**
     * 생성자
     */
    public ShapeComponentNormal() {
        lineInfo = null;
        fillInfo = null;
        shadowInfo = null;
    }


    /**
     * 테두리 선 정보 객체를 생성한다.
     */
    public void createLineInfo() {
        lineInfo = new LineInfo();
    }

    /**
     * 테두리 선 정보 객체를 삭제한다.
     */
    public void deleteLineInfo() {
        lineInfo = null;
    }

    /**
     * 테두리 선 정보 객체를 반환한다.
     *
     * @return 테두리 선 정보 객체
     */
    public LineInfo getLineInfo() {
        return lineInfo;
    }

    /**
     * 채움 정보 객체를 생성한다.
     */
    public void createFillInfo() {
        fillInfo = new FillInfo();
    }

    /**
     * 채움 정보 객체를 삭제한다.
     */
    public void deleteFillInfo() {
        fillInfo = null;
    }

    /**
     * 채움 정보 객체를 반환한다.
     *
     * @return 채움 정보 객체
     */
    public FillInfo getFillInfo() {
        return fillInfo;
    }

    /**
     * 그림자 정보 객체를 생성한다.
     */
    public void createShadowInfo() {
        shadowInfo = new ShadowInfo();
    }

    /***
     * 그림자 정보 객체를 삭제한다.
     */
    public void deleteShadowInfo() {
        shadowInfo = null;
    }

    /**
     * 그림자 정보 객체를 반환한다.
     *
     * @return 그림자 정보 객체
     */
    public ShadowInfo getShadowInfo() {
        return shadowInfo;
    }


    @Override
    public void copy(ShapeComponent from) {
        copyShapeComponent(from);
        ShapeComponentNormal from2 = (ShapeComponentNormal) from;

        if (from2.lineInfo != null) {
            createLineInfo();
            lineInfo.copy(from2.lineInfo);
        } else {
            lineInfo = null;
        }

        if (from2.fillInfo != null) {
            createFillInfo();
            fillInfo.copy(from2.fillInfo);
        } else {
            fillInfo = null;
        }

        if (from2.shadowInfo != null) {
            createShadowInfo();
            shadowInfo.copy(from2.shadowInfo);
        } else {
            shadowInfo = null;
        }
    }
}
