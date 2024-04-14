package org.example.visibility;

import org.example.PS;
import org.example.core.PointSmooth;

import javax.swing.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class CanvasFrame extends JFrame {
    private FrameHelper helper = new FrameHelper();
    //options
    private int widthCanvas = 800,heightCanvas = 800,marginCanvas = 5;
    private int widthButton = 100,heightButton = 50;
    private int widthFrame = widthCanvas,heightFrame = heightCanvas + heightButton;
    //------------
    public Render render = new Render(widthCanvas,heightCanvas,marginCanvas);
    // components
    private List<JButton> buttons;
    public CanvasFrame() {
        // create components
        JPanel panel = helper.createPanel(widthFrame,heightFrame);

        JLabel label = helper.createLabel(0,0,widthCanvas,heightCanvas,render.getImage());
        buttons = new ArrayList<>();
        buttons.add(helper.createButton(widthButton*0,heightCanvas,widthButton,heightButton,PS.CYCLE));
        buttons.add(helper.createButton(widthButton*1,heightCanvas,widthButton,heightButton,PS.NEXT));
        buttons.add(helper.createButton(widthButton*2,heightCanvas,widthButton,heightButton,PS.SETTINGS));
        buttons.add(helper.createButton(widthButton*3,heightCanvas,widthButton,heightButton,PS.ADD_CURRENT_SONG));
        buttons.add(helper.createButton(widthButton*4,heightCanvas,widthButton,heightButton,PS.EXIT));

        // add to panel
        panel.add(label);
        for (JButton button : buttons) {
            panel.add(button);
        }

        // add to Frame
        add(panel);

        // final
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void update(List<PointSmooth> pointSmooths){
        render.process(pointSmooths);
        repaint();
    }

    // set
    public void setMouseListener(MouseListener mouseListener){
        for (JButton button : buttons) {
            button.addMouseListener(mouseListener);
        }
    }
    public CanvasFrame setAutoMultiplicationX(int countOfPoints){
        render.setAutoMultiplicationX(countOfPoints);
        return this;
    }

    public CanvasFrame setAutoMultiplicationY(int maxSpeed){
        render.setAutoMultiplicationY(maxSpeed);
        return this;
    }
}
