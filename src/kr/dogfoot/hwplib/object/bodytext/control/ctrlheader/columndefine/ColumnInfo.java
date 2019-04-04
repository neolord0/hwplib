package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.columndefine;

/**
 * 하나의 단에 대한 정보를 나태내는 객체
 *
 * @author neolord
 */
public class ColumnInfo {
    /**
     * 다단의 폭
     */
    private int width;
    /**
     * 다음 단과의 간격
     */
    private int gap;

    /**
     * 생성자
     */
    public ColumnInfo() {
    }

    /**
     * 다단의 폭을 반환한다.
     *
     * @return 다단의 폭
     */
    public int getWidth() {
        return width;
    }

    /**
     * 다단의 폭을 설정한다.
     *
     * @param width 다단의 폭
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * 다음 단과의 간격을 반환한다.
     *
     * @return 다음 단과의 간격
     */
    public int getGap() {
        return gap;
    }

    /**
     * 다음 단과의 간격을 설정한다.
     *
     * @param gap 다음 단과의 간격
     */
    public void setGap(int gap) {
        this.gap = gap;
    }
}
