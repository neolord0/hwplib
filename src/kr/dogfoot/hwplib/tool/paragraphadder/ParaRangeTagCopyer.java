package kr.dogfoot.hwplib.tool.paragraphadder;

import kr.dogfoot.hwplib.object.bodytext.paragraph.rangetag.ParaRangeTag;
import kr.dogfoot.hwplib.object.bodytext.paragraph.rangetag.RangeTagItem;

public class ParaRangeTagCopyer {
	public static void copy(ParaRangeTag source, ParaRangeTag target) throws Exception {
		for (RangeTagItem rti : source.getRangeTagItemList()) {
			copyRangeTagItem(rti, target.addNewRangeTagItem());
		}
	}

	private static void copyRangeTagItem(RangeTagItem source, RangeTagItem target) throws Exception {
		target.setRangeStart(source.getRangeStart());
		target.setRangeEnd(source.getRangeEnd());
		target.setSort(source.getSort());
		target.setData(clonedArray(source.getData()));
	}
	
	private static byte[] clonedArray(byte[] source) {
		byte[] target = new byte[source.length];
		System.arraycopy(source, 0, target, 0, source.length);
		return target;
	}
}
