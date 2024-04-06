package org.example;


import org.example.audibility.Sound;
import org.example.core.Numbers;
import org.example.visibility.CanvasFrame;

public class Settings {
    private Numbers numbers;
    private Sound sound;
    private CanvasFrame canvas;

    public Settings(Numbers numbers, Sound sound, CanvasFrame canvasFrame) {
        this.numbers = numbers;
        this.sound = sound;
        this.canvas = canvasFrame;
    }

    int numberOfSong = -1;
    public void updateSong(){
        if(++numberOfSong == 8){
            numberOfSong = 0;
        }

        switch (numberOfSong){
            case 0: song0(); break;
            case 1: song1(); break;
            case 2: song2(); break;
            case 3: song3(); break;
            case 4: song4(); break;
            case 5: song5(); break;
            case 6: song6(); break;
            case 7: song7(); break;
        }
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
