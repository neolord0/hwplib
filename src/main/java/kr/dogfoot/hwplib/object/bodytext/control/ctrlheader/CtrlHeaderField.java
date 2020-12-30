package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader;

import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.field.FieldHeaderProperty;

/**
 * 필드 컨트롤를 위한 컨트롤 헤더 레코드
 *
 * @author neolord
 */
public class CtrlHeaderField extends CtrlHeader {
    /**
     * 속성
     */
    private FieldHeaderProperty property;
    /**
     * 기타 속성
     */
    private short etcProperty;
    /**
     * command
     */
    private String command;
    /**
     * id(문서 내 고유 아이디)
     */
    private long instanceId;
    /**
     * 메모 인덱스
     */
    private int memoIndex;

    /**
     * 생성자
     */
    public CtrlHeaderField() {
        this(ControlType.FIELD_UNKNOWN.getCtrlId());
    }

    /**
     * 생성자
     *
     * @param ctrlId 컨트롤 아이디(필드 아이디)
     */
    public CtrlHeaderField(long ctrlId) {
        super(ctrlId);

        property = new FieldHeaderProperty();
    }

    /**
     * 컨트롤 아이디(필드 아이디)를 설정한다.
     *
     * @param ctrlId 컨트롤 아이디
     */
    public void setCtrlId(long ctrlId) {
        this.ctrlId = ctrlId;
    }

    /**
     * 필드 컨트롤의 속성 객체를 반환한다.
     *
     * @return 필드 컨트롤의 속성 객체
     */
    public FieldHeaderProperty getProperty() {
        return property;
    }

    /**
     * 기타 속성을 반환한다.
     *
     * @return 기타 속성
     */
    public short getEtcProperty() {
        return etcProperty;
    }

    /**
     * 기타 속성을 설정한다.
     *
     * @param etcProperty 기타 속성
     */
    public void setEtcProperty(short etcProperty) {
        this.etcProperty = etcProperty;
    }

    /**
     * 필드 command를 반환한다.
     *
     * @return 필드 command
     */
    public String getCommand() {
        return command;
    }

    /**
     * 필드 command를 설정한다.
     *
     * @param command 필드 command
     */
    public void setCommand(String command) {
        this.command = command;
    }

    /**
     * 문서 내 고유 아이디를 반환한다.
     *
     * @return 문서 내 고유 아이디
     */
    public long getInstanceId() {
        return instanceId;
    }

    /**
     * 문서 내 고유 아이디를 설정한다.
     *
     * @param instanceId 문서 내 고유 아이디
     */
    public void setInstanceId(long instanceId) {
        this.instanceId = instanceId;
    }

    /**
     * 메모 인덱스를 반환한다.
     *
     * @return 메모 인덱스
     */
    public int getMemoIndex() {
        return memoIndex;
    }

    /**
     * 메모 인덱스를 설정한다.
     *
     * @param memoIndex 메모 인덱스
     */
    public void setMemoIndex(int memoIndex) {
        this.memoIndex = memoIndex;
    }

    @Override
    public void copy(CtrlHeader from) {
        CtrlHeaderField from2 = (CtrlHeaderField) from;
        property.copy(from2.property);
        etcProperty = from2.etcProperty;
        command = from2.command;
        instanceId = from2.instanceId;
        memoIndex = from2.memoIndex;
    }

}
