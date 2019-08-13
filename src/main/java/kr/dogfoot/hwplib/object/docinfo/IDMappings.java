package kr.dogfoot.hwplib.object.docinfo;

/**
 * 아이디 매핑 헤더를 나타내는  레코드. "DocInfo" stream 안에 있는 다른 객체들의 개수를 저전한다.
 *
 * @author neolord
 */
public class IDMappings {
    /**
     * 바이너리 데이터의 개수
     */
    private int binDataCount;
    /**
     * 한글 글꼴의 개수
     */
    private int hangulFaceNameCount;
    /**
     * 영어 글꼴의 개수
     */
    private int englishFaceNameCount;
    /**
     * 한자 글꼴의 개수
     */
    private int hanjaFaceNameCount;
    /**
     * 일본어 글꼴의 개수
     */
    private int japaneseFaceNameCount;
    /**
     * 기타 글꼴의 개수
     */
    private int etcFaceNameCount;
    /**
     * 기호 글꼴의 개수
     */
    private int symbolFaceNameCount;
    /**
     * 사용자 글꼴의 개수
     */
    private int userFaceNameCount;
    /**
     * 테두리/배경의 개수
     */
    private int borderFillCount;
    /**
     * 글자 모양의 개수
     */
    private int charShapeCount;
    /**
     * 탭 정의의 개수
     */
    private int tabDefCount;
    /**
     * 문단 번호의 개수
     */
    private int numberingCount;
    /**
     * 글머리표의 개수
     */
    private int bulletCount;
    /**
     * 문단 모양의 개수
     */
    private int paraShapeCount;
    /**
     * 스타일의 개수
     */
    private int styleCount;
    /**
     * 메모 모양의 개수(5.0.2.1 이상)
     */
    private int memoShapeCount;
    /**
     * 변경 추적의 개수(5.0.3.2 이상)
     */
    private int trackChangeCount;
    /**
     * 변경추적 사용자의 개수 (5.0.3.2 이상)
     */
    private int trackChangeAuthorCount;

    /**
     * 생성자
     */
    public IDMappings() {
    }

    /**
     * 바이너리 데이터 객체의 개수를 반환한다.
     *
     * @return 바이너리 데이터 객체의 개수
     */
    public int getBinDataCount() {
        return binDataCount;
    }

    /**
     * 바이너리 데이터 객체의 개수를 설정한다.
     *
     * @param binDataCount 바이너리 데이터 객체의 개수
     */
    public void setBinDataCount(int binDataCount) {
        this.binDataCount = binDataCount;
    }

    /**
     * 한글 글꼴 객체의 개수를 반환한다.
     *
     * @return 한글 글꼴 객체의 개수
     */
    public int getHangulFaceNameCount() {
        return hangulFaceNameCount;
    }

    /**
     * 한글 글꼴 객체의 개수를 설정한다.
     *
     * @param hangulFaceNameCount 한글 글꼴 객체의 개수
     */
    public void setHangulFaceNameCount(int hangulFaceNameCount) {
        this.hangulFaceNameCount = hangulFaceNameCount;
    }

    /**
     * 영어 글꼴 객체의 개수를 반환한다.
     *
     * @return 영어 글꼴 객체의 개수
     */
    public int getEnglishFaceNameCount() {
        return englishFaceNameCount;
    }

    /**
     * 영어 글꼴 객체의 개수를 설정한다.
     *
     * @param englishFaceNameCount 영어 글꼴 객체의 개수
     */
    public void setEnglishFaceNameCount(int englishFaceNameCount) {
        this.englishFaceNameCount = englishFaceNameCount;
    }

    /**
     * 한자 글꼴 객체의 개수를 반환한다.
     *
     * @return 한자 글꼴 객체의 개수
     */
    public int getHanjaFaceNameCount() {
        return hanjaFaceNameCount;
    }

    /**
     * 한자 글꼴 객체의 개수를 설정한다.
     *
     * @param hanjaFaceNameCount 한자 글꼴 객체의 개수
     */
    public void setHanjaFaceNameCount(int hanjaFaceNameCount) {
        this.hanjaFaceNameCount = hanjaFaceNameCount;
    }

    /**
     * 일본어 글꼴 객체의 개수를 반환한다.
     *
     * @return 일본어 글꼴 객체의 개수
     */
    public int getJapaneseFaceNameCount() {
        return japaneseFaceNameCount;
    }

    /**
     * 일본어 글꼴 객체의 개수를 설정한다.
     *
     * @param japaneseFaceNameCount 일본어 글꼴 객체의 개수
     */
    public void setJapaneseFaceNameCount(int japaneseFaceNameCount) {
        this.japaneseFaceNameCount = japaneseFaceNameCount;
    }

    /**
     * 기타 글꼴 객체의 개수를 반환한다.
     *
     * @return 기타 글꼴 객체의 개수
     */
    public int getEtcFaceNameCount() {
        return etcFaceNameCount;
    }

    /**
     * 기타 글꼴 객체의 개수를 설정한다.
     *
     * @param etcFaceNameCount 기타 글꼴 객체의 개수
     */
    public void setEtcFaceNameCount(int etcFaceNameCount) {
        this.etcFaceNameCount = etcFaceNameCount;
    }

    /**
     * 기호 글꼴 객체의 개수를 반환한다.
     *
     * @return 기호 글꼴 객체의 개수
     */
    public int getSymbolFaceNameCount() {
        return symbolFaceNameCount;
    }

