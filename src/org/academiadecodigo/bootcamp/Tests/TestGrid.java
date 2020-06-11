package org.academiadecodigo.bootcamp.Tests;

import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.GameObjects.Ball;
import org.academiadecodigo.bootcamp.GameObjects.Bricks.Brick;
import org.academiadecodigo.bootcamp.GameObjects.ObjectFactory;
import org.academiadecodigo.bootcamp.GameObjects.Platform;
import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Grid.GridPosition;
import org.academiadecodigo.bootcamp.Menu;
import org.academiadecodigo.bootcamp.Player;
import org.academiadecodigo.bootcamp.PosGame;

public class TestGrid {

    private static String lastGame;
    private static boolean newGame = true;

    public static void main(String[] args) throws InterruptedException {

        Menu m = new Menu();
        m.init();
        m.start();

        while (newGame) {
            Game g = new Game();
            g.init();
            g.start();
            lastGame = g.posGame();

            PosGame p = new PosGame();
            p.init();
            p.start();
            newGame = p.restartInvoked();
        }


    }
}
