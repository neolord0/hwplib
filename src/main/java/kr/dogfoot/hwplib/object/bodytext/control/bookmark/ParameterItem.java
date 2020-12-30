package kr.dogfoot.hwplib.object.bodytext.control.bookmark;

/**
 * 파라미터 아이탬 객체
 *
 * @author neolord
 */
public class ParameterItem {
    /**
     * 파라미터 아이탬 id
     */
    private long id;
    /**
     * 파라미터 아이템 종류
     */
    private ParameterType type;
    /**
     * 파라미터 아이템 값(문자열)
     */
    private String value_BSTR;
    /**
     * 파라미터 아이템 값(1byte 정수)
     */
    private byte value_I1;
    /**
     * 파라미터 아이템 값(2byte 정수)
     */
    private short value_I2;
    /**
     * 파라미터 아이템 값(4byte 정수)
     */
    private int value_I4;
    /**
     * 파라미터 아이템 값(정수)
     */
    private int value_I;
    /**
     * 파라미터 아이템 값(1byte 부호없는 정수)
     */
    private short value_UI1;
    /**
     * 파라미터 아이템 값(2byte 부호없는 정수)
     */
    private int value_UI2;
    /**
     * 파라미터 아이템 값(4byte 부호없는 정수)
     */
    private long value_UI4;
    /**
     * 파라미터 아이템 값(부호없는 정수)
     */
    private long value_UI;
    /**
     * 파라미터 아이템 값(파라미터 셋)
     */
    private ParameterSet value_ParameterSet;
    /**
     * 파라미터 아이템 값(파라미터 배열)
     */
    private ParameterItem[] value_ParameterArray;
    /**
     * 파라미터 아이템 값(binData id)
     */
    private int value_binData;

    /**
     * 생성자
     */
    public ParameterItem() {
        id = 0;
        type = ParameterType.NULL;

        value_BSTR = null;
        value_I1 = 0;
        value_I2 = 0;
        value_I4 = 0;
        value_I = 0;
        value_UI1 = 0;
        value_UI2 = 0;
        value_UI4 = 0;
        value_UI = 0;
        value_ParameterSet = null;
        value_ParameterArray = null;
        value_binData = -1;
    }

    /**
     * 파라미터 아이탬 id를 반환한다.
     *
     * @return 파라미터 아이탬 id
     */
    public long getId() {
        return id;
    }

    /**
     * 파라미터 아이탬 id를 설정한다.
     *
     * @param id 파라미터 아이탬 id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * 파라미터 아이템 종류를 반환한다.
     *
     * @return 파라미터 아이템 종류
     */
    public ParameterType getType() {
        return type;
    }

    /**
     * 파라미터 아이템 종류를 설정한다.
     *
     * @param type 파라미터 아이템 종류
     */
    public void setType(ParameterType type) {
        this.type = type;
    }

    /**
     * 파라미터 아이템 값(문자열)을 반환한다.
     *
     * @return 파라미터 아이템 값(문자열)
     */
    public String getValue_BSTR() {
        return value_BSTR;
    }

    /**
     * 파라미터 아이템 값(문자열)을 설정한다.
     *
     * @param value_BSTR 파라미터 아이템 값(문자열)
     */
    public void setValue_BSTR(String value_BSTR) {
        this.value_BSTR = value_BSTR;
    }

    /**
     * 파라미터 아이템 값(1byte 정수)을 반환한다.
     *
     * @return 파라미터 아이템 값(1byte 정수)
     */
    public byte getValue_I1() {
        return value_I1;
    }

    /**
     * 파라미터 아이템 값(1byte 정수)을 설정한다.
     *
     * @param value_I1 파라미터 아이템 값(1byte 정수)
     */
    public void setValue_I1(byte value_I1) {
        this.value_I1 = value_I1;
    }

    /**
     * 파라미터 아이템 값(2byte 정수)을 반환한다.
     *
     * @return 파라미터 아이템 값(2byte 정수)
     */
    public short getValue_I2() {
        return value_I2;
    }

    /**
     * 파라미터 아이템 값(2byte 정수)을 설정한다.
     *
     * @param value_I2 파라미터 아이템 값(2byte 정수)
     */
    public void setValue_I2(short value_I2) {
        this.value_I2 = value_I2;
    }

    /**
     * 파라미터 아이템 값(4byte 정수)을 반환한다.
     *
     * @return 파라미터 아이템 값(4byte 정수)
     */
    public int getValue_I4() {
        return value_I4;
    }

    /**
     * 파라미터 아이템 값(4byte 정수)을 설정한다.
     *
     * @param value_I4 파라미터 아이템 값(4byte 정수)
     */
    public void setValue_I4(int value_I4) {
        this.value_I4 = value_I4;
    }

    /**
     * 파라미터 아이템 값(정수)을 반환한다.
     *
     * @return 파라미터 아이템 값(정수)
     */
    public int getValue_I() {
        return value_I;
    }

    /**
     * 파라미터 아이템 값(정수)을 설정한다.
     *
     * @param value_I 파라미터 아이템 값(정수)
     */
    public void setValue_I(int value_I) {
        this.value_I = value_I;
    }

    /**
     * 파라미터 아이템 값(1byte 부호없는 정수)을 반환한다.
     *
     * @return 파라미터 아이템 값(1byte 부호없는 정수)
     */
    public short getValue_UI1() {
        return value_UI1;
    }

