package kr.dogfoot.hwplib.tool.paragraphadder;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.ParagraphListInterface;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.tool.paragraphadder.docinfo.DocInfoAdder;

import java.util.ArrayList;

/**
 * 파일에 문단을 추가하는 기능을 포함하는 클래스.
 */
public class ParagraphAdder {
    /**
     * target 한글 파일
     */
    private HWPFile targetHWPFile;
    /**
     * target 문단 리스트
     */
    private ParagraphListInterface targetParaList;

    /**
     * 생성자
     *
     * @param targetHWPFile  문단을 추가할 한글 파일(target)
     * @param targetParaList 문단을 추가할 문단 리스트(target)
     */
    public ParagraphAdder(HWPFile targetHWPFile, ParagraphListInterface targetParaList) {
        this.targetHWPFile = targetHWPFile;
        this.targetParaList = targetParaList;
    }

    /**
     * target 한긒피일의 tagert문단 리스트에 문단을 추가한다.
     *
     * @param hwpFile 추가될 문단을 포함하는 한글 파일
     * @param p       추가될 문단
     * @throws Exception
     */
    public void add(HWPFile hwpFile, Paragraph p) throws Exception {
        ParagraphCopier paraCopyer = new ParagraphCopier(new DocInfoAdder(hwpFile, targetHWPFile));

        Paragraph targetParagraph = targetParaList.addNewParagraph();
        paraCopyer.copy(p, targetParagraph);
    }

    /**
     * target 한긒피일의 tagert문단 리스트에 문단 리스트를  추가한다.
     *
     * @param hwpFile 추가될 문단을 포함하는 한글 파일
     * @param list    문단 리스트
     * @throws Exception
     */
    public void add(HWPFile hwpFile, ArrayList<Paragraph> list) throws Exception {
        ParagraphCopier copyer = new ParagraphCopier(new DocInfoAdder(hwpFile, targetHWPFile));
        for (Paragraph p : list) {
            Paragraph targetParagraph = targetParaList.addNewParagraph();
            copyer.copy(p, targetParagraph);
        }
    }

    public void merge(Paragraph targetParagraph, HWPFile hwpFile, Paragraph p) throws Exception {
        ParagraphMerger merger = new ParagraphMerger(new DocInfoAdder(hwpFile, targetHWPFile));
        merger.merge(p, targetParagraph);
    }
}
