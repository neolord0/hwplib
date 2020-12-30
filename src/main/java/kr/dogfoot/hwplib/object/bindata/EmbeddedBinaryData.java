package kr.dogfoot.hwplib.object.bindata;

import kr.dogfoot.hwplib.object.docinfo.bindata.BinDataCompress;

/**
 * HWP 파일내에서 사용하는 이미지등의 바이너리 데이터를 저장하는 객체
 *
 * @author neolord
 */
public class EmbeddedBinaryData {
    /**
     * 바이너리 데이터의 이름
     */
    private String name;
    /**
     * 실제 데이터
     */
    private byte[] data;
    /**
     * 압축 방법
     */
    private BinDataCompress compressMethod;

    /**
     * 생성자
     */
    public EmbeddedBinaryData() {
    }

    /**
     * 바이너리 데이터의 이름을 반환한다.
     *
     * @return 바이너리 데이터의 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 바이너리 데이터의 이름을 설정한다.
     *
     * @param name 바이너리 데이터의 이름
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 실제 데이터를 반환한다.
     *
     * @return 실제 데이터
     */
    public byte[] getData() {
        return data;
    }

    /**
     * 실제 데이터를 설정한다.
     *
     * @param data 실제 데이터
     */
    public void setData(byte[] data) {
        this.data = data;
    }

    /**
     * 압축 방법을 리턴한다.
     *
     * @return 압축 방법
     */
    public BinDataCompress getCompressMethod() {
        return compressMethod;
    }

    /**
     * 압축 방법을 설정한다.
     *
     * @param compressMethod 압축 방법
     */
    public void setCompressMethod(BinDataCompress compressMethod) {
        this.compressMethod = compressMethod;
    }

    public EmbeddedBinaryData clone(boolean deepCopyImage) {
        EmbeddedBinaryData cloned = new EmbeddedBinaryData();
        cloned.name = name;
        if (deepCopyImage) {
            cloned.data = data.clone();
        } else {
            cloned.data = data;
        }
        cloned.compressMethod = compressMethod;
        return cloned;
    }
}
