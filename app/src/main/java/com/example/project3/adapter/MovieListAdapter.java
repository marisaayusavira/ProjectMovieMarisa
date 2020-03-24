package com.example.project3.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.example.project3.R;
import com.example.project3.model.MovieData;
import com.example.project3.network.Constant;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter <MovieListAdapter.MovieViewHolder> {
    private List<MovieData> movieDatas;
    private  Context context;

    private OnMovieItemSelectedListener onMovieItemSelectedListener;

    public MovieListAdapter(Context context) {
        this.context = context;
        movieDatas = new ArrayList<>();
    }

    public void add(MovieData item){
        movieDatas.add(item);
        notifyItemInserted(movieDatas.size()-1);
    }

    public void addAll(List<MovieData> movieDatas){
        for (MovieData movieData : movieDatas){
            add(movieData);
        }
    }

    public void remove(MovieData item){
        int position = movieDatas.indexOf(item);
        if(position>-1){
            movieDatas.remove(position);
            notifyItemRemoved(position);
        }
    }
    public void clear(){
        while (getItemCount()>0){
            remove(getItem(0));
        }
    }

    private MovieData getItem(int i) {
        return movieDatas.get(i);
    }


    public MovieListAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_movie,viewGroup,false);
        final MovieViewHolder movieViewHolder = new MovieViewHolder(view);
        movieViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPos = movieViewHolder.getAdapterPosition();
                if (adapterPos != RecyclerView.NO_POSITION){
                    if (onMovieItemSelectedListener != null){
                        onMovieItemSelectedListener.onItemClick(movieViewHolder.itemView,adapterPos);
                    }
                }
            }
        });
        return movieViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListAdapter.MovieViewHolder movieViewHolder, int i) {
        final MovieData movieData1 = movieDatas.get(i);
        movieViewHolder.bind(movieData1);
    }

    @Override
    public int getItemCount() {
        return movieDatas.size();
    }

    public void setOnMovieItemSelectedListener
            (OnMovieItemSelectedListener onMovieItemSelectedListener){
        this.onMovieItemSelectedListener = onMovieItemSelectedListener;
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView)itemView.findViewById(R.id.img_data) ;
        }

        public void bind(MovieData movieData1) {
            Picasso.get().load(Constant.IMG_URL + movieData1.getPoster_path()).into(img);
        }
    }

    private interface OnMovieItemSelectedListener {
        void onItemClick(View itemView, int i);
    }
}
