package kr.dogfoot.hwplib.writer.bodytext.paragraph.memo;

import kr.dogfoot.hwplib.object.bodytext.paragraph.memo.MemoList;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 메모 리스트 레코드를 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForMemoList {
    /**
     * 메모 리스트 레코드를 쓴다.
     *
     * @param ml 메모 리스트 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    public static void write(MemoList ml, StreamWriter sw) throws IOException {
        if (ml == null) {
            return;
        }

        recordHeader(ml, sw);
        sw.writeUInt4(ml.getMemoIndex());
    }

    /**
     * 메모 리스트 레코드의 레코드 헤더를 쓴다.
     *
     * @param ml 메모 리스트 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(MemoList ml, StreamWriter sw)
            throws IOException {
        sw.writeRecordHeader(HWPTag.MEMO_LIST, 4);
    }
}
