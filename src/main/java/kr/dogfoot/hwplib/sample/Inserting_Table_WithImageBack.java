package kr.dogfoot.hwplib.sample;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.object.bodytext.control.ControlTable;
import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderGso;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.gso.*;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.sectiondefine.TextDirection;
import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.LineChange;
import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.TextVerticalAlignment;
import kr.dogfoot.hwplib.object.bodytext.control.table.*;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.bodytext.paragraph.charshape.ParaCharShape;
import kr.dogfoot.hwplib.object.bodytext.paragraph.header.ParaHeader;
import kr.dogfoot.hwplib.object.bodytext.paragraph.lineseg.LineSegItem;
import kr.dogfoot.hwplib.object.bodytext.paragraph.lineseg.ParaLineSeg;
import kr.dogfoot.hwplib.object.docinfo.BinData;
import kr.dogfoot.hwplib.object.docinfo.BorderFill;
import kr.dogfoot.hwplib.object.docinfo.bindata.BinDataCompress;
import kr.dogfoot.hwplib.object.docinfo.bindata.BinDataState;
import kr.dogfoot.hwplib.object.docinfo.bindata.BinDataType;
import kr.dogfoot.hwplib.object.docinfo.borderfill.BackSlashDiagonalShape;
import kr.dogfoot.hwplib.object.docinfo.borderfill.BorderThickness;
import kr.dogfoot.hwplib.object.docinfo.borderfill.BorderType;
import kr.dogfoot.hwplib.object.docinfo.borderfill.SlashDiagonalShape;
import kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo.ImageFill;
import kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo.ImageFillType;
import kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo.PatternFill;
import kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo.PatternType;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.writer.HWPWriter;

import java.io.*;

public class Inserting_Table_WithImageBack {

    public static void main(String[] args) throws Exception {
        String filename = "sample_hwp" + File.separator + "blank.hwp";

        HWPFile hwpFile = HWPReader.fromFile(filename);
        if (hwpFile != null) {
            Inserting_Table_WithImageBack tmt = new Inserting_Table_WithImageBack(hwpFile);
            tmt.addBinData();
            tmt.addBinDataInDocInfo();
            tmt.makeTable();
            String writePath = "sample_hwp" + File.separator + "result-inserting-table-with-imageback.hwp";
            HWPWriter.toFile(hwpFile, writePath);
        }

    }

    private final String imageFilePath = "sample_hwp" + File.separator + "image" + File.separator + "sample.jpg";
    private final String imageFileExt = "jpg";
    private final BinDataCompress compressMethod = BinDataCompress.ByStroageDefault;

    private HWPFile hwpFile;
    private ControlTable table;
    private Row row;
    private Cell cell;
    private int borderFillIDForCell;

    private int zOrder = 0;

    private int streamIndex;
    private int binDataID;

    public Inserting_Table_WithImageBack(HWPFile hwpFile) {
        this.hwpFile = hwpFile;
    }


    private void addBinData() throws IOException {
        streamIndex = hwpFile.getBinData().getEmbeddedBinaryDataList().size() + 1;
        String streamName = getStreamName();
        byte[] fileBinary = loadFile();

        hwpFile.getBinData().addNewEmbeddedBinaryData(streamName, fileBinary, compressMethod);
    }

    private String getStreamName() {
        return "Bin" + String.format("%04X", streamIndex) + "." + imageFileExt;
    }

    private byte[] loadFile() throws IOException {
        File file = new File(imageFilePath);
        byte[] buffer = new byte[(int) file.length()];
        InputStream ios = null;
        try {
            ios = new FileInputStream(file);
            ios.read(buffer);
        } finally {
            try {
                if (ios != null)
                    ios.close();
            } catch (IOException e) {
            }
        }
        return buffer;
    }

    private void addBinDataInDocInfo() {
        BinData bd = new BinData();
        bd.getProperty().setType(BinDataType.Embedding);
        bd.getProperty().setCompress(compressMethod);
        bd.getProperty().setState(BinDataState.NotAcceess);
        bd.setBinDataID(streamIndex);
        bd.setExtensionForEmbedding(imageFileExt);
        hwpFile.getDocInfo().getBinDataList().add(bd);
        binDataID =  hwpFile.getDocInfo().getBinDataList().size();
    }

