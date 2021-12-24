package io.renren.common.utils;

import okhttp3.*;
import okhttp3.Headers.Builder;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * @author guoyh
 */
@Component
public class OkHttpUtil {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    //@Resource
    private OkHttpClient okHttpClient = new OkHttpClient();

    /**
     * get
     *
     * @param url     请求的url
     * @param queries 请求的参数，在浏览器？后面的数据，没有可以传null
     * @return
     */
    public String get(String url, Map<String, String> queries, Map<String, String> cookies) {
        String responseBody = "";
        StringBuffer paramsBuffer = new StringBuffer(url);
        StringBuffer cookiesBuffer = new StringBuffer();

        //添加params参数
        if (cookies != null && cookies.keySet().size() > 0) {
            for (Map.Entry<String, String> entry : cookies.entrySet()) {
                cookiesBuffer.append(entry.getKey() + "=" + entry.getValue() + ";");
            }
        }

        //添加params参数
        if (queries != null && queries.keySet().size() > 0) {
            boolean firstFlag = true;
            Iterator iterator = queries.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry<String, String>) iterator.next();
                if (firstFlag) {
                    paramsBuffer.append("?" + entry.getKey() + "=" + entry.getValue());
                    firstFlag = false;
                } else {
                    paramsBuffer.append("&" + entry.getKey() + "=" + entry.getValue());
                }
            }
        }

        Request request = new Request
                .Builder()
                .addHeader("Content-Type", "application/json; charset=UTF-8")
                .addHeader("Accept-Encoding", "gzip, deflate")
                .addHeader("Connection", "keep-alive")
                .addHeader("Accept", "*/*")
                .addHeader("Cookie", cookiesBuffer.toString())
                .url(paramsBuffer.toString())
                .build();
        Response response = null;

        try {
            response = okHttpClient.newCall(request).execute();
            logger.info("OkHttp CALL GET; URL:"+paramsBuffer.toString());
            int status = response.code();
            if (status == 200) {
                return response.body().string();
            }
        } catch (Exception e) {
            logger.error("OkHttp put error >> ex = {}", ExceptionUtils.getStackTrace(e));
        } finally {
            if (response != null) {
                response.close();
            }
        }

        return responseBody;
    }
    /**
     * post
     *
     * @param url    请求的url
     * @param params post form 提交的参数
     * @return
     */
    public String post(String url, Map<String, String> params, Map<String, String> cookies) {
        String responseBody = "";
        FormBody.Builder bodyBuilder = new FormBody.Builder();
        StringBuffer cookiesBuffer = new StringBuffer();

        //添加cookies参数
        if (cookies != null && cookies.keySet().size() > 0) {
            for (Map.Entry<String, String> entry : cookies.entrySet()) {
                cookiesBuffer.append(entry.getKey() + "=" + entry.getValue() + ";");
            }
        }

        //添加body参数
        if (params != null && params.keySet().size() > 0) {
            for (String key : params.keySet()) {
                bodyBuilder.add(key, params.get(key));
            }
        }

        Request request = new Request
                .Builder()
                .addHeader("Content-Type", "application/json; charset=UTF-8")
                .addHeader("Accept-Encoding", "gzip, deflate")
                .addHeader("Connection", "keep-alive")
                .addHeader("Accept", "*/*")
                .addHeader("Cookie", cookiesBuffer.toString())
                .url(url)
                .post(bodyBuilder.build())
                .build();
        Response response = null;

        try {
            response = okHttpClient.newCall(request).execute();
            logger.info("OkHttp CALL POST; URL:"+url+", BODY:"+bodyBuilder.toString());
            int status = response.code();
            if (status == 200) {
                return response.body().string();
            }
        } catch (Exception e) {
            logger.error("okhttp post error >> ex = {}", ExceptionUtils.getStackTrace(e));
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return responseBody;
    }
    /**
     * post 上传文件
     *
     * @param url
     * @param params
     * @param fileType
     * @return
     */
    public String postFile(String url, Map<String, Object> params, String fileType) {
        String responseBody = "";
        MultipartBody.Builder builder = new MultipartBody.Builder();
        //添加参数
        if (params != null && params.keySet().size() > 0) {
            for (String key : params.keySet()) {
                if (params.get(key) instanceof File) {
                    File file = (File) params.get(key);
                    builder.addFormDataPart(key, file.getName(), RequestBody.create(MediaType.parse(fileType), file));
                    continue;
                }
                builder.addFormDataPart(key, params.get(key).toString());
            }
        }
        Request request = new Request
                .Builder()
                .url(url)
                .post(builder.build())
                .build();
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            int status = response.code();
            if (status == 200) {
                return response.body().string();
            }
        } catch (Exception e) {
            logger.error("okhttp postFile error >> ex = {}", ExceptionUtils.getStackTrace(e));
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return responseBody;
    }
}
