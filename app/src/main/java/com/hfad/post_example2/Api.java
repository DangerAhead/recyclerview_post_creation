package com.hfad.post_example2;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface Api {

    String BASE_URL = "https://community-ebh.herokuapp.com/";
    String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJtb2JpbGVObyI6IjExMTExMTExMTEiLCJ1c2VySWQiOiI1ZWRmZjEzYTRlZjEwMDBkMzQ4MjVmN2MiLCJpYXQiOjE1OTIyOTYwODcsImV4cCI6MTU5MjMxNzY4N30.bcmriTSBAq_a0o7tz292dik58845a9R3y7beWVjK62E";

    @Multipart
    @Headers("authorization: "+token)
    @POST("posts")
    Call<MyResponse> uploadImage(@Part List<MultipartBody.Part> file, @Part("text") RequestBody post_text);

}
