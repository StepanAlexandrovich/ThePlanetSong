package org.example.visibility;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Render {
    private int width,height,margin;
    private int widthIn,heightIn;
    private double multiplicationX,multiplicationY;
    //-------------------------
    private BufferedImage image;
    private Graphics2D g;
    //-----------------
    private int step = 0;


    public Render(int width, int height, int margin) {
        this.width = width;
        this.height = height;
        this.margin = margin;

        this.widthIn = width - 2 * margin;
        this.heightIn = height - 2 * margin;

        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g = image.createGraphics();
    }

    // get -----
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public BufferedImage getImage(){ return image; }

    // set ------
    public void setMultiplication(double multiplicationX,double multiplicationY) {
        this.multiplicationX = multiplicationX;
        this.multiplicationY = multiplicationY;
    }

    public void setAutoMultiplication(int countOfPoints){
        multiplicationX = (double)widthIn/(double)countOfPoints;
        multiplicationY = (double)heightIn/(double)countOfPoints;
    }

    public void process(int[] values) {
        g.setColor(Color.GREEN);
        g.fillRect(0,0,width,height);

        for (int i = 0; i<values.length; i++) {
            int x = (int) ((double)values[i]*multiplicationX) + margin;
            int y = (int) ((double)i*multiplicationY) + margin;

            if(i==0){ g.setColor(Color.RED); } else
            if(i >0){ g.setColor(Color.BLACK); }

            g.fillOval(x-5,y-5,10,10);
        }
    }
}
