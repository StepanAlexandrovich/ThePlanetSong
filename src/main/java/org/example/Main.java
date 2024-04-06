package org.example;

import org.example.audibility.Sound;
import org.example.core.Numbers;
import org.example.core.Test;
import org.example.listeners.MouseListenerImpl;
import org.example.visibility.CanvasFrame;

public class Main {
    Numbers numbers = new Numbers();
    //----------------
    CanvasFrame canvasFrame = new CanvasFrame();
    Sound sound = new Sound();
    //----------------------
    Settings settings = new Settings(numbers,sound,canvasFrame);
    //-----------------------
    //----------------------
    Test test = new Test();
    enum Mode{PROCESS,PAUSE,EXIT,NEXT}
    Mode mode = Mode.PROCESS;

    public static void main(String[] args) {
        new Main().start();
    }

    private void start(){
        canvasFrame.setMouseListener(new MouseListenerImpl(this));

        settings.updateSong();

        sound.open();

        while (true){
            Helper.sleep(1);
            switch (mode){
                case PROCESS :
                    canvasFrame.update(numbers.getDistances());
                    sound.process((int)(numbers.getValue()));

                    numbers.process();

                    //test.test(sound);
                    break;
                case NEXT:
                    settings.updateSong();
                    mode = Mode.PROCESS;
                    break;
                case EXIT:
                    sound.close();
                    canvasFrame.dispose();
                    return;
            }

        }
    }
    public void startStop(){
        if(mode == Mode.PROCESS){
            mode = Mode.PAUSE;
        }else
        if(mode == Mode.PAUSE){
            mode = Mode.PROCESS;
        }
    }

    public void nextSong(){
        mode = Mode.NEXT;
    }

    public void exit(){
        mode = Mode.EXIT;
    }
}