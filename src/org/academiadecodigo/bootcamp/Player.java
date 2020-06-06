package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.GameObjects.Platform;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player implements KeyboardHandler {

    private Platform platform;
    private Keyboard keyboard;


    public Player () {

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        /*
        If Pressed Key Space
            game.start();
        If pressed key left
            platform.moveleft();
        If pressed key right;
            platform.moveright();

         */
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
