package htmltohwp;

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
import kr.dogfoot.hwplib.object.bodytext.paragraph.ParagraphList;
import kr.dogfoot.hwplib.object.bodytext.paragraph.charshape.ParaCharShape;
import kr.dogfoot.hwplib.object.bodytext.paragraph.header.ParaHeader;
import kr.dogfoot.hwplib.object.bodytext.paragraph.lineseg.LineSegItem;
import kr.dogfoot.hwplib.object.bodytext.paragraph.lineseg.ParaLineSeg;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.ParaText;
import kr.dogfoot.hwplib.object.docinfo.BorderFill;
import kr.dogfoot.hwplib.object.docinfo.CharShape;
import kr.dogfoot.hwplib.object.docinfo.FaceName;
import kr.dogfoot.hwplib.object.docinfo.ParaShape;
import kr.dogfoot.hwplib.object.docinfo.borderfill.BackSlashDiagonalShape;
import kr.dogfoot.hwplib.object.docinfo.borderfill.BorderThickness;
import kr.dogfoot.hwplib.object.docinfo.borderfill.BorderType;
import kr.dogfoot.hwplib.object.docinfo.borderfill.SlashDiagonalShape;
import kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo.PatternFill;
import kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo.PatternType;
import kr.dogfoot.hwplib.object.docinfo.charshape.EmphasisSort;
import kr.dogfoot.hwplib.object.docinfo.charshape.OutterLineSort;
import kr.dogfoot.hwplib.object.docinfo.charshape.ShadowSort;
import kr.dogfoot.hwplib.object.docinfo.charshape.UnderLineSort;
import kr.dogfoot.hwplib.object.docinfo.parashape.Alignment;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.writer.HWPWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.*;

/**
 * 예제 만든 이) d_duck@naver.com(이준성), jwj9408@naver.com(장원준)
 * 설명 :
 * 본 예제는 Jsoup를 활용하여 HTML 파일을 읽어, 한글 표로 만드는 과정을 보여줍니다.
 * 입력 방식은 FileSystem이나, 활용하실 서비스에 맞게 JSON 혹은 XML등으로 변환하시면 되겠습니다.
 */

public class HtmlToTableExample {
    public static void main(String[] args) {
        new HtmlToTableExample().run();
    }

    // 빈 문서를 활용, 빈 문서의 경로
    public static final String hwpBlankPath = "sample_hwp" + File.separator + "blank.hwp";

    // 저장할 파일 경로
    public static final String hwpOutputPath = "sample_hwp" + File.separator + "result-htmltohwp.hwp";

    private HWPFile hwpFile;

    // 생성된 첫번째 테두리를 가지고 모든 테두리를 똑같이 적용합니다.
    private int borderFillIDForCell;
    private int zOrder = 0;

    // 이 예제는 폰트가 전역으로 설정 합니다.
    // 폰트 이름과, 스타일, pt 사이즈를 입력합니다.
    private String fontName = "굴림";
    private int fontStyle = Font.PLAIN;
    private int fontSize = 7;

