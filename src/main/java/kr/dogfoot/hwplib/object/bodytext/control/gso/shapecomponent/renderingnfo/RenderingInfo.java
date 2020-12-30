package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.renderingnfo;

import kr.dogfoot.hwplib.object.bodytext.Section;

import java.util.ArrayList;

/**
 * Rendering 정보
 *
 * @author neolord
 */
public class RenderingInfo {
    /**
     * 이동을 위한 행렬
     */
    private Matrix translationMatrix;
    /**
     * 확장/회전을 위한 행령의 쌍에 대한 리스트
     */
    private ArrayList<ScaleRotateMatrixPair> scaleRotateMatrixPairList;

    /**
     * 생성자
     */
    public RenderingInfo() {
        translationMatrix = new Matrix();
        scaleRotateMatrixPairList = new ArrayList<ScaleRotateMatrixPair>();
    }

    /**
     * 이동을 위한 행렬 객체를 반환한다.
     *
     * @return 이동을 위한 행렬 객체
     */
    public Matrix getTranslationMatrix() {
        return translationMatrix;
    }

    /**
     * 새로운 확장/회전을 위한 행령의 쌍을 생성하고 리스트에 추가한다.
     *
     * @return 새로 생성된 확장/회전을 위한 행령의 쌍
     */
    public ScaleRotateMatrixPair addNewScaleRotateMatrixPair() {
        ScaleRotateMatrixPair srmp = new ScaleRotateMatrixPair();
        scaleRotateMatrixPairList.add(srmp);
        return srmp;
    }

    /**
     * 확장/회전을 위한 행령의 쌍에 대한 리스트를 반환한다.
     *
     * @return 확장/회전을 위한 행령의 쌍에 대한 리스트
     */
    public ArrayList<ScaleRotateMatrixPair> getScaleRotateMatrixPairList() {
        return scaleRotateMatrixPairList;
    }

    public void copy(RenderingInfo from) {
        translationMatrix.copy(from.translationMatrix);

        scaleRotateMatrixPairList.clear();
        for (ScaleRotateMatrixPair matrixPair : from.scaleRotateMatrixPairList) {
            scaleRotateMatrixPairList.add(matrixPair.clone());
        }

    }
}
