package kr.dogfoot.hwplib.object.bodytext.control;

import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeader;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderGso;
import kr.dogfoot.hwplib.object.bodytext.control.gso.caption.Caption;
import kr.dogfoot.hwplib.object.bodytext.control.table.Row;
import kr.dogfoot.hwplib.object.bodytext.control.table.Table;

import java.util.ArrayList;

/**
 * 표 컨트롤
 *
 * @author neolord
 */
public class ControlTable extends Control {
    /**
     * 캡션
     */
    private Caption caption;
    /**
     * 표 정보
     */
    private Table table;
    /**
     * 행 리스트
     */
    private ArrayList<Row> rowList;

    /**
     * 생성자
     */
    public ControlTable() {
        this(new CtrlHeaderGso(ControlType.Table));

        caption = null;
        table = new Table();
        rowList = new ArrayList<Row>();
    }

    /**
     * 생성자
     *
     * @param header 컨트롤 헤더
     */
    public ControlTable(CtrlHeader header) {
        super(header);

        caption = null;
        table = new Table();
        rowList = new ArrayList<Row>();
    }


    /**
     * 그리기 객체 용 컨트롤 헤더를 반환한다.
     *
     * @return 그리기 객체 용 컨트롤 헤더
     */
    public CtrlHeaderGso getHeader() {
        return (CtrlHeaderGso) header;
    }

    /**
     * 캡션 객체를 생성한다.
     */
    public void createCaption() {
        caption = new Caption();
    }

    /**
     * 캡션 객체를 삭제한다.
     */
    public void deleteCaption() {
        caption = null;
    }

    /**
     * 캡션 객체를 반환한다.
     *
     * @return 캡션 객체
     */
    public Caption getCaption() {
        return caption;
    }

    /**
     * 표 정보 객체를 반환한다.
     *
     * @return 표 정보 객체
     */
    public Table getTable() {
        return table;
    }

    /**
     * 새로운 행 객체를 생성하고 리스트에 추가한다.
     *
     * @return 새로 생성된 행 객체
     */
    public Row addNewRow() {
        Row r = new Row();
        rowList.add(r);
        return r;
    }

    /**
     * 행 리스트를 반환한다.
     *
     * @return 행 리스트
     */
    public ArrayList<Row> getRowList() {
        return rowList;
    }

    @Override
    public Control clone() {
        ControlTable cloned = new ControlTable();
        cloned.copyControlPart(this);

        if (caption != null) {
            cloned.createCaption();
            cloned.caption.copy(caption);
        } else {
            cloned.caption = null;
        }

        cloned.table.copy(table);

        for (Row row : rowList) {
            cloned.rowList.add(row.clone());
        }

        return cloned;
    }
}
