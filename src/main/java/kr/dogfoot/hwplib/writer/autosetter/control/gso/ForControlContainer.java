package kr.dogfoot.hwplib.writer.autosetter.control.gso;

import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlContainer;
import kr.dogfoot.hwplib.object.bodytext.control.gso.GsoControl;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.ShapeComponentContainer;
import kr.dogfoot.hwplib.writer.autosetter.InstanceID;

/**
 * 묶음 컨트롤을 쓰기 전에 자동 설정하기 위한 객체
 *
 * @author neolord
 */
public class ForControlContainer {
    /**
     * 묶음 컨트롤을 자동 설정하다.
     *
     * @param cont 묶음 컨트롤
     * @param iid  인스턴스 id
     */
    public static void autoSet(ControlContainer cont, InstanceID iid) {
        shapeComponent(cont);
        childControls(cont, iid);
    }

    /**
     * 묶음 컨트롤의 객체 공통 속성 레코드를 자동 설정한다.
     *
     * @param cont 묶음 컨트롤
     */
    private static void shapeComponent(ControlContainer cont) {
        ShapeComponentContainer scc = (ShapeComponentContainer) cont
                .getShapeComponent();
        scc.getChildControlIdList().clear();
        for (GsoControl child : cont.getChildControlList()) {
            scc.addChildControlId(child.getGsoId());
        }
    }

    /**
     * 묶음 컨트롤의 자식 컨트롤들을 자동 설정한다.
     *
     * @param cont 묶음 컨트롤
     * @param iid  인스턴스 id
     */
    private static void childControls(ControlContainer cont, InstanceID iid) {
        for (GsoControl child : cont.getChildControlList()) {
            ForGsoControl.autoSet(child, iid);
        }
    }
}
