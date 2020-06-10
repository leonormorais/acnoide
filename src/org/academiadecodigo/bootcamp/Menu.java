package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Tests.Sound;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Menu implements KeyboardHandler {

    private final String background = "background2.jpg";

    private Grid grid;
    private Keyboard keyboard;
    private boolean isRunning = true;


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

    }

    public void start() throws InterruptedException {
        while (isRunning) {
            Thread.sleep(10);
        }
        Sound.playPipinoDNovo();
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
