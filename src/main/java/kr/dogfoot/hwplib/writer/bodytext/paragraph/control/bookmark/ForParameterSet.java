package kr.dogfoot.hwplib.writer.bodytext.paragraph.control.bookmark;

import kr.dogfoot.hwplib.object.bodytext.control.bookmark.ParameterItem;
import kr.dogfoot.hwplib.object.bodytext.control.bookmark.ParameterSet;
import kr.dogfoot.hwplib.util.StringUtil;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 파라미터 셋을 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForParameterSet {
    /**
     * 파라미터 셋의 크기를 반환한다.
     *
     * @param ps 파라미터 셋
     * @return 파라미터 셋의 크기
     */
    public static int getSize(ParameterSet ps) {
        int size = 0;
        if (ps != null) {
            size += 6;
            for (ParameterItem pi : ps.getParameterItemList()) {
                size += getSizeForParameterItem(pi);
            }
        } else {
            size = 0;
        }
        return size;
    }

    /**
     * 파라미터 아이탬의 크기를 반환한다.
     *
     * @param pi 파라미터 아이탬
     * @return 파라미터 아이탬의 크기
     */
    private static int getSizeForParameterItem(ParameterItem pi) {
        int size = 0;
        size += 4;
        switch (pi.getType()) {
            case NULL:
                break;
            case String:
                size += StringUtil.getUTF16LEStringSize(pi.getValue_BSTR());
                break;
            case Integer1:
                size += 4;
                break;
            case Integer2:
                size += 4;
                break;
            case Integer4:
                size += 4;
                break;
            case Integer:
                size += 4;
                break;
            case UnsignedInteger1:
                size += 4;
                break;
            case UnsignedInteger2:
                size += 4;
                break;
            case UnsignedInteger4:
                size += 4;
                break;
            case UnsignedInteger:
                size += 4;
                break;
            case ParameterSet:
                size += getSize(pi.getValue_ParameterSet());
                break;
            case Array:
                size += getSizeForParameterArray(pi);
                break;
            case BINDataID:
                size += 2;
                break;
        }

        return size;
    }

    /**
     * 배열 파라미터 아이탬의 크기를 반환한다.
     *
     * @param pi 배열 파라미터 아이탬
     * @return 배열 파라미터 아이탬의 크기
     */
    private static int getSizeForParameterArray(ParameterItem pi) {
        int size = 0;
        size += 4;
        short count = (short) pi.getValue_ParameterArrayCount();
        for (int index = 0; index < count; index++) {
            size += getSizeForParameterItem(pi.getValue_ParameterArray(index)) - 2;
        }
        return size;
    }

    /**
     * 파라미터 셋를 쓴다.
     *
     * @param ps 파라미터 셋
     * @param sw 스트림 라이터
     * @throws IOException
     */
    public static void write(ParameterSet ps, StreamWriter sw)
            throws IOException {
        sw.writeUInt2(ps.getId());
        short parameterCount = (short) ps.getParameterItemList().size();
        sw.writeSInt2(parameterCount);
        sw.writeZero(2);
        for (ParameterItem pi : ps.getParameterItemList()) {
            parameterItem(pi, sw);
        }
    }

    /**
     * 파라미터 아이탬을 쓴다.
     *
     * @param pi 파라미터 아이탬
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void parameterItem(ParameterItem pi, StreamWriter sw)
            throws IOException {
        sw.writeUInt2((int) pi.getId());
        sw.writeUInt2(pi.getType().getValue());
        paramterValue(pi, sw);
    }

    /**
     * 파라미터 아이탬의 값을 쓴다.
     *
     * @param pi 파라미터 아이탬
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void paramterValue(ParameterItem pi, StreamWriter sw)
            throws IOException {
        switch (pi.getType()) {
            case NULL:
                break;
            case String:
                sw.writeUTF16LEString(pi.getValue_BSTR());
                break;
            case Integer1:
                sw.writeSInt4(pi.getValue_I1());
                break;
            case Integer2:
                sw.writeSInt4(pi.getValue_I2());
                break;
            case Integer4:
                sw.writeSInt4(pi.getValue_I4());
                break;
            case Integer:
                sw.writeSInt4(pi.getValue_I());
                break;
            case UnsignedInteger1:
                sw.writeUInt4(pi.getValue_UI1());
                break;
            case UnsignedInteger2:
                sw.writeUInt4(pi.getValue_UI2());
                break;
            case UnsignedInteger4:
                sw.writeUInt4(pi.getValue_UI4());
                break;
            case UnsignedInteger:
                sw.writeUInt4(pi.getValue_UI());
                break;
            case ParameterSet:
                write(pi.getValue_ParameterSet(), sw);
                break;
            case Array:
                parameterArray(pi, sw);
                break;
            case BINDataID:
                sw.writeUInt2(pi.getValue_binData());
                break;
        }
    }

    /**
     * 배열 파라미터 아이탬의 값을 쓴다.
     *
     * @param pi 배열 파라미터 아이탬
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void parameterArray(ParameterItem pi, StreamWriter sw)
            throws IOException {
        short count = (short) pi.getValue_ParameterArrayCount();
        sw.writeSInt2(count);
        if (count > 0) {
            sw.writeUInt2((int) pi.getValue_ParameterArray(0).getId());

            for (int index = 0; index < count; index++) {
                ParameterItem elementPi = pi.getValue_ParameterArray(index);
                sw.writeUInt2(elementPi.getType().getValue());
                paramterValue(elementPi, sw);
            }
        }
    }
}
