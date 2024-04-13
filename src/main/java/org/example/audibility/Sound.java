package org.example.audibility;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class Sound {
    /////// sound
    private AudioFormat af;
    private SourceDataLine sdl;
    private byte[] buf = new byte[1];

    private int volume,speed;

    public Sound setVolume(int volume) {
        this.volume = volume;
        return this;
    }

    public Sound setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    public Sound() {

        try {
            af = new AudioFormat(44100,8,1,true,false);
            sdl = AudioSystem.getSourceDataLine(af);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public void process(int hz){
        try {
            tone(hz,speed,volume);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public void tone(int hz, int msecs, double vol)throws LineUnavailableException {
        double forAngle = (double)hz/2000;

        for (int i=0; i < msecs*8; i++) {
            double angle = i*forAngle;
            buf[0] = (byte)(Math.sin(angle) * vol);
            sdl.write(buf,0,1);
        }

    }

    public void open(){
        try {
            sdl.open(af);
            sdl.start();
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public void close(){
        sdl.drain();
        sdl.stop();
        sdl.close();
    }
}
