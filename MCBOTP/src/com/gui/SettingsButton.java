package com.gui;

import java.awt.event.MouseListener;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

import java.awt.event.MouseEvent;

public class SettingsButton extends JLabel implements MouseListener {

    JPanel panel;
    Time clock;
    Settings settings;
    JPanel frame;

    SettingsButton(Time clock, JPanel panel, JPanel frame) {
        setIcon(new ImageIcon(createImage("images/Settings.png", 60, 60)));
        addMouseListener(this);
        this.panel = panel;
        this.clock = clock;
        this.frame = frame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        clock.timer.stop();
        settings = new Settings(clock, frame);
        frame.setEnabled(false);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        panel.setBackground(new Color(47, 38, 29));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        panel.setBackground(new Color(71, 64, 55));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        panel.setBackground(new Color(71, 64, 55));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        panel.setBackground(new Color(214,188,153));
    }

    private Image createImage(String filename, int width, int height) {
        Image background = null;
        try {
            InputStream in = Chessboard.class.getResourceAsStream(filename);
            BufferedImage bi = ImageIO.read(in);
            ImageIcon icon = new ImageIcon(bi);
            background = icon.getImage().getScaledInstance(width, height,Image.SCALE_SMOOTH);;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        return background;
    }
}
