package com.itcode.environment.util;


import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


/**
 * @Author:wx
 * @Date:2019/12/9 11:31
 */
public class ZxingCodeUtil {

    private static Logger logger = LoggerFactory.getLogger(ZxingCodeUtil.class);

    /**
     *  生成二维码格式
     * @param text 二维码内容
     * @param path 指定生成二维码的存储路径
     * @param width 宽度
     * @param height 高度
     * @param format 图片后缀格式：.png
     */
    public static void encodeQRCode(String text, String path, Integer width, Integer height, String format) {
        //根据路径获取文件对象
        File file = new File(path);
        //判断目标文件所在的目录是否存在
        if (!file.getParentFile().exists()) {
            logger.info("目标文件目录不存在，准备创建它!");
            if (!file.getParentFile().mkdirs()) {
                logger.info("创建目标文件所在目录失败!");
                return;
            }
        }

        //判断指定高宽是否为null，否则选择默认值
        width = width == null ? 300 : width;
        height = height == null ? 300 : height;
        format = format == null ? "png" : format;
        //设置字符集
        Map<EncodeHintType, Object> hints = new HashMap<>(16);
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        try {
            //生成二维码矩阵
            BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
            //二维码路径
            Path outputPath = Paths.get(path);
            //写入文件
            MatrixToImageWriter.writeToPath(bitMatrix, format, outputPath);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        String str = "2019";
        String path = "D:\\2019.png";
        encodeQRCode(str, path);
        decodeQRCode(path);
    }

    public static void encodeQRCode(String text, String path) {
        encodeQRCode(text, path, null, null, null);
    }


    public static String decodeQRCode(String filePath) {
        try {

            // 读取图片
            BufferedImage image = ImageIO.read(new File(filePath));

            // 多步解析
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);

            // 一步到位
            // BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)))

            // 设置字符集编码
            Map<DecodeHintType, String> hints = new HashMap<>(16);
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");

            // 对图像进行解码
            Result result = new MultiFormatReader().decode(binaryBitmap, hints);
            // 解码内容
//            JSONObject jsonObject = JSONObject.fromObject(result.getText());
            String text = result.getText();

            System.out.println("图片内容：  ");
            System.out.println("content： " + text);
            System.out.println("图片中格式：  ");
            System.out.println("encode： " + result.getBarcodeFormat());

            return text;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}
