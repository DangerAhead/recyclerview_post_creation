package com.hfad.post_example2;

import java.io.File;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {

    String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJtb2JpbGVObyI6IjExMTExMTExMTEiLCJ1c2VySWQiOiI1ZWRmZjEzYTRlZjEwMDBkMzQ4MjVmN2MiLCJpYXQiOjE1OTIxMjMyOTksImV4cCI6MTU5MjE0NDg5OX0.6Juxzt_4-llZp4u96mllvmuqN59cVK83EjwqXKuOIdo";

    @Multipart
    @Headers("authorization: "+token)
    @POST("posts")
    Call<RequestBody> uploadMultiFile(@Part MultipartBody.Part part, @Part("text") RequestBody requestBody);

}
