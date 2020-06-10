package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Grid.GridDirection;
import org.academiadecodigo.bootcamp.Grid.GridPosition;

public class Platform implements Hittable {

    private int plataformSpeed = 15;

    private GridPosition position;

    public Platform (Grid grid) {
        this.position = grid.makeGridPosition(300,675 , "platform");
    }

    public void setPlataformSpeed(int speed){
        plataformSpeed = speed;
    }

    public int getPlataformSpeed(){
        return plataformSpeed;
    }

    public GridPosition getPosition() {
        return position;
    }

    public void moveRight() {
        for (int i = 0; i < plataformSpeed; i++) {
            if (position.isOnEdgePlatform(GridDirection.RIGHT)) {
                return;
            }
            position.move(GridDirection.RIGHT);
        }
    }

    public void moveLeft() {
        for (int i = 0; i < plataformSpeed; i++) {
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
