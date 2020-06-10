package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Grid.GridDirection;
import org.academiadecodigo.bootcamp.Grid.GridPosition;

public class Platform implements Hittable {

    private int width = 40;
    private int height = 10;
    private int plataformSpeed = 15;
    private int superSize = 0;

    //private Grid grid;
    private GridPosition position;




    public Platform (Grid grid) {
        this.position = grid.makeGridPosition(300,675 , "platform");
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setPlataformSpeed(int speed){
        plataformSpeed = speed;
    }

    public int getPlataformSpeed(){
        return plataformSpeed;
    }

    /*
    public void setGrid(Grid grid) {
        this.grid = grid;
    }
*/
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

    public void setWidth(int width) {
        this.width = width;
    }

    public int getSuperSize() {
        return superSize;
    }

    public void setSuperSize(int superSize) {
        this.superSize = superSize;
    }



    @Override
    public String toString() {
        return "Platform{" +
                "WIDTH=" + width +
                ", HEIGHT=" + height +
                ", position=" + position +
                '}';
    }
}
