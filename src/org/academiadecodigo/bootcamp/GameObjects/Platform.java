package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Grid.GridDirection;
import org.academiadecodigo.bootcamp.Grid.GridPosition;

public class Platform implements Hittable {

    private final int PLATFORM_POSITION_X = 300;
    private final int PLATFORM_POSITION_Y = 675;

    private int platformSpeed = 15;

    private GridPosition position;

    public Platform (Grid grid) {
        this.position = grid.makeGridPosition(PLATFORM_POSITION_X, PLATFORM_POSITION_Y, "platform");
    }

    public void setPlatformSpeed(int speed){
        platformSpeed = speed;
    }

    public int getPlatformSpeed(){
        return platformSpeed;
    }

    public GridPosition getPosition() {
        return position;
    }

    public void moveRight() {
        for (int i = 0; i < platformSpeed; i++) {
            if (position.isOnEdgePlatform(GridDirection.RIGHT)) {
                return;
            }
            position.move(GridDirection.RIGHT);
        }
    }

    public void moveLeft() {
        for (int i = 0; i < platformSpeed; i++) {
            if (position.isOnEdgePlatform(GridDirection.LEFT)) {
                return;
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
