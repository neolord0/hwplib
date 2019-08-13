package kr.dogfoot.hwplib.tool.objectfinder;

import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;

/**
 * 원하는 컨트롤을 찾기 위한 조건을 입력할 수 있는 인터페이스
 *
 * @author neolord
 */
public interface ControlFilter {
    /**
     * 원하는 컨트롤을 찾기 위한 조건에 맞는지 여부를 반환한다.
     *
     * @param control   컨트롤
     * @param paragrpah 현재 문단
     * @param section   현재 구역
     * @return 원하는 컨트롤을 찾기 위한 조건에 맞는지 여부
     */
    boolean isMatched(Control control, Paragraph paragrpah,
                      Section section);
}
