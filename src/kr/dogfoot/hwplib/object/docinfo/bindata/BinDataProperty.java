package kr.dogfoot.hwplib.object.docinfo.bindata;

import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 바이너리 데이터의 속성
 *
 * @author neolord
 */
public class BinDataProperty {
    /**
     * 파일에 저장되는 정수값(unsigned 2 byte)
     */
    private int value;

    /**
     * 생성자
     */
    public BinDataProperty() {
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
     * 파일에 저장되는 정수값을 설정한다.
     *
     * @param value 파일에 저장되는 정수값
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * 바이너리 데이터의 타입을 반환한다. (0~3 BitFlag)
     *
     * @return 바이너리 데이터의 타입
     */
    public BinDataType getType() {
        return BinDataType.valueOf((byte) BitFlag.get(value, 0, 3));
    }

    /**
     * 바이너리 데이터의 타입을 설정한다. (0~3 BitFlag)
     *
     * @param type 바이너리 데이터의 타입
     */
    public void setType(BinDataType type) {
        value = BitFlag.set(value, 0, 3, type.getValue());
    }

    /**
     * 바이너리 데이터의 압축 방법을 반환한다. (4~5 BitFlag)
     *
     * @return 바이너리 데이터의 압축 방법
     */
    public BinDataCompress getCompress() {
        return BinDataCompress.valueOf((byte) BitFlag.get(value, 4, 5));
    }

    /**
     * 바이너리 데이터의 압축 방법을 설정한다. (4~5 BitFlag)
     *
     * @param compress 바이너리 데이터의 압축 방법
     */
    public void setCompress(BinDataCompress compress) {
        value = BitFlag.set(value, 4, 5, compress.getValue());
    }

    /**
     * 바이너리 데이터의 상태를 반환한다. (8~9 BitFlag)
     *
     * @return 바이너리 데이터의 상태
     */
    public BinDataState getState() {
        return BinDataState.valueOf((byte) BitFlag.get(value, 8, 9));
    }

    /**
     * 바이너리 데이터의 상태를 설정한다. (8~9 BitFlag)
     *
     * @param state 바이너리 데이터의 상태
     */
    public void setState(BinDataState state) {
        value = BitFlag.set(value, 8, 9, state.getValue());
    }
}
