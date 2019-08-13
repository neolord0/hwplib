package kr.dogfoot.hwplib.tool.textextractor;

/**
 * 텍스트 추출 방법
 *
 * @author neolord
 */
public enum TextExtractMethod {
    /**
     * 메인 문단에 포함된 텍스트만 추출함
     */
    OnlyMainParagraph,
    /**
     * 컨트롤의 텍스트를 문단 텍스트 사이에 삽입하여 추출함
     */
    InsertControlTextBetweenParagraphText,
    /**
     * 컨트롤의 텍스트를 문단 텍스트 뒤에 추가하여 추출함
     */
    AppendControlTextAfterParagraphText
}
