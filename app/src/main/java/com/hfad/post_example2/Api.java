package com.hfad.post_example2;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface Api {

    String BASE_URL = "http://894ba8888af2.ngrok.io/";
    String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJtb2JpbGVObyI6IjExMTExMTExMTEiLCJ1c2VySWQiOiI1ZWRmZjEzYTRlZjEwMDBkMzQ4MjVmN2MiLCJpYXQiOjE1OTIyMTIxNDEsImV4cCI6MTU5MjIzMzc0MX0.XokM6fAwAwg95sDclzs-hece16LhrImRx1zB66ED41Y";

    @Multipart
    @Headers("authorization: "+token)
    @POST("posts")
    Call<MyResponse> uploadImage(@Part("postMedia") RequestBody file);

}
