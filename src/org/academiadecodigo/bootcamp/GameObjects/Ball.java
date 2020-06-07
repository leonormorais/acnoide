package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.Grid.GridDirection;
import org.academiadecodigo.bootcamp.Grid.GridPosition;

public class Ball {

    private final static int BALL_WIDTH = 10;
    private final static int BALL_HEIGTH = 10;
    private final static int BALL_SPEED = 6;

    private GridPosition position;
    private GridDirection currentDirection;

    public Ball () {
        this.position = new GridPosition(BALL_WIDTH, BALL_HEIGTH);
        this.currentDirection = GridDirection.DOWN;
    }

    public void move() {
        for (int i = 0; i < BALL_SPEED; i++) {

            if (position.isOnEdge()) {
                //currentDirection = getnewdirection(currentDirection)
            }

            // if (collisionDetection.check())
                 //currentDirection = getnewdirection(currentDirection)
                //currentDirection = GridDirection.getnewDirection(currentDirection);

            position.moveBall(currentDirection);
        }

    }

    public GridPosition getPosition() {
        return position;
    }
}
