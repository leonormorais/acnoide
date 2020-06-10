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
        //Grid grid = new Grid(612, 700); // OK de tamanho
        //GridPosition test = new GridPosition(40, 40, 60, 20);

        //testing initial menu

        /*
        Menu m = new Menu();


        m.init();
        m.start();
    */

        Game g = new Game();

        g.init();
        g.start();

        // Brick[] test = ObjectFactory.createBricks(72);

        //Player player = new Player();
        //player.init();

        //player.getPlatform().setGrid(g.getGrid());

        //for (int i = 0; i < test.length; i++) {
          //  test[i].getPosition().show();
        //}



      // System.out.println(test.toString());
    }
}
