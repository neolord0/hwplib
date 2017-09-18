package kr.dogfoot.hwplib.object.bodytext.control.gso;

import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.bookmark.CtrlData;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderGso;
import kr.dogfoot.hwplib.object.bodytext.control.gso.caption.Caption;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.ShapeComponent;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.ShapeComponentNormal;

/**
 * 그리기 개체 컨트롤
 * 
 * @author neolord
 */
public class GsoControl extends Control {
	/**
	 * 컨트롤 데이터
	 */
	private CtrlData ctrlData;
	/**
	 * 캡션 정보
	 */
	private Caption caption;
	/**
	 * 그리기 개체의 공통 요소
	 */
	protected ShapeComponent shapeComponent;

	/**
	 * 생성자
	 */
	public GsoControl() {
		this(new CtrlHeaderGso());
	}

	/**
	 * 생상자
	 * 
	 * @param header
	 *            그리기 개체를 위한 컨트롤 헤더
	 */
	public GsoControl(CtrlHeaderGso header) {
		super(header);

		ctrlData = null;
		caption = null;
		shapeComponent = new ShapeComponentNormal();
	}

	/**
	 * 그리기 개체를 위한 컨트롤 헤더 객체를 반환한다.
	 * 
	 * @return 그리기 개체를 위한 컨트롤 헤더 객체
	 */
	public CtrlHeaderGso getHeader() {
		return (CtrlHeaderGso) header;
	}

	/**
	 * 그리기 개체 아이디를 반환환다.
	 * 
	 * @return 그리기 개체 아이디
	 */
	public long getGsoId() {
		return shapeComponent.getGsoId();
	}

	/**
	 * 그리기 개체 아이디를 설정한다.
	 * 
	 * @param gsoId
	 *            그리기 개체 아이디
	 */
	protected void setGsoId(long gsoId) {
		shapeComponent.setGsoId(gsoId);
	}

	/**
	 * 그리기 개체 타입을 반환한다.
	 * 
	 * @return 그리기 개체 타입
	 */
	public GsoControlType getGsoType() {
		return GsoControlType.idOf(getGsoId());
	}

	/**
	 * 컨트롤 데이터(??)를 생성한다.
	 */
	public void createCtrlData() {
		ctrlData = new CtrlData();
	}

	/**
	 * 컨트롤 데이터(??)를 반환한다.
	 * 
	 * @return 컨트롤 데이터 객체
	 */
	public CtrlData getCtrlData() {
		return ctrlData;
	}

	/**
	 * 캡션 객체를 생성한다.
	 */
	public void createCaption() {
		caption = new Caption();
	}

	/**
	 * 캡션 정보 객체를 반환한다.
	 * 
	 * @return 캡션 정보 객체
	 */
	public Caption getCaption() {
		return caption;
	}

	/**
	 * 캡션 정보 객체을 설정한다.
	 * 
	 * @param caption
	 *            캡션 정보 객체
	 */
	public void setCaption(Caption caption) {
		this.caption = caption;
	}

	/**
	 * 그리기 개체의 공통 요소을 나태내는 객체를 반환한다.
	 * 
	 * @return 그리기 개체의 공통 요소을 나태내는 객체
	 */
	public ShapeComponent getShapeComponent() {
		return shapeComponent;
	}
}
