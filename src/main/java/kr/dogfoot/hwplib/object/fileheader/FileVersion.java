package kr.dogfoot.hwplib.object.fileheader;

/**
 * 파일 버전를 나타내는 객체
 *
 * @author neolord
 */
public class FileVersion {
    /**
     * 파일 버전 - MM
     */
    private short mm;
    /**
     * 파일 번전 - nn
     */
    private short nn;
    /**
     * 파일 버전 - PP
     */
    private short pp;
    /**
     * 파일 버전 - rr
     */
    private short rr;

    /**
     * 생성자
     */
    public FileVersion() {
    }

    /**
     * 버전을 설정한다.
     *
     * @param version 버전(unsigned 4 bytes)
     */
    public void setVersion(long version) {
        mm = (short) ((version & 0xff000000) >> 24);
        nn = (short) ((version & 0xff0000) >> 16);
        pp = (short) ((version & 0xff00) >> 8);
        rr = (short) (version & 0xff);
    }

    public void setVersion(short mm, short nn, short pp, short rr) {
        this.mm = mm;
        this.nn = nn;
        this.pp = pp;
        this.rr = rr;
    }

    public long getVersion() {
        long version = 0;
        version += (mm & 0xff) << 24;
        version += (nn & 0xff) << 16;
        version += (pp & 0xff) << 8;
        version += (rr & 0xff);
        return version;
    }

    /**
     * 파일 버전 - MM를 반환한다.
     *
     * @return 파일 버전 - MM(0~255)
     */
    public short getMM() {
        return mm;
    }

    /**
     * 파일 버전 - nn를 반환한다.
     *
     * @return 파일 버전 - nn(0~255)
     */
    public short getNN() {
        return nn;
    }

    /**
     * 파일 버전 - PP를 반환한다.
     *
     * @return 파일 버전 - PP(0~255)
     */
    public short getPP() {
        return pp;
    }

    /**
     * 파일 버전 - rr를 반환한다.
     *
     * @return 파일 버전 - rr(0~255)
     */
    public short getRR() {
        return rr;
    }

    /**
     * 현재 버전이 비교 버전(mm2,nn2,pp2,rr2)보다 상위 버전인지 여부를 반환한다.
     *
     * @param mm2 비교 버전 - MM
     * @param nn2 비교 버전 - nn
     * @param pp2 비교 버전 - PP
     * @param rr2 비교 버전 - rr
     * @return 현재 버전이 비교 버전(mm2,nn2,pp2,rr2)보다 상위 버전인지 여부
     */
    public boolean isOver(int mm2, int nn2, int pp2, int rr2) {
        return (mm > mm2) || (mm == mm2 && nn > nn2) || (mm == mm2 && nn == nn2 && pp > pp2)
                || (mm == mm2 && nn == nn2 && pp == pp2 && rr > rr2)
                || (mm == mm2 && nn == nn2 && pp == pp2 && rr == rr2);
    }

    /**
     * 버젼 문자열로 반환한다.
     *
     * @return 버젼 문자열
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(mm).append(".").append(nn).append(".").append(pp).append(".").append(rr).append(".");
        return sb.toString();
    }

    public void copy(FileVersion from) {
        mm = from.mm;
        nn = from.nn;
        pp = from.pp;
        rr = from.rr;
    }
}
