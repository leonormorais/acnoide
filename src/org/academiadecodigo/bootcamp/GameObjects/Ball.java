package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.CollisionDetector;
import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Grid.GridDirection;
import org.academiadecodigo.bootcamp.Grid.GridPosition;

public class Ball {

    private final static int BALL_WIDTH = 10;
    private final static int BALL_HEIGHT = 10;
    private final static int BALL_SPEED = 5;

    private GridPosition position;
    private GridDirection currentDirection;
    private CollisionDetector collisionDetector;
    private boolean isRunning;

    private int[] direction;

    public Ball (Grid grid) {
        this.position = grid.makeGridPosition(BALL_WIDTH, BALL_HEIGHT);
        this.currentDirection = GridDirection.NW;
        this.isRunning = true;
        this.direction = new int[2];

        direction[0] = 1; //x
        direction[1] = -1; //y
    }

    public int getBallWidth() {
        return BALL_WIDTH;
    }

    public int getBallHeight() {
        return BALL_HEIGHT;
    }

    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }

    public void move() {

        for (int i = 0; i < BALL_SPEED; i++) {

        if (position.isOnTopEdge()) {
            direction[1] = - direction[1];
            // currentDirection = GridDirection.getNewTopDirection(currentDirection);
        }

        if (position.isOnEdge()) {
            direction[0] = - direction[0];
           //currentDirection = GridDirection.getNewDirection(currentDirection);
        }

        if (position.isOnBottomEdge()) {
            gameOver();
            break;
        }

        if (collisionDetector.checkForCollisionPlatform()) {
                currentDirection = GridDirection.NE;
        }

        if (collisionDetector.checkForCollisionBrick()) {
            currentDirection = GridDirection.NE;
        }


        /* if (position.isOnEdge()) {
            String edge = getHittedEdge();
            currentDirection = GridDirection.getNewDirection(currentDirection, edge);
        }
        */

                 //currentDirection = getnewdirection(currentDirection)
                //currentDirection = GridDirection.getnewDirection(currentDirection);


        position.moveBall(direction);

        }
    }

    public void gameOver() {
        position.hideBall();
        isRunning = false;
    }

    public boolean isBallRunning() {
        return isRunning;
    }

    public GridPosition getPosition() {
        return position;
    }
}
