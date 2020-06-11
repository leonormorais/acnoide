package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Grid.GridPosition;
import org.academiadecodigo.bootcamp.Tests.Sound;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.Timer;
import java.util.TimerTask;

public class PosGame implements KeyboardHandler {

    private final String background = "resources/finalscreen.jpg";

    private Grid grid;
    private Keyboard keyboard;
    private boolean isRunning;
    private String lastGame;
    private GridPosition textStart;
    private GridPosition titleImage;

    private boolean restart = false;

    public PosGame(String lastGame) {
        this.grid = new Grid(600, 700, background);
        keyboard = new Keyboard(this);
        this.isRunning = true;
        this.lastGame = lastGame;
    }

    public void init() {
        grid.init();

        KeyboardEvent inputStart = new KeyboardEvent();
        inputStart.setKey(KeyboardEvent.KEY_SPACE);
        inputStart.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(inputStart);

        textStart = grid.makeGridPosition(170, 400, 286, 26, "resources/playagain.png");

        if (lastGame.equals("win")) {
            titleImage = grid.makeGridPosition(200, 200, 286,26,"resources/congrats.png");
        }

        if (lastGame.equals("gameover")){
            titleImage = grid.makeGridPosition(200, 200, 286,26,"resources/gameover.png");
        }


    }

    public void start() throws InterruptedException {

        Timer timer = new Timer();

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

        while (isRunning) {
            Thread.sleep(50);
        }

        timer.cancel();
        Sound.playPipinoDNovo();
        Thread.sleep(1000);
        grid.hide();

    }

    public boolean restartInvoked() {
        return restart;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        isRunning = false;
        restart = true;
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
