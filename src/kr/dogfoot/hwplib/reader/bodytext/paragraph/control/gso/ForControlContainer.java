package kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso;

import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlContainer;
import kr.dogfoot.hwplib.object.bodytext.control.gso.GsoControl;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.ShapeComponentContainer;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

/**
 * 묶은 컨트롤을 읽기 위한 객체
 * 
 * @author neolord
 */
public class ForControlContainer {
	/**
	 * 묶은 컨트롤을 읽는다.
	 * 
	 * @param container
	 *            묶은 컨트롤
	 * @param sr
	 *            스트림 리더
	 * @throws Exception
	 */
	public static void read(ControlContainer container, StreamReader sr)
			throws Exception {
		ShapeComponentContainer scc = (ShapeComponentContainer) container
				.getShapeComponent();
		int childCount = scc.getChildControlIdList().size();
		for (int i = 0; i < childCount; i++) {
			ForControlGso fgc = new ForControlGso();
			GsoControl gc = fgc.readInContainer(sr);
			container.addChildControl(gc);
		}
	}
}
