package kr.dogfoot.hwplib.reader;

import kr.dogfoot.hwplib.object.fileheader.FileHeader;
import kr.dogfoot.hwplib.object.fileheader.FileVersion;
import kr.dogfoot.hwplib.util.binary.BitFlag;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;
import java.util.Arrays;

/**
 * 파일 헤더를 읽기 위한 객체
 *
 * @author neolord
 */
public class ForFileHeader {
    /**
     * File Header 스트림을 읽는다.
     *
     * @param fh 파일 헤더 객체
     * @param sr 스트림 리더
     * @throws Exception
     */
    public static void read(FileHeader fh, StreamReader sr)
            throws Exception {
        signature(sr);
        fileVersion(fh.getVersion(), sr);
        properties(fh, sr);
    }

    /**
     * 한글 파일 시그니처(이 파일이 한글 파일인지 확인하는 부분)을 읽는다.
     *
     * @param sr 스트림 리더
     * @throws Exception
     */
    private static void signature(StreamReader sr) throws Exception {
        byte[] sign = new byte[32];
        sr.readBytes(sign);

        if (Arrays.equals(FileHeader.getFileSignature(), sign) == false) {
            throw new Exception("this is not hwp file.");
        }
    }

    /**
     * 파일 버전 부분을 읽는다.
     *
     * @param fv 읽은 내을을 저장할 객체
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void fileVersion(FileVersion fv, StreamReader sr)
            throws IOException {
        fv.setVersion(sr.readUInt4());
    }

    /**
     * 속성 부분을 읽는다.
     *
     * @param fh 읽은 내을을 저장할 객체
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void properties(FileHeader fh, StreamReader sr)
            throws IOException {
        long flag = sr.readUInt4();
        fh.setCompressed(BitFlag.get(flag, 0));
        fh.setHasPassword(BitFlag.get(flag, 1));
        fh.setDeploymentDocument(BitFlag.get(flag, 2));
        fh.setSaveScript(BitFlag.get(flag, 3));
        fh.setDRMDocument(BitFlag.get(flag, 4));
        fh.setHasXMLTemplate(BitFlag.get(flag, 5));
        fh.setHasDocumentHistory(BitFlag.get(flag, 6));
        fh.setHasSignature(BitFlag.get(flag, 7));
        fh.setEncryptPublicCertification(BitFlag.get(flag, 8));
        fh.setSavePrepareSignature(BitFlag.get(flag, 9));
        fh.setPublicCertificationDRMDocument(BitFlag.get(flag, 10));
        fh.setCCLDocument(BitFlag.get(flag, 11));
    }
}
