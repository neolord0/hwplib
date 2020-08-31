package kr.dogfoot.hwplib.tool.blankfilemaker;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.BodyText;
import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.docinfo.DocInfo;
import kr.dogfoot.hwplib.object.docinfo.DocumentPropeties;
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
        CharShapeAdder.add(docInfo);
        TabDefAdder.add(docInfo);
        NumberingAdder.add(docInfo);
        ParaShapeAdder.add(docInfo);
        StyleAdder.add(docInfo);
        compatibleDocument(docInfo);
        layoutCompatibility(docInfo);

        Section section = hwpFile.getBodyText().addNewSection();
        EmptyParagraphAdder.add(section);
        return hwpFile;

    }


    private static void setFileHeader(FileHeader fileHeader) {
        fileHeader.getVersion().setVersion((short) 5, (short) 0, (short) 3, (short) 4);
        fileHeader.setCompressed(false);
        fileHeader.setHasPassword(false);
        fileHeader.setDeploymentDocument(false);
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

    private static void setDocumentProperties(DocumentPropeties documentProperties) {
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
}
