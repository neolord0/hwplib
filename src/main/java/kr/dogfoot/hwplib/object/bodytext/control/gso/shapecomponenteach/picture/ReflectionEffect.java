package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.picture;

/**
 * 반사 효과 속성
 *
 * @author neolord
 */
public class ReflectionEffect {
    /**
     * 반사 스타일 (정보 없음)
     */
    private int style;
    /**
     * 반경
     */
    private float radius;
    /**
     * 방향
     */
    private float direction;
    /**
     * 거리
     */
    private float distance;
    /**
     * x축 기울기 각도
     */
    private float tiltAngleX;
    /**
     * y축 기울기 각도
     */
    private float tiltAngleY;
    /**
     * x축 확대 비율
     */
    private float zoomRateX;
    /**
     * y축 확대 비율
     */
    private float zoomRateY;
    /**
     * 회전 스타일 (정보 없음)
     */
    private int rotationStyle;
    /**
     * 시작 투명도
     */
    private float startTransparency;
    /**
     * 시작 위치
     */
    private float startPosition;
    /**
     * 끝 투명도
     */
    private float endTransparency;
    /**
     * 끝 위치
     */
    private float endPosition;
    /**
     * 오프셋 방향
     */
    private float offsetDirection;

    /**
     * 생성자
     */
    public ReflectionEffect() {
    }

    /**
     * 반사 스타일을 반환한다. (정보 없음)
     *
     * @return 반사 스타일
     */
    public int getStyle() {
        return style;
    }

    /**
     * 반사 스타일를 설정한다. (정보 없음)
     *
     * @param style 반사 스타일
     */
    public void setStyle(int style) {
        this.style = style;
    }

    /**
     * 반경을 반환한다.
     *
     * @return 반경
     */
    public float getRadius() {
        return radius;
    }

    /**
     * 반경을 설정한다.
     *
     * @param radius 반경
     */
    public void setRadius(float radius) {
        this.radius = radius;
    }

    /**
     * 방향을 반환한다.
     *
     * @return 방향
     */
    public float getDirection() {
        return direction;
    }

    /**
     * 방향을 설정한다.
     *
     * @param direction 방향
     */
    public void setDirection(float direction) {
        this.direction = direction;
    }

    /**
     * 거리를 반환한다.
     *
     * @return 거리
     */
    public float getDistance() {
        return distance;
    }

    /**
     * 거리를 설정한다.
     *
     * @param distance 거리
     */
    public void setDistance(float distance) {
        this.distance = distance;
    }

    /**
     * x축 기울기 각도를 반환한다.
     *
     * @return x축 기울기 각도
     */
    public float getTiltAngleX() {
        return tiltAngleX;
    }

    /**
     * x축 기울기 각도를 설정한다.
     *
     * @param tiltAngleX x축 기울기 각도
     */
    public void setTiltAngleX(float tiltAngleX) {
        this.tiltAngleX = tiltAngleX;
    }

    /**
     * y축 기울기 각도를 반환한다.
     *
     * @return y축 기울기 각도
     */
    public float getTiltAngleY() {
        return tiltAngleY;
    }

    /**
     * y축 기울기 각도를 설정한다.
     *
     * @param tiltAngleY y축 기울기 각도
     */
    public void setTiltAngleY(float tiltAngleY) {
        this.tiltAngleY = tiltAngleY;
    }

    /**
     * x축 확대 비율을 반환한다.
     *
     * @return x축 확대 비율
     */
    public float getZoomRateX() {
        return zoomRateX;
    }

    /**
     * x축 확대 비율을 설정한다.
     *
     * @param zoomRateX x축 확대 비율
     */
    public void setZoomRateX(float zoomRateX) {
        this.zoomRateX = zoomRateX;
    }

    /**
     * y축 확대 비율을 반환한다.
     *
     * @return y축 확대 비율
     */
    public float getZoomRateY() {
        return zoomRateY;
    }

    /**
     * y축 확대 비율을 설정한다.
     *
     * @param zoomRateY y축 확대 비율
     */
    public void setZoomRateY(float zoomRateY) {
        this.zoomRateY = zoomRateY;
    }

    /**
     * 회전 스타일을 반환한다. (정보 없음)
     *
     * @return 회전 스타일
     */
    public int getRotationStyle() {
        return rotationStyle;
    }

    /**
     * 회전 스타일을 설정한다. (정보 없음)
     *
     * @param rotationStyle 회전 스타일
     */
    public void setRotationStyle(int rotationStyle) {
        this.rotationStyle = rotationStyle;
    }

    /**
     * 시작 투명도를 반환한다.
     *
     * @return 시작 투명도
     */
    public float getStartTransparency() {
        return startTransparency;
    }

    /**
     * 시작 투명도를 설정한다.
     *
     * @param startTransparency 시작 투명도
     */
    public void setStartTransparency(float startTransparency) {
        this.startTransparency = startTransparency;
    }

    /**
     * 시작 위치를 반환한다.
     *
     * @return 시작 위치
     */
    public float getStartPosition() {
        return startPosition;
    }

    /**
     * 시작 위치를 설정한다.
     *
     * @param startPosition 시작 위치
     */
    public void setStartPosition(float startPosition) {
        this.startPosition = startPosition;
    }

    /**
     * 끝 투명도를 반환한다.
     *
     * @return 끝 투명도
     */
    public float getEndTransparency() {
        return endTransparency;
    }

    /**
     * 끝 투명도를 설정한다.
     *
     * @param endTransparency 끝 투명도
     */
    public void setEndTransparency(float endTransparency) {
        this.endTransparency = endTransparency;
    }

    /**
     * 끝 위치를 반환한다.
     *
     * @return 끝 위치
     */
    public float getEndPosition() {
        return endPosition;
    }

    /**
     * 끝 위치를 설정한다.
     *
     * @param endPosition 끝 위치
     */
    public void setEndPosition(float endPosition) {
        this.endPosition = endPosition;
    }

    /**
     * 오프셋 방향을 반환한다.
     *
     * @return 오프셋 방향
     */
    public float getOffsetDirection() {
        return offsetDirection;
    }

    /**
     * 오프셋 방향을 설정한다.
     *
     * @param offsetDirection 오프셋 방향
     */
    public void setOffsetDirection(float offsetDirection) {
        this.offsetDirection = offsetDirection;
    }
}
