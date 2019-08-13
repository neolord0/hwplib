package kr.dogfoot.hwplib.object.bodytext.control.bookmark;


/**
 * 파라미터 아이템 종류
 *
 * @author neolord
 */
public enum ParameterType {
    /**
     * PIT_NULL,
     */
    NULL(0),
    /**
     * PIT_BSTR
     */
    String(1),
    /**
     * PIT_I1
     */
    Integer1(2),
    /**
     * PIT_I2
     */
    Integer2(3),
    /**
     * PIT_I4
     */
    Integer4(4),
    /**
     * PIT_I
     */
    Integer(5),
    /**
     * PIT_UI1
     */
    UnsignedInteger1(6),
    /**
     * PIT_UI2
     */
    UnsignedInteger2(7),
    /**
     * PIT_UI4
     */
    UnsignedInteger4(8),
    /**
     * PIT_UI
     */
    UnsignedInteger(9),
    /**
     * PIT_SET
     */
    ParameterSet(0x8000),
    /**
     * PIT_ARRAY
     */
    Array(0x8001),
    /**
     * PIT_BINDATA
     */
    BINDataID(0x8002);

    /**
     * 파일에 저장되는 정수값
     */
    private int value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    ParameterType(int value) {
        this.value = value;
    }

    /**
     * 파일에 저장되는 정수값을 반환한다.
     *
     * @return 파일에 저장되는 정수값
     */
    public int getValue() {
        return value;
    }

    /**
     * 파일에 저장되는 정수값에 해당되는 enum 값을 반환한다.
     *
     * @param value 파일에 저장되는 정수값
     * @return enum 값
     */
    public static ParameterType valueOf(int value) {
        for (ParameterType pt : values()) {
            if (pt.value == value) {
                return pt;
            }
        }
        return NULL;
    }
}
