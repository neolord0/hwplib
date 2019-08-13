package kr.dogfoot.hwplib.tool.paragraphadder.docinfo;

import kr.dogfoot.hwplib.object.HWPFile;

/**
 * DocInfo를 복사하는 기능을 포함하는 클레스
 *
 * @author neolord
 */
public class DocInfoAdder {
    private HWPFile sourceHWPFile;
    private HWPFile targetHWPFile;

    private BinDataAdder binDataAdder;
    private BorderFillAdder borderFillAdder;
    private BulletAdder bulletAdder;
    private CharShapeAdder charShapeAdder;
    private FaceNameAdder faceNameAdder;
    private NumberingAdder numberingAdder;
    private ParaShapeAdder paraShapeAdder;
    private StyleAdder styleAdder;
    private TabDefAdder tabDefAdder;

    public DocInfoAdder(HWPFile sourceHWPFile, HWPFile targetHWPFile) {
        this.sourceHWPFile = sourceHWPFile;
        this.targetHWPFile = targetHWPFile;

        binDataAdder = new BinDataAdder(this);
        borderFillAdder = new BorderFillAdder(this);
        bulletAdder = new BulletAdder(this);
        charShapeAdder = new CharShapeAdder(this);
        faceNameAdder = new FaceNameAdder(this);
        numberingAdder = new NumberingAdder(this);
        paraShapeAdder = new ParaShapeAdder(this);
        styleAdder = new StyleAdder(this);
        tabDefAdder = new TabDefAdder(this);
    }

    public HWPFile getSourceHWPFile() {
        return sourceHWPFile;
    }

    public HWPFile getTargetHWPFile() {
        return targetHWPFile;
    }

    public BinDataAdder forBinData() {
        return binDataAdder;
    }

    public BorderFillAdder forBorderFill() {
        return borderFillAdder;
    }

    public BulletAdder forBullet() {
        return bulletAdder;
    }

    public CharShapeAdder forCharShape() {
        return charShapeAdder;
    }

    public FaceNameAdder forFaceName() {
        return faceNameAdder;
    }

    public NumberingAdder forNumbering() {
        return numberingAdder;
    }

    public ParaShapeAdder forParaShape() {
        return paraShapeAdder;
    }

    public StyleAdder forStyle() {
        return styleAdder;
    }

    public TabDefAdder forTabDef() {
        return tabDefAdder;
    }
}
