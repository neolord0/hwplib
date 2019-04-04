package kr.dogfoot.hwplib.writer.autosetter;

import kr.dogfoot.hwplib.object.bodytext.ParagraphListInterface;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;

/**
 * 문단 리스트 객체를 쓰기 전에 자동 설정하기 위한 객체
 *
 * @author neolord
 */
public class ForParagraphList {
    /**
     * 문단 리스트를 자동 설정한다.
     *
     * @param pli 문단 리스트 객체
     * @param iid 인스턴스 id
     */
    public static void autoSet(ParagraphListInterface pli, InstanceID iid) {
        int count = pli.getParagraphCount();
        for (int index = 0; index < count; index++) {
            Paragraph p = pli.getParagraph(index);
            if (index == count - 1) {
                ForParagraph.autoSet(p, true, iid);
            } else {
                ForParagraph.autoSet(p, false, iid);
            }
        }
    }
}
