package kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso.part;

import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderGso;
import kr.dogfoot.hwplib.util.binary.BitFlag;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 그리기 개체의 컨트롤 헤더 레코드를 읽는다.
 *
 * @author neolord
 */
public class ForCtrlHeaderGso {
    /**
     * 그리기 개체의 컨트롤 헤더 레코드를 읽는다.
     *
     * @param header 그리기 개체의 컨트롤 헤더 레코드
     * @param sr     스트림 리더
     * @throws IOException
     */
    public static void read(CtrlHeaderGso header, StreamReader sr)
            throws IOException {
        header.getProperty().setValue(sr.readUInt4());
        header.setyOffset(sr.readUInt4());
        header.setxOffset(sr.readUInt4());
        header.setWidth(sr.readUInt4());
        header.setHeight(sr.readUInt4());
        header.setzOrder(sr.readSInt4());
        header.setOutterMarginLeft(sr.readUInt2());
        header.setOutterMarginRight(sr.readUInt2());
        header.setOutterMarginTop(sr.readUInt2());
        header.setOutterMarginBottom(sr.readUInt2());
        header.setInstanceId(sr.readUInt4());

        // **남은 양을 보고 읽는다.** isEndOfRecord() 는 "끝에 닿았는가" 만 본다 —
        // 2 바이트가 남은 레코드에서도 거짓이라, 아래 4 바이트 읽기를 막지 못했다.
        // 실제로 그런 파일이 있다: 개체 공통 속성이 instanceId 까지 40 바이트로 끝나고
        // 2 바이트만 남은 42 바이트 CTRL_HEADER. 거기서 4 바이트를 읽으면 경계를 2
        // 바이트 넘고, 그 뒤 모든 레코드 위치가 어긋난다. 어긋난 자리가 size=0 인
        // 헤더로 읽히면 ForParagraph 의 읽기 루프가 진행 없이 영원히 돈다.
        if (sr.remainingInRecord() >= 4) {
            int temp = sr.readSInt4();
            header.setPreventPageDivide(BitFlag.get(temp, 0));

            // 한글 문자열은 길이(2 바이트)부터 읽는다 — 그만큼도 없으면 읽지 않는다.
            if (sr.remainingInRecord() >= 2) {
                header.getExplanation().setBytes(sr.readHWPString());
            }
        }

        // **남은 바이트는 무엇이든 여기서 소비한다.** 위에서 그냥 return 하면 레코드가
        // 덜 읽힌 채로 끝나고, 호출부(ForControlTable.ctrlData)가 곧바로 다음 헤더를
        // 읽어 같은 어긋남이 난다 — 읽기를 멈추는 것만으로는 부족하고, 레코드를 끝까지
        // 소비해야 다음 레코드가 제 경계에서 시작한다.
        if (sr.isEndOfRecord()) return;

        int length = (int) sr.remainingInRecord();
        byte[] unknown = new byte[length];
        sr.readBytes(unknown);
        header.setUnknown(unknown);
    }
}
