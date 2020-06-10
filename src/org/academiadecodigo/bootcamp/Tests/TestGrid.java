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

public class TestGrid {

    public static void main(String[] args) throws InterruptedException {

        Menu m = new Menu();
        m.init();
        m.start();

        Game g = new Game();
        g.init();
        g.start();

    }
}
