package kr.dogfoot.hwplib.object.docinfo;

import kr.dogfoot.hwplib.object.docinfo.bindata.BinDataProperty;

/**
 * 바이너리 데이터를 나타내는 레코드
 *
 * @author neolord
 */
public class BinData {
    /**
     * 속성
     */
    private BinDataProperty property;
    /**
     * Type이 "LINK"일 때, 연결 파일의 절대 경로
     */
    private String absolutePathForLink;
    /**
     * Type이 "LINK"일 때, 연결 파일의 상대 경로
     */
    private String relativePathForLink;
    /**
     * Type이 "EMBEDDING"이거나 "STORAGE"일 때, BINDATASTORAGE에 저장된 바이너리 데이터의 아이디
     */
    private int binDataID;
    /**
     * Type이 "EMBEDDING"일 때 extension("." 제외)
     */
    private String extensionForEmbedding;

    /**
     * 생성자
     */
    public BinData() {
        property = new BinDataProperty();
    }

    /**
     * 바이너리 데이터의 속성 객체를 반환한다.
     *
     * @return 바이너리 데이터의 속성 객체
     */
    public BinDataProperty getProperty() {
        return property;
    }

    /**
     * Type이 "LINK"일 때, 연결 파일의 절대 경로를 반환한다.
     *
     * @return 연결 파일의 절대 경로
     */
    public String getAbsolutePathForLink() {
        return absolutePathForLink;
    }

    /**
     * Type이 "LINK"일 때, 연결 파일의 절대 경로를 설정한다.
     *
     * @param absolutePathForLink 연결 파일의 절대 경로
     */
    public void setAbsolutePathForLink(String absolutePathForLink) {
        this.absolutePathForLink = absolutePathForLink;
    }

    /**
     * Type이 "LINK"일 때, 연결 파일의 상대 경로를 반환한다.
     *
     * @return 연결 파일의 상대 경로
     */
    public String getRelativePathForLink() {
        return relativePathForLink;
    }

    /**
     * Type이 "LINK"일 때, 연결 파일의 상대 경로를 설정한다.
     *
     * @param relativePathForLink 연결 파일의 상대 경로
     */
    public void setRelativePathForLink(String relativePathForLink) {
        this.relativePathForLink = relativePathForLink;
    }

    /**
     * Type이 "EMBEDDING"이거나 "STORAGE"일 때, 바이너리 데이터의 아이디를 반환한다.
     *
     * @return 바이너리 데이터의 아이디
     */
    public int getBinDataID() {
        return binDataID;
    }

    /**
     * Type이 "EMBEDDING"이거나 "STORAGE"일 때, 바이너리 데이터의 아이디를 설정한다.
     *
     * @param binDataID 바이너리 데이터의 아이디
     */
    public void setBinDataID(int binDataID) {
        this.binDataID = binDataID;
    }

    /**
     * Type이 "EMBEDDING"일 때, 파일의 extension을 반환한다.
     *
     * @return 파일의 extension
     */
    public String getExtensionForEmbedding() {
        return extensionForEmbedding;
    }

    /**
     * Type이 "EMBEDDING"일 때, 파일의 extension을 설정한다.
     *
     * @param extensionForEmbedding 파일의 extension
     */
    public void setExtensionForEmbedding(String extensionForEmbedding) {
        this.extensionForEmbedding = extensionForEmbedding;
    }

    public BinData clone() {
        BinData cloned = new BinData();
        cloned.property.copy(property);
        cloned.absolutePathForLink = absolutePathForLink;
        cloned.relativePathForLink = relativePathForLink;
        cloned.binDataID = binDataID;
        cloned.extensionForEmbedding = extensionForEmbedding;
        return cloned;
    }
}
