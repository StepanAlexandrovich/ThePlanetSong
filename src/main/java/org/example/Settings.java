package org.example;


import org.example.audibility.Sound;
import org.example.core.Numbers;
import org.example.visibility.CanvasFrame;

import java.util.ArrayList;
import java.util.List;

public class Settings {
    // NAMES
    public final static String LENGTH_CYCLE = "LENGTH_CYCLE";
    public final static String COUNT_OF_POINTS = "COUNT_OF_POINTS";
    public final static String MODE = "MODE";
    public final static String BORDER_DOWN = "BORDER_DOWN";
    public final static String MULTIPLICATION_HZ = "MULTIPLICATION_HZ";
    public final static String VOLUME = "VOLUME";
    public final static String SPEED = "SPEED";

    //-------------------------------
    private Numbers numbers;
    private Sound sound;
    private CanvasFrame canvas;
    //------------------
    private List<Song> songs = new ArrayList<>();

    public Settings(Numbers numbers, Sound sound, CanvasFrame canvasFrame) {
        this.numbers = numbers;
        this.sound = sound;
        this.canvas = canvasFrame;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void updateSong(Song song){
        numbers
                .setDistance(song.getLengthCycle())
                .setCountOfPoints(song.getCountOfPoints())
                .setMode(song.getMode())
                .setBorderDown(song.getBorderDown())
                .setMultiplicationHz(song.getMultiplicationHz())
                .apply();
        sound
                .setVolume(song.getVolume())
                .setSpeed(song.getSpeed());
        canvas
                .setAutoMultiplications(song.getLengthCycle());
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

    public void song0(){
        int lengthCycle = 2*3*4;

        numbers
                .setDistance(lengthCycle)
                .setCountOfPoints(20)
                .setMode("UP")
                .setBorderDown(0)
                .setMultiplicationHz(20)
                .apply();
        sound
                .setVolume(5)
                .setSpeed(1000);
        canvas
                .setAutoMultiplications(lengthCycle);
    }

    public void song1(){
        int lengthCycle = 2*3*4;
        numbers
                .setDistance(lengthCycle)
                .setCountOfPoints(22)
                .setMode("UP")
                .setBorderDown(0)
                .setMultiplicationHz(20)
                .apply();
        sound
                .setVolume(5)
                .setSpeed(1000);
        canvas
                .setAutoMultiplications(lengthCycle);
    }

    public void song2(){
        int lengthCycle = 24*4;
        numbers
                .setDistance(lengthCycle)
                .setCountOfPoints(24*4)
                .setMode("DOWN")
                .setBorderDown(5)
                .setMultiplicationHz(10)
                .apply();
        sound
                .setVolume(5)
                .setSpeed(500);
        canvas
                .setAutoMultiplications(lengthCycle);
    }
    public void song3(){
        int lengthCycle = 4*7*9;
        numbers
                .setDistance(lengthCycle)
                .setCountOfPoints(lengthCycle)
                .setMode("DOWN")
                .setBorderDown(100)
                .setMultiplicationHz(1)
                .apply();
        sound
                .setVolume(5)
                .setSpeed(500);
        canvas
                .setAutoMultiplications(lengthCycle);
    }
    public void song4(){
        int lengthCycle = 3*4*5*6;
        numbers
                .setDistance(lengthCycle)
                .setCountOfPoints(lengthCycle)
                .setMode("DOWN")
                .setBorderDown(100)
                .setMultiplicationHz(1)
                .apply();
        sound
                .setVolume(5)
                .setSpeed(600);
        canvas
                .setAutoMultiplications(lengthCycle);
    }
    public void song5(){
        int lengthCycle = 4*5*6*7;
        numbers
                .setDistance(lengthCycle)
                .setCountOfPoints(lengthCycle)
                .setMode("DOWN")
                .setBorderDown(200)
                .setMultiplicationHz(0.5)
                .apply();
        sound
                .setVolume(5)
                .setSpeed(600);
        canvas
                .setAutoMultiplications(lengthCycle);
    }
    // UP DOWN
    public void song6(){
        int lengthCycle = 3*6*9;
        numbers
                .setDistance(lengthCycle)
                .setCountOfPoints(lengthCycle)
                .setMode("DOWN")
                .setBorderDown(200)
                .setMultiplicationHz(0.5)
                .apply();
        sound
                .setVolume(5)
                .setSpeed(600);
        canvas
                .setAutoMultiplications(lengthCycle);
    }
    public void song7(){
        int lengthCycle = 3*4*7*11;
        //int lengthCycle = 3*4*7*7;
        numbers
                .setDistance(lengthCycle)
                .setCountOfPoints(lengthCycle)
                .setMode("DOWN")
                .setBorderDown(200)
                .setMultiplicationHz(0.5)
                .apply();
        sound
                .setVolume(5)
                .setSpeed(600);
        canvas
                .setAutoMultiplications(lengthCycle);
    }

}
