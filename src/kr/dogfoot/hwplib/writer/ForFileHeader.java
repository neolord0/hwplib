package kr.dogfoot.hwplib.writer;

import kr.dogfoot.hwplib.object.fileheader.FileHeader;
import kr.dogfoot.hwplib.object.fileheader.FileVersion;
import kr.dogfoot.hwplib.util.binary.BitFlag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 파일 헤더를 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForFileHeader {
    /**
     * 파일 헤더를 쓴다.
     *
     * @param fh 파일 헤더
     * @param sw 스트림 라이터
     * @throws IOException
     */
    public static void write(FileHeader fh, StreamWriter sw) throws IOException {
        signature(sw);
        fileVersion(fh.getVersion(), sw);
        properties(fh, sw);
        zero216(sw);
    }

    /**
     * 파일 시그널을 쓴다.
     *
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void signature(StreamWriter sw) throws IOException {
        byte[] signature = {0x48, 0x57, 0x50, 0x20, 0x44, 0x6F, 0x63, 0x75,
                0x6D, 0x65, 0x6E, 0x74, 0x20, 0x46, 0x69, 0x6C, 0x65, 0x00,
                0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00};
        sw.writeBytes(signature);
    }

    /**
     * 파일 버전을 쓴다.
     *
     * @param version 파일 버전
     * @param sw      스트림 라이터
     * @throws IOException
     */
    private static void fileVersion(FileVersion version, StreamWriter sw)
            throws IOException {
        sw.writeUInt4(version.getVersion());
    }

    /**
     * 파일 속성을 쓴다.
     *
     * @param fh 파일 헤더
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void properties(FileHeader fh, StreamWriter sw)
            throws IOException {
        long properties = 0;
        properties = BitFlag.set(properties, 0, fh.isCompressed());
        properties = BitFlag.set(properties, 1, fh.hasPassword());
        properties = BitFlag.set(properties, 2, fh.isDeploymentDocument());
        properties = BitFlag.set(properties, 3, fh.isSaveScript());
        properties = BitFlag.set(properties, 4, fh.isDRMDocument());
        properties = BitFlag.set(properties, 5, fh.hasXMLTemplate());
        properties = BitFlag.set(properties, 6, fh.hasDocumentHistory());
        properties = BitFlag.set(properties, 7, fh.hasSignature());
        properties = BitFlag.set(properties, 8,
                fh.isEncryptPublicCertification());
        properties = BitFlag.set(properties, 9, fh.isSavePrepareSignature());
        properties = BitFlag.set(properties, 10,
                fh.isPublicCertificationDRMDocument());
        properties = BitFlag.set(properties, 11, fh.isCCLDocument());
        sw.writeUInt4(properties);
    }

    /**
     * 나머지 부분(216 bytes)을 0으로 쓴다.
     *
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void zero216(StreamWriter sw) throws IOException {
        sw.writeZero(216);
    }
}
