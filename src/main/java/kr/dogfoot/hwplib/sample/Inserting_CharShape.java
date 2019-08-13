package kr.dogfoot.hwplib.sample;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.bodytext.paragraph.charshape.ParaCharShape;
import kr.dogfoot.hwplib.object.bodytext.paragraph.header.ParaHeader;
import kr.dogfoot.hwplib.object.bodytext.paragraph.lineseg.LineSegItem;
import kr.dogfoot.hwplib.object.bodytext.paragraph.lineseg.ParaLineSeg;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.ParaText;
import kr.dogfoot.hwplib.object.docinfo.CharShape;
import kr.dogfoot.hwplib.object.docinfo.FaceName;
import kr.dogfoot.hwplib.object.docinfo.borderfill.BorderType;
import kr.dogfoot.hwplib.object.docinfo.charshape.EmphasisSort;
import kr.dogfoot.hwplib.object.docinfo.charshape.OutterLineSort;
import kr.dogfoot.hwplib.object.docinfo.charshape.ShadowSort;
import kr.dogfoot.hwplib.object.docinfo.charshape.UnderLineSort;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.writer.HWPWriter;

import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * 새로운 글자 모양을 추가하고 문단에 글자 모양을 설정하는 샘플 프로그램.
 */
public class Inserting_CharShape {
    public static void main(String[] args) throws Exception {
        String filename = "sample_hwp" + File.separator + "test-blank.hwp";

        HWPFile hwpFile = HWPReader.fromFile(filename);
        if (hwpFile != null) {
            Inserting_CharShape tmcs = new Inserting_CharShape();
            tmcs.test(hwpFile);

            String writePath = "sample_hwp" + File.separator + "test-making-charshape.hwp";
            HWPWriter.toFile(hwpFile, writePath);
        }
    }

    private HWPFile hwpFile;
    private int charShapeIndexForNormal;
    private int charShapeIndexForBold;
    private int faceNameIndexForBatang;

    private Inserting_CharShape() {
        hwpFile = null;
    }

    private void test(HWPFile hwpFile) {
        this.hwpFile = hwpFile;

        faceNameIndexForBatang = createFaceNameForBatang();
        charShapeIndexForNormal = createCharShape(false);
        charShapeIndexForBold = createCharShape(true);

        createTestParagraph();
    }

    // 바탕 폰트를 위한 FaceName 객체를 생성한다.(create FaceName Object for 'Batang' font)
    // '한글' 프로그램에서는 폰트를 적용할 문자를 6개의 부분으로 나눈다.(In 'Hangul' programs, the characters
    // to be applied to the font are divided into six parts.)
    private int createFaceNameForBatang() {
        FaceName fn;

        // 한글 부분을 위한 FaceName 객체를 생성한다. (create FaceName Object for hangul part.)
        fn = hwpFile.getDocInfo().addNewHangulFaceName();
        setFaceNameForBatang(fn);

        // 영어 부분을 위한 FaceName 객체를 생성한다. (create FaceName Object for english part.)
        fn = hwpFile.getDocInfo().addNewEnglishFaceName();
        setFaceNameForBatang(fn);

        // 한자 부분을 위한 FaceName 객체를 생성한다. (create FaceName Object for hanja(Chinese)
        // part.)
        fn = hwpFile.getDocInfo().addNewHanjaFaceName();
        setFaceNameForBatang(fn);

        // 일본어 부분을 위한 FaceName 객체를 생성한다.(create FaceName Object for japanse part.)
        fn = hwpFile.getDocInfo().addNewJapaneseFaceName();
        setFaceNameForBatang(fn);

        // 기타 문자 부분을 위한 FaceName 객체를 생성한다.(create FaceName Object for etc part.)
        fn = hwpFile.getDocInfo().addNewEtcFaceName();
        setFaceNameForBatang(fn);

        // 기호 문자 부분을 위한 FaceName 객체를 생성한다.(create FaceName Object for symbol part.)
        fn = hwpFile.getDocInfo().addNewSymbolFaceName();
        setFaceNameForBatang(fn);

        // 사용자 정의 문자 부분을 위한 FaceName 객체를 생성한다.(create FaceName Object for user part.)
        fn = hwpFile.getDocInfo().addNewUserFaceName();
        setFaceNameForBatang(fn);

        return hwpFile.getDocInfo().getHangulFaceNameList().size() - 1;
    }

    private void setFaceNameForBatang(FaceName fn) {
        String fontName = "바탕";
        fn.getProperty().setHasBaseFont(false);
        fn.getProperty().setHasFontInfo(false);
        fn.getProperty().setHasSubstituteFont(false);
        fn.setName(fontName);
    }

