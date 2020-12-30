package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach;

import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.lineinfo.LineInfoProperty;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ole.ShapeComponentOLEProperty;
import kr.dogfoot.hwplib.object.etc.Color4Byte;

/**
 * OLE 개체 속성 레코드
 *
 * @author neolord
 */
public class ShapeComponentOLE {
    /**
     * 속성
     */
    private ShapeComponentOLEProperty property;
    /**
     * 오브젝트 자체의 extent x크기
     */
    private int extentWidth;
    /**
     * 오브젝트 자체의 extent y크기
     */
    private int extentHeight;
    /**
     * 오브젝트가 사용하는 스토리지의 BinData ID
     */
    private int binDataId;
    /**
     * 테두리 색
     */
    private Color4Byte borderColor;
    /**
     * 테두리 두꼐
     */
    private int borderThickness;
    /**
     * 테두리 속성
     */
    private LineInfoProperty borderProperty;

    /**
     * 생성자
     */
    public ShapeComponentOLE() {
        property = new ShapeComponentOLEProperty();
        borderColor = new Color4Byte();
        borderProperty = new LineInfoProperty();
    }

    /**
     * 속성 객체를 반환한다.
     *
     * @return 속성 객체
     */
    public ShapeComponentOLEProperty getProperty() {
        return property;
    }

    /**
     * 오브젝트 자체의 extent x크기를 반환한다.
     *
     * @return 오브젝트 자체의 extent x크기
     */
    public int getExtentWidth() {
        return extentWidth;
    }

    /**
     * 오브젝트 자체의 extent x크기를 설정한다.
     *
     * @param extentWidth 오브젝트 자체의 extent x크기
     */
    public void setExtentWidth(int extentWidth) {
        this.extentWidth = extentWidth;
    }

    /**
     * 오브젝트 자체의 extent y크기를 반환한다.
     *
     * @return 오브젝트 자체의 extent y크기
     */
    public int getExtentHeight() {
        return extentHeight;
    }

    /**
     * 오브젝트 자체의 extent y크기를 설정한다.
     *
     * @param extentHeight 오브젝트 자체의 extent y크기
     */
    public void setExtentHeight(int extentHeight) {
        this.extentHeight = extentHeight;
    }

    /**
     * 오브젝트가 사용하는 스토리지의 BinData ID를 반환한다.
     *
     * @return 오브젝트가 사용하는 스토리지의 BinData ID
     */
    public int getBinDataId() {
        return binDataId;
    }

    /**
     * 오브젝트가 사용하는 스토리지의 BinData ID를 설정한다.
     *
     * @param binDataId 오브젝트가 사용하는 스토리지의 BinData ID
     */
    public void setBinDataId(int binDataId) {
        this.binDataId = binDataId;
    }

    /**
     * 테두리 색상 객체를 반환한다.
     *
     * @return 테두리 색상 객체
     */
    public Color4Byte getBorderColor() {
        return borderColor;
    }

    /**
     * 테두리 두꼐를 반환한다.
     *
     * @return 테두리 두꼐
     */
    public int getBorderThickness() {
        return borderThickness;
    }

    /**
     * 테두리 두꼐를 설정한다.
     *
     * @param borderThickness 테두리 두꼐
     */
    public void setBorderThickness(int borderThickness) {
        this.borderThickness = borderThickness;
    }

    /**
     * 테두리 속성 객체를 반환한다.
     *
     * @return 테두리 속성 객체
     */
    public LineInfoProperty getBorderProperty() {
        return borderProperty;
    }

    public void copy(ShapeComponentOLE from) {
        property.copy(from.property);
        extentWidth = from.extentWidth;
        extentHeight = from.extentHeight;
        binDataId = from.binDataId;
        borderColor.copy(from.borderColor);
        borderThickness = from.borderThickness;
        borderProperty.copy(from.borderProperty);
    }
}
