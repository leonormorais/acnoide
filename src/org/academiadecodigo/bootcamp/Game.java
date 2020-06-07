package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.GameObjects.Ball;
import org.academiadecodigo.bootcamp.GameObjects.Bricks.Brick;
import org.academiadecodigo.bootcamp.GameObjects.ObjectFactory;
import org.academiadecodigo.bootcamp.Grid.Grid;

public class Game {

    private final int BRICKS_NUMBER = 72; //Level 1
    private final int DELAY = 100;

    private Grid grid;
    private Brick[] bricks;
    private Player player;
    private Ball ball;

    public Game() {
        this.grid = new Grid(612, 700);

    }

    public Grid getGrid() {
        return grid;
    }

    public void init()  {

        grid.init();

        //create bricks and set grid for bricks
        bricks = ObjectFactory.createBricks(BRICKS_NUMBER);

        for (Brick brick : bricks) {
            brick.setGrid(grid);
        }

        //initializing player and set grid to platform
        player = new Player();
        player.init();
        player.getPlatform().setGrid(grid);

        //initializing ball
        ball = new Ball();

    }

   public void start() throws InterruptedException {

        while (true) {

            ball.move();

            //animation speed
            Thread.sleep(DELAY);

        }

    }


}
