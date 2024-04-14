package org.example;

import org.example.audibility.Sound;
import org.example.core.Numbers;
import org.example.core.NumbersSmooth;
import org.example.core.Test;
import org.example.database.QueriesToDataBase;
import org.example.listeners.MouseListenerImpl;
import org.example.visibility.CanvasFrame;
import org.example.visibility.FrameSettings;

public class Main {
    private Numbers numbers = new Numbers();
    private NumbersSmooth numbersSmooth = new NumbersSmooth();
    //----------------
    private CanvasFrame canvasFrame = new CanvasFrame();
    private Sound sound = new Sound();
    private Delay delay = new Delay();
    //----------------------
    private UpdateCurrentSong updateCurrentSong = new UpdateCurrentSong(numbers,numbersSmooth,sound,canvasFrame,delay);
    private QueriesToDataBase queries = new QueriesToDataBase();
    private Song current_song = null;

    //-----------------------
    //----------------------
    Test test = new Test();
    enum Mode{PROCESS,PAUSE,EXIT,NEXT,SETTINGS,ADD_CURRENT_SONG}
    Mode mode = Mode.PROCESS;

    public static void main(String[] args) {
        new Main().start();
    }

    private void start(){
        numbersSmooth.setNumbers(numbers);
        canvasFrame.setMouseListener(new MouseListenerImpl(this));

        //queries.createDataBase();
        queries.initialization();

        updateCurrentSong.setSongs(queries.getSongs());
        current_song = updateCurrentSong.updateSong();

        sound.open();

        while (true){
            delay.process();

            switch (mode){
                case PROCESS :
                    if(numbersSmooth.beat()){
                        new Thread(()->{ sound.process((numbersSmooth.getValue())); }).start();
                    }

                    canvasFrame.update(numbersSmooth.getPointSmooths());
                    numbersSmooth.process();

                    //test.test(sound);
                    break;
                case NEXT:
                    current_song = updateCurrentSong.updateSong();
                    mode = Mode.PROCESS;
                    break;
                case SETTINGS:
                    current_song = new FrameSettings(current_song).process();
                    updateCurrentSong.updateSong(current_song);
                    mode = Mode.PROCESS;
                    break;
                case ADD_CURRENT_SONG:
                    queries.addSong(current_song);
                    updateCurrentSong.setSongs(queries.getSongs());
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
    public void settings() { mode = Mode.SETTINGS; }
    public void addCurrentSong() { mode = Mode.ADD_CURRENT_SONG; }
    public void exit(){
        mode = Mode.EXIT;
    }
}