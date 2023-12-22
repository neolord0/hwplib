package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach;

import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.objectlinkline.ControlPoint;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.objectlinkline.LinkLineType;

import java.util.ArrayList;

/**
 * 객체 연결선 컨트롤을 위한 선 개체 속성 레코드
 *
 * @author neolord
 */
public class ShapeComponentLineForObjectLinkLine {
    /**
     * 시작점 x 좌표
     */
    private int startX;
    /**
     * 시작점 y 좌표
     */
    private int startY;
    /**
     * 끝점 x 좌표
     */
    private int endX;
    /**
     * 끝점 y 좌표
     */
    private int endY;
    private LinkLineType type;
    private long startSubjectID;
    private long startSubjectIndex;
    private long endSubjectID;
    private long endSubjectIndex;
    private ArrayList<ControlPoint> controlPoints;

    /**
     * 생성자
     */
    public ShapeComponentLineForObjectLinkLine() {
        controlPoints = new ArrayList<ControlPoint>();
    }

    /**
     * 시작점 x 좌표를 반환한다.
     *
     * @return 시작점 x 좌표
     */
    public int getStartX() {
        return startX;
    }

    /**
     * 시작점 x 좌표를 설정한다.
     *
     * @param startX 시작점 x 좌표
     */
    public void setStartX(int startX) {
        this.startX = startX;
    }

    /**
     * 시작점 y 좌표를 반환한다.
     *
     * @return 시작점 y 좌표
     */
    public int getStartY() {
        return startY;
    }

    /**
     * 시작점 y 좌표를 설정한다.
     *
     * @param startY 시작점 y 좌표
     */
    public void setStartY(int startY) {
        this.startY = startY;
    }

    /**
     * 끝점 x 좌표를 반환한다.
     *
     * @return 끝점 x 좌표
     */
    public int getEndX() {
        return endX;
    }

    /**
     * 끝점 x 좌표를 설정한다.
     *
     * @param endX 끝점 x 좌표
     */
    public void setEndX(int endX) {
        this.endX = endX;
    }

    /**
     * 끝점 y 좌표를 반환한다.
     *
     * @return 끝점 y 좌표
     */
    public int getEndY() {
        return endY;
    }

    /**
     * 끝점 y 좌표를 설정한다.
     *
     * @param endY 끝점 y 좌표
     */
    public void setEndY(int endY) {
        this.endY = endY;
    }

    public LinkLineType getType() {
        return type;
    }

    public void setType(LinkLineType type) {
        this.type = type;
    }

    public long getStartSubjectID() {
        return startSubjectID;
    }

    public void setStartSubjectID(long startSubjectID) {
        this.startSubjectID = startSubjectID;
    }

    public long getStartSubjectIndex() {
        return startSubjectIndex;
    }

    public void setStartSubjectIndex(long startSubjectIndex) {
        this.startSubjectIndex = startSubjectIndex;
    }

    public long getEndSubjectID() {
        return endSubjectID;
    }

    public void setEndSubjectID(long endSubjectID) {
        this.endSubjectID = endSubjectID;
    }

    public long getEndSubjectIndex() {
        return endSubjectIndex;
    }

    public void setEndSubjectIndex(long endSubjectIndex) {
        this.endSubjectIndex = endSubjectIndex;
    }

    public ControlPoint addNewControlPoint() {
        ControlPoint newCP = new ControlPoint();
        controlPoints.add(newCP);
        return newCP;
    }

    public ArrayList<ControlPoint> getControlPoints() {
        return controlPoints;
    }

    public void copy(ShapeComponentLineForObjectLinkLine from) {
        startX = from.startX;
        startY = from.startY;
        endX = from.endX;
        endY = from.endY;
        type = from.type;
        startSubjectID  = from.startSubjectID;
        startSubjectIndex = from.startSubjectIndex;
        endSubjectID = from.endSubjectID;
        endSubjectIndex = from.endSubjectIndex;

        for (ControlPoint fromCP : from.controlPoints) {
            addNewControlPoint().copy(fromCP);
        }
    }
 }
