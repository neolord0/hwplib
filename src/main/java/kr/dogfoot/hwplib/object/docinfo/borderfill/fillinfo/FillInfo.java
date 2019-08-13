package kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo;

/**
 * 채우기 정보를 나태내는 객체
 *
 * @author neolord
 */
public class FillInfo {
    /**
     * 채우기 종류
     */
    private FillType type;
    /**
     * 단색 채우기
     */
    private PatternFill patternFill;
    /**
     * 그러데이션 채우기
     */
    private GradientFill gradientFill;
    /**
     * 이미지 채우기
     */
    private ImageFill imageFill;

    /**
     * 생성자
     */
    public FillInfo() {
        type = new FillType();
    }

    /**
     * 채우기 종류 객체를 반환한다.
     *
     * @return 채우기 종류 객체
     */
    public FillType getType() {
        return type;
    }

    /**
     * 단색 채우기 객체를 생성한다.
     */
    public void createPatternFill() {
        patternFill = new PatternFill();
    }

    /**
     * 단색 채우기 객체를 삭제한다.
     */
    public void deletePatternFill() {
        patternFill = null;
    }

    /**
     * 단색 채우기 객체를 반환한다.
     *
     * @return 단색 채우기 객체
     */
    public PatternFill getPatternFill() {
        return patternFill;
    }

    /**
     * 그러데이션 채우기 객체를 생성한다.
     */
    public void createGradientFill() {
        gradientFill = new GradientFill();
    }

    /**
     * 그러데이션 채우기 객체를 삭제한다.
     */
    public void deleteGradientFill() {
        gradientFill = null;
    }

    /**
     * 그러데이션 채우기 객체를 반환한다.
     *
     * @return 그러데이션 채우기 객체
     */
    public GradientFill getGradientFill() {
        return gradientFill;
    }

    /**
     * 이미지 채우기 객체를 생성한다.
     */
    public void createImageFill() {
        imageFill = new ImageFill();
    }

    /**
     * 이미지 채우기 객체를 삭제한다.
     */
    public void deleteImageFill() {
        imageFill = null;
    }

    /**
     * 이미지 채우기 객체를 반환한다.
     *
     * @return 이미지 채우기 객체
     */
    public ImageFill getImageFill() {
        return imageFill;
    }
}
