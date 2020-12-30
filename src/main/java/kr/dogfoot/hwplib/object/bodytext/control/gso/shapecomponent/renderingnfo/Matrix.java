package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.renderingnfo;

import kr.dogfoot.hwplib.object.bodytext.paragraph.memo.Memo;

/**
 * 행렬을 나타내는 객체. 각 행렬는 원소가 double로 표현되는 3 X 3 matrix로 구현된다. 마지막 행은 항상 [0,0,1]이기
 * 떄문에 생략되어 실제 6개의 원소만 저장한다.
 *
 * @author neolord
 */
public class Matrix {
    /**
     * 행렬의 원소를 저장하는 배열
     */
    private double[] values;

    /**
     * 생성자
     */
    public Matrix() {
        values = new double[6];
    }

    /**
     * 행렬의 원소를 반환한다.
     *
     * @param index 원소의 인덱스
     * @return 행렬의 원소
     */
    public double getValue(int index) {
        return values[index];
    }

    /**
     * 행렬의 원소를 설정한다.
     *
     * @param index 원소의 인덱스
     * @param value 행렬의 원소
     */
    public void setValue(int index, double value) {
        values[index] = value;
    }

    public void copy(Matrix from) {
        values = from.values.clone();
    }
}
