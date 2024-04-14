package org.example;


import org.example.audibility.Sound;
import org.example.core.Numbers;
import org.example.visibility.CanvasFrame;

import java.util.ArrayList;
import java.util.List;

public class UpdateCurrentSong {
    //-------------------------------
    private Numbers numbers;
    private Sound sound;
    private CanvasFrame canvas;
    private Delay delay;
    //------------------
    private List<Song> songs = new ArrayList<>();

    public UpdateCurrentSong(Numbers numbers, Sound sound, CanvasFrame canvasFrame,Delay delay) {
        this.numbers = numbers;
        this.sound = sound;
        this.canvas = canvasFrame;
        this.delay = delay;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void updateSong(Song song){
        numbers
                .setDistance(song.getLengthCycle())
                .setMode(song.getMode())
                .setBorderDown(song.getBorderDown())
                .setMultiplicationHz(song.getMultiplicationHz())
                .apply();
        sound
                .setVolume(song.getVolume())
                .setDuration(song.getDurationSound());
        canvas
                .setAutoMultiplicationX(song.getLengthCycle())
                .setAutoMultiplicationY(song.getLengthCycle()/2);
        delay
                .setDelay(song.getDelayCycle());
    }

    int numberOfSong = -1;
    public Song updateSong(){
        if(songs.size()>0){
            if(numberOfSong + 1 < songs.size()){
                numberOfSong++;
            }else{
                numberOfSong = 0;
            }
            updateSong(songs.get(numberOfSong));
            return songs.get(numberOfSong);
        }
        return new Song();
    }

}
