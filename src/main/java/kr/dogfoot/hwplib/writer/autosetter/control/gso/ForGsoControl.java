package kr.dogfoot.hwplib.writer.autosetter.control.gso;

import kr.dogfoot.hwplib.object.bodytext.control.gso.*;
import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.TextBox;
import kr.dogfoot.hwplib.writer.autosetter.ForParagraphList;
import kr.dogfoot.hwplib.writer.autosetter.InstanceID;
import kr.dogfoot.hwplib.writer.autosetter.control.gso.part.ForCaption;
import kr.dogfoot.hwplib.writer.autosetter.control.gso.part.ForCtrlHeaderGso;

/**
 * 각각의 그리기 개체 컨트롤을 쓰기 전에 자동 설정하기 위한 객체
 *
 * @author neolord
 */
public class ForGsoControl {
    /**
     * 그리기 개체 컨트롤를 자동 설정한다.
     *
     * @param gc  그리기 개체 컨트롤
     * @param iid 인스턴스 아이디
     */
    public static void autoSet(GsoControl gc, InstanceID iid) {
        ForCtrlHeaderGso.autoSet(gc.getHeader(), iid);
        ForCaption.autoSet(gc.getCaption(), iid);
        restPart(gc, iid);
    }

    /**
     * 그리기 개체 컨트롤 별의 나머지 부분을 자동 설정한다.
     *
     * @param gc  그리기 개체 컨트롤
     * @param iid 인스턴스 id
     */
    private static void restPart(GsoControl gc, InstanceID iid) {
        switch (gc.getGsoType()) {
            case Arc:
                arc((ControlArc) gc, iid);
                break;
            case Container:
                container((ControlContainer) gc, iid);
                break;
            case Curve:
                curve((ControlCurve) gc, iid);
                break;
            case Ellipse:
                ellipse((ControlEllipse) gc, iid);
                break;
            case Line:
                break;
            case OLE:
                break;
            case Picture:
                break;
            case Polygon:
                polygon((ControlPolygon) gc, iid);
                break;
            case Rectangle:
                rectangle((ControlRectangle) gc, iid);
                break;
            default:
                break;
        }
    }

    /**
     * 호 컨트롤의 나머지 부분을 자동 설정한다.
     *
     * @param arc 호 개체 컨트롤
     * @param iid 인스턴스 id
     */
    private static void arc(ControlArc arc, InstanceID iid) {
        textBox(arc.getTextBox(), iid);
    }

    /**
     * 글상자를 자동 설정한다.
     *
     * @param tb  글상자 객체
     * @param iid 인스턴스 id
     */
    private static void textBox(TextBox tb, InstanceID iid) {
        if (tb == null) {
            return;
        }

        listHeader(tb);
        ForParagraphList.autoSet(tb.getParagraphList(), iid);
    }

    /**
     * 글상자의 리스트 헤더 레코드를 자동 설정한다.
     *
     * @param tb 글상자
     */
    private static void listHeader(TextBox tb) {
        tb.getListHeader().setParaCount(
                tb.getParagraphList().getParagraphCount());
    }

    /**
     * 묶음 컨트롤의 나머지 부분을 자동 설정한다.
     *
     * @param cont 묶음 컨트롤
     * @param iid  인스턴스 id
     */
    private static void container(ControlContainer cont, InstanceID iid) {
        ForControlContainer.autoSet(cont, iid);
    }

    /**
     * 곡선 컨트롤의 나머지 부분을 자동 설정한다.
     *
     * @param curv 곡선 컨트롤
     * @param iid  인스턴스 id
     */
    private static void curve(ControlCurve curv, InstanceID iid) {
        textBox(curv.getTextBox(), iid);
    }

    /**
     * 타원 컨트롤의 나머지 부분을 자동 설정한다.
     *
     * @param ell 타원 컨트롤
     * @param iid 인스턴스 id
     */
    private static void ellipse(ControlEllipse ell, InstanceID iid) {
        textBox(ell.getTextBox(), iid);
    }

    /**
     * 다각형 컨트롤의 나머지 부분을 자동 설정한다.
     *
     * @param poly 다각형 컨트롤
     * @param iid  인스턴스 id
     */
    private static void polygon(ControlPolygon poly, InstanceID iid) {
        textBox(poly.getTextBox(), iid);
    }

    /**
     * 사각형 컨트롤의 나머지 부분을 자동 설정한다.
     *
     * @param rect 사각형 컨트롤
     * @param iid  인스턴스 id
     */
    private static void rectangle(ControlRectangle rect, InstanceID iid) {
        textBox(rect.getTextBox(), iid);
    }
}
