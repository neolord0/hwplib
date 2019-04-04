package kr.dogfoot.hwplib.object.docinfo.charshape;

/**
 * 언어별 글자 위치에 대한 객체
 *
 * @author neolord
 */
public class CharOffsets {
    /**
     * 언어별 글자 위치의 값이 저장된 배열
     */
    private byte[] array;

    /**
     * 생성자
     */
    public CharOffsets() {
        array = new byte[7];
    }

    /**
     * 언어별 글자 위치의 값이 저장된 배열을 반환한다.
     *
     * @return 언어별 글자 위치의 값이 저장된 배열
     */
    public byte[] getArray() {
        return array;
    }

    /**
     * 언어별 글자 위치의 값이 저장된 배열를 설정한다.
     *
     * @param array 언어별 글자 위치의 값이 저장된 배열
     * @throws Exception array 크기가 7이 아닐때 발생
     */
    public void setArray(byte[] array) throws Exception {
        if (array.length != 7) {
            throw new Exception("array length must be 7");
        }
        this.array = array;
    }

    /**
     * 한글에 대한 글자 위치 값을 반환한다.
     *
     * @return 한글에 대한 글자 위치 값
     */
    public byte getHangul() {
        return array[0];
    }

    /**
     * 한글에 대한 글자 위치 값을 설정한다.
     *
     * @param charOffset 한글에 대한 글자 위치 값
     */
    public void setHangul(byte charOffset) {
        array[0] = charOffset;
    }

    /**
     * 영어에 대한 글자 위치 값을 반환한다.
     *
     * @return 영어에 대한 글자 위치 값
     */
    public byte getLatin() {
        return array[1];
    }

    /**
     * 영어에 대한 글자 위치 값을 설정한다.
     *
     * @param charOffset 영어에 대한 글자 위치 값
     */
    public void setLatin(byte charOffset) {
        array[1] = charOffset;
    }

    /**
     * 한자에 대한 글자 위치 값을 반환한다.
     *
     * @return 한자에 대한 글자 위치 값
     */
    public byte getHanja() {
        return array[2];
    }

    /**
     * 한자에 대한 글자 위치 값을 설정한다.
     *
     * @param charOffset 한자에 대한 글자 위치 값
     */
    public void setHanja(byte charOffset) {
        array[2] = charOffset;
    }

    /**
     * 일본어에 대한 글자 위치 값을 반환한다.
     *
     * @return 일본어에 대한 글자 위치 값
     */
    public byte getJapanese() {
        return array[3];
    }

    /**
     * 일본어에 대한 글자 위치 값을 설정한다.
     *
     * @param charOffset 일본어에 대한 글자 위치 값
     */
    public void setJapanese(byte charOffset) {
        array[3] = charOffset;
    }

    /**
     * 기타 언어에 대한 글자 위치 값를 반환한다.
     *
     * @return 기타 언어에 대한 글자 위치 값
     */
    public byte getOther() {
        return array[4];
    }

    /**
     * 기타 언어에 대한 글자 위치 값을 반환한다.
     *
     * @param charOffset 기타 언어에 대한 글자 위치 값
     */
    public void setOther(byte charOffset) {
        array[4] = charOffset;
    }

    /**
     * 기호에 대한 글자 위치 값을 반환한다.
     *
     * @return 기호에 대한 글자 위치 값
     */
    public byte getSymbol() {
        return array[5];
    }

    /**
     * 기호에 대한 글자 위치 값를 설정한다.
     *
     * @param charOffset 기호에 대한 글자 위치 값
     */
    public void setSymbol(byte charOffset) {
        array[5] = charOffset;
    }

    /**
     * 사용자 정의 글자 위치 값을 반환한다.
     *
     * @return 사용자 정의 글자 위치 값
     */
    public byte getUser() {
        return array[6];
    }

    /**
     * 사용자 정의 글자 위치 값를 설정한다.
     *
     * @param charOffset 사용자 정의 글자 위치 값
     */
    public void setUser(byte charOffset) {
        array[6] = charOffset;
    }

    /**
     * 모든 문자에 대한 글자 위치 값를 설정한다.
     *
     * @param charOffset 모든 문자에 대한 글자 위치 값
     */
    public void setForAll(byte charOffset) {
        for (int index = 0; index < 7; index++) {
            array[index] = charOffset;
        }
    }
}
