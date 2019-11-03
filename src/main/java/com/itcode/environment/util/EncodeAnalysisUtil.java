package com.itcode.environment.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.security.SecureRandom;
import java.util.BitSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author:wx
 * @Date:2019/1/28 10:37
 */
public class EncodeAnalysisUtil {
    static BitSet dontNeedEncoding;
    static final int caseDiff = ('a' - 'A');
    static String dfltEncName = null;
    static {
        /**
         * 设置不需要转义的字符
         * A-Z,a-z,0-9,-、_、*、.' '(空格)
         * dontNeedEncoding:存储相应的ASCII
         */
        dontNeedEncoding = new BitSet(256);
        int k;
        for(k = 'A'; k <= 'Z'; k ++){
            dontNeedEncoding.set(k);
        }
        for (k = 'a'; k <= 'z'; k++){
            dontNeedEncoding.set(k);
        }
        for (k = '0'; k<= '9'; k++){
            dontNeedEncoding.set(k);
        }
        //Unicode编码16进制汉字范围
        for (k = 0x4e00; k <= 0x9fa5; k ++){
            dontNeedEncoding.set(k);
        }
//        dontNeedEncoding.set('-');
//        dontNeedEncoding.set('_');
//        dontNeedEncoding.set('*');
//        dontNeedEncoding.set('.');
//        dontNeedEncoding.set(' ');
    }


    public static String encode(String s, String enc) throws UnsupportedEncodingException {
        boolean needToChange = false;
        StringBuffer out = new StringBuffer(s.length());
        Charset charset;
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        if (enc == null)
            throw new NullPointerException("charsetName");

        try {
            charset = Charset.forName(enc);
        } catch (IllegalCharsetNameException e) {
            throw new UnsupportedEncodingException(enc);
        } catch (UnsupportedCharsetException e) {
            throw new UnsupportedEncodingException(enc);
        }

        /**
         * 遍历字符串，比较字符串中的字符是否需要转码
         */
        for (int i = 0; i < s.length();) {
            int c = (int) s.charAt(i);
            //System.out.println("Examining character: " + c);
            //dontNeedEncoding存在相应的ASCII码，字符串不需要转义
            if (dontNeedEncoding.get(c)) {
                //将空字符串转成+号
//                if (c == ' ') {
//                    c = '+';
//                    needToChange = true;
//                }
                out.append((char)c);
                i++;
            } else {
                // convert to external encoding before hex conversion
                do {
                    //将ASCII码转为字符
                    charArrayWriter.write(c);
                    if (c >= 0xD800 && c <= 0xDBFF) {
                        if ( (i+1) < s.length()) {
                            int d = (int) s.charAt(i+1);
                            if (d >= 0xDC00 && d <= 0xDFFF) {
                                charArrayWriter.write(d);
                                i++;
                            }
                        }
                    }
                    i++;
                } while (i < s.length() && !dontNeedEncoding.get((c = (int) s.charAt(i))));

                charArrayWriter.flush();
                String str = new String(charArrayWriter.toCharArray());
                byte[] ba = str.getBytes(charset);
                for (int j = 0; j < ba.length; j++) {
                    out.append('_');
                    char ch = Character.forDigit((ba[j] >> 4) & 0xF, 16);
                    if (Character.isLetter(ch)) {
                        ch -= caseDiff;
                    }
                    out.append(ch);
                    ch = Character.forDigit(ba[j] & 0xF, 16);
                    if (Character.isLetter(ch)) {
                        ch -= caseDiff;
                    }
                    out.append(ch);
                }
                charArrayWriter.reset();
                needToChange = true;
            }
        }

        return (needToChange? out.toString() : s);
    }


    public static String decode(String s, String enc)
            throws UnsupportedEncodingException{

        boolean needToChange = false;
        int numChars = s.length();
        StringBuffer sb = new StringBuffer(numChars > 500 ? numChars / 2 : numChars);
        int i = 0;
        if (enc.length() == 0) {
            throw new UnsupportedEncodingException ("URLDecoder: empty string enc parameter");
        }
        char c;
        byte[] bytes = null;
        while (i < numChars) {
            c = s.charAt(i);
            switch (c) {
//                case '+':
//                    sb.append(' ');
//                    i++;
//                    needToChange = true;
//                    break;
                case '_':
                    try {
                        if (bytes == null)
                            bytes = new byte[(numChars-i)/3];
                        int pos = 0;
                        //将%后面的两位字符转换
                        while ( ((i+2) < numChars) &&
                                (c=='_')) {
                            int v = Integer.parseInt(s.substring(i+1,i+3),16);
                            if (v < 0)
                                throw new IllegalArgumentException("URLDecoder: Illegal hex characters in escape (%) pattern - negative value");
                            bytes[pos++] = (byte) v;
                            i+= 3;
                            if (i < numChars)
                                c = s.charAt(i);
                        }
                        if ((i < numChars) && (c=='_'))
                            throw new IllegalArgumentException("URLDecoder: Incomplete trailing escape (%) pattern");

                        sb.append(new String(bytes, 0, pos, enc));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("URLDecoder: Illegal hex characters in escape (%) pattern - " + e.getMessage());
                    }
                    needToChange = true;
                    break;
                default:
                    sb.append(c);
                    i++;
                    break;
            }
        }
        return (needToChange? sb.toString() : s);
    }

    /**
     * \\w*：匹配字母、数字、下划线[A-Za-z0-9_]
     * */
    private final static String RULE = "\\w*";
    public static String ngPattern(String str){
        Pattern pattern = Pattern.compile(RULE);
        Matcher matcher = pattern.matcher(str);
        StringBuilder groups = new StringBuilder();
        String group = null;
        while (matcher.find()){
            group = groups.append(matcher.group()).toString();
        }
        return group;
    }



    public static String encrypt(String data, String key) {
        byte[] bt = null;
        try {
            bt = encrypt(data.getBytes(), key.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String strs = new BASE64Encoder().encode(bt);
        return strs;
    }

    public static String decrypt(String data, String key) {
        if (data == null)
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] buf = null;
        try {
            buf = decoder.decodeBuffer(data);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        byte[] bt = null;
        try {
            bt = decrypt(buf, key.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(bt);
    }

    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        SecureRandom sr = new SecureRandom();

        DESKeySpec dks = new DESKeySpec(key);

        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(dks);

        Cipher cipher = Cipher.getInstance("DES");

        cipher.init(1, securekey, sr);

        return cipher.doFinal(data);
    }

    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        SecureRandom sr = new SecureRandom();

        DESKeySpec dks = new DESKeySpec(key);

        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(dks);

        Cipher cipher = Cipher.getInstance("DES");

        cipher.init(2, securekey, sr);

        return cipher.doFinal(data);
    }

}