    private void run() {
        try {
            hwpFile = HWPReader.fromFile(hwpBlankPath);
            // HTML 파일을 불러옵니다. 이 예제는 resources 폴더의 tableExample.html을 예로 합니다.
            String html = new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("tableExample.html").toURI())));

            // 불러온 HTML을 Jsoup로 변환합니다. 이는 각 Element를 조사하고, 어떤 텍스트가 들었는지,
            // 합쳐진 열이나 행이 있는지 알기 위함입니다.
            Document doc = Jsoup.parse(html);

            Map<String, List<List<TableCellDTO>>> tableMap = parseTable(doc);
            if (hwpFile != null) {
                // 테이블 그리기 시작.
                for (String tableID : tableMap.keySet()) {
                    makeTable(tableMap.get(tableID));
                }

                // HWP 파일 생성
                HWPWriter.toFile(hwpFile, hwpOutputPath);
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param doc : HTML 내용을 Parse한 최상위 Document
     * @return Table 구조가 담긴 Map<String, List<List<TableCellDTO>>>
     */
    private Map<String, List<List<TableCellDTO>>> parseTable(Document doc) {
        int idtable = 1;
        Map<String, List<List<TableCellDTO>>> tableMap = new HashMap<String, List<List<TableCellDTO>>>();
        Elements table = doc.select("table");
        for (Element e : table) {
            String tableID = String.format("Table%d", idtable);
            List<List<TableCellDTO>> parseData = parseList(e);
            tableMap.put(tableID, parseData);
        }
        return tableMap;
    }

    /**
     * @param table
     * @return 정렬된 테이블 정보 List<List<TableCellDTO>>
     */
    private List<List<TableCellDTO>> parseList(Element table) {
        List<List<TableCellDTO>> returnRowDataList = new ArrayList<List<TableCellDTO>>();
        List<Map<Integer, TableCellDTO>> rowDataList = new ArrayList<Map<Integer, TableCellDTO>>();

        // Table 내의 TR을 모두 조사합니다.
        Elements rows = table.select("tr");

        // TR 개수만큼, rowDataList에 데이터 영역을 생성합니다.
        for (int i = 0; i < rows.size(); i++) {
            rowDataList.add(i, new HashMap<Integer, TableCellDTO>());
        }

        // 각 TR을 돌면서 TR 아래 항목인 TH나 TD를 구합니다.
        for (int i = 0; i < rows.size(); i++) {
            int colCount = 0; // 유동적인 Column 인덱스를 구합니다.
            Element tr = rows.get(i);
            Elements cells = tr.children();
            for (Element e : cells) {
                String style = e.attr("style");
                // display:none 인(안보이는) 요소는 건너뜁니다.
                if (!(style.contains("display") && style.contains("none"))) {
                    int rowSpan;
                    try {
                        // rowspan을 가져옵니다.
                        rowSpan = Integer.parseInt(e.attr("rowspan"));
                    } catch (Exception ex) {
                        // rowspan이 없다면, span수는 1로 취급합니다.
                        rowSpan = 1;
                    }
                    int colSpan;
                    try {
                        // colspan을 가져옵니다.
                        colSpan = Integer.parseInt(e.attr("colspan"));
                    } catch (Exception ex) {
                        // colspan이 없다면, span수는 1로 취급합니다.
                        colSpan = 1;
                    }

                    // 한글 표 각 Cell에 저장할 데이터를 선언합니다.
                    TableCellDTO tmp = null;
                    while (true) {
                        try {
                            // rowDataList 내에서 빈 공간을 찾습니다.
                            // span이 된 영역은 span수 만큼 공간을 차지하므로 빈 영역을 찾기 위함입니다.
                            // 영역을 찾지못하면 cell의 index를 늘리고 다음 빈 영역을 찾습니다.
                            tmp = rowDataList.get(i).get(colCount);
                            if (tmp == null)
                                break;
                            colCount++;
                        } catch (Exception ex) {
                            tmp = null;
                            break;
                        }
                    }
                    // 표를 그릴때, colspan, rowspan가 없는 일반 셀이라면 type을 1로 두고, 그 외엔 0으로 둡니다.
                    // type이 0일 경우는 hide 된 셀임을 의미합니다.
                    for (int x = 0; x < colSpan; x++) {
                        for (int y = 0; y < rowSpan; y++) {
                            int type = 0;
                            if (x + y == 0) {
                                type = 1;
                            }

                            // 셀 자체에 고유한 너비나 높이가 있다면 가져오고, 아니면 0값을 넣어 후에 자동으로 조정되게 합니다.
                            double width, height;
                            try {
                                width = Double.parseDouble(e.attr("width"));
                            } catch (Exception ex) {
                                width = 0;
                            }
                            try {
                                height = Double.parseDouble(e.attr("height"));
                            } catch (Exception ex) {
                                height = 0;
                            }
                            TableCellDTO cellDTO = new TableCellDTO();
                            cellDTO.setColspan(colSpan);
                            cellDTO.setRowspan(rowSpan);
                            cellDTO.setWidth(width);
                            cellDTO.setHeight(height);
                            cellDTO.setType(type);
                            cellDTO.setText(e.text()); // 셀 텍스트를 입력합니다.
                            // rowDataList[Row][Cell_Index] 에 셀 정보를 입력합니다.
                            rowDataList.get(i + y).put(colCount, cellDTO);
                        }
                        colCount++; // 다음 인덱스 지점에 입력하기 위하여 카운트 합니다.
                    }
                }
            }
        }

        // 입력한 셀 정보들을 순회 하면서, 데이터 타입을 Map 에서 List 형태로 만들어줍니다.
        // 이유는, Map의 순서가 섞여있기 때문에, 나중에 iterator로 순회 할 때에, 정렬되지 않을 수 있기 때문입니다.
        for (Map<Integer, TableCellDTO> m : rowDataList) {
            TreeMap<Integer, TableCellDTO> tm = new TreeMap<Integer, TableCellDTO>(m);
            Iterator<Integer> iteratorKey = tm.keySet().iterator();
            List<TableCellDTO> subList = new ArrayList<TableCellDTO>();
            while (iteratorKey.hasNext()) {
                Integer key = iteratorKey.next();
                subList.add(tm.get(key));
            }
            returnRowDataList.add(subList);
        }
        return returnRowDataList;
    }

    public void makeTable(List<List<TableCellDTO>> rowList) {

        int maxRow = rowList.size();
        int maxCol = rowList.get(0).size();
        ControlTable table = createTableControlAtFirstParagraph(); // 첫 문단에 테이블을 생성합니다.
        setCtrlHeaderRecord(table); // 테이블의 헤더를 설정합니다.
        setTableRecord(table, maxRow, maxCol); // 테이블 레코드 정보를 설정합니다.
        addCell(table, rowList); // 테이블 정보를 등록합니다.
    }

    /**
     * 첫 섹션, 첫 번째 문단에 테이블을 생성합니다.
     * 동적으로 i번째 문단에 테이블을 생성하시려면 그 만큼 문단이 필요합니다.
     * 이 예제는 하나의 테이블만 그리기 위해 첫 번째로 고정합니다.
     *
     * @return
     */
    private ControlTable createTableControlAtFirstParagraph() {
        Section firstSection = hwpFile.getBodyText().getSectionList().get(0);
        Paragraph firstParagraph = firstSection.getParagraph(0);

        // 문단에서 표 컨트롤의 위치를 표현하기 위한 확장 문자를 넣는다.
        firstParagraph.getText().addExtendCharForTable();

        // 문단에 표 컨트롤 추가한다.
        return (ControlTable) firstParagraph.addNewControl(ControlType.Table);
    }

    private void setCtrlHeaderRecord(ControlTable table) {
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
        ctrlHeader.setxOffset(mmToHwp(0.0)); // 좌표 X 위치
        ctrlHeader.setyOffset(mmToHwp(10.0)); // 좌표 Y 위치
        ctrlHeader.setWidth(mmToHwp(60.0)); // 테이블의 너비, 조정하여도 셀 크기만큼 동적으로 늘어 납니다.
        ctrlHeader.setHeight(mmToHwp(60.0)); // 테이블의 높이, 위와 같습니다.
        // overlap 인덱스를 설정합니다.
        ctrlHeader.setzOrder(zOrder++);
        // 여백을 설정합니다. 좌, 우, 상, 하
        ctrlHeader.setOutterMarginLeft(0);
        ctrlHeader.setOutterMarginRight(0);
        ctrlHeader.setOutterMarginTop(0);
        ctrlHeader.setOutterMarginBottom(0);
    }


    private void setTableRecord(ControlTable table, int rowCount, int colCount) {
        Table tableRecord = table.getTable();
        tableRecord.getProperty().setDivideAtPageBoundary(DivideAtPageBoundary.DivideByCell);
        tableRecord.getProperty().setAutoRepeatTitleRow(false);
        tableRecord.setRowCount(rowCount); // 총 행의 개수
        tableRecord.setColumnCount(colCount); // 총 열의 개수
        tableRecord.setCellSpacing(0);
        tableRecord.setLeftInnerMargin(0);
        tableRecord.setRightInnerMargin(0);
        tableRecord.setTopInnerMargin(0);
        tableRecord.setBottomInnerMargin(0);

        // 테이블의 테두리를 설정합니다.
        // 여기서 테두리를 설정하셔도, 맞닫는 각 셀의 테두리도 설정하셔야 적용됩니다.
        borderFillIDForCell = getBorderFillIDForCell();
        tableRecord.setBorderFillId(borderFillIDForCell);
    }

    private void addCell(ControlTable table, List<List<TableCellDTO>> rowList) {
        for (int i = 0; i < rowList.size(); i++) {
            // ControlTable에 Row를 추가합니다.
            Row row = table.addNewRow();

            // 이전에 입력한 셀 정보 리스트에서, Row 정보를 가져옵니다.
            List<TableCellDTO> cellList = rowList.get(i);
            for (int j = 0; j < cellList.size(); j++) {
                // Row의 Cell 리스트를 가져옵니다.
                TableCellDTO tableCell = cellList.get(j);

                // Hide된 Cell은 건너 뜁니다.
                if (tableCell.getType() == 0) continue;

                // 위에서 생성한 Row에 Cell을 추가합니다.
                Cell cell = row.addNewCell();
                // Cell Width, Height가 지정되어 있다면 그대로 가져오고, 없다면 Wrap + Padding 된 사이즈를 구합니다.
                double cellWidth = tableCell.getWidth() != 0 ? pxTomm(tableCell.getWidth()) : autoWidth(tableCell.getText());
                double cellHeight = tableCell.getHeight() != 0 ? pxTomm(tableCell.getHeight()) : autoHeight();
                // Cell 정보를 입력합니다.
                setListHeaderForCell(cell, j, i, tableCell.getColspan(), tableCell.getRowspan(), cellWidth, cellHeight);
                // 셀에 텍스트를 지정합니다. ""만 입력하게 될 시, 셀이 그려지지 않습니다. 최소한 띄어쓰기를 넣어 줍니다.
                setParagraphForCell(cell, tableCell.getText() + " ");
                // 셀의 스타일 또한 지정할 수 있습니다.
                setCellStyle(hwpFile, cell, "000000", false);
                // 줄 바꿈이 포함된 셀은 한 줄입력으로 하지 않고 줄 바꿈이 포함된 텍스트로 입력합니다.
                setCellLineBreaker(hwpFile, cell);
            }
        }
    }

    private int getBorderFillIDForCell() {
        BorderFill bf = hwpFile.getDocInfo().addNewBorderFill();
        bf.getProperty().set3DEffect(false);
        bf.getProperty().setShadowEffect(false);
        bf.getProperty().setSlashDiagonalShape(SlashDiagonalShape.None);
        bf.getProperty().setBackSlashDiagonalShape(BackSlashDiagonalShape.None);
        bf.getLeftBorder().setType(BorderType.Solid); // BorderType.Solid = 실선
        bf.getLeftBorder().setThickness(BorderThickness.MM0_12); // 기본 두께
        bf.getLeftBorder().getColor().setValue(0x0);
        bf.getRightBorder().setType(BorderType.Solid);
        bf.getRightBorder().setThickness(BorderThickness.MM0_12);
        bf.getRightBorder().getColor().setValue(0x0);
        bf.getTopBorder().setType(BorderType.Solid);
        bf.getTopBorder().setThickness(BorderThickness.MM0_12);
        bf.getTopBorder().getColor().setValue(0x0);
        bf.getBottomBorder().setType(BorderType.Solid);
        bf.getBottomBorder().setThickness(BorderThickness.MM0_12);
        bf.getBottomBorder().getColor().setValue(0x0);
        bf.setDiagonalSort(BorderType.Solid);
        bf.setDiagonalThickness(BorderThickness.MM0_12);
        bf.getDiagonalColor().setValue(0x0);

        bf.getFillInfo().getType().setPatternFill(true);
        bf.getFillInfo().createPatternFill();
        PatternFill pf = bf.getFillInfo().getPatternFill();
        pf.setPatternType(PatternType.None);
        pf.getBackColor().setValue(-1);
        pf.getPatternColor().setValue(0);

        return hwpFile.getDocInfo().getBorderFillList().size();
    }

    private void setListHeaderForCell(Cell cell, int colIndex, int rowIndex, int colSpan, int rowSpan, double width, double height) {
        ListHeaderForCell lh = cell.getListHeader();
        lh.setParaCount(1);
        lh.getProperty().setTextDirection(TextDirection.Horizontal);
        lh.getProperty().setLineChange(LineChange.Normal);
        lh.getProperty().setTextVerticalAlignment(TextVerticalAlignment.Center);
        lh.getProperty().setProtectCell(false);
        lh.getProperty().setEditableAtFormMode(false);
        lh.setColIndex(colIndex);
        lh.setRowIndex(rowIndex);
        lh.setColSpan(colSpan);
        lh.setRowSpan(rowSpan);
        lh.setWidth(mmToHwp(width));
        lh.setHeight(mmToHwp(height));
        lh.setLeftMargin(0);
        lh.setRightMargin(0);
        lh.setTopMargin(0);
        lh.setBottomMargin(0);
        lh.setBorderFillId(borderFillIDForCell);
        lh.setTextWidth(mmToHwp(width));
        lh.setFieldName("");
    }

    private void setParagraphForCell(Cell cell, String text) {
        Paragraph p = cell.getParagraphList().addNewParagraph();
        setParaHeader(p);
        setParaText(p, text);
        //setParaCharShape(p);
        setParaLineSeg(p);
    }

    private void setParaHeader(Paragraph p) {
        ParaHeader ph = p.getHeader();
        ph.setLastInList(true);
        // 셀의 문단 모양을 이미 만들어진 문단 모양으로 사용함
        ph.setParaShapeId(-1);
        // 셀의 스타일을 이미 만들어진 스타일으로 사용하려면 스타일 ID를 넣어주세요.
        //ph.setStyleId((short) 1);
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

    /**
     * Swing에 JLabel을 백그라운드로 생성하여 텍스트의 너비, 높이를 구합니다.
     * return: px 단위의 int형 변수.
     */
    private Font font = new Font(fontName, fontStyle, fontSize);
    private JLabel label = new JLabel();
    private FontMetrics fm = label.getFontMetrics(font);

    private int autoWidth(String text) {
        return SwingUtilities.computeStringWidth(fm, text);
    }

    private int autoHeight() {
        return fm.getHeight();
    }


    private void setCellStyle(HWPFile hwpFile, Cell c, String color, boolean bold) {
        ParagraphList paragraphs = c.getParagraphList();
        for (int i = 0; i < paragraphs.getParagraphCount(); i++) {
            Paragraph p = paragraphs.getParagraph(i);
            ParaCharShape pcs = p.getCharShape();
            if (pcs == null) {
                p.createCharShape(); // 글자 모양이 없다면, 글자 모양을 담을 공간을 생성하여야 합니다.
                pcs = p.getCharShape();
            }
            // 글자 모양에 지정한 폰트, 크기, bold를 지정합니다.
            pcs.addParaCharShape(0, createCharShape(hwpFile, color, fontName, fontSize, bold));
        }
    }

    private void setParaLineSeg(Paragraph p) {
        p.createLineSeg();

        ParaLineSeg pls = p.getLineSeg();
        LineSegItem lsi = pls.addNewLineSegItem();

        lsi.setTextStartPositon(0);
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

    private void setCellLineBreaker(HWPFile hwpFile, Cell c) {
        ParagraphList paragraphs = c.getParagraphList();
        for (int i = 0; i < paragraphs.getParagraphCount(); i++) {
            Paragraph p = paragraphs.getParagraph(i);
            ParaHeader ph = p.getHeader();
            ParaShape paraShape = hwpFile.getDocInfo().addNewParaShape();
            paraShape.getProperty1().setAlignment(Alignment.Center); // 가운데정렬
            paraShape.setLineSpace(100); // 줄바꿈이 일어날 위치 지정.
            int id = hwpFile.getDocInfo().getParaShapeList().size() - 1;
            ph.setParaShapeId(id);
        }
    }

    /**
     * 폰트 pt 사이즈를 줄 높이 사이즈로 변환 합니다.
     *
     * @param pt
     * @return int
     */
    private int ptToLineHeight(double pt) {
        return (int) (pt * 100.0f);
    }

    /**
     * mm를 Hwp에 포맷에 맞게 변환 합니다.
     *
     * @param mm
     * @return long
     */
    private long mmToHwp(double mm) {
        return (long) (mm * 72000.0f / 254.0f + 0.5f);
    }

    /**
     * px값을 mm로 변환합니다.
     *
     * @param px
     * @return double
     */
    private double pxTomm(double px) {
        return px * 0.264583333;
    }

    /**
     * 기본 pt사이즈를 지정합니다.
     *
     * @param pt
     * @return int
     */
    private int ptToBaseSize(int pt) {
        return pt * 100;
    }

    /**
     * HTML의 HexColor값을 RGB로 변환하기 위한 메소드 입니다.
     *
     * @param colorStr
     * @return RGBColor
     */
    private RGBColor hexToRgb(String colorStr) {
        return new RGBColor(
                Short.valueOf(colorStr.substring(0, 2), 16),
                Short.valueOf(colorStr.substring(2, 4), 16),
                Short.valueOf(colorStr.substring(4, 6), 16));
    }

    private int createCharShape(HWPFile hwpFile, String color, String fontName, int ptSize, boolean bold) {
        CharShape cs = hwpFile.getDocInfo().addNewCharShape();
        // 지정 폰트를 위한 FaceName 객체를 링크
        cs.getFaceNameIds().setForAll(createFaceName(hwpFile, fontName));

        cs.getRatios().setForAll((short) 100);
        cs.getCharSpaces().setForAll((byte) 0);
        cs.getRelativeSizes().setForAll((short) 100);
        cs.getCharOffsets().setForAll((byte) 0);
        cs.setBaseSize(ptToBaseSize(ptSize));

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
        RGBColor rgbColor = hexToRgb(color);
        cs.getCharColor().setR(rgbColor.getR());
        cs.getCharColor().setG(rgbColor.getG());
        cs.getCharColor().setB(rgbColor.getB());
        cs.getUnderLineColor().setValue(0x00000000);
        cs.getShadeColor().setValue(-1);
        cs.getShadowColor().setValue(0x00b2b2b2);
        cs.setBorderFillId(0);

        return hwpFile.getDocInfo().getCharShapeList().size() - 1;
    }

    // 바탕 폰트를 위한 FaceName 객체를 생성한다.(create FaceName Object for 'Batang' font)
    // '한글' 프로그램에서는 폰트를 적용할 문자를 6개의 부분으로 나눈다.(In 'Hangul' programs, the characters
    // to be applied to the font are divided into six parts.)
    private int createFaceName(HWPFile hwpFile, String fontName) {
        FaceName fn;

        // 한글 부분을 위한 FaceName 객체를 생성한다. (create FaceName Object for hangul part.)
        fn = hwpFile.getDocInfo().addNewHangulFaceName();
        setFaceName(fn, fontName);

        // 영어 부분을 위한 FaceName 객체를 생성한다. (create FaceName Object for english part.)
        fn = hwpFile.getDocInfo().addNewEnglishFaceName();
        setFaceName(fn, fontName);

        // 한자 부분을 위한 FaceName 객체를 생성한다. (create FaceName Object for hanja(Chinese)
        // part.)
        fn = hwpFile.getDocInfo().addNewHanjaFaceName();
        setFaceName(fn, fontName);

        // 일본어 부분을 위한 FaceName 객체를 생성한다.(create FaceName Object for japanse part.)
        fn = hwpFile.getDocInfo().addNewJapaneseFaceName();
        setFaceName(fn, fontName);

        // 기타 문자 부분을 위한 FaceName 객체를 생성한다.(create FaceName Object for etc part.)
        fn = hwpFile.getDocInfo().addNewEtcFaceName();
        setFaceName(fn, fontName);

        // 기호 문자 부분을 위한 FaceName 객체를 생성한다.(create FaceName Object for symbol part.)
        fn = hwpFile.getDocInfo().addNewSymbolFaceName();
        setFaceName(fn, fontName);

        // 사용자 정의 문자 부분을 위한 FaceName 객체를 생성한다.(create FaceName Object for user part.)
        fn = hwpFile.getDocInfo().addNewUserFaceName();
        setFaceName(fn, fontName);

        return hwpFile.getDocInfo().getHangulFaceNameList().size() - 1;
    }

    private void setFaceName(FaceName fn, String fontName) {
        fn.getProperty().setHasBaseFont(false);
        fn.getProperty().setHasFontInfo(false);
        fn.getProperty().setHasSubstituteFont(false);
        fn.setName(fontName);
    }
}
