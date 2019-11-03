package com.itcode.environment.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author:wx
 * @Date:2019/8/15 9:04
 */
public class HttpUtil {

    public static void main(String[] args) {
        String getUrl = "http://localhost:8000/nipt/getNiptConfig";

        String getParam = "usertoken=5a1d914cd554414c86edccc770b4cee7&labId=22";

        String getResult = sendGet(getUrl, getParam);
        System.out.println("getResult ===========>" + getResult);
        System.out.println("*****************************************");
        String postUrl = "http://localhost:8000/nipt/postNiptConfig?usertoken=5a1d914cd554414c86edccc770b4cee7";
        String postParam ="&niptConfigId=0f853a024aed47a796a7849d40321e9f&labId=22&readsCount=21&gcRatio=230&fetusRatio=3";
        //post请求：把请求参数直接拼接到URL中
        String postResult = sendPost(postUrl + postParam,"");
        System.out.println("postResult=====>" + postResult);
    }

    /**
     * 向指定的URL发送get方法请求
     *
     * @param url   URL地址
     * @param param 请求参数 格式 name1=value1 & name2=value2
     * @return 远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;

        try {
            //封装URL地址格式
            String urlAddress = url + "?" + param;
            URL requestUrl = new URL(urlAddress);
            //建立URL之间的连接
            URLConnection connection = requestUrl.openConnection();
            //设置请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            /**
             *  建立实际连接
             */
            connection.connect();
            // 获取所有的响应头字段
            /*Map<String, List<String>> headerFieldMap = connection.getHeaderFields();
            //遍历所有的响应头字段
            for (String key : headerFieldMap.keySet()) {
                System.out.println(key + "--->" + headerFieldMap.get(key));
            }*/

            //定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭流
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    /**
     * 向指定URL发送post方法请求
     *
     * @param url   post请求的地址
     * @param param 请求参数 格式：name1=value1 & name2=value2(此方法中param无效，直接将请求参数拼接到URL中)
     * @return 返回远程资源（第三方接口）的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";

        try {
            //根据请求地址创建URL
            URL requestUrl = new URL(url);

            //建立URL之间的连接
            URLConnection connection = requestUrl.openConnection();

            //设置请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            /**
             * 发送post请求必须设置以下两行
             */
            connection.setDoInput(true);
            connection.setDoOutput(true);

            //获取URLConnect对象输出流
            out = new PrintWriter(connection.getOutputStream());

            /**
             * 发送请求参数
             */
            out.print(param);

            //定义BufferedReader读取URL的响应结果
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
