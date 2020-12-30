package kr.dogfoot.hwplib.object.docinfo.charshape;

/**
 * 언어별 상대 크기
 *
 * @author neolord
 */
public class RelativeSizes {
    /**
     * 언어별 글자 장평의 값이 저장된 배열
     */
    private short[] array;

    /**
     * 생성자
     */
    public RelativeSizes() {
        array = new short[7];
    }

    /**
     * 언어별 글자 장평의 값이 저장된 배열을 반환한다.
     *
     * @return 언어별 글자 장평의 값이 저장된 배열
     */
    public short[] getArray() {
        return array;
    }

    /**
     * 언어별 글자 장평의 값이 저장된 배열를 설정한다.
     *
     * @param array 언어별 글자 장평의 값이 저장된 배열
     * @throws Exception array 크기가 7이 아닐때 발생
     */
    public void setArray(short[] array) throws Exception {
        if (array.length != 7) {
            throw new Exception("array length must be 7");
        }
        this.array = array;
    }

    /**
     * 한글에 대한 글자 장평을 반환한다.
     *
     * @return 한글에 대한 글자 장평
     */
    public short getHangul() {
        return array[0];
    }

    /**
     * 한글에 대한 글자 장평을 설정한다.
     *
     * @param relativeSize 한글에 대한 글자 장평
     */
    public void setHangul(short relativeSize) {
        array[0] = relativeSize;
    }

    /**
     * 영어에 대한 글자 장평을 반환한다.
     *
     * @return 영어에 대한 글자 장평
     */
    public short getLatin() {
        return array[1];
    }

    /**
     * 영어에 대한 글자 장평을 설정한다.
     *
     * @param relativeSize 영어에 대한 글자 장평
     */
    public void setLatin(short relativeSize) {
        array[1] = relativeSize;
    }

    /**
     * 한자에 대한 글자 장평을 반환한다.
     *
     * @return 한자에 대한 글자 장평
     */
    public short getHanja() {
        return array[2];
    }

    /**
     * 한자에 대한 글자 장평을 설정한다.
     *
     * @param relativeSize 한자에 대한 글자 장평
     */
    public void setHanja(short relativeSize) {
        array[2] = relativeSize;
    }

    /**
     * 일본어에 대한 글자 장평을 반환한다.
     *
     * @return 일본어에 대한 글자 장평
     */
    public short getJapanese() {
        return array[3];
    }

    /**
     * 일본어에 대한 글자 장평을 설정한다.
     *
     * @param relativeSize 일본어에 대한 글자 장평
     */
    public void setJapanese(short relativeSize) {
        array[3] = relativeSize;
    }

    /**
     * 기타 언어에 대한 글자 장평을 반환한다.
     *
     * @return 기타 언어에 대한 글자 장평
     */
    public short getOther() {
        return array[4];
    }

    /**
     * 기타 언어에 대한 글자 장평을 설정한다.
     *
     * @param relativeSize 기타 언어에 대한 글자 장평
     */
    public void setOther(short relativeSize) {
        array[4] = relativeSize;
    }

    /**
     * 기호에 대한 글자 장평을 반환한다.
     *
     * @return 기호에 대한 글자 장평
     */
    public short getSymbol() {
        return array[5];
    }

    /**
     * 기호에 대한 글자 장평을 설정한다.
     *
     * @param relativeSize 기호에 대한 글자 장평
     */
    public void setSymbol(short relativeSize) {
        array[5] = relativeSize;
    }

    /**
     * 사용자 정의 글자 장평을 반환한다.
     *
     * @return 사용자 정의 글자 장평
     */
    public short getUser() {
        return array[6];
    }

    /**
     * 사용자 정의 글자 장평을 설정한다.
     *
     * @param relativeSize 사용자 정의 글자 장평
     */
    public void setUser(short relativeSize) {
        array[6] = relativeSize;
    }

    /**
     * 모든 문자에 대한 글자 장평을 설정한다.
     *
     * @param relativeSize 모든 문자에 대한 글자 장평
     */
    public void setForAll(short relativeSize) {
        for (int index = 0; index < 7; index++) {
            array[index] = relativeSize;
        }
    }

    public void copy(RelativeSizes from) {
        System.arraycopy(from.array, 0, array, 0, from.array.length);
    }
}
