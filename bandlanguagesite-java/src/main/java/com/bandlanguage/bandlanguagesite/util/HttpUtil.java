package com.bandlanguage.bandlanguagesite.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * http 请求工具类
 * 参考：https://github.com/zhuzhegithub/utils/tree/master/src/main/java/com/space/utils/http
 *
 * @author xiaov
 * @since 2021-06-22 20:20
 */
@Slf4j
public class HttpUtil {

    /**
     * GET 请求
     *
     * @param host     主机
     * @param path     路径
     * @param headers  headers参数列表
     * @param queryMap 请求参数列表
     * @return HttpResponse
     * @throws IOException IO异常
     */
    public static HttpResponse doGet(String host, String path,
                                     Map<String, String> headers,
                                     Map<String, String> queryMap) throws IOException {
        HttpClient httpClient = getHttpClient(host, path);
        HttpGet request = new HttpGet(buildUrl(host, path, queryMap));
        for (Map.Entry<String, String> e : headers.entrySet()) {
            request.addHeader(e.getKey(), e.getValue());
        }
        request.setConfig(setTimeOutConfig(request.getConfig()));
        return httpClient.execute(request);
    }

    /**
     * POST form
     *
     * @param host     主机
     * @param path     路径
     * @param headers  headers参数
     * @param queryMap 请求参数列表
     * @param bodyMap  Map类型请求体
     * @return HttpResponse
     * @throws IOException IO异常
     */
    public static HttpResponse doPost(String host, String path,
                                      Map<String, String> headers,
                                      Map<String, String> queryMap,
                                      Map<String, String> bodyMap) throws IOException {
        HttpClient httpClient = getHttpClient(host, path);
        HttpPost request = new HttpPost(buildUrl(host, path, queryMap));
        for (Map.Entry<String, String> e : headers.entrySet()) {
            request.addHeader(e.getKey(), e.getValue());
        }
        request.setConfig(setTimeOutConfig(request.getConfig()));
        if (bodyMap != null && bodyMap.size() > 0) {
            List<NameValuePair> nameValuePairList = new ArrayList<>();
            for (String key : bodyMap.keySet()) {
                nameValuePairList.add(new BasicNameValuePair(key, bodyMap.get(key)));
            }
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(nameValuePairList, "utf-8");
            formEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
            request.setEntity(formEntity);
        }
        return httpClient.execute(request);
    }

    /**
     * POST String
     *
     * @param host     主机
     * @param path     路径
     * @param headers  headers参数
     * @param queryMap 请求参数列表
     * @param body     String类型请求体
     * @return HttpResponse
     * @throws IOException IO异常
     */
    public static HttpResponse doPost(String host, String path,
                                      Map<String, String> headers,
                                      Map<String, String> queryMap,
                                      String body) throws IOException {
        HttpClient httpClient = getHttpClient(host, path);
        HttpPost request = new HttpPost(buildUrl(host, path, queryMap));
        for (Map.Entry<String, String> e : headers.entrySet()) {
            request.addHeader(e.getKey(), e.getValue());
        }
        if (StringUtils.isNotBlank(body)) {
            request.setEntity(new StringEntity(body, "utf-8"));
        }
        request.setConfig(setTimeOutConfig(request.getConfig()));
        return httpClient.execute(request);
    }

    /**
     * POST stream
     *
     * @param host     主机
     * @param path     路径
     * @param headers  headers参数
     * @param queryMap 请求参数列表
     * @param body     byte[]类型请求体
     * @return HttpResponse
     * @throws IOException IO异常
     */
    public static HttpResponse doPost(String host, String path,
                                      Map<String, String> headers,
                                      Map<String, String> queryMap,
                                      byte[] body) throws IOException {
        HttpClient httpClient = getHttpClient(host, path);
        HttpPost request = new HttpPost(buildUrl(host, path, queryMap));
        for (Map.Entry<String, String> e : headers.entrySet()) {
            request.addHeader(e.getKey(), e.getValue());
        }
        if (body != null)
            request.setEntity(new ByteArrayEntity(body));
        request.setConfig(setTimeOutConfig(request.getConfig()));
        return httpClient.execute(request);
    }

