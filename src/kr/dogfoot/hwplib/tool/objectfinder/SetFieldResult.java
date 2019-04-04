package kr.dogfoot.hwplib.tool.objectfinder;

/**
 * SetField 처리 결과상태.
 */
public enum SetFieldResult {
    /**
     * 처리중
     */
    InProcess,
    /**
     * 파일 끝까지  찾지 못함.
     */
    NotFound,
    /**
     * Text가 남음
     */
    TextRemains,
    /**
     * 모든 text를 설정함
     */
    SetAllText,
    /**
     * text가 부족함
     */
    NotEnoughText,
    /**
     * 기타 에러
     */
    ETCError
}
