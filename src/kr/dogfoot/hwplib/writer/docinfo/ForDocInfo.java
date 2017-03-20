package kr.dogfoot.hwplib.writer.docinfo;

import java.io.IOException;
import java.util.ArrayList;

import kr.dogfoot.hwplib.object.docinfo.BinData;
import kr.dogfoot.hwplib.object.docinfo.BorderFill;
import kr.dogfoot.hwplib.object.docinfo.Bullet;
import kr.dogfoot.hwplib.object.docinfo.CharShape;
import kr.dogfoot.hwplib.object.docinfo.DocInfo;
import kr.dogfoot.hwplib.object.docinfo.DocumentPropeties;
import kr.dogfoot.hwplib.object.docinfo.FaceName;
import kr.dogfoot.hwplib.object.docinfo.IDMappings;
import kr.dogfoot.hwplib.object.docinfo.Numbering;
import kr.dogfoot.hwplib.object.docinfo.ParaShape;
import kr.dogfoot.hwplib.object.docinfo.Style;
import kr.dogfoot.hwplib.object.docinfo.TabDef;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.object.etc.UnknownRecord;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;
import kr.dogfoot.hwplib.writer.ForUnknown;

public class ForDocInfo {
	private DocInfo docInfo;
	private StreamWriter sw;

	public ForDocInfo() {
	}

	public void write(DocInfo docInfo, StreamWriter sw) throws Exception {
		this.docInfo = docInfo;
		this.sw = sw;

		documentProerties();
		idMappings();
		binData();
		faceName();
		borderFill();
		charShape();
		tabDef();
		numbering();
		bullet();
		paraShape();
		style();
		docData();
		forbiddenChar();
		distributeDocData();
		compatibleDocument();
		layoutCompatibility();
		trackChange();
		memoShape();
		trackChange2();
		trackChangeAuthor();
	}

	private void documentProerties() throws IOException {
		DocumentPropeties dp = docInfo.getDocumentProperties();

		if (dp == null) {
			return;
		}
		ForDocumentProperties.write(dp, sw);
	}

	private void idMappings() throws IOException {
		IDMappings im = docInfo.getIDMappings();
		if (im == null) {
			return;
		}
		ForIDMappings.write(im, sw);
	}

	private void binData() throws IOException {
		for (BinData bd : docInfo.getBinDataList()) {
			ForBinData.write(bd, sw);
		}
	}

	private void faceName() throws IOException {
		faceNameList(docInfo.getHangulFaceNameList());
		faceNameList(docInfo.getEnglishFaceNameList());
		faceNameList(docInfo.getHanjaFaceNameList());
		faceNameList(docInfo.getJapaneseFaceNameList());
		faceNameList(docInfo.getEtcFaceNameList());
		faceNameList(docInfo.getSymbolFaceNameList());
		faceNameList(docInfo.getUserFaceNameList());
	}

	private void faceNameList(ArrayList<FaceName> faceNameList)
			throws IOException {
		for (FaceName fa : faceNameList) {
			ForFaceName.write(fa, sw);
		}
	}

	private void borderFill() throws IOException {
		for (BorderFill bf : docInfo.getBorderFillList()) {
			ForBorderFill.write(bf, sw);
		}
	}

	private void charShape() throws IOException {
		for (CharShape cs : docInfo.getCharShapeList()) {
			ForCharShape.write(cs, sw);
		}
	}

	private void tabDef() throws IOException {
		for (TabDef td : docInfo.getTabDefList()) {
			ForTabDef.write(td, sw);
		}
	}

	private void numbering() throws Exception {
		for (Numbering n : docInfo.getNumberingList()) {
			ForNumbering.write(n, sw);
		}
	}

	private void bullet() throws IOException {
		for (Bullet b : docInfo.getBulletList()) {
			ForBullet.write(b, sw);
		}
	}

	private void paraShape() throws IOException {
		for (ParaShape ps : docInfo.getParaShapeList()) {
			ForParaShape.write(ps, sw);
		}
	}

	private void style() throws IOException {
		for (Style s : docInfo.getStyleList()) {
			ForStyle.write(s, sw);
		}
	}

	private void docData() throws IOException {
		if (docInfo.getDocData() != null) {
			ForUnknown.write(docInfo.getDocData(), HWPTag.DOC_DATA, 0, sw);
		}
	}

	private void forbiddenChar() throws IOException {
		if (docInfo.getForbiddenChar() != null) {
			ForUnknown.write(docInfo.getForbiddenChar(), HWPTag.FORBIDDEN_CHAR,
					1, sw);
		}
	}

	private void distributeDocData() throws IOException {
		if (docInfo.getDistributeDocData() != null) {
			ForUnknown.write(docInfo.getDistributeDocData(),
					HWPTag.DISTRIBUTE_DOC_DATA, 0, sw);
		}
	}

	private void compatibleDocument() throws IOException {
		if (docInfo.getCompatibleDocument() != null) {
			ForCompatibleDocument.write(docInfo.getCompatibleDocument(), sw);
		}
	}

	private void layoutCompatibility() throws IOException {
		if (docInfo.getLayoutCompatibility() != null) {
			ForLayoutCompatibility.write(docInfo.getLayoutCompatibility(), sw);
		}
	}

	private void trackChange() throws IOException {
		if (docInfo.getTrackChange() != null) {
			ForUnknown.write(docInfo.getTrackChange(), HWPTag.TRACKCHANGE, 1,
					sw);
		}
	}

	private void memoShape() throws IOException {
		for (UnknownRecord memoShape : docInfo.getMemoShapeList()) {
			ForUnknown.write(memoShape, HWPTag.MEMO_SHAPE, 1, sw);
		}
	}

	private void trackChange2() throws IOException {
		for (UnknownRecord trackChange2 : docInfo.getTrackChange2List()) {
			ForUnknown.write(trackChange2, HWPTag.TRACK_CHANGE, 1, sw);
		}
	}

	private void trackChangeAuthor() throws IOException {
		for (UnknownRecord trackChangeAuthor : docInfo.getTrackChangeAuthorList()) {
			ForUnknown.write(trackChangeAuthor, HWPTag.TRACK_CHANGE_AUTHOR, 1, sw);
		}
	}
}
