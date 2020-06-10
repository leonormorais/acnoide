package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.GameObjects.Platform;
import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class User implements KeyboardHandler {

    private Keyboard keyboard;
    private boolean keyPressed = false;

    public User () {
        keyboard = new Keyboard(this);
    }

    public boolean isKeyPressed() {
        return keyPressed;
    }

    public void init() {

        KeyboardEvent inputStart = new KeyboardEvent();
        inputStart.setKey(KeyboardEvent.KEY_SPACE);
        inputStart.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(inputStart);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
            keyPressed = true;
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


}
