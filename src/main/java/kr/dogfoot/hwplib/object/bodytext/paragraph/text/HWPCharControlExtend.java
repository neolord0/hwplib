package kr.dogfoot.hwplib.object.bodytext.paragraph.text;

/**
 * 확장 컨트롤 Character
 *
 * @author neolord
 */
public class HWPCharControlExtend extends HWPChar {
    /**
     * 추가 정보
     */
    private byte[] addition;

    /**
     * 생성자
     */
    public HWPCharControlExtend() {
    }

    /**
     * 글자의 종류을 반환한다.
     *
     * @return 글자의 타입
     */
    @Override
    public HWPCharType getType() {
        return HWPCharType.ControlExtend;
    }

    /**
     * 컨트롤 객체의 Instance Id를 반환한다.
     *
     * @return 컨트롤 객체의 Instance Id
     */
    public String getInstanceId() {
        int bufferIndex = 0;
        boolean insert = false;
        byte[] buf = new byte[addition.length];
        for (int index = addition.length - 1; index >= 0; index--) {
            if (addition[index] != 0) {
                insert = true;
            }

            if (insert == true) {
                buf[bufferIndex++] = addition[index];
            }
        }
        return new String(buf, 0, bufferIndex);
    }

    /**
     * 추가 정보를 반환한다.
     *
     * @return 추가 정보
     */
    public byte[] getAddition() {
        return addition;
    }

    /**
     * 추가 정보를 설정한다.
     *
     * @param addition 추가 정보
     * @throws Exception
     */
    public void setAddition(byte[] addition) throws Exception {
        if (addition.length != 12) {
            throw new Exception("addition's length must be 12");
        }
        this.addition = addition;
    }
}