    private void makeTable() {
        createTableControlAtFirstParagraph();
        setCtrlHeaderRecord();
        setTableRecordFor2By2Cells();
        add2By2Cell();
    }

    private void createTableControlAtFirstParagraph() {
        Section firstSection = hwpFile.getBodyText().getSectionList().get(0);
        Paragraph firstParagraph = firstSection.getParagraph(0);

        // 문단에서 표 컨트롤의 위치를 표현하기 위한 확장 문자를 넣는다.
        firstParagraph.getText().addExtendCharForTable();

        // 문단에 표 컨트롤 추가한다.
        table = (ControlTable) firstParagraph.addNewControl(ControlType.Table);
    }

    private void setCtrlHeaderRecord() {
        CtrlHeaderGso ctrlHeader = table.getHeader();
        ctrlHeader.getProperty().setLikeWord(false);
        ctrlHeader.getProperty().setApplyLineSpace(false);
        ctrlHeader.getProperty().setVertRelTo(VertRelTo.Para);
        ctrlHeader.getProperty().setVertRelativeArrange(RelativeArrange.TopOrLeft);
        ctrlHeader.getProperty().setHorzRelTo(HorzRelTo.Para);
        ctrlHeader.getProperty().setHorzRelativeArrange(RelativeArrange.TopOrLeft);
        ctrlHeader.getProperty().setVertRelToParaLimit(false);
        ctrlHeader.getProperty().setAllowOverlap(false);
        ctrlHeader.getProperty().setWidthCriterion(WidthCriterion.Absolute);
        ctrlHeader.getProperty().setHeightCriterion(HeightCriterion.Absolute);
        ctrlHeader.getProperty().setProtectSize(false);
        ctrlHeader.getProperty().setTextFlowMethod(TextFlowMethod.Tight);
        ctrlHeader.getProperty().setTextHorzArrange(TextHorzArrange.BothSides);
        ctrlHeader.getProperty().setObjectNumberSort(ObjectNumberSort.Table);
        ctrlHeader.setxOffset(mmToHwp(20.0));
        ctrlHeader.setyOffset(mmToHwp(20.0));
        ctrlHeader.setWidth(mmToHwp(100.0));
        ctrlHeader.setHeight(mmToHwp(60.0));
        ctrlHeader.setzOrder(zOrder++);
        ctrlHeader.setOutterMarginLeft(0);
        ctrlHeader.setOutterMarginRight(0);
        ctrlHeader.setOutterMarginTop(0);
        ctrlHeader.setOutterMarginBottom(0);
    }

    private long mmToHwp(double mm) {
        return (long) (mm * 72000.0f / 254.0f + 0.5f);
    }

    private void setTableRecordFor2By2Cells() {
        Table tableRecord = table.getTable();
        tableRecord.getProperty().setDivideAtPageBoundary(DivideAtPageBoundary.DivideByCell);
        tableRecord.getProperty().setAutoRepeatTitleRow(false);
        tableRecord.setRowCount(2);
        tableRecord.setColumnCount(2);
        tableRecord.setCellSpacing(0);
        tableRecord.setLeftInnerMargin(0);
        tableRecord.setRightInnerMargin(0);
        tableRecord.setTopInnerMargin(0);
        tableRecord.setBottomInnerMargin(0);
        tableRecord.setBorderFillId(getBorderFillIDForTableOutterLine());
        tableRecord.getCellCountOfRowList().add(2);
        tableRecord.getCellCountOfRowList().add(2);
    }

