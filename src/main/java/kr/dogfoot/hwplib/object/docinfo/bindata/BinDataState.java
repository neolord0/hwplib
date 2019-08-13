package kr.dogfoot.hwplib.object.docinfo.bindata;

/**
 * 바이너리 데이터의 상태
 *
 * @author neolord
 */
public enum BinDataState {
    /**
     * 아직 access 된 적이 없는 상태
     */
    NotAcceess((byte) 0),
    /**
     * access에 성공하여 파일을 찾은 상태
     */
    SuccessAccess((byte) 1),
    /**
     * access가 실패한 에러 상태
     */
    FailAccess((byte) 2),
    /**
     * 링크 access가 실패했으나 무시된 상태
     */
    FailAccessButIgnore((byte) 3);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    BinDataState(byte value) {
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
    public static BinDataState valueOf(byte value) {
        for (BinDataState bds : values()) {
            if (bds.value == value) {
                return bds;
            }
        }
        return NotAcceess;
    }
}
