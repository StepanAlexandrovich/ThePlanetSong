package org.example;


import org.example.audibility.Sound;
import org.example.core.Numbers;
import org.example.core.NumbersSmooth;
import org.example.visibility.CanvasFrame;

import java.util.ArrayList;
import java.util.List;

public class UpdateCurrentSong {
    //-------------------------------
    private Numbers numbers;
    private NumbersSmooth numbersSmooth;
    private Sound sound;
    private CanvasFrame canvas;
    private Delay delayCycle;
    //------------------
    private List<Song> songs = new ArrayList<>();

    public UpdateCurrentSong(Numbers numbers, NumbersSmooth numbersSmooth, Sound sound, CanvasFrame canvasFrame, Delay delayCycle) {
        this.numbers = numbers;
        this.numbersSmooth = numbersSmooth;
        this.sound = sound;
        this.canvas = canvasFrame;
        this.delayCycle = delayCycle;
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
        numbersSmooth
                .setSmoothness(song.getSmoothness())
                .apply();
        sound
                .setVolume(song.getVolume())
                .setDuration(song.getDurationSound());
        canvas
                .setAutoMultiplicationX(song.getLengthCycle())
                .setAutoMultiplicationY(song.getLengthCycle()/2);
        delayCycle
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
