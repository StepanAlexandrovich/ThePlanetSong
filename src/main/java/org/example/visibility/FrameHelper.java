package org.example.visibility;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class FrameHelper {
    // components
    public JButton createButton(int x, int y, int width, int height, String text){
        JButton button = new JButton(text);
        button.setName(text);
        button.setBounds(x,y,width,height);
        return button;
    }
    public JPanel createPanel(int width, int height){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(width,height));
        return panel;
    }

    public JLabel createLabel(int x,int y,int width, int height, BufferedImage image){
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(image));
        label.setBounds(x,y,width,height);
        return label;
    }
}
