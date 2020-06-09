package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.CollisionDetector;
import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Grid.GridDirection;
import org.academiadecodigo.bootcamp.Grid.GridPosition;

public class Ball {

    private final static int BALL_WIDTH = 10;
    private final static int BALL_HEIGHT = 10;
    private final static int BALL_SPEED = 10;

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

        direction[0] = -2; //x
        direction[1] = 1; //y
    }

    //getters
    public int getBallWidth() {
        return BALL_WIDTH;
    }

    public int getBallHeight() {
        return BALL_HEIGHT;
    }

    public int getXDirection() {
        return direction[0];
    }

    public int getYDirection() {
        return direction[1];
    }

    //setters
    public void setNewXDirection(int x) {
        direction[0] = x;
    }

    public void setNewYDirection(int y) {
        direction[1] = y;
    }

    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }

    //move
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
            direction[1] = - direction[1];
            //currentDirection = GridDirection.NE;
        }

        if (collisionDetector.checkForCollisionBrick()) {
            //test
            direction[1] = - direction[1]; //y

            //currentDirection = GridDirection.NE;
        }

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
