package kr.dogfoot.hwplib.object.bodytext.control.bookmark;

/**
 * 임의 데이터 레코드
 *
 * @author neolord
 */
public class CtrlData {
    /**
     * 파라미터 셋
     */
    private ParameterSet parameterSet;

    /**
     * 생성자
     */
    public CtrlData() {
        parameterSet = new ParameterSet();
    }

    /**
     * 파라미터 셋을 반환한다.
     *
     * @return 파라미터 셋
     */
    public ParameterSet getParameterSet() {
        return parameterSet;
    }
}
