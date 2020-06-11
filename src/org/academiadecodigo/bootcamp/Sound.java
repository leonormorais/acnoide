package org.academiadecodigo.bootcamp;

import java.io.File;
import java.net.URL;
import java.io.BufferedInputStream;
import java.io.InputStream;
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
            //String currentDir = System.getProperty("user.dir");
            InputStream audiosrc = getClass().getClassLoader().getResourceAsStream("resources/entryTheme.wav");
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
            InputStream audiosrc = getClass().getClassLoader().getResourceAsStream("resources/themesong.wav");
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
            InputStream audiosrc = getClass().getClassLoader().getResourceAsStream("resources/lastsong.wav");
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
            InputStream audiosrc = getClass().getClassLoader().getResourceAsStream("resources/testeSound.wav");
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
            InputStream audiosrc = getClass().getClassLoader().getResourceAsStream("resources/pipino.wav");
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
            InputStream audiosrc = getClass().getClassLoader().getResourceAsStream("resources/meow.wav");
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
            InputStream audiosrc = getClass().getClassLoader().getResourceAsStream("resources/baby.wav");
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
            InputStream audiosrc = getClass().getClassLoader().getResourceAsStream("resources/gameover.wav");
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
            InputStream audiosrc = getClass().getClassLoader().getResourceAsStream("resources/win.wav");
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
            InputStream audiosrc = getClass().getClassLoader().getResourceAsStream("resources/tada.wav");
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
            InputStream audiosrc = getClass().getClassLoader().getResourceAsStream("resources/rita.wav");
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
            InputStream audiosrc = getClass().getClassLoader().getResourceAsStream("resources/vando.wav");
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

}


/*

    private String ritaSound = "resources/rita.wav";
   // URL ritaSound = getClass().getResource("resources/rita.wav");
    SoundEffect se8 = new SoundEffect();

    private String vandoSound = "resources/vando.wav";
    // URL vandoSound = getClass().getResource("resources/vando.wav");
     SoundEffect se9 = new SoundEffect();

    private String themeSong = "resources/entryTheme.wav";
   // URL themeSong = getClass().getResource("resources/entryTheme.wav");
    SoundEffect theme1 = new SoundEffect();

    private String gameSong = "resources/themesong.wav";
   // URL gameSong = getClass().getResource("resources/themesong.wav");
    SoundEffect theme2 = new SoundEffect();

    private String lastSong = "resources/lastsong.wav";
   // URL lastSong = getClass().getResource("resources/lastsong.wav");
    SoundEffect theme3 = new SoundEffect();

     private String ballSound = "resources/testeSound.wav";
    //URL ballSound = getClass().getResource("resources/testeSound.wav");
     SoundEffect se = new SoundEffect();

   private String pepinoSound = "resources/pipino.wav";
    //URL pepinoSound = getClass().getResource("resources/pipino.wav");
     SoundEffect se2 = new SoundEffect();

    private String meowSound = "resources/meow.wav";
  //  URL meowSound = getClass().getResource("resources/meow.wav");
   SoundEffect se3 = new SoundEffect();

    private String babySound = "resources/baby.wav";
    //URL babySound = getClass().getResource("resources/baby.wav");
    SoundEffect se4 = new SoundEffect();

    private String gameOverSound = "resources/gameover.wav";
    // URL gameOverSound = getClass().getResource("resources/gameover.wav");
    SoundEffect se5 = new SoundEffect();


    private String winSound = "resources/win.wav";
   // URL winSound = getClass().getResource("resources/win.wav");
    SoundEffect se6 = new SoundEffect();

    private String tadaSound = "resources/tada.wav";
    // URL tadaSound = getClass().getResource("resources/tada.wav");
     SoundEffect se7 = new SoundEffect();


    public void playEntryThemeSong() {
        theme1.setFile(themeSong);
        theme1.play();
    }

    public void playGameSong(){
        theme2.setFile(gameSong);
        theme2.play();

    }
    public void playPosGameSong(){
        theme3.setFile(lastSong);
        theme3.play();
    }

    public void stopPosGameSong(){
        theme3.stop();
    }

    public void stopGameSong(){
        theme2.stop();
    }

    public void stopThemeSong() {
        theme1.stop();
    }

    public void playBallEffect() {
        se.setFile(ballSound);
        se.play();
    }

    public void playPipinoDNovo() {
        se2.setFile(pepinoSound);
        se2.play();
    }



    public void playMeow() {
        se3.setFile(meowSound);
        se3.play();
    }



    public void playBaby() {
        se4.setFile(babySound);
        se4.play();
    }



    public void playGameOverSound() {
        se5.setFile(gameOverSound);
        se5.play();
    }

    public void playWinSound() {
        se6.setFile(winSound);
        se6.play();
    }

    public void playTadaSound() {
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

        public void setFile(String path) {

            try {
               File file = new File(path);
               AudioInputStream sound = AudioSystem.getAudioInputStream(file);

               // AudioInputStream sound = AudioSystem.getAudioInputStream(url);
                clip = AudioSystem.getClip();
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

