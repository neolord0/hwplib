package kr.dogfoot.hwplib.object.docinfo.compatibledocument;

/**
 * 대상 프로그램의 종류
 *
 * @author neolord
 */
public enum CompatibleDocumentSort {
    /**
     * 한글 문서(현재 버전)
     */
    HWPCurrent((byte) 0),
    /**
     * 한글 2007 호환 문서
     */
    HWP2007((byte) 1),
    /**
     * MS 워드 호환 문서
     */
    MSWord((byte) 2);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    CompatibleDocumentSort(byte value) {
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
    public static CompatibleDocumentSort valueOf(byte value) {
        for (CompatibleDocumentSort cds : values()) {
            if (cds.value == value) {
                return cds;
            }
        }
        return HWPCurrent;
    }
}
