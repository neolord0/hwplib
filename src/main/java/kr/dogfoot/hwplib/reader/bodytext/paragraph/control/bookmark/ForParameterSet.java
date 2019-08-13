package kr.dogfoot.hwplib.reader.bodytext.paragraph.control.bookmark;

import kr.dogfoot.hwplib.object.bodytext.control.bookmark.ParameterItem;
import kr.dogfoot.hwplib.object.bodytext.control.bookmark.ParameterSet;
import kr.dogfoot.hwplib.object.bodytext.control.bookmark.ParameterType;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 파라메터 셋을 읽기 위한 객체
 *
 * @author neolord
 */
public class ForParameterSet {
    /**
     * 파라메터 셋을 읽는다.
     *
     * @param ps 파라메터 셋
     * @param sr 스트림 리더
     * @throws IOException
     */
    public static void read(ParameterSet ps, StreamReader sr)
            throws IOException {
        ps.setId(sr.readUInt2());
        short parameterCount = sr.readSInt2();
        sr.skip(2);
        for (int parameterIndex = 0; parameterIndex < parameterCount; parameterIndex++) {
            ParameterItem pi = ps.addNewParameterItem();
            parameterItem(pi, sr);
        }
    }

    /**
     * 파라메터 아이템을 읽는다.
     *
     * @param pi 파라메터 아이템
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void parameterItem(ParameterItem pi, StreamReader sr)
            throws IOException {
        pi.setId(sr.readUInt2());
        pi.setType(ParameterType.valueOf(sr.readUInt2()));
        paramterValue(pi, sr);
    }

    /**
     * 파라메터 아이템의 값을 읽는다.
     *
     * @param pi 파라메터 아이템
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void paramterValue(ParameterItem pi, StreamReader sr)
            throws IOException {
        switch (pi.getType()) {
            case NULL:
                break;
            case String:
                pi.setValue_BSTR(sr.readUTF16LEString());
                break;
            case Integer1:
                pi.setValue_I1((byte) sr.readSInt4());
                break;
            case Integer2:
                pi.setValue_I2((short) sr.readSInt4());
                break;
            case Integer4:
                pi.setValue_I4(sr.readSInt4());
                break;
            case Integer:
                pi.setValue_I(sr.readSInt4());
                break;
            case UnsignedInteger1:
                pi.setValue_UI1((short) sr.readUInt4());
                break;
            case UnsignedInteger2:
                pi.setValue_UI2((int) sr.readUInt4());
                break;
            case UnsignedInteger4:
                pi.setValue_UI4(sr.readUInt4());
                break;
            case UnsignedInteger:
                pi.setValue_UI(sr.readUInt4());
                break;
            case ParameterSet:
                parameterSet(pi, sr);
                break;
            case Array:
                parameterArray(pi, sr);
                break;
            case BINDataID:
                pi.setValue_binData(sr.readUInt2());
                break;

        }
    }

    /**
     * 파라미터셋 타입의 파라메터 아이템값을 읽는다.
     *
     * @param pi 파라메터 아이템
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void parameterSet(ParameterItem pi, StreamReader sr)
            throws IOException {
        pi.createValue_ParameterSet();
        read(pi.getValue_ParameterSet(), sr);
    }

    /**
     * 배열 타입의 파라메터 아이템값을 읽는다.
     *
     * @param pi 파라메터 아이템
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void parameterArray(ParameterItem pi, StreamReader sr)
            throws IOException {
        short count = sr.readSInt2();
        if (count > 0) {
            pi.createValue_ParameterArray(count);
            int id = sr.readUInt2();
            for (int index = 0; index < count; index++) {
                parameterItemForArray(pi.getValue_ParameterArray(index), sr, id);
            }
        }
    }

    /**
     * 배열안에 파라메터 아이템을 읽는다.
     *
     * @param pi 파라메터 아이템
     * @param sr 스트림 리더
     * @param id 파라메터 아이템의 아이디
     * @throws IOException
     */
    private static void parameterItemForArray(ParameterItem pi,
                                              StreamReader sr, int id) throws IOException {
        pi.setId(id);
        pi.setType(ParameterType.valueOf(sr.readUInt2()));
        paramterValue(pi, sr);
    }
}
