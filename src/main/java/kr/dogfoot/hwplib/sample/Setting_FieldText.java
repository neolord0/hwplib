package kr.dogfoot.hwplib.sample;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.tool.objectfinder.FieldFinder;
import kr.dogfoot.hwplib.tool.objectfinder.SetFieldResult;
import kr.dogfoot.hwplib.writer.HWPWriter;

import java.io.File;
import java.util.ArrayList;

/**
 * 필드 컨트롤의 텍스트를 설정하는 샘플 프로그램.
 */
public class Setting_FieldText {

    public static void main(String[] args) throws Exception {
        HWPFile hwpFile = HWPReader.fromFile("sample_hwp" + File.separator + "test-필드설정.hwp");
        if (hwpFile != null) {
            {
                ArrayList<String> textList = new ArrayList<String>();
                textList.add("필드1 값1\n2줄\n3줄\n");
                textList.add("필드1 값1\n2줄\n3줄");
                textList.add("필드1 값3");
                textList.add("필드1 값4");
                SetFieldResult sfr = FieldFinder.setFieldText(hwpFile, ControlType.FIELD_CLICKHERE, "필드1", textList);
                System.out.println("필드1 설정경과  = " + sfr);
            }
            {
                ArrayList<String> textList = new ArrayList<String>();
                textList.add("필드2 값1");
                textList.add("필드2 값2");
                textList.add("필드2 값3");
                SetFieldResult sfr = FieldFinder.setFieldText(hwpFile, ControlType.FIELD_CLICKHERE, "필드2", textList);
                System.out.println("필드2 설정경과  = " + sfr);
            }

            HWPWriter.toFile(hwpFile, "sample_hwp" + File.separator + "test-필드설정_saved.hwp");
        }
    }

}
