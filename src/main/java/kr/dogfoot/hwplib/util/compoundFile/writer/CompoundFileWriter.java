package kr.dogfoot.hwplib.util.compoundFile.writer;

import kr.dogfoot.hwplib.object.fileheader.FileVersion;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * MS Compound File을 쓰기 위한 객체. Apache POI 라이브러리를 사용함
 *
 * @author neolord
 */
public class CompoundFileWriter {
    /**
     * 파일 시스템(Apache POI 라이브러리)
     */
    private POIFSFileSystem fs;
    /**
     * 현재 스토리지(디렉토리)
     */
    private DirectoryEntry currentStorage;
    /**
     * 현재 스크림(파일)을 쓰기 위한 객체
     */
    private StreamWriter currentStreamWriter;

    /**
     * 생성자
     */
    public CompoundFileWriter() {
        fs = new POIFSFileSystem();
        currentStorage = fs.getRoot();
    }

    /**
     * 파일 시스탬(Apache POI 라이브러리)에 저장하고 있는 내용을 파일로 저장한다.
     *
     * @param filepath 파일 경로
     * @throws IOException
     */
    public void write(String filepath) throws IOException {
        OutputStream os = new FileOutputStream(filepath);
        fs.writeFilesystem(os);
        os.close();
    }

    /**
     * 파일 시스탬(Apache POI 라이브러리)에 저장하고 있는 내용을 파일로 저장한다.
     *
     * @param os 출력 스트림
     * @throws IOException
     */
    public void write(OutputStream os) throws IOException {
        fs.writeFilesystem(os);
        os.close();
    }

    /**
     * 파일 시스탬(Apache POI 라이브러리)을 닫는다.
     *
     * @throws IOException
     */
    public void close() throws IOException {
        fs.close();
    }

    /**
     * 스토리지(디렉토리)를 생성한다.
     *
     * @param name 스토리지(디렉토리) 이름
     * @throws IOException
     */
    public void openCurrentStorage(String name) throws IOException {
        currentStorage = currentStorage.createDirectory(name);
    }

    /**
     * 현재 스토리지(디렉토리)을 닫는다.
     */
    public void closeCurrentStorage() {
        currentStorage = currentStorage.getParent();
    }

    /**
     * 열려있는 스토리지(디렉토리)에 스트림(파일)을 생성하고 스트림을 쓰기 위한 객체를 반환한다.
     *
     * @param name        스트림(파일) 이름
     * @param compress    압축 여부
     * @param fileVersion 한글 파일의 버전
     * @return 스트림을 쓰기 위한 객체
     */
    public StreamWriter openCurrentStream(String name, boolean compress,
                                          FileVersion fileVersion) {
        currentStreamWriter = new StreamWriter(name, compress, fileVersion);
        return currentStreamWriter;
    }

    /**
     * 현재 스트림(파일)을 닫는다.
     *
     * @throws IOException
     */
    public void closeCurrentStream() throws IOException {
        InputStream is = currentStreamWriter.getDataStream();
        currentStorage.createDocument(currentStreamWriter.getName(), is);
        is.close();
        currentStreamWriter.close();
        currentStreamWriter = null;
    }

    /**
     * root 스토리지(디렉토리)로 이동한다.
     */
    public void gotoRootStorage() {
        currentStorage = fs.getRoot();
    }
}
