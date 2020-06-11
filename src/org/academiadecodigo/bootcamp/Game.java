package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.GameObjects.Ball;
import org.academiadecodigo.bootcamp.GameObjects.Bricks.Brick;
import org.academiadecodigo.bootcamp.GameObjects.Bricks.SuperBrick;
import org.academiadecodigo.bootcamp.GameObjects.ObjectFactory;
import org.academiadecodigo.bootcamp.GameObjects.Score;
import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Grid.GridPosition;

public class Game {

    private final int BRICKS_NUMBER = 72; //Level 1
    private final int DELAY = 75;
    private final String background = "resources/backgroundV3.jpg";

    private Grid grid;
    private Brick[] bricks;
    private Player player;
    private Ball ball;
    private CollisionDetector collisionDetector;
    private boolean isGameRunning;
    private GridPosition testPosition;

    private String output;

    public Game() {
        this.grid = new Grid(600, 700, background);
    }

    public Grid getGrid() {
        return grid;
    }

    public void init()  {

        grid.init();

        //create bricks and set grid for bricks
        bricks = ObjectFactory.createBricks(BRICKS_NUMBER, grid);

        for (Brick brick : bricks) {
            brick.setGrid(grid);
        }

        //initializing player and set grid to platform
        player = new Player(grid);
        player.init();

        //initializing ball
        ball = ObjectFactory.createBall(grid);

        //initializing collision detector
        collisionDetector = new CollisionDetector(bricks, player.getPlatform(), ball);
        ball.setCollisionDetector(collisionDetector);

        for (Brick brick : bricks) {
            if (brick instanceof SuperBrick) {
                ((SuperBrick) brick).setCollisionDetector(collisionDetector);
            }
        }

        //initializing score
        Score.createGridPosition(grid);

    }

   public void start() throws InterruptedException {

        isGameRunning = true;
        collisionDetector.resetDestroyedBricks();
        Score.resetScore();

        while(isGameRunning) {

            ball.move();

            for (Brick brick : bricks) {
                brick.move();

            }

            if (collisionDetector.getDestroyedBricksCounter() == bricks.length) {
                output = "win";
                isGameRunning = false;
                break;
            }

            if (!ball.isBallRunning()) {
                output = "gameover";
                isGameRunning = false;
                break;
            }

            //animation speed
            Thread.sleep(DELAY);

        }

    }


    public String posGame() {
        return output;
    }

}
