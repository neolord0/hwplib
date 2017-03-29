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
	 * @param id
	 *            파라미터 셋 id
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
	 * 
	 * @param id
	 * @return
	 */
	public ParameterItem getParameterItem(int id) {
		for (ParameterItem pi : parameterItemList) {
			if (pi.getId() == id) {
				return pi;
			}
		}
		return null;
	}
}
