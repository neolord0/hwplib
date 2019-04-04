package kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso;

import kr.dogfoot.hwplib.object.bodytext.control.FactoryForControl;
import kr.dogfoot.hwplib.object.bodytext.control.bookmark.CtrlData;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderGso;
import kr.dogfoot.hwplib.object.bodytext.control.gso.*;
import kr.dogfoot.hwplib.object.bodytext.control.gso.caption.Caption;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.reader.bodytext.paragraph.control.bookmark.ForCtrlData;
import kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso.part.ForCaption;
import kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso.part.ForCtrlHeaderGso;
import kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso.part.ForShapeComponent;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 그리기 개체 컨트롤들을 읽는다.
 *
 * @author neolord
 */
public class ForGsoControl {
    /**
     * 문단 객체
     */
    private Paragraph paragraph;
    /**
     * 스트림 리더
     */
    private StreamReader sr;
    /**
     * 생성된 그리기 개체 컨트롤
     */
    private GsoControl gsoControl;

    /**
     * 생성자
     */
    public ForGsoControl() {
    }

    /**
     * 그리기 개체 컨트롤을 읽는다.
     *
     * @param paragraph 문단 객체
     * @param sr        스트림 리더
     * @throws Exception
     */
    public void read(Paragraph paragraph, StreamReader sr) throws Exception {
        this.paragraph = paragraph;
        this.sr = sr;
        CtrlHeaderGso header = ctrlHeader();
        Caption caption = caption();
        CtrlData ctrlData = ctrlData();
        long gsoId = gsoIDFromShapeComponent();
        gsoControl = createGsoControl(header, caption, ctrlData, gsoId);
        restPartOfShapeCompponent();
        restPartOfControl();
    }

    /**
     * 그리기 개체의 컨트롤 헤더 레코드를 읽는다.
     *
     * @return 그리기 개체의 컨트롤 헤더 레코드
     * @throws IOException
     */
    private CtrlHeaderGso ctrlHeader() throws IOException {
        CtrlHeaderGso header = new CtrlHeaderGso();
        ForCtrlHeaderGso.read(header, sr);
        return header;
    }

    /**
     * 캡션 정보를 읽는다.
     *
     * @return 캡션 정보
     * @throws Exception
     */
    private Caption caption() throws Exception {
        sr.readRecordHeder();
        if (sr.getCurrentRecordHeader().getTagID() == HWPTag.LIST_HEADER) {
            Caption caption = new Caption();
            ForCaption.read(caption, sr);
            return caption;
        } else {
            return null;
        }
    }

    /**
     * 컨트롤 데이터를 읽는다.
     *
     * @return 컨트롤 데이터
     * @throws IOException
     */
    private CtrlData ctrlData() throws IOException {
        if (sr.isImmediatelyAfterReadingHeader() == false) {
            sr.readRecordHeder();
        }
        if (sr.getCurrentRecordHeader().getTagID() == HWPTag.CTRL_DATA) {
            CtrlData ctrlData = new CtrlData();
            ForCtrlData.read(ctrlData, sr);
            return ctrlData;
        } else {
            return null;
        }
    }

    /**
     * 객체 공통 속성 레코드로 부터 그리기 개체의 id를 읽는다.
     *
     * @return 그리기 개체의 id
     * @throws Exception
     */
    private long gsoIDFromShapeComponent() throws Exception {
        if (sr.isImmediatelyAfterReadingHeader() == false) {
            sr.readRecordHeder();
        }
        if (sr.getCurrentRecordHeader().getTagID() == HWPTag.SHAPE_COMPONENT) {
            long id = sr.readUInt4();
            sr.skip(4); // id2;
            return id;
        } else {
            throw new Exception(
                    "Shape Component must come after CtrlHeader for gso control.");
        }
    }

    /**
     * 그리기 개체 컨트롤을 생성한다.
     *
     * @param header   컨트롤 헤더
     * @param caption  캡션 정보
     * @param ctrlData 컨트롤 데이터
     * @param gsoId    그리기 개체 아이디
     * @return 생성된 그리기 개체 컨트롤
     */
    private GsoControl createGsoControl(CtrlHeaderGso header, Caption caption,
                                        CtrlData ctrlData, long gsoId) {
        GsoControl gc = paragraph.addNewGsoControl(gsoId, header);
        gc.setCaption(caption);
        gc.setCtrlData(ctrlData);
        return gc;
    }

    /**
     * 객체 공통 속성 레코드의 나머지 부분을 읽는다.
     *
     * @throws IOException
     */
    private void restPartOfShapeCompponent() throws IOException {
        ForShapeComponent.read(gsoControl, sr);
    }

    /**
     * 컨트롤의 너머지 부분을 읽는다.
     *
     * @throws Exception
     */
    private void restPartOfControl() throws Exception {
        switch (gsoControl.getGsoType()) {
            case Line:
                ForControlLine.readRest((ControlLine) gsoControl, sr);
                break;
            case Rectangle:
                ForControlRectangle.readRest((ControlRectangle) gsoControl, sr);
                break;
            case Ellipse:
                ForControlEllipse.readRest((ControlEllipse) gsoControl, sr);
                break;
            case Arc:
                ForControlArc.readRest((ControlArc) gsoControl, sr);
                break;
            case Polygon:
                ForControlPolygon.readRest((ControlPolygon) gsoControl, sr);
                break;
            case Curve:
                ForControlCurve.readRest((ControlCurve) gsoControl, sr);
                break;
            case Picture:
                ForControlPicture.readRest((ControlPicture) gsoControl, sr);
                break;
            case OLE:
                ForControlOLE.readRest((ControlOLE) gsoControl, sr);
                break;
            case Container:
                ForControlContainer.readRest((ControlContainer) gsoControl, sr);
                break;
            case ObjectLinkLine:
                ForControlObjectLinkLine.readRest((ControlObjectLinkLine) gsoControl, sr);
                break;
        }
    }

    /**
     * 묶음 컨트롤 안에 포함된 컨트롤을 읽는다.
     *
     * @param sr 스트림 리더
     * @return 묶음 컨트롤 안에 포함된 컨트롤
     * @throws Exception
     */
    public GsoControl readInContainer(StreamReader sr) throws Exception {
        this.sr = sr;
        shapeComponentInContainer();
        restPartOfControl();
        return gsoControl;
    }

    /**
     * 묶음 컨트롤 안에 포함된 컨트롤을 위한 그리기 개체 컨트롤 헤더 레코드를 읽는다.
     *
     * @throws Exception
     */
    private void shapeComponentInContainer() throws Exception {
        sr.readRecordHeder();
        if (sr.getCurrentRecordHeader().getTagID() == HWPTag.SHAPE_COMPONENT) {
            long id = sr.readUInt4();
            gsoControl = FactoryForControl.createGso(id, null);
            ForShapeComponent.read(gsoControl, sr);
        } else {
            throw new Exception(
                    "Shape Component must come after CtrlHeader for gso control.");
        }
    }
}
