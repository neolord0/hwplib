package kr.dogfoot.hwplib.object.docinfo.charshape;

/**
 * 언어별 참조된 글꼴 ID(FaceID)
 *
 * @author neolord
 */
public class FaceNameIds {
    /**
     * 언어별 참조된 글꼴 ID 값이 저장된 배열
     */
    private int[] array;

    /**
     * 생성자
     */
    public FaceNameIds() {
        array = new int[7];
    }

    /**
     * 언어별 참조된 글꼴 ID 값이 저장된 배열를 반환한다.
     *
     * @return 언어별 참조된 글꼴 ID 값이 저장된 배열
     */
    public int[] getArray() {
        return array;
    }

    /**
     * 언어별 참조된 글꼴 ID 값이 저장된 배열를 설정한다.
     *
     * @param array 언어별 참조된 글꼴 ID 값이 저장된 배열
     * @throws Exception array 크기가 7이 아닐때 발생
     */
    public void setArray(int[] array) throws Exception {
        if (array.length != 7) {
            throw new Exception("array length must be 7");
        }
        this.array = array;
    }

    /**
     * 한글에 대한 참조된 글꼴 Id를 반환한다.
     *
     * @return 한글에 대한 참조된 글꼴 Id
     */
    public int getHangul() {
        return array[0];
    }

    /**
     * 한글에 대한 참조된 글꼴 Id를 설정한다.
     *
     * @param faceNameID 한글에 대한 참조된 글꼴 Id
     */
    public void setHangul(int faceNameID) {
        array[0] = faceNameID;
    }

    /**
     * 영어에 대한 참조된 글꼴 Id를 반환한다.
     *
     * @return 영어에 대한 참조된 글꼴 Id
     */
    public int getLatin() {
        return array[1];
    }

    /**
     * 영어에 대한 참조된 글꼴 Id를 설정한다.
     *
     * @param faceNameID 영어에 대한 참조된 글꼴 Id
     */
    public void setLatin(int faceNameID) {
        array[1] = faceNameID;
    }

    /**
     * 한자에 대한 참조된 글꼴 Id를 반환한다.
     *
     * @return 한자에 대한 참조된 글꼴 Id
     */
    public int getHanja() {
        return array[2];
    }

    /**
     * 한자에 대한 참조된 글꼴 Id를 설정한다.
     *
     * @param faceNameID 한자에 대한 참조된 글꼴 Id
     */
    public void setHanja(int faceNameID) {
        array[2] = faceNameID;
    }

    /**
     * 일본어에 대한 참조된 글꼴 Id를 반환한다.
     *
     * @return 일본어에 대한 참조된 글꼴 Id
     */
    public int getJapanese() {
        return array[3];
    }

    /**
     * 일본어에 대한 참조된 글꼴 Id를 설정한다.
     *
     * @param faceNameID 일본어에 대한 참조된 글꼴 Id
     */
    public void setJapanese(int faceNameID) {
        array[3] = faceNameID;
    }

    /**
     * 기타 언어에 대한 참조된 글꼴 Id를 반환한다.
     *
     * @return 기타 언어에 대한 참조된 글꼴 Id
     */
    public int getOther() {
        return array[4];
    }

    /**
     * 기타 언어에 대한 참조된 글꼴 Id를 설정한다.
     *
     * @param faceNameID 기타 언어에 대한 참조된 글꼴 Id
     */
    public void setOther(int faceNameID) {
        array[4] = faceNameID;
    }

    /**
     * 기호에 대한 참조된 글꼴 Id를 반환한다.
     *
     * @return 기호에 대한 참조된 글꼴 Id
     */
    public int getSymbol() {
        return array[5];
    }

    /**
     * 기호에 대한 참조된 글꼴 Id를 설정한다.
     *
     * @param faceNameID 기호에 대한 참조된 글꼴 Id
     */
    public void setSymbol(int faceNameID) {
        array[5] = faceNameID;
    }

    /**
     * 사용자 정의에 대한 참조된 글꼴 Id를 반환한다.
     *
     * @return 사용자 정의에 대한 참조된 글꼴 Id
     */
    public int getUser() {
        return array[6];
    }

    /**
     * 사용자 정의에 대한 참조된 글꼴 Id를 설정한다.
     *
     * @param faceNameID 사용자 정의에 대한 참조된 글꼴 Id
     */
    public void setUser(int faceNameID) {
        array[6] = faceNameID;
    }

    /**
     * 모든 문자에 대한 참조된 글꼴 Id를 설정한다.
     *
     * @param faceNameID 모든 문자에 대한 참조된 글꼴 Id
     */
    public void setForAll(int faceNameID) {
        for (int index = 0; index < 7; index++) {
            array[index] = faceNameID;
        }
    }
}
