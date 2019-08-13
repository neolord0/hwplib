package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.picture;

/**
 * 그림자 효과 속성
 *
 * @author neolord
 */
public class ShadowEffect {
    /**
     * 그림자 스타일 (정보 없음)
     */
    private int style;
    /**
     * 그림자 투명도
     */
    private float transparency;
    /**
     * 그림자 흐릿하게
     */
    private float cloudy;
    /**
     * 방향
     */
    private float direction;
    /**
     * 거리
     */
    private float distance;
    /**
     * 정렬 (정보 없음)
     */
    private int sort;
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
     * 도형과 함께 그림자 회전
     */
    private int rotateWithShape;
    /**
     * 그림자 색상
     */
    private ColorWithEffect color;

    /**
     * 생성자
     */
    public ShadowEffect() {
        color = new ColorWithEffect();
    }

    /**
     * 그림자 스타일을 반환한다.(정보 없음)
     *
     * @return 그림자 스타일
     */
    public int getStyle() {
        return style;
    }

    /**
     * 그림자 스타일을 설정한다.
     *
     * @param style 그림자 스타일
     */
    public void setStyle(int style) {
        this.style = style;
    }

    /**
     * 그림자 투명도를 반환한다.
     *
     * @return 그림자 투명도
     */
    public float getTransparency() {
        return transparency;
    }

    /**
     * 그림자 투명도를 설정한다.
     *
     * @param transparency 그림자 투명도
     */
    public void setTransparency(float transparency) {
        this.transparency = transparency;
    }

    /**
     * 그림자 흐릿함 정도를 반환한다.
     *
     * @return 그림자 흐릿함 정도
     */
    public float getCloudy() {
        return cloudy;
    }

    /**
     * 그림자 흐릿함 정도를 설정한다.
     *
     * @param cloudy 그림자 흐릿함 정도
     */
    public void setCloudy(float cloudy) {
        this.cloudy = cloudy;
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
     * 정렬 방법을 반환한다.(정보 없음)
     *
     * @return 정렬 방법
     */
    public int getSort() {
        return sort;
    }

    /**
     * 정렬 방법을 설정한다.
     *
     * @param sort 정렬 방법
     */
    public void setSort(int sort) {
        this.sort = sort;
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
     * 도형과 함께 그림자 회전 여부(?)을 반환한다.
     *
     * @return 도형과 함께 그림자 회전 여부
     */
    public int getRotateWithShape() {
        return rotateWithShape;
    }

    /**
     * 도형과 함께 그림자 회전 여부(?)을 설정한다.
     *
     * @param rotateWithShape 도형과 함께 그림자 회전 여부
     */
    public void setRotateWithShape(int rotateWithShape) {
        this.rotateWithShape = rotateWithShape;
    }

    /**
     * 그림자 색상 객체를 반환한다.
     *
     * @return 그림자 색상 객체
     */
    public ColorWithEffect getColor() {
        return color;
    }
}
