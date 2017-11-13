package com.baisi.myapplication.okhttp.request;

import android.util.Log;

import com.baisi.myapplication.okhttp.listener.DisposeDataHandle;
import com.baisi.myapplication.okhttp.response.CommonJsonCallback;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author vision
 * @function build the request
 */
public class CommonRequest {
    /**
     * create the key-value Request
     *
     * @param url
     * @param params
     * @return
     */
    public static final MediaType FORM_CONTENT_TYPE
            = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");

    public static Request createPostRequest(String url, RequestParams params) {
        return createPostRequest(url, params, null);
    }
    public static Request createPostRequest1(String url, RequestParams params,RequestParams headers) {
        return createPostRequest(url, params, headers);
    }


    /**可以带请求头的Post请求
     * @param url
     * @param params
     * @param headers
     * @return
     */
    public static Request createPostRequest(String url, RequestParams params, RequestParams headers) {
        StringBuilder tempParams = new StringBuilder();
        FormBody.Builder mFormBodyBuild = new FormBody.Builder();

        if (params != null) {
            for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {

                mFormBodyBuild.add(entry.getKey(), entry.getValue());

                RequestBody.create(FORM_CONTENT_TYPE,entry.getValue());
            }
        }
        //添加请求头
//        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        Headers.Builder mHeaderBuild = new Headers.Builder();
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.urlParams.entrySet()) {
                mHeaderBuild.add(entry.getKey(), entry.getValue());
            }
        }

        FormBody mFormBody = mFormBodyBuild.build();

        Headers mHeader = mHeaderBuild.build();

//        Log.i("YYYY",String.valueOf(mHeader.get("private-token")));

        Request request = new Request.Builder().url(url).
                post(mFormBody)
//                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8")
                .headers(mHeader)
                .build();
//        request.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        return request;
    }

    /**
     * ressemble the params to the url
     *
     * @param url
     * @param params
     * @return
     */
    public static Request createGetRequest(String url, RequestParams params) {

        return createGetRequest(url, params, null);
    }

    /**
     * 可以带请求头的Get请求
     * @param url
     * @param params
     * @param headers
     * @return
     */
    public static Request createGetRequest(String url, RequestParams params, RequestParams headers) {
        StringBuilder urlBuilder = new StringBuilder(url).append("?");
        if (params != null) {
            for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
                urlBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        //添加请求头
        Headers.Builder mHeaderBuild = new Headers.Builder();
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.urlParams.entrySet()) {
                mHeaderBuild.add(entry.getKey(), entry.getValue());
            }
        }
        Headers mHeader = mHeaderBuild.build();
        return new Request.Builder().
                url(urlBuilder.substring(0, urlBuilder.length() - 1))
                .get()
                .headers(mHeader)
                .build();
    }

    /**
     * @param url
     * @param params
     * @return
     */
    public static Request createMonitorRequest(String url, RequestParams params) {
        StringBuilder urlBuilder = new StringBuilder(url).append("&");
        if (params != null && params.hasParams()) {
            for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
                urlBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        return new Request.Builder().url(urlBuilder.substring(0, urlBuilder.length() - 1)).get().build();
    }
    /**
     * 文件上传请求
     *
     * @return
     */

    private static final MediaType FILE_TYPE = MediaType.parse("application/octet-stream");

//    public static Request createMultiPostRequest(String url, RequestParams params) {
//
//        MultipartBody.Builder requestBody = new MultipartBody.Builder();
//        requestBody.setType(MultipartBody.FORM);
//        if (params != null) {
//
//            for (Map.Entry<String, Object> entry : params.fileParams.entrySet()) {
//                if (entry.getValue() instanceof File) {
//                    requestBody.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + entry.getKey() + "\""),
//                            RequestBody.create(FILE_TYPE, (File) entry.getValue()));
//                }
//                else if (entry.getValue() instanceof String) {
//
//                    requestBody.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + entry.getKey() + "\""),
//                            RequestBody.create(null, (String) entry.getValue()));
//                }
//            }
//        }
//        return new Request.Builder().url(url).post(requestBody.build()).build();
//    }

    private static final int TIME_OUT=300;//超时参数
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/*");
    public static Request createMultiPostRequest(String url, RequestParams params) {

        MultipartBody.Builder requestBody = new MultipartBody.Builder();
        requestBody.setType(MultipartBody.FORM);
        if (params != null) {

            for (Map.Entry<String, Object> entry : params.fileParams.entrySet()) {
                if (entry.getValue() instanceof File) {
                    requestBody.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + entry.getKey() + "\""),
                            RequestBody.create(FILE_TYPE, (File) entry.getValue()));
                } else if (entry.getValue() instanceof String) {

                    requestBody.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + entry.getKey() + "\""),
                            RequestBody.create(null, (String) entry.getValue()));
                }
            }
        }
        return new Request.Builder().url(url).head().post(requestBody.build()).build();
    }
    public  static void uploadImgAndParameter(Map<String, Object> map,
                                                   String url,DisposeDataHandle handle) {

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        okhttp3.Request request = chain.request().newBuilder()
                                .build();
                        return chain.proceed(request);
                    }
                }).readTimeout(TIME_OUT, TimeUnit.SECONDS)// 设置读取超时时间
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)// 设置写的超时时间
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)// 设置连接超时时间
                .build();

        MultipartBody.Builder builder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM);
        if (null != map) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    if (entry.getValue() instanceof File) {
                        File f = (File) entry.getValue();
                        builder.addFormDataPart(entry.getKey(), f.getName(),
                                RequestBody.create(MEDIA_TYPE_PNG, f));
                        Log.i("FILE",f.getAbsolutePath());
                    } else {
                        builder.addFormDataPart(entry.getKey(), entry
                                .getValue().toString());
                        Log.i("FILE",entry.getValue().toString());
                    }
                }

            }
        }else {
//            builder.addPart();

        }
        // 创建RequestBody
        okhttp3.Request request = null;
//        if (map.get("iconFile")!=null){
        RequestBody body = builder.build();
        request = new okhttp3.Request.Builder().url(url)// 地址
                .post(body)// 添加请求体
                .build();
//        }
//        else {
//            MultipartBody.Builder builder1 = new MultipartBody.Builder()
//                    .setType(MultipartBody.FORM);
//
//            builder.addPart(RequestBody.create(MEDIA_TYPE_PNG, (File) null));
//
//            RequestBody mFormBody = builder1.build();
//            request= new okhttp3.Request.Builder().url(url)// 地址
//                    .post(mFormBody)// 添加请求体
//                    .build();
//        }
        client.newCall(request).enqueue(new CommonJsonCallback(handle));

    }
}