    private int getBorderFillIDForTableOutterLine() {
        BorderFill bf = hwpFile.getDocInfo().addNewBorderFill();
        bf.getProperty().set3DEffect(false);
        bf.getProperty().setShadowEffect(false);
        bf.getProperty().setSlashDiagonalShape(SlashDiagonalShape.None);
        bf.getProperty().setBackSlashDiagonalShape(BackSlashDiagonalShape.None);
        bf.getLeftBorder().setType(BorderType.None);
        bf.getLeftBorder().setThickness(BorderThickness.MM0_5);
        bf.getLeftBorder().getColor().setValue(0x0);
        bf.getRightBorder().setType(BorderType.None);
        bf.getRightBorder().setThickness(BorderThickness.MM0_5);
        bf.getRightBorder().getColor().setValue(0x0);
        bf.getTopBorder().setType(BorderType.None);
        bf.getTopBorder().setThickness(BorderThickness.MM0_5);
        bf.getTopBorder().getColor().setValue(0x0);
        bf.getBottomBorder().setType(BorderType.None);
        bf.getBottomBorder().setThickness(BorderThickness.MM0_5);
        bf.getBottomBorder().getColor().setValue(0x0);
        bf.setDiagonalSort(BorderType.None);
        bf.setDiagonalThickness(BorderThickness.MM0_5);
        bf.getDiagonalColor().setValue(0x0);

        bf.getFillInfo().getType().setPatternFill(true);
        bf.getFillInfo().createPatternFill();
        PatternFill pf = bf.getFillInfo().getPatternFill();
        pf.setPatternType(PatternType.None);
        pf.getBackColor().setValue(-1);
        pf.getPatternColor().setValue(0);

        return hwpFile.getDocInfo().getBorderFillList().size();
    }

    private void add2By2Cell() {
        borderFillIDForCell = createBorderFillIDForCell();

        addFirstRow();
        addSecondRow();
    }

    private int createBorderFillIDForCell() {
        BorderFill bf = hwpFile.getDocInfo().addNewBorderFill();
        bf.getProperty().set3DEffect(false);
        bf.getProperty().setShadowEffect(false);
        bf.getProperty().setSlashDiagonalShape(SlashDiagonalShape.None);
        bf.getProperty().setBackSlashDiagonalShape(BackSlashDiagonalShape.None);
        bf.getLeftBorder().setType(BorderType.Solid);
        bf.getLeftBorder().setThickness(BorderThickness.MM0_5);
        bf.getLeftBorder().getColor().setValue(0x0);
        bf.getRightBorder().setType(BorderType.Solid);
        bf.getRightBorder().setThickness(BorderThickness.MM0_5);
        bf.getRightBorder().getColor().setValue(0x0);
        bf.getTopBorder().setType(BorderType.Solid);
        bf.getTopBorder().setThickness(BorderThickness.MM0_5);
        bf.getTopBorder().getColor().setValue(0x0);
        bf.getBottomBorder().setType(BorderType.Solid);
        bf.getBottomBorder().setThickness(BorderThickness.MM0_5);
        bf.getBottomBorder().getColor().setValue(0x0);
        bf.setDiagonalSort(BorderType.None);
        bf.setDiagonalThickness(BorderThickness.MM0_5);
        bf.getDiagonalColor().setValue(0x0);

        bf.getFillInfo().getType().setPatternFill(true);
        bf.getFillInfo().createPatternFill();
        PatternFill pf = bf.getFillInfo().getPatternFill();
        pf.setPatternType(PatternType.None);
        pf.getBackColor().setValue(-1);
        pf.getPatternColor().setValue(0);

        return hwpFile.getDocInfo().getBorderFillList().size();
    }

    private void addFirstRow() {
        row = table.addNewRow();
        addLeftTopCell();
        addRightTopCell();
    }

    private void addLeftTopCell() {
        cell = row.addNewCell();
        setListHeaderForCell(0, 0, true);
        setParagraphForCell();
    }

    private void setListHeaderForCell(int colIndex, int rowIndex, boolean insertImage) {
        ListHeaderForCell lh = cell.getListHeader();
        lh.setParaCount(1);
        lh.getProperty().setTextDirection(TextDirection.Horizontal);
        lh.getProperty().setLineChange(LineChange.Normal);
        lh.getProperty().setTextVerticalAlignment(TextVerticalAlignment.Center);
        lh.getProperty().setProtectCell(false);
        lh.getProperty().setEditableAtFormMode(false);
        lh.setColIndex(colIndex);
        lh.setRowIndex(rowIndex);
        lh.setColSpan(1);
        lh.setRowSpan(1);
        lh.setWidth(mmToHwp(50.0));
        lh.setHeight(mmToHwp(30.0));
        lh.setLeftMargin(0);
        lh.setRightMargin(0);
        lh.setTopMargin(0);
        lh.setBottomMargin(0);
        if (insertImage) {
            lh.setBorderFillId(createBorderFillIDForCellWithImage(binDataID));
        } else {
            lh.setBorderFillId(borderFillIDForCell);
        }
        lh.setTextWidth(mmToHwp(50.0));
        lh.setFieldName("");
    }

