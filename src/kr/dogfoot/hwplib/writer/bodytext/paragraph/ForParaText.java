package kr.dogfoot.hwplib.writer.bodytext.paragraph;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPChar;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPCharControlChar;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPCharControlExtend;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPCharControlInline;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPCharNormal;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.ParaText;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

public class ForParaText {
	public static void write(ParaText pt, StreamWriter sw) throws IOException {
		if (pt == null) {
			return;
		}
		
		recordHeader(pt, sw);
		
		for (HWPChar hc : pt.getCharList()) {
			hwpChar(hc, sw);
		}
	}

	private static void recordHeader(ParaText pt, StreamWriter sw) throws IOException {
		sw.writeRecordHeader(HWPTag.PARA_TEXT, sw.getCurrentParagraphLevel() + 1, getSize(pt));
	}

	private static int getSize(ParaText pt) {
		int size = 0;
		for (HWPChar hc : pt.getCharList()) { 
			switch(hc.getType()) {
			case Normal:
				size += 2;
				break;
			case ControlChar:
				size += 2;
				break;
			case ControlInline:
				size += 16;
				break;
			case ControlExtend:
				size += 16;
				break;
			}
		}
		return size;
	}
	
	private static void hwpChar(HWPChar hc, StreamWriter sw) throws UnsupportedEncodingException, IOException {
		switch(hc.getType()) {
		case Normal:
			normal((HWPCharNormal)hc, sw);
			break;
		case ControlChar:
			controlChar((HWPCharControlChar)hc, sw);
			break;
		case ControlInline:
			controlInline((HWPCharControlInline)hc, sw); 
			break;
		case ControlExtend:
			controlExtend((HWPCharControlExtend)hc, sw);
			break;
		}
	}

	private static void normal(HWPCharNormal hc, StreamWriter sw) throws UnsupportedEncodingException, IOException {
		sw.writeBytes(hc.getCh().getBytes("UTF-16LE"));
	}

	private static void controlChar(HWPCharControlChar hc, StreamWriter sw) throws IOException {
		sw.writeSInt2(hc.getCode());
	}

	private static void controlInline(HWPCharControlInline hc, StreamWriter sw) throws IOException {
		sw.writeSInt2(hc.getCode());
		sw.writeBytes(hc.getAddition());
		sw.writeSInt2(hc.getCode());
	}

	private static void controlExtend(HWPCharControlExtend hc, StreamWriter sw) throws IOException {
		sw.writeSInt2(hc.getCode());
		sw.writeBytes(hc.getAddition());
		sw.writeSInt2(hc.getCode());
	}
}
