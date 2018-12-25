package com.exampfle.peynoosh.testresrofit2;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Adapter;
import android.widget.Toast;

import com.exampfle.peynoosh.testresrofit2.adapter.RecyclerviewAdapter;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = "TAG";
    RecyclerView recyclerView;
    serveeApi serveeApi;
    RecyclerviewAdapter  adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        serveeApi.getPosts(this, new serveeApi.OnPostsReceived() {
            @Override
            public void onReceived(List<Post> posts) {
                Post post = posts.get(2);
                Log.i(TAG, "onReceived: " + post.getBody());
                adapter = new RecyclerviewAdapter(MainActivity.this , posts);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this , LinearLayoutManager.VERTICAL ,false));
                recyclerView.setAdapter(adapter);
            }
        });

    }

    public void init() {
        recyclerView = findViewById(R.id.recyclerview);
        serveeApi = new serveeApi();

    }
}