    private int createBorderFillIDForCellWithImage(int binDataID) {
        BorderFill bf = hwpFile.getDocInfo().addNewBorderFill();
        bf.getProperty().set3DEffect(false);
        bf.getProperty().setShadowEffect(false);
        bf.getProperty().setSlashDiagonalShape(SlashDiagonalShape.None);
        bf.getProperty().setBackSlashDiagonalShape(BackSlashDiagonalShape.None);
        bf.getLeftBorder().setType(BorderType.Solid);
        bf.getLeftBorder().setThickness(BorderThickness.MM0_5);
        bf.getLeftBorder().getColor().setValue(0x0);
        bf.getRightBorder().setType(BorderType.Solid);
        bf.getRightBorder().setThickness(BorderThickness.MM0_5);
        bf.getRightBorder().getColor().setValue(0x0);
        bf.getTopBorder().setType(BorderType.Solid);
        bf.getTopBorder().setThickness(BorderThickness.MM0_5);
        bf.getTopBorder().getColor().setValue(0x0);
        bf.getBottomBorder().setType(BorderType.Solid);
        bf.getBottomBorder().setThickness(BorderThickness.MM0_5);
        bf.getBottomBorder().getColor().setValue(0x0);
        bf.setDiagonalSort(BorderType.None);
        bf.setDiagonalThickness(BorderThickness.MM0_5);
        bf.getDiagonalColor().setValue(0x0);

        bf.getFillInfo().getType().setImageFill(true);
        bf.getFillInfo().createImageFill();
        ImageFill imgF = bf.getFillInfo().getImageFill();
        imgF.setImageFillType(ImageFillType.FitSize);
        imgF.getPictureInfo().setBinItemID(binDataID);

        return hwpFile.getDocInfo().getBorderFillList().size();
    }


    private void setParagraphForCell() {
        Paragraph p = cell.getParagraphList().addNewParagraph();
        setParaHeader(p);
        setParaCharShape(p);
        setParaLineSeg(p);
    }

    private void setParaHeader(Paragraph p) {
        ParaHeader ph = p.getHeader();
        ph.setLastInList(true);
        // 셀의 문단 모양을 이미 만들어진 문단 모양으로 사용함
        ph.setParaShapeId(1);
        // 셀의 스타일을이미 만들어진 스타일으로 사용함
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

    private void setParaCharShape(Paragraph p) {
        p.createCharShape();

        ParaCharShape pcs = p.getCharShape();
        // 셀의 글자 모양을 이미 만들어진 글자 모양으로 사용함
        pcs.addParaCharShape(0, 1);
    }


    private void setParaLineSeg(Paragraph p) {
        p.createLineSeg();

        ParaLineSeg pls = p.getLineSeg();
        LineSegItem lsi = pls.addNewLineSegItem();

        lsi.setTextStartPosition(0);
        lsi.setLineVerticalPosition(0);
        lsi.setLineHeight(ptToLineHeight(10.0));
        lsi.setTextPartHeight(ptToLineHeight(10.0));
        lsi.setDistanceBaseLineToLineVerticalPosition(ptToLineHeight(10.0 * 0.85));
        lsi.setLineSpace(ptToLineHeight(3.0));
        lsi.setStartPositionFromColumn(0);
        lsi.setSegmentWidth((int) mmToHwp(50.0));
        lsi.getTag().setFirstSegmentAtLine(true);
        lsi.getTag().setLastSegmentAtLine(true);
    }

    private int ptToLineHeight(double pt) {
        return (int) (pt * 100.0f);
    }

    private void addRightTopCell() {
        cell = row.addNewCell();
        setListHeaderForCell(1, 0, false);
        setParagraphForCell();
    }

    private void addSecondRow() {
        row = table.addNewRow();
        addLeftBottomCell();
        addRightBottomCell();
    }

    private void addLeftBottomCell() {
        cell = row.addNewCell();
        setListHeaderForCell(0, 1, false);
        setParagraphForCell();
    }

    private void addRightBottomCell() {
        cell = row.addNewCell();
        setListHeaderForCell(1, 1, false);
        setParagraphForCell();
    }
}
