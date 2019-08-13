package kr.dogfoot.hwplib.sample;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bindata.EmbeddedBinaryData;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.writer.HWPWriter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * 이미지 변경하는 샘플 프로그램.
 */
public class Changing_Image {
    public static void main(String[] args) throws Exception {
        String filename = "sample_hwp" + File.separator + "test-change-image.hwp";

        HWPFile hwpFile = HWPReader.fromFile(filename);

        processAllImages(hwpFile);

        String filename2 = "sample_hwp" + File.separator + "edit_test-change-image.hwp";
        HWPWriter.toFile(hwpFile, filename2);
    }

    private static void processAllImages(HWPFile hwpFile) throws IOException {
        for (EmbeddedBinaryData ebd : hwpFile.getBinData().getEmbeddedBinaryDataList()) {
            BufferedImage img = loadImage(ebd.getData());
            changeImage(img);

            byte[] changedFileBinary = makeFileBinary(ebd.getName(), img);
            if (changedFileBinary != null) {
                ebd.setData(changedFileBinary);
            }
        }
    }

    private static BufferedImage loadImage(byte[] data) throws IOException {
        return ImageIO.read(new ByteArrayInputStream(data));
    }

    private static void changeImage(BufferedImage img) {
        makeGray(img);
    }

    public static void makeGray(BufferedImage img) {
        for (int x = 0; x < img.getWidth(); ++x) {
            for (int y = 0; y < img.getHeight(); ++y) {
                int rgb = img.getRGB(x, y);
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = (rgb & 0xFF);

                // Normalize and gamma correct:
                float rr = (float) Math.pow(r / 255.0, 2.2);
                float gg = (float) Math.pow(g / 255.0, 2.2);
                float bb = (float) Math.pow(b / 255.0, 2.2);

                // Calculate luminance:
                float lum = (float) (0.2126 * rr + 0.7152 * gg + 0.0722 * bb);

                // Gamma compand and rescale to byte range:
                int grayLevel = (int) (255.0 * Math.pow(lum, 1.0 / 2.2));
                int gray = (grayLevel << 16) + (grayLevel << 8) + grayLevel;
                img.setRGB(x, y, gray);
            }
        }
    }

    private static byte[] makeFileBinary(String name, BufferedImage img) throws IOException {
        String ext = getExtension(name);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, ext, baos);
        baos.flush();
        byte[] imageInByte = baos.toByteArray();
        baos.close();
        return imageInByte;
    }

    private static String getExtension(String name) {
        int pos = name.lastIndexOf('.');
        if (pos != -1) {
            return name.substring(pos + 1);
        }
        return null;
    }
}
