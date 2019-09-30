package kr.dogfoot.hwplib.object.bodytext.paragraph.charshape;

import java.util.ArrayList;

/**
 * 문단의 글자 모양에 대한 레코드. ex) (위치:0, 글자모양:1), (위치:5, 글자모양:3), (위치:9, 글자모양:2) 이럴 경우,
 * 1번 글자모양으로 시작해서, 5번째 글자부터 3번으로 글자모양으로 적용되다가, 9번째 글자 부터 끝까지 2번 글자모양으로 적용된다.
 *
 * @author neolord
 */
public class ParaCharShape {
    /**
     * 위치와 글자 모양의 쌍에 대한 리스트
     */
    private ArrayList<CharPositionShapeIdPair> positionShapeIdPairList;

    /**
     * 생성자
     */
    public ParaCharShape() {
        positionShapeIdPairList = new ArrayList<CharPositionShapeIdPair>();
    }

    /**
     * position 위치와 charShapeId 글자 모양의 쌍에 대한 객체를 생성하고 리스트에 추가한다.
     *
     * @param position    글자모양이 charShapeId로 바꿔지는 글자의 위치
     * @param charShapeId 참조된 글자모양 id
     */
    public void addParaCharShape(long position, long charShapeId) {
        CharPositionShapeIdPair cpsp = new CharPositionShapeIdPair(position,
                charShapeId);
        positionShapeIdPairList.add(cpsp);
    }

    /**
     * 위치와 글자 모양의 쌍에 대한 리스트를 반환한다.
     *
     * @return 위치와 글자 모양의 쌍에 대한 리스트
     */
    public ArrayList<CharPositionShapeIdPair> getPositonShapeIdPairList() {
        return positionShapeIdPairList;
    }
}