    /**
     * PUT string
     *
     * @param host     主机
     * @param path     路径
     * @param headers  headers参数列表
     * @param queryMap 请求参数列表
     * @param body     String类型请求体
     * @return HttpResponse
     * @throws IOException IO异常
     */
    public static HttpResponse doPut(String host, String path,
                                     Map<String, String> headers,
                                     Map<String, String> queryMap,
                                     String body) throws IOException {
        HttpClient httpClient = getHttpClient(host, path);
        HttpPut request = new HttpPut(buildUrl(host, path, queryMap));
        for (Map.Entry<String, String> e : headers.entrySet()) {
            request.addHeader(e.getKey(), e.getValue());
        }
        if (StringUtils.isNotBlank(body)) {
            request.setEntity(new StringEntity(body, "utf-8"));
        }
        request.setConfig(setTimeOutConfig(request.getConfig()));
        return httpClient.execute(request);
    }

    /**
     * PUT stream
     *
     * @param host     主机
     * @param path     路径
     * @param headers  headers参数列表
     * @param queryMap 请求参数列表
     * @param body     byte[]类型参数
     * @return HttpResponse
     * @throws IOException IO异常
     */
    public static HttpResponse doPut(String host, String path,
                                     Map<String, String> headers,
                                     Map<String, String> queryMap,
                                     byte[] body) throws IOException {
        HttpClient httpClient = getHttpClient(host, path);
        HttpPut request = new HttpPut(buildUrl(host, path, queryMap));
        for (Map.Entry<String, String> e : headers.entrySet()) {
            request.addHeader(e.getKey(), e.getValue());
        }
        if (body != null) {
            request.setEntity(new ByteArrayEntity(body));
        }
        request.setConfig(setTimeOutConfig(request.getConfig()));
        return httpClient.execute(request);
    }

    /**
     * DELETE 请求
     *
     * @param host     主机
     * @param path     路径
     * @param headers  headers参数列表
     * @param queryMap 请求参数列表
     * @return HttpResponse
     * @throws IOException IO异常
     */
    public static HttpResponse doDelete(String host, String path,
                                        Map<String, String> headers,
                                        Map<String, String> queryMap) throws IOException {
        HttpClient httpClient = getHttpClient(host, path);
        HttpDelete request = new HttpDelete(buildUrl(host, path, queryMap));
        for (Map.Entry<String, String> e : headers.entrySet()) {
            request.addHeader(e.getKey(), e.getValue());
        }
        request.setConfig(setTimeOutConfig(request.getConfig()));
        return httpClient.execute(request);
    }

    /**
     * 将response结果转化为字符串
     *
     * @param httpResponse httpResponse
     * @return String
     * @throws IOException IO异常
     */
    public static String parseString(HttpResponse httpResponse) throws IOException {
        HttpEntity entity = httpResponse.getEntity();
        String resp = EntityUtils.toString(entity, "UTF-8");
        EntityUtils.consume(entity);
        return resp;
    }

    /**
     * 将response转为字符串的基础上再转为为JSONObject
     *
     * @param httpResponse httpResponse
     * @return JSONObject
     * @throws IOException IO异常
     */
    public static JSONObject parseJson(HttpResponse httpResponse) throws IOException {
        return JSON.parseObject(parseString(httpResponse));
    }

