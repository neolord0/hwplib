package kr.dogfoot.hwplib.object.docinfo.charshape;

/**
 * 언어별 자간에 대한 객체
 *
 * @author neolord
 */
public class CharSpaces {
    /**
     * 언어별 글자 자간의 값이 저장된 배열
     */
    private byte[] array;

    /**
     * 생성자
     */
    public CharSpaces() {
        array = new byte[7];
    }

    /**
     * 언어별 글자 자간의 값이 저장된 배열를 반환한다.
     *
     * @return 언어별 글자 자간의 값이 저장된 배열
     */
    public byte[] getArray() {
        return array;
    }

    /**
     * 언어별 글자 자간의 값이 저장된 배열를 설정한다.
     *
     * @param array 언어별 글자 자간의 값이 저장된 배열
     * @throws Exception array 크기가 7이 아닐때 발생
     */
    public void setArray(byte[] array) throws Exception {
        if (array.length != 7) {
            throw new Exception("array length must be 7");
        }
        this.array = array;
    }

    /**
     * 한글에 대한 자간 값을 반환한다.
     *
     * @return 한글에 대한 자간 값
     */
    public byte getHangul() {
        return array[0];
    }

    /**
     * 한글에 대한 자간 값을 설정한다.
     *
     * @param charSpace 한글에 대한 자간 값
     */
    public void setHangul(byte charSpace) {
        array[0] = charSpace;
    }

    /**
     * 영어에 대한 자간 값을 반환한다.
     *
     * @return 영어에 대한 자간 값
     */
    public byte getLatin() {
        return array[1];
    }

    /**
     * 영어에 대한 자간 값을 설정한다.
     *
     * @param charSpace 영어에 대한 자간 값
     */
    public void setLatin(byte charSpace) {
        array[1] = charSpace;
    }

    /**
     * 한자에 대한 자간 값을 반환한다.
     *
     * @return 한자에 대한 자간 값
     */
    public byte getHanja() {
        return array[2];
    }

    /**
     * 한자에 대한 자간 값을 설정한다.
     *
     * @param charSpace 한자에 대한 자간 값
     */
    public void setHanja(byte charSpace) {
        array[2] = charSpace;
    }

    /**
     * 일본어에 대한 자간 값을 반환한다.
     *
     * @return 일본어에 대한 자간 값
     */
    public byte getJapanese() {
        return array[3];
    }

    /**
     * 일본어에 대한 자간 값을 설정한다.
     *
     * @param charSpace 일본어에 대한 자간 값
     */
    public void setJapanese(byte charSpace) {
        array[3] = charSpace;
    }

    /**
     * 기타 언어에 대한 자간 값을 반환한다.
     *
     * @return 기타 언어에 대한 자간 값
     */
    public byte getOther() {
        return array[4];
    }

    /**
     * 기타 언어에 대한 자간 값을 설정한다.
     *
     * @param charSpace 기타 언어에 대한 자간 값
     */
    public void setOther(byte charSpace) {
        array[4] = charSpace;
    }

    /**
     * 기호에 대한 자간 값을 반환한다.
     *
     * @return 기호에 대한 자간 값
     */
    public byte getSymbol() {
        return array[5];
    }

    /**
     * 기호에 대한 자간 값을 설정한다.
     *
     * @param charSpace 기호에 대한 자간 값
     */
    public void setSymbol(byte charSpace) {
        array[5] = charSpace;
    }

    /**
     * 사용자 정의 자간 값을 반환한다.
     *
     * @return 사용자 정의 자간 값
     */
    public byte getUser() {
        return array[6];
    }

    /**
     * 사용자 정의 자간 값을 설정한다.
     *
     * @param charSpace 사용자 정의 자간 값
     */
    public void setUser(byte charSpace) {
        array[6] = charSpace;
    }

    /**
     * 모든 문자에 대한 자간 값를 설정한다.
     *
     * @param charSpace 모든 문자에 대한 자간 값
     */
    public void setForAll(byte charSpace) {
        for (int index = 0; index < 7; index++) {
            array[index] = charSpace;
        }
    }
}
