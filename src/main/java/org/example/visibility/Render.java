package org.example.visibility;

import org.example.core.PointSmooth;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

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
    // set ------
    public void setMultiplication(double multiplicationX,double multiplicationY) {
        this.multiplicationX = multiplicationX;
        this.multiplicationY = multiplicationY;
    }

    public void setAutoMultiplicationX(int countOfPoints){
        multiplicationX = (double)widthIn/(double)countOfPoints;
    }

    public void setAutoMultiplicationY(int maxSpeed){
        multiplicationY = (double)heightIn/(double)maxSpeed;
    }

    public void process(List<PointSmooth> points) {
        g.setColor(Color.GREEN);
        g.fillRect(0,0,width,height);

        g.setColor(Color.BLACK);
        for (PointSmooth point : points) {
            int x = (int) (point.getDistance()*multiplicationX) + margin;
            int y = (int) (point.getSpeed()*multiplicationY) + margin;

            g.fillOval(x-5,y-5,10,10);
        }
    }
}
