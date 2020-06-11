package org.academiadecodigo.bootcamp.Tests;

import java.io.File;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Sound {

    //URL beepURL = Sound.class.getResource("resources/testeSound.wav");

    private static String themeSong = "resources/tada.wav";
    static SoundEffect theme1 = new SoundEffect();

    private static String ballSound = "resources/testeSound.wav";
    static SoundEffect se = new SoundEffect();

    private static String pepinoSound = "resources/pipino.wav";
    static SoundEffect se2 = new SoundEffect();

    private static String meowSound = "resources/meow.wav";
    static SoundEffect se3 = new SoundEffect();

    private static String babySound = "resources/baby.wav";
    static SoundEffect se4 = new SoundEffect();

    private static String gameOverSound = "resources/gameover.wav";
    static SoundEffect se5 = new SoundEffect();

    private static String winSound = "resources/win.wav";
    static SoundEffect se6 = new SoundEffect();

    private static String tadaSound = "resources/tada.wav";
    static SoundEffect se7 = new SoundEffect();

    public static void playEntryThemeSong() {
        theme1.setFile(themeSong);
        theme1.play();
    }

    public static void playBallEffect() {
        se.setFile(ballSound);
        se.play();
    }

    public static void playPipinoDNovo() {
        se2.setFile(pepinoSound);
        se2.play();
    }

    public static void playMeow() {
        se3.setFile(meowSound);
        se3.play();
    }

    public static void playBaby() {
        se4.setFile(babySound);
        se4.play();
    }

    public static void playGameOverSound() {
        se5.setFile(gameOverSound);
        se5.play();
    }

    public static void playWinSound() {
        se6.setFile(winSound);
        se6.play();
    }

    public static void playTadaSound() {
        se7.setFile(tadaSound);
        se7.play();
    }




    public static class SoundEffect {
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

}


