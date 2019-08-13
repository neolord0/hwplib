package kr.dogfoot.hwplib.util.binary;

/**
 * 이진 연산을 하는 객체
 *
 * @author neolord
 */
public class BitFlag {
    /**
     * mask에서 position번째 비트가 1인지 여부를 반환한다.
     *
     * @param mask     long 값
     * @param position 비트 위치
     * @return mask값에서 position번째 비트가 1인지 여부
     */
    public static boolean get(long mask, int position) {
        long mask2 = 1 << position;
        return (mask & mask2) == mask2;
    }

    /**
     * mask에서 position번째 비트가 1인지 여부를 반환한다.
     *
     * @param mask     int 값
     * @param position 비트 위치
     * @return mask값에서 position번째 비트가 1인지 여부
     */
    public static boolean get(int mask, int position) {
        int mask2 = 1 << position;
        return (mask & mask2) == mask2;
    }

    /**
     * mask에서 position번째 비트가 1인지 여부를 반환한다.
     *
     * @param mask     short 값
     * @param position 비트 위치
     * @return mask값에서 position번째 비트가 1인지 여부
     */
    public static boolean get(short mask, int position) {
        short mask2 = (short) (1 << position);
        return (mask & mask2) == mask2;
    }

    /**
     * mask의 position번째 비트을 flag값이 true일때 1, false일때 0으로 설정한다..
     *
     * @param mask     이전 long 값
     * @param position 비트 위치
     * @param flag     bool 값
     * @return mask의 position번째 비트을 flag값이 true일때 1, false일때 0으로 설정한 결과값
     */
    public static long set(long mask, int position, boolean flag) {
        if (flag) {
            mask = mask | (0x1 << position);
        } else {
            if ((mask & (0x1 << position)) != 0) {
                mask = mask ^ (0x1 << position);
            }
        }
        return mask;
    }

    /**
     * mask의 position번째 비트을 flag값이 true일때 1, false일때 0으로 설정한다..
     *
     * @param mask     이전 int 값
     * @param position 비트 위치
     * @param flag     bool 값
     * @return mask의 position번째 비트을 flag값이 true일때 1, false일때 0으로 설정한 결과값
     */
    public static int set(int mask, int position, boolean flag) {
        if (flag) {
            mask = mask | (0x1 << position);
        } else {
            if ((mask & (0x1 << position)) != 0) {
                mask = mask ^ (0x1 << position);
            }
        }
        return mask;
    }

    /**
     * mask의 position번째 비트을 flag값이 true일때 1, false일때 0으로 설정한다..
     *
     * @param mask     이전 short 값
     * @param position 비트 위치
     * @param flag     bool 값
     * @return mask의 position번째 비트을 flag값이 true일때 1, false일때 0으로 설정한 결과값
     */
    public static short set(short mask, int position, boolean flag) {
        if (flag) {
            mask = (short) (mask | (0x1 << position));
        } else {
            if ((mask & (0x1 << position)) != 0) {
                mask = (short) (mask ^ (0x1 << position));
            }
        }
        return mask;
    }

    /**
     * mask 값에서 start부터 end까지의 비트의 값을 반환한다.
     *
     * @param mask  long 값
     * @param start 비트 시작 위치
     * @param end   비트 끝 위치
     * @return mask 값에서 start부터 end까지 비트의 정수값
     */
    public static long get(long mask, int start, int end) {
        long ret = 0;
        ret = mask >> start;

        long temp = 0;
        for (int nIndex = 0; nIndex < end - start + 1; nIndex++) {
            temp = temp << 1;
            temp += 1;
        }

        ret = ret & temp;

        return ret;
    }

    /**
     * mask 값에서 start부터 end까지의 비트의 값을 반환한다.
     *
     * @param mask  int 값
     * @param start 비트 시작 위치
     * @param end   비트 끝 위치
     * @return mask 값에서 start부터 end까지 비트의 정수값
     */
    public static int get(int mask, int start, int end) {
        int ret = 0;
        ret = mask >> start;

        int temp = 0;
        for (int nIndex = 0; nIndex < end - start + 1; nIndex++) {
            temp = temp << 1;
            temp += 1;
        }

        ret = ret & temp;

        return ret;
    }

    /**
     * mask 값에서 start부터 end까지의 비트의 값을 반환한다.
     *
     * @param mask  short 값
     * @param start 비트 시작 위치
     * @param end   비트 끝 위치
     * @return mask 값에서 start부터 end까지 비트의 정수값
     */
    public static short get(short mask, int start, int end) {
        short ret = 0;
        ret = (short) (mask >> start);

        int temp = 0;
        for (int nIndex = 0; nIndex < end - start + 1; nIndex++) {
            temp = temp << 1;
            temp += 1;
        }

        ret = (short) (ret & temp);

        return ret;
    }

    /**
     * mask값에서 start부터 end까지의 비트를 value값으로 설정한다.
     *
     * @param mask  이전 long 값
     * @param start 비트 시작 위치
     * @param end   비트 끝 위치
     * @param value 설정값
     * @return mask값에서 start부터 end까지의 비트를 value값으로 설정한 결과값
     */
    public static long set(long mask, int start, int end, int value) {
        for (int position = start; position <= end; position++) {
            boolean flag = BitFlag.get(value, position - start);
            mask = BitFlag.set(mask, position, flag);
        }
        return mask;
    }

    /**
     * mask값에서 start부터 end까지의 비트를 value값으로 설정한다.
     *
     * @param mask  이전 int 값
     * @param start 비트 시작 위치
     * @param end   비트 끝 위치
     * @param value 설정값
     * @return mask값에서 start부터 end까지의 비트를 value값으로 설정한 결과값
     */
    public static int set(int mask, int start, int end, int value) {
        for (int position = start; position <= end; position++) {
            boolean flag = BitFlag.get(value, position - start);
            mask = BitFlag.set(mask, position, flag);
        }
        return mask;
    }

    /**
     * mask값에서 start부터 end까지의 비트를 value값으로 설정한다.
     *
     * @param mask  이전 short 값
     * @param start 비트 시작 위치
     * @param end   비트 끝 위치
     * @param value 설정값
     * @return mask값에서 start부터 end까지의 비트를 value값으로 설정한 결과값
     */
    public static short set(short mask, int start, int end, int value) {
        for (int position = start; position <= end; position++) {
            boolean flag = BitFlag.get(value, position - start);
            mask = BitFlag.set(mask, position, flag);
        }
        return mask;
    }

}
