package kr.dogfoot.hwplib.object.bodytext.control.sectiondefine;

import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 용지 설정의 속성에 대한 객체
 *
 * @author neolord
 */
public class PageDefProperty {
    /**
     * 파일에 저장되는 정수값(unsigned 4 byte)
     */
    private long value;

    /**
     * 생성자
     */
    public PageDefProperty() {
    }

    /**
     * 파일에 저장되는 정수값을 반환한다.
     *
     * @return 파일에 저장되는 정수값
     */
    public long getValue() {
        return value;
    }

    /**
     * 파일에 저장되는 정수값을 설정한다.
     *
     * @param value 파일에 저장되는 정수값
     */
    public void setValue(long value) {
        this.value = value;
    }

    /**
     * 용지 방향을 반환한다. (0 bit)
     *
     * @return 용지 방향
     */
    public PaperDirection getPaperDirection() {
        if (BitFlag.get(value, 0) == false) {
            return PaperDirection.Potrait;
        } else {
            return PaperDirection.Landscape;
        }
    }

    /**
     * 용지 방향을 설정한다. (0 bit)
     *
     * @param paperDirection 용지 방향
     */
    public void setPaperDirection(PaperDirection paperDirection) {
        if (paperDirection == PaperDirection.Potrait) {
            value = BitFlag.set(value, 0, false);
        } else {
            value = BitFlag.set(value, 0, true);
        }
    }

    /**
     * 제책 방법을 반환한다. (1~2 bit)
     *
     * @return 제책 방법
     */
    public MakingBookMethod getMakingBookMethod() {
        return MakingBookMethod.valueOf((byte) BitFlag.get(value, 1, 2));
    }

    /**
     * 제책 방법을 설정한다. (1~2 bit)
     *
     * @param makingBookMethod
     */
    public void setMakingBookMethod(MakingBookMethod makingBookMethod) {
        value = BitFlag.set(value, 1, 2, makingBookMethod.getValue());
    }
}
