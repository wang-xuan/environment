package com.itcode.environment;

import com.itcode.environment.model.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:wx
 * @Date:2019/9/11 13:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RestTemplateTest {

    RestTemplate restTemplate = null;

    @Before
    public void setup() {
//        restTemplate = new RestTemplate();
        /**
         * 默认RestTemplate实例的行为都会直接使用JDK网络API；
         * 底层SimpleClientHttpRequestFactory默认没有超时时间即无限等待，需要自定义连接超时时间
         */
//        restTemplate = new RestTemplate(new SimpleClientHttpRequestFactory());
        restTemplate = new RestTemplate(getClientHttpRequestFactory());
    }

    private SimpleClientHttpRequestFactory getClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        //设置连接时间
        clientHttpRequestFactory.setConnectTimeout(10000);
        //设置读取超时时间
        clientHttpRequestFactory.setReadTimeout(10000);
        return clientHttpRequestFactory;
    }
    @Test
    public void testGetProduct1() {
        String url = "http://localhost:8601/product/get_product1";

        //方式一：通过GET方式获取JSON串数据
        /**
         * getForObject获取请求结果
         */
        String result = restTemplate.getForObject(url,String.class);
        System.out.println("get_product1返回结果：" + result);

        //方式二：get方式，获取JSON数据映射后的Product实体对象
        Product product = restTemplate.getForObject(url, Product.class);
        System.out.println("get_product1返回结果："+ product.getId());

        //方式三：GET 方式获取包含Product实体对象 的响应实体ResponseEntity对象，用getBody()获取
        /**
         * getEntity获取带有响应码、响应头和响应数据
         */
        ResponseEntity<Product> responseEntity = restTemplate.getForEntity(url, Product.class);
        if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
            System.out.println("get_product1返回结果：" + responseEntity.getBody());
        }

    }

    @Test
    public void test2() {
        String url = "http://localhost:8601/product/get_product1";

        //方式一：构建请求实体HttpEntity对象，用于配置Header信息和请求参数
        MultiValueMap header = new LinkedMultiValueMap();
        //APPLICATION_JSON_UTF8_VALUE
        header.add(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<Object> requestEntity = new HttpEntity<>(header);
        //执行请求获取包含Product实体对象
        /**
         * 更通用版本的请求处理方法，接受一个RequestEntity对象，可以设置路径、请求头、请求信息等，最后返回一个ResponseEntity实体
         */
        ResponseEntity<Product> exchangeResult = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Product.class);
        System.out.println("获取响应结果："+exchangeResult.getBody());

        //方式二：根据 RequestCallback 接口实现类设置Header信息,用 ResponseExtractor 接口实现类读取响应数据
        /**
         * 最通用的执行 HTTP 请求的方法，上面所有方法都是基于 execute 的封装，全面控制请求信息，并通过回调接口获得响应数据
         */
        String executeResult = restTemplate.execute(url, HttpMethod.GET, request -> {
            request.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        }, (clientHttpResponse) -> {
            InputStream body = clientHttpResponse.getBody();
            byte[] bytes = new byte[body.available()];
            body.read(bytes);
            return new String(bytes);
        });

        System.out.println("获取响应结果" + executeResult);
    }

    @Test
    public void test3() {
        String url = "http://localhost:8601/product/get_product2/";

        //方式1：将参数的值存在可变长度参数里，按照顺序进行参数匹配(getFotEntity)
        ResponseEntity<Product> responseEntity = restTemplate.getForEntity(url, Product.class, 2);
        System.out.println("响应结果："+ responseEntity);

        //方式2：封装成Map
        Map<String,Object> uriVariables = new HashMap<>();
        uriVariables.put("id",1);
        Product product = restTemplate.getForObject(url, Product.class, uriVariables);
        System.out.println("响应结果"+ product);

    }

    /**
     * post请求：content-type不同，主要常用的application/json、application/x-www-form-urlencoded
     */
    @Test
    public void test4() {
        String url = "http://localhost:8601/product/post_product2";

        //设置请求Content-type为application/json
        MultiValueMap<String,String> header = new LinkedMultiValueMap<>();
        header.put(HttpHeaders.CONTENT_TYPE,Arrays.asList(MediaType.APPLICATION_JSON_VALUE));
        //设置Accept,向服务器表名客户端可处理的内容类型
        header.put(HttpHeaders.ACCEPT,Arrays.asList(MediaType.APPLICATION_JSON_VALUE));
        //直接将实体Product作为请求参数传入，底层利用JackSon框架序列化JSON串发送请求
        Product product = new Product(2, "Macbook", BigDecimal.valueOf(10000));
        HttpEntity<Product> requestEntity = new HttpEntity<>(product,header);
        ResponseEntity<String> exchangeResult = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        System.out.println("post_product2:" + exchangeResult);

    }


}