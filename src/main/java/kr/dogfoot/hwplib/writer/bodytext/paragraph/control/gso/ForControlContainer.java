package kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso;

import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlContainer;
import kr.dogfoot.hwplib.object.bodytext.control.gso.GsoControl;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

/**
 * 묶음 컨트롤의 나머지 부분을 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForControlContainer {
    /**
     * 묶음 컨트롤의 나머지 부분을 쓴다.
     *
     * @param cont 묶음 컨트롤
     * @param sw   스트림 라이터
     * @throws Exception
     */
    public static void writeRest(ControlContainer cont, StreamWriter sw)
            throws Exception {
        childControls(cont, sw);
    }

    /**
     * 묶음 컨트롤에 포함된 컨트롤들을 쓴다.
     *
     * @param cont 묶음 컨트롤
     * @param sw   스트림 라이터
     * @throws Exception
     */
    private static void childControls(ControlContainer cont, StreamWriter sw)
            throws Exception {
        for (GsoControl child : cont.getChildControlList()) {
            ForGsoControl.writeInContainer(child, sw);
        }
    }
}
