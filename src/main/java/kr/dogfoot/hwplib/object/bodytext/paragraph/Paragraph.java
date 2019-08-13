package kr.dogfoot.hwplib.object.bodytext.paragraph;

import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.control.FactoryForControl;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderGso;
import kr.dogfoot.hwplib.object.bodytext.control.gso.GsoControl;
import kr.dogfoot.hwplib.object.bodytext.control.gso.GsoControlType;
import kr.dogfoot.hwplib.object.bodytext.paragraph.charshape.ParaCharShape;
import kr.dogfoot.hwplib.object.bodytext.paragraph.header.ParaHeader;
import kr.dogfoot.hwplib.object.bodytext.paragraph.lineseg.ParaLineSeg;
import kr.dogfoot.hwplib.object.bodytext.paragraph.memo.Memo;
import kr.dogfoot.hwplib.object.bodytext.paragraph.rangetag.ParaRangeTag;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.ParaText;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * 하나의 문단을 나타내는 객체
 *
 * @author neolord
 */
public class Paragraph {
    /**
     * 헤더
     */
    private ParaHeader header;
    /**
     * 텍스트
     */
    private ParaText text;
    /**
     * 글자 모양
     */
    private ParaCharShape charShape;
    /**
     * 레이아웃
     */
    private ParaLineSeg lineSeg;
    /**
     * 영역 태그
     */
    private ParaRangeTag rangeTag;

    /**
     * 컨트롤 리스트
     */
    private ArrayList<Control> controlList;

    /**
     * 메모 리스트
     */
    private ArrayList<Memo> memoList;

    /**
     * 생성자
     */
    public Paragraph() {
        header = new ParaHeader();
    }

    /**
     * 헤더에 대한 객체를 반환한다.
     *
     * @return 헤더에 대한 객체
     */
    public ParaHeader getHeader() {
        return header;
    }

    /**
     * 문단 텍스트에 대한 객체를 생성한다.
     */
    public void createText() {
        text = new ParaText();
    }

    /**
     * 문단 텍스트에 대한 객체를 삭제한다.
     */
    public void deleteText() {
        text = null;
    }

    /**
     * 문단 텍스트에 대한 객체를 반환한다.
     *
     * @return 문단 텍스트에 대한 객체
     */
    public ParaText getText() {
        return text;
    }

    /**
     * 문단의 글자 모양에 대한 객체를 생성한다.
     */
    public void createCharShape() {
        charShape = new ParaCharShape();
    }

    /**
     * 문단의 글자 모양에 대한 객체를 삭제한다.
     */
    public void deleteCharShape() {
        charShape = null;
    }

    /**
     * 문단의 글자 모양에 대한 객체를 반환한다.
     *
     * @return 문단의 글자 모양에 대한 객체
     */
    public ParaCharShape getCharShape() {
        return charShape;
    }

    /**
     * 문단의 레이아웃에 대한 객체를 생성한다.
     */
    public void createLineSeg() {
        lineSeg = new ParaLineSeg();
    }

    /**
     * 문단의 레이아웃에 대한 객체를 삭제한다.
     */
    public void deleteLineSeg() {
        lineSeg = null;
    }

    /**
     * 문단의 레이아웃에 대한 객체를 반환한다.
     *
     * @return 문단의 레이아웃에 대한 객체
     */
    public ParaLineSeg getLineSeg() {
        return lineSeg;
    }

    /**
     * 문단의 영역 태그에 대한 객체를 생성한다.
     */
    public void createRangeTag() {
        rangeTag = new ParaRangeTag();
    }

    /**
     * 문단의 영역 태그에 대한 객체를 삭제한다.
     */
    public void deleteRangeTag() {
        rangeTag = null;
    }

    /**
     * 문단의 영역 태그에 대한 객체를 반환한다.
     *
     * @return 문단의 영역 태그에 대한 객체
     */
    public ParaRangeTag getRangeTag() {
        return rangeTag;
    }

    /**
     * type에 해당하는 새로운 컨트롤을 생성하고 리스트에 추가한다.
     *
     * @param type 컨트롤 타입
     * @return 새로 생성된 컨트롤 객체
     */
    public Control addNewControl(ControlType type) {
        return addNewControl(type.getCtrlId());
    }

    /**
     * id에 해당하는 새로운 컨트롤을 생성하고 리스트에 추가한다.
     *
     * @param id 컨트롤 id값
     * @return 새로 생성된 컨트롤 객체
     */
    public Control addNewControl(long id) {
        if (controlList == null) {
            controlList = new ArrayList<Control>();
        }
        Control c = FactoryForControl.create(id);
        controlList.add(c);
        return c;
    }

    /**
     * gsoType에 해당하는 새로운 GSO 컨트롤(그리기 객체)를 생성하고 리스트에 추가한다.
     *
     * @param gsoType GSO 컨트롤(그리기 객체) 타입
     * @return 새로 생성한 GSO 컨트롤
     */
    public GsoControl addNewGsoControl(GsoControlType gsoType) {
        return addNewGsoControl(gsoType.getId(), new CtrlHeaderGso());
    }

    /**
     * gsoType에 해당하는 새로운 GSO 컨트롤(그리기 객체)를 생성하고 리스트에 추가한다. 새로 생성한 GSO 컨트롤의 헤더를
     * header로 설정한다.
     *
     * @param gsoType GSO 컨트롤(그리기 객체) 타입
     * @param header  컨트롤 헤더 객체
     * @return 새로 생성한 GSO 컨트롤
     */
    public GsoControl addNewGsoControl(GsoControlType gsoType, CtrlHeaderGso header) {
        return addNewGsoControl(gsoType.getId(), header);
    }

    /**
     * gsoid에 해당하는 새로운 GSO 컨트롤(그리기 객체)를 생성하고 리스트에 추가한다. 새로 생성한 GSO 컨트롤의 헤더를 header로
     * 설정한다.
     *
     * @param gsoId  GSO 컨트롤(그리기 객체)의 id
     * @param header 컨트롤 헤더 객체
     * @return 새로 생성한 GSO 컨트롤
     */
    public GsoControl addNewGsoControl(long gsoId, CtrlHeaderGso header) {
        if (controlList == null) {
            controlList = new ArrayList<Control>();
        }
        GsoControl gc = FactoryForControl.createGso(gsoId, header);
        controlList.add(gc);
        return gc;
    }

    /**
     * 컨트롤 리스트를 반환한다.
     *
     * @return 컨트롤 리스트
     */
    public ArrayList<Control> getControlList() {
        return controlList;
    }

    /**
     * 컨트롤 리스트에서 컨트롤의 순번을 반환한다.
     *
     * @param c 컨트롤
     * @return 컨트롤의 순번
     */
    public int getControlIndex(Control c) {
        return controlList.indexOf(c);
    }

    /**
     * 문단 내의 일반 문자열을 반환한다.
     *
     * @return 문단 내의 일반 문자열
     * @throws UnsupportedEncodingException
     */
    public String getNormalString() throws UnsupportedEncodingException {
        if (text != null) {
            return text.getNormalString(0);
        }
        return "";
    }

    /**
     * 새로운 메모을 생성하여 반환한다.
     *
     * @return 새로 생성된 메모
     */
    public Memo addNewMemo() {
        if (memoList == null) {
            memoList = new ArrayList<Memo>();
        }

        Memo m = new Memo();
        memoList.add(m);
        return m;
    }

    /**
     * 메모 리스트를 반환한다.
     *
     * @return 메모 리스트
     */
    public ArrayList<Memo> getMemoList() {
        return memoList;
    }
}
