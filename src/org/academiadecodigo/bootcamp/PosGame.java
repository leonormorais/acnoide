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

    private final String background = "resources/ACNOID2020.jpg";

    private Grid grid;
    private Keyboard keyboard;
    private boolean isRunning;
    private GridPosition textStart;

    private boolean restart = false;

    public PosGame() {
        this.grid = new Grid(600, 700, background);
        keyboard = new Keyboard(this);
        this.isRunning = true;
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
