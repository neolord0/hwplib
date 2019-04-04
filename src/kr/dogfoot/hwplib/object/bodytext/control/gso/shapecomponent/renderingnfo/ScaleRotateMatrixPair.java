package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.renderingnfo;

/**
 * 확장/회전을 위한 행렬의 쌍을 나타내는 객체
 *
 * @author neolord
 */
public class ScaleRotateMatrixPair {
    /**
     * 확장을 위한 행렬
     */
    private Matrix scaleMatrix;
    /**
     * 회전을 위한 행렬
     */
    private Matrix rotateMatrix;

    /**
     * 생성자
     */
    public ScaleRotateMatrixPair() {
        scaleMatrix = new Matrix();
        rotateMatrix = new Matrix();
    }

    /**
     * 확장을 위한 행렬을 반환한다.
     *
     * @return 확장을 위한 행렬
     */
    public Matrix getScaleMatrix() {
        return scaleMatrix;
    }

    /**
     * 회전을 위한 행렬을 반환한다.
     *
     * @return 회전을 위한 행렬
     */
    public Matrix getRotateMatrix() {
        return rotateMatrix;
    }
}
