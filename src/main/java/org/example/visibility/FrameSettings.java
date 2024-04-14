package org.example.visibility;

import org.example.Helper;
import org.example.PS;
import org.example.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class FrameSettings extends JFrame{
    private List<JTextField> fields = new ArrayList<>();
    private boolean process = true;
    private Song song;



    public FrameSettings(Song song) {
        /////////
        this.song = song;
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                process = false;
            }
        });
        ////////

        this.setBounds(0,0,300,400);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));

        this.add(createPanel(PS.LENGTH_CYCLE,"96"));
        this.add(createPanel(PS.COUNT_OF_POINTS,"96"));
        this.add(createPanel(PS.MODE,"DOWN"));
        this.add(createPanel(PS.BORDER_DOWN,"0"));
        this.add(createPanel(PS.MULTIPLICATION_HZ,"10"));
        this.add(createPanel(PS.VOLUME,"5"));
        this.add(createPanel(PS.SPEED,"500"));

        this.add(createButton("apply"));

        this.setVisible(true);
    }

    public JPanel createPanel(String text,String value){
        JPanel panel = new JPanel();
        panel.setToolTipText(text);
        panel.setPreferredSize(new Dimension(280,40));

        JTextField field = new JTextField(value);
        field.setPreferredSize(new Dimension(130,30));
        field.setName(text);
        fields.add(field);

        JLabel label = new JLabel(text);
        label.setPreferredSize(new Dimension(130,30));

        panel.add(field);
        panel.add(label);
        return panel;
    }

    public JButton createButton(String text){
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(250,40));
        button.addMouseListener(new MouseListenerInner());
        return button;
    }

    class MouseListenerInner implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            for (JTextField field : fields) {
                switch (field.getName()){
                    case PS.LENGTH_CYCLE: song.setLengthCycle(Integer.parseInt(field.getText())); break;
                    case PS.COUNT_OF_POINTS: song.setCountOfPoints(Integer.parseInt(field.getText())); break;
                    case PS.MODE: song.setMode(field.getText()); break;
                    case PS.BORDER_DOWN: song.setBorderDown(Integer.parseInt(field.getText())); break;
                    case PS.MULTIPLICATION_HZ: song.setMultiplicationHz(Double.parseDouble(field.getText())); break;
                    case PS.VOLUME: song.setVolume(Integer.parseInt(field.getText())); break;
                    case PS.SPEED: song.setSpeed(Integer.parseInt(field.getText())); break;
                }
            }

            process = false;
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    }


    public Song process(){
        while(process){
            Helper.sleep(10);
        }
        this.dispose();
        return song;
    }
}
