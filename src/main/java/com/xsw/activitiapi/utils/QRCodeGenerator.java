package com.xsw.activitiapi.utils;

import cn.hutool.core.lang.Console;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * 生成二维码
 *
 * @author xueshengwen
 * @since 2021/1/6 9:33
 */
public class QRCodeGenerator {
    // 默认二维码宽度
    private static final int width = 300;
    // 默认二维码高度
    private static final int height = 300;
    // 默认二维码文件格式
    private static final String format = "png";
    // 二维码参数
    private static final Map<EncodeHintType, Object> hints = new HashMap<>();

    static {
        // 字符编码
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        // 容错等级 L、M、Q、H 其中 L 为最低, H 为最高
        // hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        // hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        // hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.Q);
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        // 二维码与图片边距
        hints.put(EncodeHintType.MARGIN, 1);
    }

    /**
     * 生成二维码
     *
     * @param content  内容
     * @param width    宽度
     * @param height   高度
     * @param filePath 二维码生成存放路径
     * @throws WriterException
     * @throws IOException
     */
    public static void generateQRCodeImage(String content, int width, int height, String filePath) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height, hints);
        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

    public static void main(String[] args) {
        try {
            String level = hints.get(EncodeHintType.ERROR_CORRECTION).toString();
            generateQRCodeImage("容错等级" + level, width, height, "D:/test.png");
            Console.log("生成二维码done！");
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
