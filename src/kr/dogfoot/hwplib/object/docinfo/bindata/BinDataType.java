package kr.dogfoot.hwplib.object.docinfo.bindata;

/**
 * 바이너리 데이터의 타입
 *
 * @author neolord
 */
public enum BinDataType {
    /**
     * LINK. 그림 외부 파일 참조
     */
    Link((byte) 0),
    /**
     * EMBEDDING. 그림 파일 포함
     */
    Embedding((byte) 1),
    /**
     * STORAGE. OLE 포함
     */
    Storage((byte) 2);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    BinDataType(byte value) {
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
    public static BinDataType valueOf(byte value) {
        for (BinDataType bdt : values()) {
            if (bdt.value == value) {
                return bdt;
            }
        }
        return Link;
    }
}
