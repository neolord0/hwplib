package kr.dogfoot.hwplib.tool.blankfilemaker;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.object.docinfo.DocInfo;
import kr.dogfoot.hwplib.object.docinfo.DocumentProperties;
import kr.dogfoot.hwplib.object.docinfo.LayoutCompatibility;
import kr.dogfoot.hwplib.object.docinfo.compatibledocument.CompatibleDocumentSort;
import kr.dogfoot.hwplib.object.docinfo.documentproperties.CaretPosition;
import kr.dogfoot.hwplib.object.docinfo.documentproperties.StartNumber;
import kr.dogfoot.hwplib.object.fileheader.FileHeader;

public class BlankFileMaker {
    public static HWPFile make() {
        HWPFile hwpFile = new HWPFile();
        setFileHeader(hwpFile.getFileHeader());

        DocInfo docInfo = hwpFile.getDocInfo();
        setDocumentProperties(docInfo.getDocumentProperties());

        FaceNameAdder.add(docInfo);
        BorderFillAdder.add(docInfo);
        CharShapeAdder.add(docInfo);
        TabDefAdder.add(docInfo);
        NumberingAdder.add(docInfo);
        ParaShapeAdder.add(docInfo);
        StyleAdder.add(docInfo);
        compatibleDocument(docInfo);
        layoutCompatibility(docInfo);

        Section section = hwpFile.getBodyText().addNewSection();
        EmptyParagraphAdder.add(section);

        setScript(hwpFile);
        return hwpFile;
    }


    private static void setFileHeader(FileHeader fileHeader) {
        fileHeader.getVersion().setVersion((short) 5, (short) 0, (short) 3, (short) 4);
        fileHeader.setCompressed(true);
        fileHeader.setHasPassword(false);
        fileHeader.setDistribution(false);
        fileHeader.setSaveScript(false);
        fileHeader.setDRMDocument(false);
        fileHeader.setHasXMLTemplate(false);
        fileHeader.setHasDocumentHistory(false);
        fileHeader.setHasSignature(false);
        fileHeader.setEncryptPublicCertification(false);
        fileHeader.setSavePrepareSignature(false);
        fileHeader.setPublicCertificationDRMDocument(false);
        fileHeader.setCCLDocument(false);
    }

    private static void setDocumentProperties(DocumentProperties documentProperties) {
        documentProperties.setSectionCount(1);

        StartNumber startNumber = documentProperties.getStartNumber();
        startNumber.setPage(1);
        startNumber.setFootnote(1);
        startNumber.setEndnote(1);
        startNumber.setPicture(1);
        startNumber.setTable(1);
        startNumber.setEquation(1);

        CaretPosition caretPosition = documentProperties.getCaretPosition();
        caretPosition.setListID(0);
        caretPosition.setParagraphID(0);
        caretPosition.setPositionInParagraph(0);
    }

    private static void compatibleDocument(DocInfo docInfo) {
        docInfo.createCompatibleDocument();
        docInfo.getCompatibleDocument().setTargetProgream(CompatibleDocumentSort.HWPCurrent);
    }

    private static void layoutCompatibility(DocInfo docInfo) {
        docInfo.createLayoutCompatibility();
        LayoutCompatibility layoutCompatibility = docInfo.getLayoutCompatibility();
        layoutCompatibility.setLetterLevelFormat(0);
        layoutCompatibility.setParagraphLevelFormat(0);
        layoutCompatibility.setSectionLevelFormat(0);
        layoutCompatibility.setObjectLevelFormat(0);
        layoutCompatibility.setFieldLevelFormat(0);
    }

    private static void setScript(HWPFile hwpFile) {
        byte[] compressed_jsVersion = new byte[]{0x63, 0x64, (byte) 0x80, 0x00, 0x00, (byte) 0xf7, (byte) 0xdf, (byte) 0x88, (byte) 0xa9, 0x08, 0x00, 0x00, 0x00};
        hwpFile.getScripts().setJScriptVersion(compressed_jsVersion);

        byte[] compressed_defaultJScript = new byte[]{
                0x75, (byte) 0x8E, 0x3D, 0x0F, (byte) 0x82, 0x40, 0x10, 0x44, 0x5F, (byte) 0xAB, (byte) 0x89, (byte) 0xFF, (byte) 0xE1, 0x4A, 0x2C, (byte) 0xC4,
                0x5E, 0x42, 0x41, 0x62, 0x41, 0x25, 0x2D, 0x1D, 0x31, (byte) 0x8A, 0x09, 0x05, 0x1F, (byte) 0x91, 0x43, 0x0A,
                (byte) 0xE3, 0x6F, (byte) 0xD7, (byte) 0xF1, (byte) 0x80, 0x46, 0x64, 0x2F, 0x33, (byte) 0xD9, (byte) 0xCC, (byte) 0xED, (byte) 0xDB, 0x6C, 0x02, 0x3C,
                0x38, 0x73, (byte) 0xC7, 0x70, (byte) 0xA4, (byte) 0xE6, 0x42, 0x47, 0x49, 0x4E, (byte) 0x85, (byte) 0xA5, 0x55, 0x16, 0x4A, 0x29,
                0x31, 0x3D, (byte) 0xCD, (byte) 0x9F, (byte) 0xFF, (byte) 0x80, 0x0D, (byte) 0xEB, 0x45, 0x7E, (byte) 0xA0, (byte) 0xE7, (byte) 0x94, 0x4F, (byte) 0xA4, (byte) 0xC4,
                0x52, (byte) 0x88, (byte) 0xCC, (byte) 0xC9, 0x16, (byte) 0xF7, 0x0F, (byte) 0xDB, 0x77, (byte) 0xBA, (byte) 0xF0, (byte) 0xA6, (byte) 0xB4, 0x1A, (byte) 0x99, 0x5A,
                (byte) 0x9D, 0x21, (byte) 0x91, (byte) 0xFF, (byte) 0xCE, 0x67, (byte) 0x9C, (byte) 0xD4, (byte) 0xF5, 0x78, 0x6C, 0x1D, (byte) 0xF9, 0x74, (byte) 0xBE, 0x62,
                (byte) 0xAF, 0x67, 0x35, 0x7B, (byte) 0x95, 0x0C, 0x07, (byte) 0xE9, (byte) 0x9B, (byte) 0xBF, (byte) 0x9C, 0x4F, (byte) 0xF5, 0x56, 0x7D, 0x00,
                0x18, (byte) 0xF1, 0x09, (byte) 0xB2, 0x0C, 0x01, 0x00, 0x00
        };
        hwpFile.getScripts().setDefaultJScript(compressed_defaultJScript);
    }
}
