package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent;

/**
 * 객체 공통 속성
 *
 * @author neolord
 */
public abstract class ShapeComponent {
    /**
     * 개체 컨트롤 Id
     */
    private long gsoId;

    /**
     * 생성자
     */
    protected ShapeComponent() {
    }

    /**
     * 개체 컨트롤 Id를 반환한다.
     *
     * @return 개체 컨트롤 Id
     */
    public long getGsoId() {
        return gsoId;
    }

    /**
     * 개체 컨트롤 Id를 설정한다.
     *
     * @param gsoId 개체 컨트롤 Id
     */
    public void setGsoId(long gsoId) {
        this.gsoId = gsoId;
    }

    public abstract void copy(ShapeComponent from);

}
