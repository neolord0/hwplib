package kr.dogfoot.hwplib.object.bodytext.control.bookmark;

import java.util.ArrayList;

/**
 * 파라미터 셋 객체
 *
 * @author neolord
 */
public class ParameterSet {
    /**
     * 파라미터 셋 id
     */
    private int id;
    /**
     * 파라미터 아이탬 리스트
     */
    private ArrayList<ParameterItem> parameterItemList;

    /**
     * 생성자
     */
    public ParameterSet() {
        id = 0;
        parameterItemList = new ArrayList<ParameterItem>();
    }

    /**
     * 파라미터 셋 id를 반환한다.
     *
     * @return 파라미터 셋 id
     */
    public int getId() {
        return id;
    }

    /**
     * 파라미터 셋 id를 설정한다.
     *
     * @param id 파라미터 셋 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 파라미터 아이탬을 생성하고 리스트에 추가한다.
     *
     * @return 새로 생성된 파라미터 아이탬
     */
    public ParameterItem addNewParameterItem() {
        ParameterItem pi = new ParameterItem();
        parameterItemList.add(pi);
        return pi;
    }

    /**
     * 파라미터 아이탬 리스트를 반환한다.
     *
     * @return 파라미터 아이탬 리스트
     */
    public ArrayList<ParameterItem> getParameterItemList() {
        return parameterItemList;
    }

    /**
     * 아이디가 id인 파라미터 아이탬을 반환한다.
     *
     * @param id 파리미터 아이탬의 아이디
     * @return 아이디가 id인 파라미터 아이탬
     */
    public ParameterItem getParameterItem(int id) {
        for (ParameterItem pi : parameterItemList) {
            if (pi.getId() == id) {
                return pi;
            }
        }
        return null;
    }

    /**
     * 필드 이름을 위한 파라미터 셋 객체를 만든다.
     *
     * @param fieldName 필드 이름
     * @return 필드 이름을 위한 파라미터 셋 객체
     */
    public static ParameterSet createForFieldName(String fieldName) {
        if (fieldName == null || fieldName.length() == 0) {
            return null;
        }

        ParameterSet ps = new ParameterSet();
        ps.setId(0x21b);
        ParameterItem pi = ps.addNewParameterItem();
        pi.setId(0x4000);
        pi.setType(ParameterType.String);
        pi.setValue_BSTR(fieldName);
        return ps;
    }

    public void copy(ParameterSet from) {
        id = from.id;

        for (ParameterItem parameterItem : from.parameterItemList) {
            parameterItemList.add(parameterItem.clone());
        }
    }
}
