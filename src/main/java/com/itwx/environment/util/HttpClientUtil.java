package com.itwx.environment.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.itwx.environment.util.model.NiptConfig;
import com.itwx.environment.util.model.Sample;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections.CollectionUtils;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author:wx
 * @Date:2019/8/15 10:46
 */
public class HttpClientUtil {

    public static void main(String[] args) {
//        String getUrl = "http://localhost:8000/nipt/getNiptConfigs";
//        Map<String,String> getParamMap = new HashMap<>(16);
//        getParamMap.put("usertoken","5a1d914cd554414c86edccc770b4cee7");
//        getParamMap.put("labId","22");
//        String getResult = doGet(getUrl, getParamMap);
//        System.out.println("getResult ===========>" + getResult);
//
//        System.out.println("***************************");
//
//        String postUrl = "http://localhost:8000/nipt/postNiptConfig";
//        Map<String,String> postParamMap = new HashMap<>(16);
//        postParamMap.put("usertoken","5a1d914cd554414c86edccc770b4cee7");
//        postParamMap.put("niptConfigId","0f853a024aed47a796a7849d40321e9f");
//        postParamMap.put("labId","22");
//        postParamMap.put("readsCount","23");
//        postParamMap.put("gcRatio","30");
//        //post请求
//        String postResult = doPost(postUrl,postParamMap);
//        System.out.println("postResult=====>" + postResult);
//
//        System.out.println("################################");
//
//        String getUrl1 = "http://localhost:8000/nipt/getNiptConfig";
//        Map<String,String> getParamMap1 = new HashMap<>(16);
//        getParamMap1.put("usertoken","5a1d914cd554414c86edccc770b4cee7");
//        getParamMap1.put("labId","22");
//        String getResult1 = doGet(getUrl1, getParamMap1);
//        System.out.println("getResult1 ===========>" + getResult1);
//
        String url = "http://101.68.81.90:8050/NIPT/api/sequence/status";
        Map<String,String> paramMap = new HashMap<>(16);
        paramMap.put("name","190501_MACHINEID_0001_AXVDRFGDDF");
        paramMap.put("action","reanalysis");
//        paramMap.put("passwd","testadmin");
//        String get = doPost(url, paramMap);
        String get = doGet(url, paramMap);
        System.out.println(get);
//        String url = "http://101.68.81.90:8050/NIPT/api/analysis/review/";
//        Map<String,String> paramMap = new HashMap<>(16);
//        paramMap.put("name","1223");
//        List<Sample> samples = new LinkedList<>();
//        Sample sample1 = new Sample("2","1","12");
//        Sample sample2 = new Sample("2","1","12");
//        samples.add(sample1);
//        samples.add(sample2);
//        paramMap.put("samples",samples.toString());
//        String post = doPost(url,paramMap);
//        System.out.println(post);

    }


    private static final String URL = "url";
    //用户名
    private static final String APP_KEY = "testadmin";
    //密码
    private static final String SECRET_KEY = "testadmin";

    /**
     * 构造Basic Auth认证头信息
     *
     * @return
     */
    public static String getHeader() {
        String auth = APP_KEY + ":" + SECRET_KEY;
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodedAuth);
        return authHeader;
    }


    public static String doGet(String url, Map<String,String> param) {
        //创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = "";

        CloseableHttpResponse response = null;

        try {
            //创建URI
            URIBuilder uriBuilder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    uriBuilder.addParameter(key, param.get(key));
                }
            }

            //创建URI
            URI uri = uriBuilder.build();
            //创建Http Get 请求
            HttpGet httpGet = new HttpGet(uri);
            httpGet.addHeader("Authorization",getHeader());
            //执行请求
            response = httpClient.execute(httpGet);

            //判断响应状态是否为200
//            if (response.getStatusLine().getStatusCode() == 200) {
                result = UnicodeToChar.unicodeToCn(EntityUtils.toString(response.getEntity(),"UTF-8"));
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public static String doGet(String url) {
        return doGet(url, null);
    }


    public static String doPost(String url, Map<String, String> param) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = "";

        CloseableHttpResponse response = null;

        try {
            //创建Http POST请求
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("Authorization",getHeader());
            //封装post请求的请求体
            if (param != null) {
                //创建参数列表
                List<NameValuePair> paramList = new LinkedList<>();
                for (String key : param.keySet()) {
                    paramList.add(new BasicNameValuePair(key, param.get(key)));
                }

                //模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
                httpPost.setEntity(entity);
             }

             //执行post请求
            response = httpClient.execute(httpPost);
            //获取响应结果
            result = UnicodeToChar.unicodeToCn(EntityUtils.toString(response.getEntity(),"UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String doPost(String url) {
        return doPost(url, null);
    }


    /**
     * 传送json类型的post请求
     * @param url
     * @param json
     * @return String
     */
    public static String doPostJson(String url, String json) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建请求内容
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }

}
