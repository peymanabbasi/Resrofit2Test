package com.exampfle.peynoosh.testresrofit2;

import android.content.Context;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class serveeApi {

    Retrofit retrofit;

    public void getPosts(final Context context , final OnPostsReceived onPostsReceived) {


        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();


        MyApi myApi = retrofit.create(MyApi.class);
        myApi.getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                List<Post> posts = response.body();
                onPostsReceived.onReceived(posts);


            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {



                Toast.makeText(context, "Connection is failed:res Cod=" + call.request().headers(), Toast.LENGTH_LONG).show();
            }
        });


    }

    public interface OnPostsReceived{

        void onReceived(List<Post> posts);
    }
}
