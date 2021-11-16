package kr.dogfoot.hwplib.tool.textextractor;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.tool.textextractor.paraHead.ParaHeadMaker;

import java.io.UnsupportedEncodingException;

/**
 * 한글 파일에서 텍스트를 추출하는 객체
 *
 * @author neolord
 */
public class TextExtractor {
    /**
     * 텍스트틀 추출한다.
     *
     * @param hwpFile 한글 파일 객체
     * @param tem     추출 방법
     * @return 추출된 문자열
     * @throws UnsupportedEncodingException
     */
    public static String extract(HWPFile hwpFile, TextExtractMethod tem) throws UnsupportedEncodingException {
        return extract(hwpFile, new TextExtractOption(tem));
    }

    /**
     * 텍스트틀 추출한다.
     *
     * @param hwpFile 한글 파일 객체
     * @param option  추출 옵션
     * @return 추출된 문자열
     * @throws UnsupportedEncodingException
     */
    public static String extract(HWPFile hwpFile, TextExtractOption option) throws UnsupportedEncodingException {
        StringBuffer sb = new StringBuffer();
        ParaHeadMaker paraHeadMaker = new ParaHeadMaker(hwpFile);
        for (Section s : hwpFile.getBodyText().getSectionList()) {
            paraHeadMaker.startSection(s);
            ForParagraphList.extract(s, option, paraHeadMaker, sb);
            paraHeadMaker.endSection();
        }
        return sb.toString();
    }
}
