package kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso;

import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlPicture;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ShapeComponentPicture;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.picture.InnerMargin;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso.part.ForPictureEffect;
import kr.dogfoot.hwplib.writer.docinfo.borderfill.ForFillInfo;

import java.io.IOException;

/**
 * 그림 컨트롤의 나머지 부분을 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForControlPicture {
    /**
     * 그림 컨트롤의 나머지 부분을 쓴다.
     *
     * @param pic 그림 컨트롤
     * @param sw  스트림 라이터
     * @throws Exception
     */
    public static void writeRest(ControlPicture pic, StreamWriter sw)
            throws Exception {
        sw.upRecordLevel();

        shapeComponentPicture(pic.getShapeComponentPicture(), sw);

        sw.downRecordLevel();
    }

    /**
     * 그림 개체 속성 레코드를 쓴다.
     *
     * @param scp 그림 개체 속성 레코드
     * @param sw  스트림 라이터
     * @throws Exception
     */
    private static void shapeComponentPicture(ShapeComponentPicture scp,
                                              StreamWriter sw) throws Exception {
        recordHeader(scp, sw);

        sw.writeUInt4(scp.getBorderColor().getValue());
        sw.writeSInt4(scp.getBorderThickness());
        sw.writeUInt4(scp.getBorderProperty().getValue());
        sw.writeSInt4((int) scp.getLeftTop().getX());
        sw.writeSInt4((int) scp.getLeftTop().getY());
        sw.writeSInt4((int) scp.getRightTop().getX());
        sw.writeSInt4((int) scp.getRightTop().getY());
        sw.writeSInt4((int) scp.getRightBottom().getX());
        sw.writeSInt4((int) scp.getRightBottom().getY());
        sw.writeSInt4((int) scp.getLeftBottom().getX());
        sw.writeSInt4((int) scp.getLeftBottom().getY());
        sw.writeSInt4(scp.getLeftAfterCutting());
        sw.writeSInt4(scp.getTopAfterCutting());
        sw.writeSInt4(scp.getRightAfterCutting());
        sw.writeSInt4(scp.getBottomAfterCutting());
        innerMargin(scp.getInnerMargin(), sw);
        ForFillInfo.pictureInfo(scp.getPictureInfo(), sw);
        sw.writeUInt1(scp.getBorderTransparency());
        sw.writeUInt4(scp.getInstanceId());
        ForPictureEffect.write(scp.getPictureEffect(), sw);
        sw.writeUInt4(scp.getImageWidth());
        sw.writeUInt4(scp.getImageHeight());
    }

    /**
     * 그림 개체 속성 레코드의 레코드 헤더를 쓴다.
     *
     * @param scp 그림 개체 속성 레코드
     * @param sw  스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(ShapeComponentPicture scp, StreamWriter sw)
            throws IOException {
        sw.writeRecordHeader(HWPTag.SHAPE_COMPONENT_PICTURE, getSize(scp));
    }

    /**
     * 그림 개체 속성 레코드의 크기를 반환한다.
     *
     * @param scp 그림 개체 속성 레코드
     * @return 그림 개체 속성 레코드의 크기
     */
    private static int getSize(ShapeComponentPicture scp) {
        int size = 0;
        size += 60;
        size += 8; // inner margin;
        size += 5; // pictureInfo;
        size += 5;
        size += ForPictureEffect.getSize(scp.getPictureEffect());
        size += 8;
        return size;
    }

    /**
     * 내부 여백 부분을 쓴다.
     *
     * @param im 내부 여백을 나타내는 객체
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void innerMargin(InnerMargin im, StreamWriter sw)
            throws IOException {
        sw.writeUInt2(im.getLeft());
        sw.writeUInt2(im.getRight());
        sw.writeUInt2(im.getTop());
        sw.writeUInt2(im.getBottom());
    }
}
