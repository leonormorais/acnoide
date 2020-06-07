package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Grid.GridDirection;
import org.academiadecodigo.bootcamp.Grid.GridPosition;

public class Ball {

    private final static int BALL_WIDTH = 10;
    private final static int BALL_HEIGHT = 10;
    private final static int BALL_SPEED = 6;

    private GridPosition position;
    private GridDirection currentDirection;

    public Ball (Grid grid) {
        this.position = grid.makeGridPosition(BALL_WIDTH, BALL_HEIGHT);
        this.currentDirection = GridDirection.NE;
    }

    public void move() {
        for (int i = 0; i < BALL_SPEED; i++) {

        if (position.isOnEdge(currentDirection)) {
         //   currentDirection = getNewdirection(currentDirection)
            currentDirection = GridDirection.getNewDirection(currentDirection);
            System.out.println("Hit the wall");
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
