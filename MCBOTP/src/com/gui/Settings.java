package com.gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.awt.Point;

public class Settings extends JDialog implements ActionListener {
    
    private JPanel settingsPanel;
    private JButton okay, cancel;
    private Time clock;
    private JPanel frame;

    Settings(Time clock, JPanel frame) {
        this.clock = clock;
        this.frame = frame;
        Thread settings = new Thread(new Runnable() {

            @Override
            public void run() { 
                initialize();
                showSettings();
            }
            
        });
        settings.start();
    }

    public void showSettings() {
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 700;
        int height = 500;
        setBounds(center.x - width / 2, center.y - height / 2, width, height);
        setUndecorated(true);
        getContentPane().add(getSettingsPanel());
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void initialize() {
        settingsPanel = new JPanel(new FlowLayout());
        settingsPanel.setBackground(new Color(150, 136, 118));
        settingsPanel.setBorder(new LineBorder(new Color(127, 107, 89), 5));

        okay = new JButton("Okay");
        okay.addActionListener(this);

        settingsPanel.add(okay);
    }

    public JPanel getSettingsPanel() {
        return settingsPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okay) {
            clock.timer.start();
            frame.setEnabled(true);
            dispose();
        }
    }
}
