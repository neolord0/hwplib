package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent;

import java.util.ArrayList;

/**
 * 컨테이너 컨트롤을 위한 객체 공통 속성 레코드
 *
 * @author neolord
 */
public class ShapeComponentContainer extends ShapeComponent {
    /**
     * 컨테이너에 포함된 컨트롤의 id 리스트
     */
    private ArrayList<Long> childControlIdList;

    /**
     * 생성자
     */
    public ShapeComponentContainer() {
        childControlIdList = new ArrayList<Long>();
    }

    /**
     * 컨테이너에 포함된 컨트롤의 id를 리스트 추가한다.
     *
     * @param id 컨테이너에 포함된 컨트롤의 id
     */
    public void addChildControlId(long id) {
        childControlIdList.add(id);
    }

    /**
     * 컨테이너에 포함된 컨트롤의 id 리스트를 반환한다.
     *
     * @return 컨테이너에 포함된 컨트롤의 id 리스트
     */
    public ArrayList<Long> getChildControlIdList() {
        return childControlIdList;
    }
}
