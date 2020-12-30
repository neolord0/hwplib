package kr.dogfoot.hwplib.object.etc;

import kr.dogfoot.hwplib.object.RecordHeader;

/**
 * 알려지지 않은 레코드
 *
 * @author neolord
 */
public class UnknownRecord {
    /**
     * 레코드 헤더
     */
    private RecordHeader header;
    /**
     * 레코드 데이터
     */
    private byte[] body;

    /**
     * 생성자
     */
    public UnknownRecord() {
    }

    /**
     * 생성자
     *
     * @param header 레코드 헤더
     */
    public UnknownRecord(RecordHeader header) {
        this.header = header.clone();
    }

    /**
     * 레코드 헤더를 반환한다.
     *
     * @return 레코드 헤더
     */
    public RecordHeader getHeader() {
        return header;
    }

    /**
     * 레코드 헤더를 설정한다.
     *
     * @param header 레코드 헤더
     */
    public void setHeader(RecordHeader header) {
        this.header = header.clone();
    }

    /**
     * 레코드 데이터를 반환한다.
     *
     * @return 레코드 데이터
     */
    public byte[] getBody() {
        return body;
    }

    /**
     * 레코드 데이터를 설정한다.
     *
     * @param body 레코드 데이터
     */
    public void setBody(byte[] body) {
        this.body = body;
    }

    public UnknownRecord clone() {
        UnknownRecord cloned = new UnknownRecord();
        if (header != null) {
            cloned.header = this.header.clone();
        }
        if (body != null) {
            cloned.body = this.body.clone();
        }
        return cloned;
    }

}
