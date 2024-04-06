/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Helper {
    
    public int ring(int vel,int min,int max){
       if(vel<min)  { vel = vel + (max - min + 1); }
       if(vel>max)  { vel = vel - (max - min + 1); }
       return vel;  
    }
    
    public int border(int vel,int min, int max){
        if(vel>max){ vel = max; }
        if(vel<min){ vel = min; }
        return vel;
    }
    
    public static void sleep(int value){
        try {
            Thread.sleep(value);
        } catch (InterruptedException ex) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
