package org.academiadecodigo.bootcamp.Screens;

import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Grid.GridPosition;
import org.academiadecodigo.bootcamp.Sound;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.Timer;
import java.util.TimerTask;


public class Menu implements KeyboardHandler {

    private final String background = "resources/ACNOID2020.jpg";

    private Sound sound = new Sound();
    private Grid grid;
    private Keyboard keyboard;
    private boolean isRunning = true;
    private GridPosition textStart;


    public Menu () {
        this.grid = new Grid(600, 700, background);
        keyboard = new Keyboard(this);
    }

    public void init() {
        grid.init();

        KeyboardEvent inputStart = new KeyboardEvent();
        inputStart.setKey(KeyboardEvent.KEY_SPACE);
        inputStart.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(inputStart);

        textStart = grid.makeGridPosition(170, 550, 286, 26, "resources/start.png");

    }


    public void start() throws InterruptedException {


        Timer timer = new Timer();
        Timer themeSongTimer = new Timer();

        timer.schedule(new TimerTask() {
            private int i;
            @Override
            public void run() {
                if (i % 2 == 0)
                    textStart.show();
                else
                    textStart.hide();
                i++;
            }
        }, 0, 400);


        themeSongTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                sound.playEntryThemeSong();
            }

        },400, 120000);

        while (isRunning) {
            Thread.sleep(50);
        }


        sound.stopThemeSong();

        themeSongTimer.cancel();
        timer.cancel();

        sound.playPipinoDNovo();

        Thread.sleep(1000);

        grid.hide();

    }




    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        isRunning = false;
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


}
