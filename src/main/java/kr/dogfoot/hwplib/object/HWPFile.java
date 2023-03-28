package kr.dogfoot.hwplib.object;

import kr.dogfoot.hwplib.object.bindata.BinData;
import kr.dogfoot.hwplib.object.bodytext.BodyText;
import kr.dogfoot.hwplib.object.docinfo.DocInfo;
import kr.dogfoot.hwplib.object.fileheader.FileHeader;
import kr.dogfoot.hwplib.org.apache.poi.hpsf.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * HWP File를 나타내는 객체
 *
 * @author neolord
 */
public class HWPFile {
    /**
     * 파일 인식 정보를 나타내는 객체. "FileHeader" stream에 저장된다.
     */
    private FileHeader fileHeader;
    /**
     * 문서 정보를 나타내는 객체. "DocInfo" stream에 저장된다.
     */
    private DocInfo docInfo;
    /**
     * 본문을 나타내는 객체. "BodyText" storage에 저장된다.
     */
    private BodyText bodyText;
    /**
     * 바이너리 데이터를 나타내는 객체. "BinData" storage에 저장된다.
     */
    private BinData binData;
    private SummaryInformation summaryInformation;

    /**
     * 생성자
     */
    public HWPFile() {
        fileHeader = new FileHeader();
        docInfo = new DocInfo();
        bodyText = new BodyText();
        binData = new BinData();
    }

    /**
     * 파일 인식 정보를 나타내는 객체를 반환한다.
     *
     * @return 파일 인식 정보를 나타내는 객체
     */
    public FileHeader getFileHeader() {
        return fileHeader;
    }

    /**
     * 문서 정보를 나타내는 객체를 반환한다.
     *
     * @return 문서 정보를 나타내는 객체
     */
    public DocInfo getDocInfo() {
        return docInfo;
    }

    /**
     * 본문을 나타내는 객체를 반환한다.
     *
     * @return 본문을 나타내는 객체
     */
    public BodyText getBodyText() {
        return bodyText;
    }

    /**
     * 바이너리 데이터를 나타내는 객체를 반환한다.
     *
     * @return 바이너리 데이터를 나타내는 객체
     */
    public BinData getBinData() {
        return binData;
    }


    public SummaryInformation getSummaryInformation() {
        return summaryInformation;
    }

    public void setSummaryInformation(SummaryInformation summaryInformation) {
        this.summaryInformation = summaryInformation;
    }

    public void createSummaryInformation() {
//        summaryInformation = new SummaryInformation();
    }

    public HWPFile clone(boolean deepCopyImage) {
        HWPFile cloned = new HWPFile();
        cloned.copy(this, deepCopyImage);
        return cloned;
    }

    public void copy(HWPFile from, boolean deepCopyImage) {
        fileHeader.copy(from.fileHeader);
        docInfo.copy(from.docInfo);
        bodyText.copy(from.bodyText);
        binData.copy(from.binData, deepCopyImage);

        if (from.summaryInformation != null) {
            copySummaryInformation(from.summaryInformation);
        }
    }

    private void copySummaryInformation(SummaryInformation from) {
        try {
            byte[] source = from.toBytes();
            ByteArrayInputStream bis = new ByteArrayInputStream(source);
            PropertySet propertySet = new PropertySet(bis);
            summaryInformation = new SummaryInformation(propertySet);
        } catch (WritingNotSupportedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (UnexpectedPropertySetTypeException e) {
            throw new RuntimeException(e);
        } catch (NoPropertySetStreamException e) {
            throw new RuntimeException(e);
        } catch (MarkUnsupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
