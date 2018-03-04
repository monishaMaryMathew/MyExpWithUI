package com.example.monisha.myexpwithui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.monisha.myexpwithui.R;
import com.example.monisha.myexpwithui.model.SongModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Monisha on 2/6/2018.
 */

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.MySongViewHolder>{
    private List<SongModel> songList = new ArrayList<>();

    public SongAdapter(List<SongModel> songList) {
        this.songList = songList;
    }

    public class MySongViewHolder extends RecyclerView.ViewHolder {
        public TextView songName, duration;
        public MySongViewHolder(View itemView){
            super(itemView);
            songName = (TextView) itemView.findViewById(R.id.songNameTV);
            duration = (TextView) itemView.findViewById(R.id.durationTV);
        }
    }

    @Override
    public MySongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_item_layout, parent, false);
        return new MySongViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SongAdapter.MySongViewHolder holder, int position) {
        SongModel song = songList.get(position);
        holder.songName.setText(song.getSongName());
        holder.duration.setText(String.valueOf(String.valueOf(song.getSongDuration())));
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }
}
