package kr.dogfoot.hwplib.object.bodytext.paragraph.charshape;

/**
 * 글자 위치와 글자 모양의 쌍
 *
 * @author neolord
 */
public class CharPositionShapeIdPair {
    /**
     * 글자 모양이 바뀌는 시작 위치
     */
    private long position;
    /**
     * 글자 모양 ID
     */
    private long shapeId;

    /**
     * 생성자
     *
     * @param position 글자 모양이 바뀌는 시작 위치
     * @param shapeId  글자 모양 ID
     */
    public CharPositionShapeIdPair(long position, long shapeId) {
        this.position = position;
        this.shapeId = shapeId;
    }

    /**
     * 글자 모양이 바뀌는 시작 위치를 반환한다.
     *
     * @return 글자 모양이 바뀌는 시작 위치
     */
    public long getPosition() {
        return position;
    }

    /**
     * 글자 모양이 바뀌는 시작 위치를 설정한다.
     *
     * @param position 글자 모양이 바뀌는 시작 위치
     */
    public void setPosition(long position) {
        this.position = position;
    }

    /**
     * 참조된 글자 모양 ID를 반환한다.
     *
     * @return 참조된 글자 모양 ID
     */
    public long getShapeId() {
        return shapeId;
    }

    /**
     * 참조된 글자 모양 ID를 설정한다.
     *
     * @param shapeId 참조된 글자 모양 ID
     */
    public void setShapeId(long shapeId) {
        this.shapeId = shapeId;
    }
}
