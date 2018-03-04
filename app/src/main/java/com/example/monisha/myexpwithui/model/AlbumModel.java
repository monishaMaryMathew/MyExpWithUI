package com.example.monisha.myexpwithui.model;

import java.util.List;

/**
 * Created by Monisha on 2/6/2018.
 */

public class AlbumModel {
    String albumName;
    String genre;
    List<SongModel> songList;
    boolean buy;

    public AlbumModel(String albumName, String genre, List<SongModel> songList, boolean buy) {
        this.albumName = albumName;
        this.genre = genre;
        this.songList = songList;
        this.buy = buy;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<SongModel> getSongList() {
        return songList;
    }

    public void setSongList(List<SongModel> songList) {
        this.songList = songList;
    }

    public boolean isBuy() {
        return buy;
    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }
}
