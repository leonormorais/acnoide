package org.academiadecodigo.bootcamp.Tests;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Sound {

    private static String ballSound = "resources/testeSound.wav";
    static SoundEffect se = new SoundEffect();

     /* IMPLEMENT A NEW SONG.
    private static String ballSound = "resources/testeSound.wav"; //source file
    static SoundEffect se = new SoundEffect(); //create object for the clip
    */

    private static String pepinoSound = "resources/pipino.wav";
    static SoundEffect se2 = new SoundEffect();

    public static void playBallEffect() {
        se.setFile(ballSound);
        se.play();
    }

    public static void playPipinoDNovo() {
        se2.setFile(pepinoSound);
        se2.play();
    }

    /* IMPLEMENT A NEW SONG. //method for play song from any class
    public static void newSong() {
        se.setFile(ballSound);
        se.play();
    }
    */


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


