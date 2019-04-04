package kr.dogfoot.hwplib.tool.objectfinder;

import java.util.ArrayList;

/**
 * 텍스트 버퍼
 */
public class TextBuffer {
    /**
     * 텍스트 리스트
     */
    private ArrayList<String> textList;
    /**
     * 텍스트 갯수
     */
    private int textCount;
    /**
     * 현재 사용중인 텍스트 인덱스
     */
    private int currentIndex;

    /**
     * 생성자
     *
     * @param textList 텍스트 리스트
     */
    public TextBuffer(ArrayList<String> textList) {
        this.textList = textList;
        this.textCount = textList.size();
        currentIndex = 0;
    }

    /**
     * 다음 텍스트를 반환한다.
     *
     * @return 다음 텍스트
     */
    public String nextText() {
        String text = textList.get(currentIndex);
        currentIndex++;
        return text;
    }

    /**
     * 다음 텍스트가 존재하는지 여부를 반환한다.
     *
     * @return 다음 텍스트가 존재하는지 여부
     */
    public boolean hasNext() {
        return currentIndex < textCount;
    }

    /**
     * 텍스트를 모두 사용했지는 여부를 반환한다.
     *
     * @return 텍스트를 모두 사용했지는 여부
     */
    public boolean usedAll() {
        return currentIndex == textCount;
    }

    /**
     * 텍스트를 하나도 사용하지 않았는지 여부를 반환한다.
     *
     * @return 텍스트를 하나도 사용하지 않았는지 여부
     */
    public boolean notUsed() {
        return currentIndex == 0;
    }
}
