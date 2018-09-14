package kr.dogfoot.hwplib.test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.ControlTable;
import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.control.table.Cell;
import kr.dogfoot.hwplib.object.bodytext.control.table.Row;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.tool.objectfinder.ControlFilter;
import kr.dogfoot.hwplib.tool.objectfinder.ControlFinder;

public class TestFindControl {
	public static class MyControlFilter implements ControlFilter {

		@Override
		public boolean isMatched(Control control, Paragraph paragrpah,
				Section section) {
			// 컨트롤이 테이블이고
			if (control.getType() == ControlType.Table) {
				ControlTable table = (ControlTable) control;
				Row firstRow = table.getRowList().get(0);
				Cell firstCell = firstRow.getCellList().get(0);
			
				// 첫번째 셀의 문자열이 "A"로 시작되는 테이블을 찾는다.
				try {
					if (firstCell.getParagraphList().getNormalString().startsWith("A")) {
						return true;
					}
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return false;
		}
	}

	public static void main(String[] args) throws Exception {
		String filename = "sample_hwp\\test-컨트롤 찾기.hwp";
		
		HWPFile hwpFile = HWPReader.fromFile(filename);
		if (hwpFile != null) {
			MyControlFilter myFilter = new MyControlFilter();
			ArrayList<Control> result = ControlFinder.find(hwpFile, myFilter);
			
			System.out.println("found " + result.size() + " tables.");
		}
	}
}
