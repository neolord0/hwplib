package kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo;

/**
 * 이미지 채우기 객체
 *
 * @author neolord
 */
public class ImageFill {
    /**
     * 이미지 채우기 유형
     */
    private ImageFillType imageFillType;
    /**
     * 그림 정보
     */
    private PictureInfo pictureInfo;

    /**
     * 생성자
     */
    public ImageFill() {
        pictureInfo = new PictureInfo();
    }

    /**
     * 이미지 채우기 유형을 반환한다.
     *
     * @return 이미지 채우기 유형
     */
    public ImageFillType getImageFillType() {
        return imageFillType;
    }

    /**
     * 이미지 채우기 유형을 설정한다.
     *
     * @param imageFillType 이미지 채우기 유형
     */
    public void setImageFillType(ImageFillType imageFillType) {
        this.imageFillType = imageFillType;
    }

    /**
     * 그림 정보 객체를 반환한다.
     *
     * @return 그림 정보 객체
     */
    public PictureInfo getPictureInfo() {
        return pictureInfo;
    }
}
