package kr.dogfoot.hwplib.tool.objectfinder;

import java.util.ArrayList;

public class TextBuffer {
	private ArrayList<String> textList;
	private int textCount;
	private int currentIndex;

	public TextBuffer(ArrayList<String> textList) {
		this.textList = textList;
		this.textCount = textList.size();
		currentIndex = 0;
	}

	public String nextText() {
		String text = textList.get(currentIndex);
		currentIndex++;
		return text;
	}

	public boolean hasNext() {
		if (currentIndex < textCount) {	
			return true;
		}
		return false;
	}

	public boolean usedAll() {
		if (currentIndex == textCount) {
			return true;
		}
		return false;
	}

	public boolean notUsed() {
		if (currentIndex == 0) {
			return true;
		}
		return false;
	}
}
