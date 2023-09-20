package kr.dogfoot.hwplib.object.bodytext.control;

import kr.dogfoot.hwplib.object.bodytext.control.bookmark.ParameterItem;
import kr.dogfoot.hwplib.object.bodytext.control.bookmark.ParameterType;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderField;

/**
 * 필드 컨트롤
 *
 * @author neolord
 */
public class ControlField extends Control {
    /**
     * 생성자
     *
     * @param ctrlId : ctrl header의 ctrl-id.
     */
    public ControlField(long ctrlId) {
        super(new CtrlHeaderField(ctrlId));
    }

    /**
     * 필드용 컨트롤 헤더를 반환한다.
     *
     * @return 필드용 컨트롤 헤더
     */
    public CtrlHeaderField getHeader() {
        return (CtrlHeaderField) header;
    }

    /**
     * 필드 컨트롤의 이름응 반환한다.
     *
     * @return 필드 컨트롤의 이름
     */
    public String getName() {
        if (ctrlData != null) {
            if (ctrlData.getParameterSet().getId() == 0x021B) {
                ParameterItem pi = ctrlData.getParameterSet().getParameterItem(0x4000);
                if (pi != null && pi.getType() == ParameterType.String) {
                    if (pi.getValue_BSTR() != null) {
                        return pi.getValue_BSTR();
                    } else {
                        return commandToName(getHeader().getCommand().toUTF16LEString());
                    }
                }
            }
        }
        return null;
    }

    private String commandToName(String command) {
        String[] properties = command.split(" ");
        if (properties == null || properties.length < 1) {
            return null;
        }
        String[] token = properties[0].split(":");
        if (token == null || token.length < 1) {
            return null;
        }
        return token[token.length - 1];
    }

    /**
     * 필드 컨트롤의 이름응 설정한다.
     *
     * @param name 필드 이름
     */
    public void setName(String name) {
        if (ctrlData == null) {
            createCtrlData();
            ctrlData.getParameterSet().setId(0x021B);
        }

        ParameterItem pi = ctrlData.getParameterSet().getParameterItem(
                0x4000);
        if (pi == null) {
             pi = ctrlData.getParameterSet().addNewParameterItem();
             pi.setId(0x4000);
        }

        pi.setType(ParameterType.String);
        pi.setValue_BSTR(name);
    }

    @Override
    public Control clone() {
        ControlField cloned = new ControlField(this.header.getCtrlId());
        cloned.copyControlPart(this);
        return cloned;
    }
}
