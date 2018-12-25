package com.exampfle.peynoosh.testresrofit2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApi {
   @GET("posts")
   Call<List<Post>> getPosts();
}



