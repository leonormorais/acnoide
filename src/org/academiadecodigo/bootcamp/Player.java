package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.GameObjects.Platform;
import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player implements KeyboardHandler {

    private Platform platform;
    private Keyboard keyboard;


    public Player (Grid grid) {

        keyboard = new Keyboard(this);
        platform = new Platform(grid);

    }

    public Platform getPlatform() {
        return platform;
    }

    public void init() {

        KeyboardEvent inputLeft = new KeyboardEvent();
        inputLeft.setKey(KeyboardEvent.KEY_LEFT);
        inputLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(inputLeft);

        KeyboardEvent inputRight = new KeyboardEvent();
        inputRight.setKey(KeyboardEvent.KEY_RIGHT);
        inputRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(inputRight);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

       switch (keyboardEvent.getKey()) {
           case KeyboardEvent.KEY_LEFT:
               platform.moveLeft();
               break;
           case KeyboardEvent.KEY_RIGHT:
               platform.moveRight();
               break;

       }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
