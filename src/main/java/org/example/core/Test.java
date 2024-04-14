package org.example.core;

import org.example.audibility.Sound;
public class Test {
    int t = 0;
    int mult = 7;
    void test(Sound sound){
        if(++t == 4){ t = 1; }

        if(t == 1){
            sound.process(16*mult);
        }else
        if(t == 2){
            sound.process(12*mult);
        }else
        if(t == 3){
            sound.process(22*mult);
        }

    }
}
