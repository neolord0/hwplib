package kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso;

import kr.dogfoot.hwplib.object.RecordHeader;
import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlPicture;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ShapeComponentPicture;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.picture.InnerMargin;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso.part.ForPictureEffect;
import kr.dogfoot.hwplib.reader.docinfo.borderfill.ForFillInfo;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 그림 컨트롤의 나머지 부분을 읽기 위한 객체
 *
 * @author neolord
 */
public class ForControlPicture {
    /**
     * 그림 컨트롤의 나머지 부분을 읽는다.
     *
     * @param picture 그림 컨트롤
     * @param sr      스트림 리더
     * @throws Exception
     */
    public static void readRest(ControlPicture picture, StreamReader sr)
            throws Exception {
        RecordHeader rh = sr.readRecordHeder();
        if (rh.getTagID() == HWPTag.SHAPE_COMPONENT_PICTURE) {
            shapeComponentPicture(picture.getShapeComponentPicture(), sr);
        }
    }

    /**
     * 그림 개체 속성 레코드를 읽는다.
     *
     * @param scp 그림 개체 속성 레코드
     * @param sr  스트림 리더
     * @throws Exception
     */
    private static void shapeComponentPicture(ShapeComponentPicture scp,
                                              StreamReader sr) throws Exception {
        scp.getBorderColor().setValue(sr.readUInt4());
        scp.setBorderThickness(sr.readSInt4());
        scp.getBorderProperty().setValue(sr.readUInt4());
        scp.getLeftTop().setX(sr.readSInt4());
        scp.getLeftTop().setY(sr.readSInt4());
        scp.getRightTop().setX(sr.readSInt4());
        scp.getRightTop().setY(sr.readSInt4());
        scp.getRightBottom().setX(sr.readSInt4());
        scp.getRightBottom().setY(sr.readSInt4());
        scp.getLeftBottom().setX(sr.readSInt4());
        scp.getLeftBottom().setY(sr.readSInt4());
        scp.setLeftAfterCutting(sr.readSInt4());
        scp.setTopAfterCutting(sr.readSInt4());
        scp.setRightAfterCutting(sr.readSInt4());
        scp.setBottomAfterCutting(sr.readSInt4());
        innerMargin(scp.getInnerMargin(), sr);
        ForFillInfo.pictureInfo(scp.getPictureInfo(), sr);

        if (sr.isEndOfRecord() == false) {
            scp.setBorderTransparency(sr.readUInt1());
        }

        if (sr.isEndOfRecord() == false) {
            scp.setInstanceId(sr.readUInt4());
        }

        if (sr.isEndOfRecord() == false) {
            ForPictureEffect.read(scp.getPictureEffect(), sr);
        }

        if (sr.isEndOfRecord() == false) {
            scp.setImageWidth(sr.readUInt4());
            scp.setImageHeight(sr.readUInt4());
        }

        if (sr.isEndOfRecord() == false) {
            unknownBytes(sr);
        }
    }

    private static void unknownBytes(StreamReader sr) throws IOException {
        sr.skipToEndRecord();
    }

    /**
     * 그림 개체 속성 레코드의 내부 여백 부분을 읽는다.
     *
     * @param im 내부 여백을 나타내는 객체
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void innerMargin(InnerMargin im, StreamReader sr)
            throws IOException {
        im.setLeft(sr.readUInt2());
        im.setRight(sr.readUInt2());
        im.setTop(sr.readUInt2());
        im.setBottom(sr.readUInt2());
    }
}
