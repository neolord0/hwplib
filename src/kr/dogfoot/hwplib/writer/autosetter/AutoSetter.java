package kr.dogfoot.hwplib.writer.autosetter;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.BodyText;
import kr.dogfoot.hwplib.object.bodytext.Section;

/**
 * 한글 파일을 쓰기 전에 자동 설정하기 위한 객체
 *
 * @author neolord
 */
public class AutoSetter {
    /**
     * 한글 파일을 자동 설정한다.
     *
     * @param hwpFile 한글 파일 객체
     * @param iid     인스턴스 id
     */
    public static void autoSet(HWPFile hwpFile, InstanceID iid) {
        docInfo(hwpFile);
        bodyText(hwpFile.getBodyText(), iid);
    }

    /**
     * DocInfo 스트림을 자동설정한다.
     *
     * @param hwpFile 한글 파일 객체
     */
    private static void docInfo(HWPFile hwpFile) {
        ForDocInfo.autoset(hwpFile.getDocInfo(), hwpFile.getBodyText());
    }

    /**
     * BodyText 스토리지를 자동 설정한다.
     *
     * @param bodyText BodyText 스토리지 객체
     * @param iid      인스턴스 id
     */
    private static void bodyText(BodyText bodyText, InstanceID iid) {
        for (Section s : bodyText.getSectionList()) {
            ForParagraphList.autoSet(s, iid);
        }
    }
}
