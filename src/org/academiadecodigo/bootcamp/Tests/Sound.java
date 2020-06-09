package org.academiadecodigo.bootcamp.Tests;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Sound {

    JFrame window;
    Container con;
    JPanel buttonPanel;
    JButton soundButton;
    String ballSound;
    ButtonHandler bHandler = new ButtonHandler();
    SoundEffect se = new SoundEffect();

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        new Sound();

    }
    public Sound() {
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        con = window.getContentPane();


        buttonPanel = new JPanel();
        buttonPanel.setBounds(300, 300, 200, 100);
        buttonPanel.setBackground(Color.BLUE);
        con.add(buttonPanel);

        soundButton = new JButton("Testing sound");
        soundButton.setFocusPainted(false);
        soundButton.addActionListener(bHandler);
        buttonPanel.add(soundButton);

        window.setVisible(true);

        ballSound = "resources/testeSound.wav";

    }

    public class SoundEffect {
        Clip clip;

        public void setFile(String soundFileName) {

            try {
                File file = new File(soundFileName);
                AudioInputStream sound = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(sound);

            } catch (Exception e) {

            }
        }

        public void play() {
            clip.setFramePosition(0);
            clip.start();

        }
    }

    public class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            se.setFile(ballSound);
            se.play();
        }
    }
}


