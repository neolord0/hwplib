package kr.dogfoot.hwplib.object.bodytext.control.gso;

import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.FactoryForControl;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderGso;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.ShapeComponentContainer;

import java.util.ArrayList;

/**
 * 묶음 개체 컨트롤
 *
 * @author neolord
 */
public class ControlContainer extends GsoControl {
    /**
     * 차일드 컨트롤 리스트
     */
    private ArrayList<GsoControl> childControlList;

    /**
     * 생성자
     */
    public ControlContainer() {
        this(new CtrlHeaderGso());
    }

    /**
     * 생성자
     *
     * @param header 그리기 개체를 위한 컨트롤 헤더
     */
    public ControlContainer(CtrlHeaderGso header) {
        super(header);
        shapeComponent = new ShapeComponentContainer();

        setGsoId(GsoControlType.Container.getId());

        childControlList = new ArrayList<GsoControl>();
    }

    public GsoControl addNewChildControl(GsoControlType gsoType) {
        GsoControl gc = FactoryForControl.createGso(gsoType.getId(), new CtrlHeaderGso());
        childControlList.add(gc);
        return gc;
    }

    /**
     * 차일드 컨트롤을 리스트에 추가한다.
     *
     * @param childControl 차일드 컨트롤
     */
    public void addChildControl(GsoControl childControl) {
        childControlList.add(childControl);
    }

    /**
     * 차일드 컨트롤의 리스트를 반환한다.
     *
     * @return 차일드 컨트롤의 리스트
     */
    public ArrayList<GsoControl> getChildControlList() {
        return childControlList;
    }

    @Override
    public Control clone() {
        ControlContainer cloned = new ControlContainer();
        cloned.copyGsoControlPart(this);

        for (GsoControl childControl : childControlList) {
            cloned.childControlList.add((GsoControl) (childControl.clone()));
        }

        return cloned;
    }
}