    /**
     * 파라미터 아이템 값(1byte 부호없는 정수)을 설정한다.
     *
     * @param value_UI1 파라미터 아이템 값(1byte 부호없는 정수)
     */
    public void setValue_UI1(short value_UI1) {
        this.value_UI1 = value_UI1;
    }

    /**
     * 파라미터 아이템 값(2byte 부호없는 정수)을 반환한다.
     *
     * @return 파라미터 아이템 값(2byte 부호없는 정수)
     */
    public int getValue_UI2() {
        return value_UI2;
    }

    /**
     * 파라미터 아이템 값(2byte 부호없는 정수)을 설정한다.
     *
     * @param value_UI2 파라미터 아이템 값(2byte 부호없는 정수)
     */
    public void setValue_UI2(int value_UI2) {
        this.value_UI2 = value_UI2;
    }

    /**
     * 파라미터 아이템 값(4byte 부호없는 정수)을 반환한다.
     *
     * @return 파라미터 아이템 값(4byte 부호없는 정수)
     */
    public long getValue_UI4() {
        return value_UI4;
    }

    /**
     * 파라미터 아이템 값(4byte 부호없는 정수)을 설정한다.
     *
     * @param value_UI4 파라미터 아이템 값(4byte 부호없는 정수)
     */
    public void setValue_UI4(long value_UI4) {
        this.value_UI4 = value_UI4;
    }

    /**
     * 파라미터 아이템 값(부호없는 정수)을 반환한다.
     *
     * @return 파라미터 아이템 값(부호없는 정수)
     */
    public long getValue_UI() {
        return value_UI;
    }

    /**
     * 파라미터 아이템 값(부호없는 정수)을 설정한다.
     *
     * @param value_UI 파라미터 아이템 값(부호없는 정수)
     */
    public void setValue_UI(long value_UI) {
        this.value_UI = value_UI;
    }

    /**
     * 파라미터 아이템 값(파라미터 셋)을 반환한다.
     *
     * @return 파라미터 아이템 값(파라미터 셋)
     */
    public ParameterSet getValue_ParameterSet() {
        return value_ParameterSet;
    }

    /**
     * 파라미터 아이템 값(파라미터 셋) 객체를 생성한다.
     */
    public void createValue_ParameterSet() {
        value_ParameterSet = new ParameterSet();
    }

    /**
     * 파라미터 아이템 값(파라미터 셋) 객체를 삭제한다.
     */
    public void deleteValue_ParameterSet() {
        value_ParameterSet = null;
    }

    /**
     * 파라미터 아이템 값(파라미터 배열)의 원소 개수를 반환한다.
     *
     * @return 파라미터 아이템 값(파라미터 배열)의 원소 개수
     */
    public int getValue_ParameterArrayCount() {
        if (value_ParameterArray != null) {
            return value_ParameterArray.length;
        } else {
            return 0;
        }
    }

    /**
     * 파라미터 아이템 값(파라미터 배열)의 원소를 반환한다.
     *
     * @param index 파라미터 아이템 값(파라미터 배열)의 원소 인덱스
     * @return 파라미터 아이템 값(파라미터 배열)의 원소
     */
    public ParameterItem getValue_ParameterArray(int index) {
        if (value_ParameterArray != null) {
            return value_ParameterArray[index];
        } else {
            return null;
        }
    }

    /**
     * 파라미터 아이템 값(파라미터 배열)을 생성한다.
     *
     * @param count 파라미터 아이템 값(파라미터 배열)의 원소 개수
     */
    public void createValue_ParameterArray(int count) {
        value_ParameterArray = new ParameterItem[count];
        for (int index = 0; index < count; index++) {
            value_ParameterArray[index] = new ParameterItem();
        }
    }

    /**
     * 파라미터 아이템 값(파라미터 배열)을 삭제한다.
     */
    public void deleteValue_ParameterArray() {
        value_ParameterArray = null;
    }

    /**
     * 파라미터 아이템 값(binData id)을 반환한다.
     *
     * @return 파라미터 아이템 값(binData id)
     */
    public int getValue_binData() {
        return value_binData;
    }

    /**
     * 파라미터 아이템 값(binData id)를 설정한다.
     *
     * @param value_binData 파라미터 아이템 값(binData id)
     */
    public void setValue_binData(int value_binData) {
        this.value_binData = value_binData;
    }

    public ParameterItem clone() {
        ParameterItem cloned = new ParameterItem();
        cloned.copy(this);
        return cloned;
    }

    public void copy(ParameterItem from) {
        id = from.id;
        type = from.type;
        value_BSTR = from.value_BSTR;
        value_I1 = from.value_I1;
        value_I2 = from.value_I2;
        value_I4 = from.value_I4;
        value_I = from.value_I;
        value_UI1 = from.value_UI1;
        value_UI2 = from.value_UI2;
        value_UI4 = from.value_UI4;
        value_UI = from.value_UI;

        if (from.value_ParameterSet != null) {
            createValue_ParameterSet();
            value_ParameterSet.copy(from.value_ParameterSet);
        } else {
            value_ParameterSet = null;
        }

        if (from.value_ParameterArray != null) {
            int count = from.value_ParameterArray.length;
            createValue_ParameterArray(count);
            for (int index = 0; index < count; index++) {
                value_ParameterArray[index].copy(from.value_ParameterArray[index]);
            }
        }

        value_binData = from.value_binData;
    }
}
