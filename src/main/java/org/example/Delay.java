package org.example;


import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Delay {
    private long now,back;
    private long delay;

    public Delay() {}
    public Delay(long delay) {
        this.delay = delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public void process(){
        back = now;
        now = Timestamp.valueOf(LocalDateTime.now()).getTime();

        long currentDelay = now - back;

        if(currentDelay>delay){ return; }
        else{ Helper.sleep(delay - currentDelay); }
    }

}
