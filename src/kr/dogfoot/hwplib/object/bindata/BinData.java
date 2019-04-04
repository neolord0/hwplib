package kr.dogfoot.hwplib.object.bindata;

import kr.dogfoot.hwplib.object.docinfo.bindata.BinDataCompress;

import java.util.ArrayList;

/**
 * 바이너리 데이터를 나타내는 객체 HWP파일 내의 "BinData" storage에 저장된다.
 *
 * @author neolord
 */
public class BinData {
    /**
     * HWP 파일 속에 첨부된 바이너리 데이터(이미지 등)의 리스트
     */
    private ArrayList<EmbeddedBinaryData> embeddedBinaryDataList;

    /**
     * 생성자
     */
    public BinData() {
        embeddedBinaryDataList = new ArrayList<EmbeddedBinaryData>();
    }

    /**
     * 새로운 첨부된 바이너리 데이터 객체를 생성하고 list에 추가합니다.
     *
     * @return 새로 생성된 첨부된 바이너리 데이터 객체
     */
    public EmbeddedBinaryData addNewEmbeddedBinaryData() {
        EmbeddedBinaryData ebd = new EmbeddedBinaryData();
        embeddedBinaryDataList.add(ebd);
        return ebd;
    }

    /**
     * 첨부된 바이너리 데이터의 리스트를 반환한다.
     *
     * @return 첨부된 바이너리 데이터의 리스트;
     */
    public ArrayList<EmbeddedBinaryData> getEmbeddedBinaryDataList() {
        return embeddedBinaryDataList;
    }

    /**
     * 새로운 첨부된 바이너리 데이터 객체를 생성하여 list에 추가합니다.
     *
     * @param name           새로운 첨부된 바이너리 데이터 객체의 이름
     * @param data           새로운 첨부된 바이너리 데이터 객체의 데이터
     * @param compressMethod 암축 방법
     */
    public void addNewEmbeddedBinaryData(String name, byte[] data, BinDataCompress compressMethod) {
        EmbeddedBinaryData ebd = addNewEmbeddedBinaryData();
        ebd.setName(name);
        ebd.setData(data);
        ebd.setCompressMethod(compressMethod);
    }
}
