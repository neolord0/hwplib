package kr.dogfoot.hwplib.object.docinfo;

import kr.dogfoot.hwplib.object.docinfo.parashape.ParaShapeProperty1;
import kr.dogfoot.hwplib.object.docinfo.parashape.ParaShapeProperty2;
import kr.dogfoot.hwplib.object.docinfo.parashape.ParaShapeProperty3;

/**
 * 문단 모양에 대한  레코드
 *
 * @author neolord
 */
public class ParaShape {
    /**
     * 속성 1
     */
    private ParaShapeProperty1 property1;
    /**
     * 왼쪽 여백
     */
    private int leftMargin;
    /**
     * 오른쪽 여백
     */
    private int rightMargin;
    /**
     * 들여 쓰기/내어 쓰기
     */
    private int indent;
    /**
     * 문단 위 간격
     */
    private int topParaSpace;
    /**
     * 문단 아래 간격
     */
    private int bottomParaSpace;
    /**
     * 줄 간격. 한글 2007 이하 버전(5.0.2.5 버전 미만)에서 사용
     */
    private int lineSpace;
    /**
     * 참조된 탭 정의 아이디
     */
    private int tabDefId;
    /**
     * 참조된 문단 번호 아이디 나 참조된 글머리표 아이디
     */
    private int paraHeadId;
    /**
     * 참조된 테두리/배경 모양 아이디
     */
    private int borderFillId;
    /**
     * 문단 테두리 왼쪽 간격
     */
    private short leftBorderSpace;
    /**
     * 문단 테두리 오른쪽 간격
     */
    private short rightBorderSpace;
    /**
     * 문단 테두리 위쪽 간격
     */
    private short topBorderSpace;
    /**
     * 문단 테두리 아래쪽 간격
     */
    private short bottomBorderSpace;
    /**
     * 속성 2 (5.0.1.7 버전 이상)
     */
    private ParaShapeProperty2 property2;
    /**
     * 속성 3 (5.0.2.5 버전 이상)
     */
    private ParaShapeProperty3 property3;
    /**
     * 줄 간격(5.0.2.5 버전 이상)
     */
    private long lineSpace2;
    /**
     * 알수 없음(5.1.0.0 버전 이상)
     */
    private long unknown;

    /**
     * 생성자
     */
    public ParaShape() {
        property1 = new ParaShapeProperty1();
        property2 = new ParaShapeProperty2();
        property3 = new ParaShapeProperty3();
    }

    /**
     * 문단 모양의 속성1 객체를 반환한다.
     *
     * @return 문단 모양의 속성1 객체
     */
    public ParaShapeProperty1 getProperty1() {
        return property1;
    }

    /**
     * 왼쪽 여백을 반환한다.
     *
     * @return 왼쪽 여백
     */
    public int getLeftMargin() {
        return leftMargin;
    }

    /**
     * 왼쪽 여백을 설정한다.
     *
     * @param leftMargin 왼쪽 여백
     */
    public void setLeftMargin(int leftMargin) {
        this.leftMargin = leftMargin;
    }

    /**
     * 오른쪽 여백을 반환한다.
     *
     * @return 오른쪽 여백
     */
    public int getRightMargin() {
        return rightMargin;
    }

    /**
     * 오른쪽 여백을 설정한다.
     *
     * @param rightMargin 오른쪽 여백
     */
    public void setRightMargin(int rightMargin) {
        this.rightMargin = rightMargin;
    }

    /**
     * 들여 쓰기/내어 쓰기를 반환한다.
     *
     * @return 들여 쓰기/내어 쓰기
     */
    public int getIndent() {
        return indent;
    }

    /**
     * 들여 쓰기/내어 쓰기를 설정한다.
     *
     * @param indent 들여 쓰기/내어 쓰기
     */
    public void setIndent(int indent) {
        this.indent = indent;
    }

    /**
     * 문단 위 간격을 반환한다.
     *
     * @return 문단 위 간격
     */
    public int getTopParaSpace() {
        return topParaSpace;
    }

    /**
     * 문단 위 간격을 설정한다.
     *
     * @param topParaSpace 문단 위 간격
     */
    public void setTopParaSpace(int topParaSpace) {
        this.topParaSpace = topParaSpace;
    }

    /**
     * 문단 아래 간격을 반환한다.
     *
     * @return 문단 아래 간격
     */
    public int getBottomParaSpace() {
        return bottomParaSpace;
    }

    /**
     * 문단 아래 간격을 설정한다.
     *
     * @param bottomParaSpace 문단 아래 간격
     */
    public void setBottomParaSpace(int bottomParaSpace) {
        this.bottomParaSpace = bottomParaSpace;
    }

    /**
     * 줄 간격을 반환한다. 한글 2007 이하 버전(5.0.2.5 버전 미만)에서 사용
     *
     * @return 줄 간격
     */
    public int getLineSpace() {
        return lineSpace;
    }

    /**
     * 줄 간격을 설정한다. 한글 2007 이하 버전(5.0.2.5 버전 미만)에서 사용
     *
     * @param lineSpace 줄 간격
     */
    public void setLineSpace(int lineSpace) {
        this.lineSpace = lineSpace;
    }

