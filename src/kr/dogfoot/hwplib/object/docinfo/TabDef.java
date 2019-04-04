package kr.dogfoot.hwplib.object.docinfo;

import kr.dogfoot.hwplib.object.docinfo.tabdef.TabDefProperty;
import kr.dogfoot.hwplib.object.docinfo.tabdef.TabInfo;

import java.util.ArrayList;

/**
 * 탭 정의에 대한  레코드
 *
 * @author neolord
 */
public class TabDef {
    /**
     * 속성
     */
    private TabDefProperty property;
    /**
     * 탭 정보 리스트
     */
    private ArrayList<TabInfo> tabInfoList;

    /**
     * 생성자
     */
    public TabDef() {
        property = new TabDefProperty();
        tabInfoList = new ArrayList<TabInfo>();
    }

    /**
     * 탭 정의의 속성 객체를 반환한다.
     *
     * @return 탭 정의의 속성 객체
     */
    public TabDefProperty getProperty() {
        return property;
    }

    /**
     * 새로운 탭 정보를 생성하고 리스트에 추가한다.
     *
     * @return 세로 생성된 탭 정보
     */
    public TabInfo addNewTabInfo() {
        TabInfo ti = new TabInfo();
        tabInfoList.add(ti);
        return ti;
    }

    /**
     * 탭 정보 리스트를 반환한다.
     *
     * @return 탭 정보 리스트
     */
    public ArrayList<TabInfo> getTabInfoList() {
        return tabInfoList;
    }
}
