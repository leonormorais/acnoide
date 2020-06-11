package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.CollisionDetector;
import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Grid.GridDirection;
import org.academiadecodigo.bootcamp.Grid.GridPosition;

public class Platform implements Hittable {


    private final int PLATFORM_POSITION_X = 300;
    private final int PLATFORM_POSITION_Y = 670;
    private final int PLATFORM_WIDTH = 50;
    private final int PLATFORM_HEIGHT = 20;

    public static final int MAXIMUM_SPEED = 30;
    public static final int MINIMUM_SPEED = 15;

    private int platformSpeed = 15;
    private CollisionDetector collisionDetector;

    private boolean isRitaActive;

    private GridPosition position;

    public Platform (Grid grid) {
        this.position = grid.makeGridPosition(PLATFORM_POSITION_X, PLATFORM_POSITION_Y, PLATFORM_WIDTH, PLATFORM_HEIGHT,"resources/pepino.png");
    }

    public boolean getIsRitaActive() {
        return isRitaActive;
    }

    public void setPlatformSpeed(int speed){
        platformSpeed = speed;
    }

    public void setIsRitaActive(boolean isRitaActive) {
        this.isRitaActive = isRitaActive;
    }

    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }

    public GridPosition getPosition() {
        return position;
    }

    public void moveRight() {
        for (int i = 0; i < platformSpeed; i++) {
            if (position.isOnEdgePlatform(GridDirection.RIGHT)) {
                return;
            }
            if (collisionDetector.getIsCollidedPlatform()) {
                collisionDetector.setIsCollidedPlatform(true);
            }
            position.move(GridDirection.RIGHT);
        }
    }

    public void moveLeft() {
        for (int i = 0; i < platformSpeed; i++) {
            if (position.isOnEdgePlatform(GridDirection.LEFT)) {
                return;
            }
            if (collisionDetector.getIsCollidedPlatform()) {
                collisionDetector.setIsCollidedPlatform(true);
            }
            position.move(GridDirection.LEFT);
        }
    }

    @Override
    public String toString() {
        return "Platform{" +
                ", position=" + position +
                '}';
    }
}
