package org.academiadecodigo.bootcamp;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import javax.sound.sampled.*;

public class Sound {

    Clip themeSong;
    Clip gameSong;
    Clip lastSong;
    Clip ballSound;
    Clip pepinoSound;
    Clip meowSound;
    Clip babySound;
    Clip gameOverSound;
    Clip winSound;
    Clip tadaSound;
    Clip ritaSound;
    Clip vandoSound;


    public void stopPosGameSong(){
        try {
            lastSong.close();
        } catch (Exception e) {

        }
    }

    public void stopGameSong() {
        try {
            gameSong.close();
        } catch (Exception e) {

        }
    }

    public void stopThemeSong() {
        try {
            themeSong.close();
        } catch (Exception e) {

        }
    }



    public void playEntryThemeSong() {
        try {
            InputStream audiosrc = getClass().getResourceAsStream("resources/entryTheme.wav");
            InputStream bufferedIn = new BufferedInputStream(audiosrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);

            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            themeSong = (Clip) AudioSystem.getLine(info);
            themeSong.open(audioStream);
            themeSong.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void playGameSong() {
        try {
            InputStream audiosrc = getClass().getResourceAsStream("resources/themesong.wav");
            InputStream bufferedIn = new BufferedInputStream(audiosrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);

            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            gameSong = (Clip) AudioSystem.getLine(info);
            gameSong.open(audioStream);
            gameSong.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void playPosGameSong() {
        try {
            InputStream audiosrc = getClass().getResourceAsStream("resources/lastsong.wav");
            InputStream bufferedIn = new BufferedInputStream(audiosrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);

            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            lastSong = (Clip) AudioSystem.getLine(info);
            lastSong.open(audioStream);
            lastSong.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void playBallEffect() {
        try {
            InputStream audiosrc = getClass().getResourceAsStream("resources/testeSound.wav");
            InputStream bufferedIn = new BufferedInputStream(audiosrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);

            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            ballSound = (Clip) AudioSystem.getLine(info);
            ballSound.open(audioStream);
            ballSound.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void playPipinoDNovo() {
        try {
            InputStream audiosrc = getClass().getResourceAsStream("resources/pipino.wav");
            InputStream bufferedIn = new BufferedInputStream(audiosrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);

            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            pepinoSound = (Clip) AudioSystem.getLine(info);
            pepinoSound.open(audioStream);
            pepinoSound.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void playMeow() {
        try {
            InputStream audiosrc = getClass().getResourceAsStream("resources/meow.wav");
            InputStream bufferedIn = new BufferedInputStream(audiosrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);

            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            meowSound = (Clip) AudioSystem.getLine(info);
            meowSound.open(audioStream);
            meowSound.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void playBaby() {
        try {
            InputStream audiosrc = getClass().getResourceAsStream("resources/baby.wav");
            InputStream bufferedIn = new BufferedInputStream(audiosrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);

            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            babySound = (Clip) AudioSystem.getLine(info);
            babySound.open(audioStream);
            babySound.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void playGameOverSound() {
        try {
            InputStream audiosrc = getClass().getResourceAsStream("resources/gameover.wav");
            InputStream bufferedIn = new BufferedInputStream(audiosrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);

            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            gameOverSound = (Clip) AudioSystem.getLine(info);
            gameOverSound.open(audioStream);
            gameOverSound.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void playWinSound()  {
        try {
            InputStream audiosrc = getClass().getResourceAsStream("resources/win.wav");
            InputStream bufferedIn = new BufferedInputStream(audiosrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);

            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            winSound = (Clip) AudioSystem.getLine(info);
            winSound.open(audioStream);
            winSound.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void playTadaSound()  {
        try {
            InputStream audiosrc = getClass().getResourceAsStream("resources/tada.wav");
            InputStream bufferedIn = new BufferedInputStream(audiosrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);

            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            tadaSound = (Clip) AudioSystem.getLine(info);
            tadaSound.open(audioStream);
            tadaSound.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void playRitaSound()   {
        try {
            InputStream audiosrc = getClass().getResourceAsStream("resources/rita.wav");
            InputStream bufferedIn = new BufferedInputStream(audiosrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);

            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            ritaSound = (Clip) AudioSystem.getLine(info);
            ritaSound.open(audioStream);
            ritaSound.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


    public void playVandoSound()  {
        try {
            InputStream audiosrc = getClass().getResourceAsStream("resources/vando.wav");
            InputStream bufferedIn = new BufferedInputStream(audiosrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);

            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            vandoSound = (Clip) AudioSystem.getLine(info);
            vandoSound.open(audioStream);
            vandoSound.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }








/*
    //private static String ritaSound = "resources/rita.wav";
    static URL ritaSound = Sound.class.getResource("resources/rita.wav");
    static SoundEffect se8 = new SoundEffect();

    //private static String vandoSound = "resources/vando.wav";
    static URL vandoSound = Sound.class.getResource("resources/vando.wav");
    static SoundEffect se9 = new SoundEffect();

/*
 //private static String themeSong = "resources/entryTheme.wav";
    static URL themeSong = Sound.class.getResource("resources/entryTheme.wav");
    static SoundEffect theme1 = new SoundEffect();

    //private static String gameSong = "resources/themesong.wav";
    static URL gameSong = Sound.class.getResource("resources/themesong.wav");
    static SoundEffect theme2 = new SoundEffect();

    //private static String lastSong = "resources/lastsong.wav";
    static URL lastSong = Sound.class.getResource("resources/lastsong.wav");
    static SoundEffect theme3 = new SoundEffect();

  //private static String ballSound = "resources/testeSound.wav";
    static URL ballSound = Sound.class.getResource("resources/testeSound.wav");
    static SoundEffect se = new SoundEffect();


   //private static String pepinoSound = "resources/pipino.wav";
   static URL pepinoSound = Sound.class.getResource("resources/pipino.wav");
    static SoundEffect se2 = new SoundEffect();

        //private static String meowSound = "resources/meow.wav";
    static URL meowSound = Sound.class.getResource("resources/meow.wav");
    static SoundEffect se3 = new SoundEffect();


    //private static String babySound = "resources/baby.wav";
    static URL babySound = Sound.class.getResource("resources/baby.wav");
    static SoundEffect se4 = new SoundEffect();


    //private static String gameOverSound = "resources/gameover.wav";
    static URL gameOverSound = Sound.class.getResource("resources/gameover.wav");
    static SoundEffect se5 = new SoundEffect();


    //private static String winSound = "resources/win.wav";
    static URL winSound = Sound.class.getResource("resources/win.wav");
    static SoundEffect se6 = new SoundEffect();

      //private static String tadaSound = "resources/tada.wav";
    static URL tadaSound = Sound.class.getResource("resources/tada.wav");
    static SoundEffect se7 = new SoundEffect();


    public static void playEntryThemeSong() {
        theme1.setFile(themeSong);
        theme1.play();
    }

    public static void playGameSong(){
        theme2.setFile(gameSong);
        theme2.play();

    }
    public static void playPosGameSong(){
        theme3.setFile(lastSong);
        theme3.play();
    }
    */
/*
    public static void stopPosGameSong(){
        theme3.stop();
    }

    public static void stopGameSong(){
        theme2.stop();
    }

    public static void stopThemeSong() {
        theme1.stop();
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




    public static void playRitaSound() {
        se8.setFile(ritaSound);
        se8.play();
    }

    public static void playVandoSound() {
        se9.setFile(vandoSound);
        se9.play();
    }


    public static class SoundEffect {
        Clip clip;

        public void setFile(URL url) {

            try {
               // File file = new File(soundFileName);
                // AudioInputStream sound = AudioSystem.getAudioInputStream(file);

                clip = AudioSystem.getClip();
                AudioInputStream sound = AudioSystem.getAudioInputStream(url);
                clip.open(sound);

            } catch (Exception e) {

            }
        }

        public void play() {
            clip.setFramePosition(0);
            clip.start();

        }

        public void stop() {
            clip.stop();
        }

    }
 */
}


