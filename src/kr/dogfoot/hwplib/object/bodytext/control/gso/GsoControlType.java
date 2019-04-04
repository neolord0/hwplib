package kr.dogfoot.hwplib.object.bodytext.control.gso;

import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlID;

/**
 * 그리기 개체 타입
 *
 * @author neolord
 */
public enum GsoControlType {
    /**
     * 선
     */
    Line(CtrlID.make('$', 'l', 'i', 'n')),
    /**
     * 사각형
     */
    Rectangle(CtrlID.make('$', 'r', 'e', 'c')),
    /**
     * 타원
     */
    Ellipse(CtrlID.make('$', 'e', 'l', 'l')),
    /**
     * 호
     */
    Arc(CtrlID.make('$', 'a', 'r', 'c')),
    /**
     * 다각형
     */
    Polygon(CtrlID.make('$', 'p', 'o', 'l')),
    /**
     * 곡선
     */
    Curve(CtrlID.make('$', 'c', 'u', 'r')),
    /**
     * 그림
     */
    Picture(CtrlID.make('$', 'p', 'i', 'c')),
    /**
     * OLE
     */
    OLE(CtrlID.make('$', 'o', 'l', 'e')),
    /**
     * 묶음 객체
     */
    Container(CtrlID.make('$', 'c', 'o', 'n')),
    /**
     * 객체 연결선
     */
    ObjectLinkLine(CtrlID.make('$', 'c', 'o', 'l'));

    /**
     * 아아디
     */
    private long id;

    /**
     * 생성자
     *
     * @param id 아이디
     */
    GsoControlType(long id) {
        this.id = id;
    }

    /**
     * 아이디를 반환한다.
     *
     * @return 아이디
     */
    public long getId() {
        return id;
    }

    /**
     * 아이디에 해당하는 그리기 개체 타입를 반환한다.
     *
     * @param id 아이디
     * @return 그리기 개체 타입
     */
    public static GsoControlType idOf(long id) {
        for (GsoControlType gct : values()) {
            if (gct.id == id) {
                return gct;
            }
        }
        return Line;
    }
}