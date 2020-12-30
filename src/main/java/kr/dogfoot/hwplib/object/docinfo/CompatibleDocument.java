package kr.dogfoot.hwplib.object.docinfo;

import kr.dogfoot.hwplib.object.docinfo.compatibledocument.CompatibleDocumentSort;

/**
 * 호환 문서에 대한 레코드
 *
 * @author neolord
 */
public class CompatibleDocument {
    /**
     * 대상 프로그램의 종류
     */
    private CompatibleDocumentSort targetProgream;

    public CompatibleDocument() {
    }

    /**
     * 대상 프로그램의 종류를 반환한다.
     *
     * @return 대상 프로그램의 종류
     */
    public CompatibleDocumentSort getTargetProgream() {
        return targetProgream;
    }

    /**
     * 대상 프로그램의 종류를 설정한다.
     *
     * @param targetProgream 대상 프로그램의 종류
     */
    public void setTargetProgream(CompatibleDocumentSort targetProgream) {
        this.targetProgream = targetProgream;
    }

    public CompatibleDocument clone() {
        CompatibleDocument cloned = new CompatibleDocument();
        cloned.targetProgream = targetProgream;
        return cloned;
    }
}
