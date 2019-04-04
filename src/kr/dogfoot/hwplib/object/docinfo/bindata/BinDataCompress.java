package kr.dogfoot.hwplib.object.docinfo.bindata;

/**
 * 바이너리 데이터의 압축 방법
 *
 * @author neolord
 */
public enum BinDataCompress {
    /**
     * 스토리지의 디폴트 모드 따라감
     */
    ByStroageDefault((byte) 0),
    /**
     * 무조건 압축
     */
    Compress((byte) 1),
    /**
     * 무조건 압축하지 않음
     */
    NoCompress((byte) 2);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    BinDataCompress(byte value) {
        this.value = value;
    }

    /**
     * 파일에 저장되는 정수값을 반환한다.
     *
     * @return 파일에 저장되는 정수값
     */
    public byte getValue() {
        return value;
    }

    /**
     * 파일에 저장되는 정수값에 해당되는 enum 값을 반환한다.
     *
     * @param value 파일에 저장되는 정수값
     * @return enum 값
     */
    public static BinDataCompress valueOf(byte value) {
        for (BinDataCompress bdc : values()) {
            if (bdc.value == value) {
                return bdc;
            }
        }
        return ByStroageDefault;
    }
}
