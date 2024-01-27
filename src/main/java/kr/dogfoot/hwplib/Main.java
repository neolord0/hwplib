package kr.dogfoot.hwplib;

import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractMethod;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractOption;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractorListener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 파일에 전체 텍스트를 추출하는 샘플 프로그램
 */
public class Main {
    static class Listener implements TextExtractorListener {
        private final String dst;
        private FileWriter writer;

        public Listener(String dst) {
            this.dst = dst;
        }

        public void begin() throws IOException {
            File file = new File(this.dst);
            file.getParentFile().mkdirs();
            this.writer = new FileWriter(file);
        }

        public void end() throws IOException {
            this.writer.close();
        }

        public void paragraphText(String text) {
            try {
                this.writer.write(text);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.exit(1);
            return;
        }

        String src = args[0];
        String dst = args[1];

        TextExtractOption option = new TextExtractOption();
        option.setMethod(TextExtractMethod.OnlyMainParagraph);
        option.setWithControlChar(false);
        option.setAppendEndingLF(true);

        Listener listener = new Listener(dst);

        listener.begin();
        HWPReader.forExtractText(src, listener, option);
        listener.end();
    }
}