    /**
     * 참조된 탭 정의 아이디를 반환한다.
     *
     * @return 참조된 탭 정의 아이디
     */
    public int getTabDefId() {
        return tabDefId;
    }

    /**
     * 참조된 탭 정의 아이디를 설정한다.
     *
     * @param tabDefId 참조된 탭 정의 아이디
     */
    public void setTabDefId(int tabDefId) {
        this.tabDefId = tabDefId;
    }

    /**
     * 참조된 문단 번호 아이디 나 참조된 글머리표 아이디를 반환한다.
     *
     * @return 참조된 문단 번호 아이디 나 참조된 글머리표 아이디
     */
    public int getParaHeadId() {
        return paraHeadId;
    }

    /**
     * 참조된 문단 번호 아이디 나 참조된 글머리표 아이디릂 설정한다.
     *
     * @param paraHeadId 참조된 문단 번호 아이디 나 참조된 글머리표 아이디
     */
    public void setParaHeadId(int paraHeadId) {
        this.paraHeadId = paraHeadId;
    }

    /**
     * 참조된 테두리/배경 모양 아이디를 반환한다.
     *
     * @return 참조된 테두리/배경 모양 아이디
     */
    public int getBorderFillId() {
        return borderFillId;
    }

    /**
     * 참조된 테두리/배경 모양 아이디를 설정한다.
     *
     * @param borderFillId 참조된 테두리/배경 모양 아이디
     */
    public void setBorderFillId(int borderFillId) {
        this.borderFillId = borderFillId;
    }

    /**
     * 문단 테두리 왼쪽 간격을 반환한다.
     *
     * @return 문단 테두리 왼쪽 간격
     */
    public short getLeftBorderSpace() {
        return leftBorderSpace;
    }

    /**
     * 문단 테두리 왼쪽 간격을 설정한다.
     *
     * @param leftBorderSpace 문단 테두리 왼쪽 간격
     */
    public void setLeftBorderSpace(short leftBorderSpace) {
        this.leftBorderSpace = leftBorderSpace;
    }

    /**
     * 문단 테두리 오른쪽 간격을 반환한다.
     *
     * @return 문단 테두리 오른쪽 간격
     */
    public short getRightBorderSpace() {
        return rightBorderSpace;
    }

    /**
     * 문단 테두리 오른쪽 간격을 설정한다.
     *
     * @param rightBorderSpace 문단 테두리 오른쪽 간격
     */
    public void setRightBorderSpace(short rightBorderSpace) {
        this.rightBorderSpace = rightBorderSpace;
    }

    /**
     * 문단 테두리 위쪽 간격을 반환한다.
     *
     * @return 문단 테두리 위쪽 간격
     */
    public short getTopBorderSpace() {
        return topBorderSpace;
    }

    /**
     * 문단 테두리 위쪽 간격을 설정한다.
     *
     * @param topBorderSpace 문단 테두리 위쪽 간격
     */
    public void setTopBorderSpace(short topBorderSpace) {
        this.topBorderSpace = topBorderSpace;
    }

    /**
     * 문단 테두리 아래쪽 간격을 반환한다.
     *
     * @return 문단 테두리 아래쪽 간격
     */
    public short getBottomBorderSpace() {
        return bottomBorderSpace;
    }

    /**
     * 문단 테두리 아래쪽 간격을 설정한다.
     *
     * @param bottomBorderSpace 문단 테두리 아래쪽 간격
     */
    public void setBottomBorderSpace(short bottomBorderSpace) {
        this.bottomBorderSpace = bottomBorderSpace;
    }

    /**
     * 믄단 모양의 속성 2 객체를 반환한다. (5.0.1.7 버전 이상)
     *
     * @return 믄단 모양의 속성 2 객체
     */
    public ParaShapeProperty2 getProperty2() {
        return property2;
    }

    /**
     * 문단 모양의 속성 3 객체를 반환한다. (5.0.2.5 버전 이상)
     *
     * @return 문단 모양의 속성 3 객체
     */
    public ParaShapeProperty3 getProperty3() {
        return property3;
    }

    /**
     * 줄 간격을 반환한다. (5.0.2.5 버전 이상)
     *
     * @return 줄 간격
     */
    public long getLineSpace2() {
        return lineSpace2;
    }

    /**
     * 줄 간격을 설정한다. (5.0.2.5 버전 이상)
     *
     * @param lineSpace2 줄 간격
     */
    public void setLineSpace2(long lineSpace2) {
        this.lineSpace2 = lineSpace2;
    }

    /**
     * 알수 없음(5.1.0.0 버전 이상) 값을 반환한다.
     *
     * @return 알수 없음(5.1.0.0 버전 이상)
     */
    public long getUnknown() {
        return unknown;
    }

    /**
     * 알수 없음(5.1.0.0 버전 이상) 값을 설정한다.
     *
     * @param unknown 알수 없음(5.1.0.0 버전 이상) 값
     */
    public void setUnknown(long unknown) {
        this.unknown = unknown;
    }
}
