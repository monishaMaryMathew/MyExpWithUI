package com.example.monisha.myexpwithui.adapter;

import android.app.Activity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.monisha.myexpwithui.R;
import com.example.monisha.myexpwithui.model.AlbumModel;

import java.util.List;

/**
 * Created by Monisha on 2/6/2018.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {
    private List<AlbumModel> albumList;
    private Activity activity;

    public class AlbumViewHolder extends RecyclerView.ViewHolder{
        public TextView albumName, genreName;
        public RadioButton buy;
        public android.support.v7.widget.RecyclerView songListRecyclerView;


         public AlbumViewHolder(View itemView) {
            super(itemView);
             albumName = (TextView) itemView.findViewById(R.id.albumNameTV);
             genreName = (TextView) itemView.findViewById(R.id.genreTV);
             buy = (RadioButton) itemView.findViewById(R.id.buyRadioButton);
             songListRecyclerView = (RecyclerView) itemView.findViewById(R.id.songRecyclerviewLayout);
        }
    }

    public AlbumAdapter(List<AlbumModel> albumList, Activity activity) {
        this.albumList = albumList;
        this.activity = activity;
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the view and attach it to the parent
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_item_layout, parent, false);
        return new AlbumViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, int position) {
        //bind the data to the view
        AlbumModel album = albumList.get(position);
        holder.albumName.setText(album.getAlbumName());
        holder.genreName.setText(album.getGenre());
        holder.buy.setChecked(album.isBuy());
        //set the song list recycler view

        //define a LayoutManager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(activity.getApplicationContext());
        //set layout manager
        holder.songListRecyclerView.setLayoutManager(layoutManager);
        //set animator
        holder.songListRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //set adapter
        SongAdapter adapter = new SongAdapter(album.getSongList());
        holder.songListRecyclerView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