    /**
     * 기호 글꼴 객체의 개수를 설정한다.
     *
     * @param symbolFaceNameCount 기호 글꼴 객체의 개수
     */
    public void setSymbolFaceNameCount(int symbolFaceNameCount) {
        this.symbolFaceNameCount = symbolFaceNameCount;
    }

    /**
     * 사용자 글꼴 객체의 개수를 반환한다.
     *
     * @return 사용자 글꼴 객체의 개수
     */
    public int getUserFaceNameCount() {
        return userFaceNameCount;
    }

    /**
     * 사용자 글꼴 객체의 개수를 설정한다.
     *
     * @param userFaceNameCount 사용자 글꼴 객체의 개수
     */
    public void setUserFaceNameCount(int userFaceNameCount) {
        this.userFaceNameCount = userFaceNameCount;
    }

    /**
     * 배경/테두리 객체의 개수를 반환한다.
     *
     * @return 배경/테두리 객체의 개수
     */
    public int getBorderFillCount() {
        return borderFillCount;
    }

    /**
     * 배경/테두리 객체의 개수를 설정한다.
     *
     * @param borderFillCount 배경/테두리 객체의 개수
     */
    public void setBorderFillCount(int borderFillCount) {
        this.borderFillCount = borderFillCount;
    }

    /**
     * 글자 모양 객체의 개수를 반환한다.
     *
     * @return 글자 모양 객체의 개수
     */
    public int getCharShapeCount() {
        return charShapeCount;
    }

    /**
     * 글자 모양 객체의 개수를 설정한다.
     *
     * @param charShapeCount 글자 모양 객체의 개수
     */
    public void setCharShapeCount(int charShapeCount) {
        this.charShapeCount = charShapeCount;
    }

    /**
     * 탭 정의 객체의 개수를 반환한다.
     *
     * @return 탭 정의 객체의 개수
     */
    public int getTabDefCount() {
        return tabDefCount;
    }

    /**
     * 탭 정의 객체의 개수를 설정한다.
     *
     * @param tabDefCount 탭 정의 객체의 개수
     */
    public void setTabDefCount(int tabDefCount) {
        this.tabDefCount = tabDefCount;
    }

    /**
     * 문단 번호 객체의 개수를 반환한다.
     *
     * @return 문단 번호 객체의 개수
     */
    public int getNumberingCount() {
        return numberingCount;
    }

    /**
     * 문단 번호 객체의 개수를 설정한다.
     *
     * @param numberingCount 문단 번호 객체의 개수
     */
    public void setNumberingCount(int numberingCount) {
        this.numberingCount = numberingCount;
    }

    /**
     * 글머리표 객체의 개수를 반환한다.
     *
     * @return 글머리표 객체의 개수
     */
    public int getBulletCount() {
        return bulletCount;
    }

    /**
     * 글머리표 객체의 개수를 설정한다.
     *
     * @param bulletCount 글머리표 객체의 개수
     */
    public void setBulletCount(int bulletCount) {
        this.bulletCount = bulletCount;
    }

    /**
     * 믄단 모양 객체의 개수를 반환한다.
     *
     * @return 믄단 모양 객체의 개수
     */
    public int getParaShapeCount() {
        return paraShapeCount;
    }

    /**
     * 믄단 모양 객체의 개수를 설정한다.
     *
     * @param paraShapeCount 믄단 모양 객체의 개수
     */
    public void setParaShapeCount(int paraShapeCount) {
        this.paraShapeCount = paraShapeCount;
    }

    /**
     * 스타일 객체의 개수를 반환한다.
     *
     * @return 스타일 객체의 개수
     */
    public int getStyleCount() {
        return styleCount;
    }

    /**
     * 스타일 객체의 개수를 설정한다.
     *
     * @param styleCount 스타일 객체의 개수
     */
    public void setStyleCount(int styleCount) {
        this.styleCount = styleCount;
    }

    /**
     * 메모 모양 객체의 개수를 반환한다. (5.0.2.1 이상)
     *
     * @return 메모 모양 객체의 개수
     */
    public int getMemoShapeCount() {
        return memoShapeCount;
    }

    /**
     * 메모 모양 객체의 개수를 설정한다. (5.0.2.1 이상)
     *
     * @param memoShapeCount 메모 모양 객체의 개수
     */
    public void setMemoShapeCount(int memoShapeCount) {
        this.memoShapeCount = memoShapeCount;
    }

    /**
     * 변경 추적 객체의 개수를 반환한다. (5.0.3.2 이상)
     *
     * @return 변경 추적 객체의 개수
     */
    public int getTrackChangeCount() {
        return trackChangeCount;
    }

    /**
     * 변경 추적 객체의 개수를 설정한다. (5.0.3.2 이상)
     *
     * @param trackChangeCount 변경 추적 객체의 개수
     */
    public void setTrackChangeCount(int trackChangeCount) {
        this.trackChangeCount = trackChangeCount;
    }

    /**
     * 변경추적 사용자 객체의 개수를 반환한다. (5.0.3.2 이상)
     *
     * @return 변경추적 사용자 객체의 개수
     */
    public int getTrackChangeAuthorCount() {
        return trackChangeAuthorCount;
    }

    /**
     * 변경추적 사용자 객체의 개수를 설정한다. (5.0.3.2 이상)
     *
     * @param trackChangeAuthorCount 변경추적 사용자 객체의 개수
     */
    public void setTrackChangeAuthorCount(int trackChangeAuthorCount) {
        this.trackChangeAuthorCount = trackChangeAuthorCount;
    }
}
