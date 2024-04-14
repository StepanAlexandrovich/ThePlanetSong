package org.example;

import org.example.audibility.Sound;
import org.example.core.Numbers;
import org.example.core.Test;
import org.example.database.QueriesToDataBase;
import org.example.listeners.MouseListenerImpl;
import org.example.visibility.CanvasFrame;
import org.example.visibility.FrameSettings;

public class Main {
    private Numbers numbers = new Numbers();
    //----------------
    private CanvasFrame canvasFrame = new CanvasFrame();
    private Sound sound = new Sound();
    //----------------------
    private UpdateCurrentSong updateCurrentSong = new UpdateCurrentSong(numbers,sound,canvasFrame);
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
        canvasFrame.setMouseListener(new MouseListenerImpl(this));

        //queries.createDataBase();
        queries.initialization();

        updateCurrentSong.setSongs(queries.getSongs());
        current_song = updateCurrentSong.updateSong();

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