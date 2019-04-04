package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader;

/**
 * 컨트롤 id을 생성하기 위한 객체
 *
 * @author neolord
 */
public class CtrlID {
    /**
     * 컨트롤 아이디를 생성한다.
     *
     * @param a 24~31 bit값
     * @param b 16~23 bit값
     * @param c 8~15 bit값
     * @param d 0~7 bit값
     * @return 컨트롤 아이디
     */
    public static long make(char a, char b, char c, char d) {
        return ((byte) a << 24) | ((byte) b << 16) | ((byte) c << 8) | (byte) d;
    }
}
