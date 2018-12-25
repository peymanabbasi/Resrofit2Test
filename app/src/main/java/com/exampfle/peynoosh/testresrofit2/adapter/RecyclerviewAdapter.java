package com.exampfle.peynoosh.testresrofit2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.exampfle.peynoosh.testresrofit2.Post;
import com.exampfle.peynoosh.testresrofit2.R;

import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder> {


    private Context context;
    private List<Post> posts;

    public RecyclerviewAdapter(Context context , List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =LayoutInflater.from(context).inflate(R.layout.item_recyclerview , viewGroup ,false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Post post = posts.get(i);
        viewHolder.tvTitle.setText(post.getTitle());
        viewHolder.tvBody.setText(post.getBody());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle;
        TextView tvBody;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvBody = itemView.findViewById(R.id.tv_body);
        }
    }
}
