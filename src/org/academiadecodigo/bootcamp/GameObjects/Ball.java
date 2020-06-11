package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.CollisionDetector;
import org.academiadecodigo.bootcamp.Grid.GridPosition;
import org.academiadecodigo.bootcamp.Tests.Sound;

public class Ball {

    public static final int MINOR_SPEED = 5;
    public static final int BALL_SPEED = 10;

    private int ballSpeed = 10;
    private GridPosition position;
    private CollisionDetector collisionDetector;
    private boolean isRunning;
    private boolean isLuisActive;
    private int[] direction;

    public Ball (GridPosition gridPosition) {
        this.position = gridPosition;
        this.isRunning = true;
        this.direction = new int[2];

        direction[0] = 0; //x
        direction[1] = 1; //y
    }

    //getters

    public int getBallSpeed() {
        return ballSpeed;
    }

    public int getXDirection() {
        return direction[0];
    }

    public int getYDirection() {
        return direction[1];
    }

    public boolean getIsLuisActive() {
        return isLuisActive;
    }

    //setters

    public void setBallSpeed(int ballSpeed) {
        this.ballSpeed = ballSpeed;
    }

    public void setIsLuisActive(boolean isLuisActive) {
        this.isLuisActive = isLuisActive;
    }

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

        for (int i = 0; i < ballSpeed; i++) {

        if (position.isOnTopEdge()) {
            direction[1] = - direction[1];
        }

        if (position.isOnEdge()) {
            direction[0] = - direction[0];
        }

        if (position.isOnBottomBabies()) {
            if (isLuisActive) {
                direction[1] = - direction[1];
            }

        }

        if (position.isOnBottomEdge()) {
            gameOver();
            break;
        }

        if (collisionDetector.checkForCollisionPlatform()) {
            direction[1] = - direction[1];
        }

        if (collisionDetector.checkForCollisionBrick()) {
            Sound.playBallEffect(); //testing sound
            Score.setScore(200);
            direction[1] = - direction[1]; //y
        }

        position.moveBall(direction);

        }
        Score.setScore(1);
    }

    public void gameOver() {
        position.hide();
        isRunning = false;
    }

    public boolean isBallRunning() {
        return isRunning;
    }

    public GridPosition getPosition() {
        return position;
    }
}
