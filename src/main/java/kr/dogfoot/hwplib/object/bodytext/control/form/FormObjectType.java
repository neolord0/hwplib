package kr.dogfoot.hwplib.object.bodytext.control.form;

import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlID;

public enum FormObjectType {
    /**
     * 양식개체_명령단추
     */
    PushButton(CtrlID.make('+', 'p', 'b', 't')),
    /**
     * 양식개체_선택상자
     */
    CheckButton(CtrlID.make('+', 'c', 'b', 't')),
    /**
     * 양식개체_목록상자
     */
    ComboBox(CtrlID.make('+', 'c', 'o', 'b')),
    /**
     * 양식개체_라디오단추
     */
    RadioButton(CtrlID.make('+', 'r', 'b', 't')),
    /**
     * 양식개체_입력상자
     */
    EditorBox(CtrlID.make('+', 'e', 'd', 't'));

    /**
     * 컨트롤 id
     */
    private long id;

    /**
     * 생성자
     *
     * @param id 양식 개체 id
     */
    FormObjectType(long id) {
        this.id = id;
    }

    /**
     * 컨트롤 id를 반환한다.
     *
     * @return 컨트롤 id
     */
    public long getId() {
        return id;
    }

    public static FormObjectType fromUint4(long id) {
        for (FormObjectType fot : values()) {
            if (fot.id == id) {
                return fot;
            }
        }
        return null;
    }
}
