package com.example.monisha.myexpwithui.model;

/**
 * Created by Monisha on 2/6/2018.
 */

public class SongModel {
    String songName;
    int songDuration;

    public SongModel(String songName, int songDuration) {
        this.songName = songName;
        this.songDuration = songDuration;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(int songDuration) {
        this.songDuration = songDuration;
    }
}