    /**
     * 在调用SSL之前需要重写验证方法，取消检测SSL
     * 创建ConnectionManager，添加Connection配置信息
     *
     * @return HttpClient 支持https
     */
    private static HttpClient sslClient() {
        try {
            // 在调用SSL之前需要重写验证方法，取消检测SSL
            X509TrustManager trustManager = new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            SSLContext context = SSLContext.getInstance(SSLConnectionSocketFactory.TLS);
            context.init(null, new TrustManager[]{trustManager}, null);
            SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(context, NoopHostnameVerifier.INSTANCE);
            // 创建Registry
            RequestConfig requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD_STRICT)
                    .setExpectContinueEnabled(Boolean.TRUE).setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
                    .setProxyPreferredAuthSchemes(Collections.singletonList(AuthSchemes.BASIC)).build();
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.INSTANCE)
                    .register("https", socketFactory).build();
            // 创建ConnectionManager，添加Connection配置信息
            PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            return HttpClients.custom().setConnectionManager(connectionManager)
                    .setDefaultRequestConfig(requestConfig).build();
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 设置 连接超时、 请求超时 、 读取超时  毫秒
     *
     * @param requestConfig requestConfig
     * @return RequestConfig
     */
    private static RequestConfig setTimeOutConfig(RequestConfig requestConfig) {
        if (requestConfig == null)
            requestConfig = RequestConfig.DEFAULT;

        return RequestConfig.copy(requestConfig)
                .setConnectionRequestTimeout(6000)
                .setConnectTimeout(6000)
                .setSocketTimeout(1000)
                .build();
    }

    /**
     * 获取HttpClient
     *
     * @param host 主机
     * @param path 路径
     * @return HttpClient
     */
    public static HttpClient getHttpClient(String host, String path) {
        if (host != null && host.startsWith("https://")) {
            return sslClient();
        } else if (StringUtils.isBlank(host) && path != null && path.startsWith("https://")) {
            return sslClient();
        } else
            return HttpClientBuilder.create().build();
    }

    /**
     * 构建请求的 url
     *
     * @param host     主机
     * @param path     路径
     * @param queryMap 请求参数列表
     * @return 请求url
     * @throws UnsupportedEncodingException 不支持的编码错误
     */
    private static String buildUrl(String host, String path, Map<String, String> queryMap) throws UnsupportedEncodingException {
        StringBuffer sfUrl = new StringBuffer();
        if (!StringUtils.isBlank(host))
            sfUrl.append(host);
        if (!StringUtils.isBlank(path)) {
            sfUrl.append(path);
        }
        if (null != queryMap) {
            StringBuffer sfQuery = new StringBuffer();
            for (Map.Entry<String, String> query : queryMap.entrySet()) {
                if (0 < sfQuery.length()) {
                    sfQuery.append("&");
                }
                if (StringUtils.isBlank(query.getKey()) && !StringUtils.isBlank(query.getValue())) {
                    sfQuery.append(query.getValue());
                }
                if (!StringUtils.isBlank(query.getKey())) {
                    sfQuery.append(query.getKey());
                    if (!StringUtils.isBlank(query.getValue())) {
                        sfQuery.append("=");
                        sfQuery.append(URLEncoder.encode(query.getValue(), "utf-8"));
                    }
                }
            }
            if (sfQuery.length() > 0) {
                sfUrl.append("?").append(sfQuery);
            }
        }
        return sfUrl.toString();
    }

    /**
     * 从response的Headers中获取某个值，如access_token
     * @param response HttpResponse
     * @return 在Headers中获得的值
     */
    public static String getValueFromHeaders(HttpResponse response,String key,String prefix){
        if(response == null || StringUtils.isBlank(key) || StringUtils.isBlank(prefix)) return null;
        Header[] headers = response.getAllHeaders();
        Map<String,String> keyValues = new ConcurrentHashMap<>();
        for (Header header : headers) {
            if (key.equals(header.getName()) && header.getValue().startsWith(prefix)){
                String[] strPairs = header.getValue().split(";");
                for (String s : strPairs) {
                    s = s.trim();
                    if(s.startsWith(prefix))
                        return s.substring(s.indexOf("=") + 1);
                }
            }
        }
        return null;
    }
}