    private int createCharShape(boolean bold) {
        CharShape cs = hwpFile.getDocInfo().addNewCharShape();
        // 바탕 폰트를 위한 FaceName 객체를 링크한다. (link FaceName Object for 'Batang' font.)
        cs.getFaceNameIds().setForAll(faceNameIndexForBatang);

        cs.getRatios().setForAll((short) 100);
        cs.getCharSpaces().setForAll((byte) 0);
        cs.getRelativeSizes().setForAll((short) 100);
        cs.getCharOffsets().setForAll((byte) 0);
        cs.setBaseSize(ptToBaseSize(11));

        cs.getProperty().setItalic(false);
        cs.getProperty().setBold(bold);
        cs.getProperty().setUnderLineSort(UnderLineSort.None);
        cs.getProperty().setOutterLineSort(OutterLineSort.None);
        cs.getProperty().setShadowSort(ShadowSort.None);
        cs.getProperty().setEmboss(false);
        cs.getProperty().setEngrave(false);
        cs.getProperty().setSuperScript(false);
        cs.getProperty().setSubScript(false);
        cs.getProperty().setStrikeLine(false);
        cs.getProperty().setEmphasisSort(EmphasisSort.None);
        cs.getProperty().setUsingSpaceAppropriateForFont(false);
        cs.getProperty().setStrikeLineShape(BorderType.None);
        cs.getProperty().setKerning(false);

        cs.setShadowGap1((byte) 0);
        cs.setShadowGap2((byte) 0);
        cs.getCharColor().setValue(0x00000000);
        cs.getUnderLineColor().setValue(0x00000000);
        cs.getShadeColor().setValue(-1);
        cs.getShadowColor().setValue(0x00b2b2b2);
        cs.setBorderFillId(0);

        return hwpFile.getDocInfo().getCharShapeList().size() - 1;
    }

    private int ptToBaseSize(int pt) {
        return pt * 100;
    }

    private void createTestParagraph() {
        Paragraph p = hwpFile.getBodyText().getSectionList().get(0).addNewParagraph();
        setParaHeader(p);
        setParaText(p, "This is a Paragraph. Bold on. Bold off.");
        setParaCharShape(p);
        setParaLineSeg(p);
    }

    private void setParaHeader(Paragraph p) {
        ParaHeader ph = p.getHeader();
        ph.setLastInList(true);
        // 문단 모양을 이미 만들어진 문단 모양으로 사용함
        ph.setParaShapeId(1);
        // 이미 만들어진 스타일으로 사용함
        ph.setStyleId((short) 1);
        ph.getDivideSort().setDivideSection(false);
        ph.getDivideSort().setDivideMultiColumn(false);
        ph.getDivideSort().setDividePage(false);
        ph.getDivideSort().setDivideColumn(false);
        ph.setCharShapeCount(1);
        ph.setRangeTagCount(0);
        ph.setLineAlignCount(1);
        ph.setInstanceID(0);
        ph.setIsMergedByTrack(0);
    }

    private void setParaText(Paragraph p, String text2) {
        p.createText();
        ParaText pt = p.getText();
        try {
            pt.addString(text2);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void setParaCharShape(Paragraph p) {
        int paragraphStartPos = 0;
        int boldStartPos = 20;
        int boldEndPos = 28;

        p.createCharShape();

        ParaCharShape pcs = p.getCharShape();
        pcs.addParaCharShape(paragraphStartPos, charShapeIndexForNormal);
        pcs.addParaCharShape(boldStartPos, charShapeIndexForBold);
        pcs.addParaCharShape(boldEndPos, charShapeIndexForNormal);
    }

    private void setParaLineSeg(Paragraph p) {
        p.createLineSeg();

        ParaLineSeg pls = p.getLineSeg();
        LineSegItem lsi = pls.addNewLineSegItem();

        lsi.setTextStartPositon(0);
        lsi.setLineVerticalPosition(0);
        lsi.setLineHeight(ptToLineHeight(11.0));
        lsi.setTextPartHeight(ptToLineHeight(11.0));
        lsi.setDistanceBaseLineToLineVerticalPosition(ptToLineHeight(11.0 * 0.85));
        lsi.setLineSpace(ptToLineHeight(4.0));
        lsi.setStartPositionFromColumn(0);
        lsi.setSegmentWidth((int) mmToHwp(50.0));
        lsi.getTag().setFirstSegmentAtLine(true);
        lsi.getTag().setLastSegmentAtLine(true);
    }

    private int ptToLineHeight(double pt) {
        return (int) (pt * 100.0f);
    }

    private long mmToHwp(double mm) {
        return (long) (mm * 72000.0f / 254.0f + 0.5f);
    }
}
