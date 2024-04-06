package org.example.core;

public abstract class NextValue {
    public int length;
    public int[] table;
    public int back = 0,now = 1,next = 2;

    public NextValue(int length) {
        this.length = length;
        this.table = new int[length];

        for (int i = 0; i < table.length - 1; i++) {
            table[i] = i + 1;
        }
    }

    public int[] getIntArray(int[] array){
        int[] duplicate = new int[array.length];
        int nowDuplicate = next;
        for (int i = 0; i < length; i++) {
            duplicate[i] = array[nowDuplicate];
            nowDuplicate = table[nowDuplicate];
        }
        return duplicate;
    }
    public NextValue process(){
        nextValue();
        back = table[back];
        now = table[now];
        next = table[next];
        return this;
    }
    public abstract void nextValue();
}
