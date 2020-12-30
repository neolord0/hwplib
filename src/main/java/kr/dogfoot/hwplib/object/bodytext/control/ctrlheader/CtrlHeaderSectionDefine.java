package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader;

import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.sectiondefine.SectionDefineHeaderProperty;

/**
 * 구역 정의 컨트롤을 위한 컨트롤 헤더 레코드
 *
 * @author neolord
 */
public class CtrlHeaderSectionDefine extends CtrlHeader {
    /**
     * 속성
     */
    private SectionDefineHeaderProperty property;
    /**
     * 동일한 페이지에서 서로 다른 단 사이의 간격
     */
    private int columnGap;
    /**
     * 세로로 줄맞춤을 할지 여부
     */
    private int verticalLineAlign;
    /**
     * 가로로 줄맞춤을 할지 여부
     */
    private int horizontalLineAlign;
    /**
     * 기본 탭 간격
     */
    private long defaultTabGap;
    /**
     * 번호 문단 모양 ID
     */
    private int numberParaShapeId;
    /**
     * 쪽 시작 번호
     */
    private int pageStartNumber;
    /**
     * 그림 시작 번호
     */
    private int imageStartNumber;
    /**
     * 표 시작 번호
     */
    private int tableStartNumber;
    /**
     * 수식 시작 번호
     */
    private int equationStartNumber;
    /**
     * 대표Language(5.0.1.5 이상)
     */
    private int defaultLanguage;

    /**
     * 생성자
     */
    public CtrlHeaderSectionDefine() {
        super(ControlType.SectionDefine.getCtrlId());
        property = new SectionDefineHeaderProperty();
    }

    /**
     * 구역 정의 컨트롤의 속성 객체를 반환한다.
     *
     * @return 구역 정의 컨트롤의 속성 객체
     */
    public SectionDefineHeaderProperty getProperty() {
        return property;
    }

    /**
     * 동일한 페이지에서 서로 다른 단 사이의 간격을 반환한다.
     *
     * @return 동일한 페이지에서 서로 다른 단 사이의 간격
     */
    public int getColumnGap() {
        return columnGap;
    }

    /**
     * 동일한 페이지에서 서로 다른 단 사이의 간격을 설정한다.
     *
     * @param columnGap 동일한 페이지에서 서로 다른 단 사이의 간격
     */
    public void setColumnGap(int columnGap) {
        this.columnGap = columnGap;
    }

    /**
     * 세로로 줄맞춤을 할지 여부를 반환한다.
     *
     * @return 세로로 줄맞춤을 할지 여부
     */
    public int getVerticalLineAlign() {
        return verticalLineAlign;
    }

    /**
     * 세로로 줄맞춤을 할지 여부를 설정한다.
     *
     * @param verticalLineAlign 세로로 줄맞춤을 할지 여부
     */
    public void setVerticalLineAlign(int verticalLineAlign) {
        this.verticalLineAlign = verticalLineAlign;
    }

    /**
     * 가로로 줄맞춤을 할지 여부를 반환한다.
     *
     * @return 가로로 줄맞춤을 할지 여부
     */
    public int getHorizontalLineAlign() {
        return horizontalLineAlign;
    }

    /**
     * 가로로 줄맞춤을 할지 여부를 설정한다.
     *
     * @param horizontalLineAlign 가로로 줄맞춤을 할지 여부
     */
    public void setHorizontalLineAlign(int horizontalLineAlign) {
        this.horizontalLineAlign = horizontalLineAlign;
    }

    /**
     * 기본 탭 간격을 반환한다.
     *
     * @return 기본 탭 간격
     */
    public long getDefaultTabGap() {
        return defaultTabGap;
    }

    /**
     * 기본 탭 간격을 설정한다.
     *
     * @param defaultTabGap 기본 탭 간격
     */
    public void setDefaultTabGap(long defaultTabGap) {
        this.defaultTabGap = defaultTabGap;
    }

    /**
     * 번호 문단 모양 ID를 반환한다.
     *
     * @return 번호 문단 모양 ID
     */
    public int getNumberParaShapeId() {
        return numberParaShapeId;
    }

    /**
     * 번호 문단 모양 ID를 설정한다.
     *
     * @param numberParaShapeId 번호 문단 모양 ID
     */
    public void setNumberParaShapeId(int numberParaShapeId) {
        this.numberParaShapeId = numberParaShapeId;
    }

    /**
     * 쪽 시작 번호를 반환한다.
     *
     * @return 쪽 시작 번호
     */
    public int getPageStartNumber() {
        return pageStartNumber;
    }

    /**
     * 쪽 시작 번호를 섫정한다.
     *
     * @param pageStartNumber 쪽 시작 번호
     */
    public void setPageStartNumber(int pageStartNumber) {
        this.pageStartNumber = pageStartNumber;
    }

    /**
     * 아미지 시작 번호를 반환한다.
     *
     * @return 아미지 시작 번호
     */
    public int getImageStartNumber() {
        return imageStartNumber;
    }

    /**
     * 아미지 시작 번호를 설정한다.
     *
     * @param imageStartNumber 아미지 시작 번호
     */
    public void setImageStartNumber(int imageStartNumber) {
        this.imageStartNumber = imageStartNumber;
    }

    /**
     * 표 시작 번호를 반환한다.
     *
     * @return 표 시작 번호
     */
    public int getTableStartNumber() {
        return tableStartNumber;
    }

    /**
     * 표 시작 번호를 설정한다.
     *
     * @param tableStartNumber 표 시작 번호
     */
    public void setTableStartNumber(int tableStartNumber) {
        this.tableStartNumber = tableStartNumber;
    }

    /**
     * 수식 시작 번호를 반환한다.
     *
     * @return 수식 시작 번호
     */
    public int getEquationStartNumber() {
        return equationStartNumber;
    }

    /**
     * 수식 시작 번호를 설정한다.
     *
     * @param equationStartNumber 수식 시작 번호
     */
    public void setEquationStartNumber(int equationStartNumber) {
        this.equationStartNumber = equationStartNumber;
    }

    /**
     * 대표Language 값을 반환한다. (5.0.1.5 이상)
     *
     * @return 대표Language 값
     */
    public int getDefaultLanguage() {
        return defaultLanguage;
    }

    /**
     * 대표Language 값을 설정한다. (5.0.1.5 이상)
     *
     * @param defaultLanguage 대표Language 값
     */
    public void setDefaultLanguage(int defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    @Override
    public void copy(CtrlHeader from) {
        CtrlHeaderSectionDefine from2 = (CtrlHeaderSectionDefine) from;
        property.copy(from2.property);
        columnGap = from2.columnGap;
        verticalLineAlign = from2.verticalLineAlign;
        horizontalLineAlign = from2.horizontalLineAlign;
        defaultTabGap = from2.defaultTabGap;
        numberParaShapeId = from2.numberParaShapeId;
        pageStartNumber = from2.pageStartNumber;
        imageStartNumber = from2.imageStartNumber;
        tableStartNumber = from2.tableStartNumber;
        equationStartNumber = from2.equationStartNumber;
        defaultLanguage = from2.defaultLanguage;
    }
}
