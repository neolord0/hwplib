package kr.dogfoot.hwplib.util.compoundFile.reader;

import kr.dogfoot.hwplib.object.fileheader.FileVersion;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.Entry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

/**
 * MS Compound File을 읽기 위한 객체. Apache POI 라이브러리를 사용함
 *
 * @author neolord
 */
public class CompoundFileReader {
    /**
     * 파일 시스템(Apache POI 라이브러리)
     */
    private POIFSFileSystem fs;
    /**
     * 현재 스토리지(디렉토리)
     */
    private DirectoryEntry currentStorage;

    /**
     * 생성자. MS Compound 파일을 열고, 현재 스토리지를 파일의 root 스토리지로 설정한다.
     *
     * @param file 읽을 파일
     * @throws IOException 파일 에러
     */
    public CompoundFileReader(File file) throws IOException {
        fs = new POIFSFileSystem(file);
        currentStorage = fs.getRoot();
    }

    /**
     * 생성자. MS Compound 파일을 열고, 현재 스토리지를 파일의 root 스토리지로 설정한다.
     *
     * @param is Input Stream 객체
     * @throws IOException 파일 에러
     */
    public CompoundFileReader(InputStream is) throws IOException {
        fs = new POIFSFileSystem(is);
        currentStorage = fs.getRoot();
    }

    /**
     * 현재 스토리지(디렉토리)에 포함된 항목(스토리지와 스트림)들의 이름을 반환한다.
     *
     * @return 현제 스토리지(디렉토리)에 포함된 항목(스토리지와 스트림)들의 이름의 리스트
     */
    public Set<String> listChildNames() {
        return currentStorage.getEntryNames();
    }

    /**
     * 현재 스토리지(디렉토리)에 이름이 name인 스토리지(디렉토리)가 있는지 여부를 반환한다.
     *
     * @param name 찾는 스토리지 이름
     * @return 현재 스토리지(디렉토리)에 이름이 name인 스토리지가 있는지 여부
     * @throws FileNotFoundException
     */
    public boolean isChildStorage(String name) throws FileNotFoundException {
        return (currentStorage.hasEntry(name) == true)
                && (currentStorage.getEntry(name).isDirectoryEntry());
    }

    /**
     * 현재 스토리지(디렉토리)에 이름이 name인 스트림(파일)이 있는지 여부를 반환한다.
     *
     * @param name 찾는 스트림 이름
     * @return 현재 스토리지(디렉토리)에 이름이 name인 스트림(파일)이 있는지 여부
     * @throws FileNotFoundException
     */
    public boolean isChildStream(String name) throws FileNotFoundException {
        return (currentStorage.hasEntry(name) == true)
                && (currentStorage.getEntry(name).isDocumentEntry());
    }

    /**
     * 이름이 name인 스토리지(디렉토리)로 이동한다.
     *
     * @param name 이동할 스토리지 이름
     * @throws Exception
     */
    public void moveChildStorage(String name) throws Exception {
        Entry e = currentStorage.getEntry(name);
        if (e != null && e.isDirectoryEntry()) {
            currentStorage = (DirectoryEntry) e;
        } else {
            throw new Exception("this is not storage.");
        }
    }

    /**
     * 부모 스토리지(디렉토리)로 이동한다.
     */
    public void moveParentStorage() {
        if (currentStorage != fs.getRoot()) {
            currentStorage = currentStorage.getParent();
        }
    }

    /**
     * 이름이 name인 스트림을 읽을 수 있는 스트림 리더 객체를 반환한다.
     *
     * @param name        찾는 스트림 이름
     * @param compress    압축 여부(한글에서 지원)
     * @param fileVersion 파일 버전
     * @return 이름이 name인 스트림을 읽을 수 있는 스트림 리더 객체
     * @throws Exception
     */
    public StreamReader getChildStreamReader(String name, boolean compress,
                                             FileVersion fileVersion) throws Exception {
        Entry e = currentStorage.getEntry(name);
        if (e != null && e.isDocumentEntry()) {
            if (compress == true) {
                return new StreamReaderForCompress((DocumentEntry) e,
                        fileVersion);
            } else {
                return new StreamReaderForNormal((DocumentEntry) e, fileVersion);
            }
        } else {
            throw new Exception("this is not stream.");
        }
    }

    /**
     * 현재 열려진 MS Compound 파일을 닫는다.
     *
     * @throws IOException
     */
    public void close() throws IOException {
        fs.close();
    }
}
