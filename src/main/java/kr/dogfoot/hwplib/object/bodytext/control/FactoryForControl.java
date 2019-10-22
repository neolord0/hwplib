package kr.dogfoot.hwplib.object.bodytext.control;

import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderGso;
import kr.dogfoot.hwplib.object.bodytext.control.gso.*;

/**
 * 컨트롤을 생성하는 객체
 *
 * @author neolord
 */
public class FactoryForControl {
    /**
     * 컨트롤 id에 해당되는 컨트롤을 생성한다.
     *
     * @param ctrlId 컨트롤 id
     * @return 새로 생성된 컨트롤
     */
    public static Control create(long ctrlId) {
        if (ctrlId == ControlType.SectionDefine.getCtrlId()) {
            return new ControlSectionDefine();
        } else if (ctrlId == ControlType.ColumnDefine.getCtrlId()) {
            return new ControlColumnDefine();
        } else if (ctrlId == ControlType.Table.getCtrlId()) {
            return new ControlTable();
        } else if (ctrlId == ControlType.Equation.getCtrlId()) {
            return new ControlEquation();
        } else if (ctrlId == ControlType.Header.getCtrlId()) {
            return new ControlHeader();
        } else if (ctrlId == ControlType.Footer.getCtrlId()) {
            return new ControlFooter();
        } else if (ctrlId == ControlType.Footnote.getCtrlId()) {
            return new ControlFootnote();
        } else if (ctrlId == ControlType.Endnote.getCtrlId()) {
            return new ControlEndnote();
        } else if (ctrlId == ControlType.AutoNumber.getCtrlId()) {
            return new ControlAutoNumber();
        } else if (ctrlId == ControlType.NewNumber.getCtrlId()) {
            return new ControlNewNumber();
        } else if (ctrlId == ControlType.PageHide.getCtrlId()) {
            return new ControlPageHide();
        } else if (ctrlId == ControlType.PageOddEvenAdjust.getCtrlId()) {
            return new ControlPageOddEvenAdjust();
        } else if (ctrlId == ControlType.PageNumberPositon.getCtrlId()) {
            return new ControlPageNumberPosition();
        } else if (ctrlId == ControlType.IndexMark.getCtrlId()) {
            return new ControlIndexMark();
        } else if (ctrlId == ControlType.Bookmark.getCtrlId()) {
            return new ControlBookmark();
        } else if (ctrlId == ControlType.OverlappingLetter.getCtrlId()) {
            return new ControlOverlappingLetter();
        } else if (ctrlId == ControlType.AdditionalText.getCtrlId()) {
            return new ControlAdditionalText();
        } else if (ctrlId == ControlType.HiddenComment.getCtrlId()) {
            return new ControlHiddenComment();
        } else if (ControlType.isField(ctrlId)) {
            return new ControlField(ctrlId);
        }
        return null;
    }

    /**
     * 그리기 객체 아이디(gsoId)에 해당되는 그리기 객체 컨트롤를 새로 생성한다.
     *
     * @param gsoId  그리기 객체 아이디
     * @param header 그리기 객체용 컨트롤 헤더
     * @return 새로 생성된 그리기 객체 컨트롤
     */
    public static GsoControl createGso(long gsoId, CtrlHeaderGso header) {
        if (gsoId == GsoControlType.Line.getId()) {
            return new ControlLine(header);
        } else if (gsoId == GsoControlType.Rectangle.getId()) {
            return new ControlRectangle(header);
        } else if (gsoId == GsoControlType.Ellipse.getId()) {
            return new ControlEllipse(header);
        } else if (gsoId == GsoControlType.Polygon.getId()) {
            return new ControlPolygon(header);
        } else if (gsoId == GsoControlType.Arc.getId()) {
            return new ControlArc(header);
        } else if (gsoId == GsoControlType.Curve.getId()) {
            return new ControlCurve(header);
        } else if (gsoId == GsoControlType.Picture.getId()) {
            return new ControlPicture(header);
        } else if (gsoId == GsoControlType.OLE.getId()) {
            return new ControlOLE(header);
        } else if (gsoId == GsoControlType.Container.getId()) {
            return new ControlContainer(header);
        } else if (gsoId == GsoControlType.ObjectLinkLine.getId()) {
            return new ControlObjectLinkLine(header);
        }
        return null;
    }
}
