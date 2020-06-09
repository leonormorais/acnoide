package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Grid.GridDirection;
import org.academiadecodigo.bootcamp.Grid.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class Platform implements Hitable {

    private int WIDTH = 40;
    private int HEIGHT = 10;
    private final static int PLATFORM_SPEED = 25;
    private int superSize = 0;

    //private Grid grid;
    private GridPosition position;
    private Color color;

    public void setSuperSize(String superPower){
        // fazer um switch por superpower;
        switch (superPower){
            case "Sergio": //dizer qual caso;
                setSuperSize(20);
                setWIDTH(getWIDTH() + superSize);
                break;
        }
    }

    public Platform (Grid grid) {
        this.color = Color.PINK;
        this.position = grid.makeGridPosition(300 - superSize/2,675 , "platform");
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
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
        for (int i = 0; i < PLATFORM_SPEED; i++) {
            if (position.isOnEdgePlatform(GridDirection.RIGHT)) {
                return;
            }
            position.move(GridDirection.RIGHT);
        }
    }

    public void moveLeft() {
        for (int i = 0; i < PLATFORM_SPEED; i++) {
            if (position.isOnEdgePlatform(GridDirection.LEFT)) {
                return;
            }
            position.move(GridDirection.LEFT);

        }
    }

    public void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
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
                "WIDTH=" + WIDTH +
                ", HEIGHT=" + HEIGHT +
                ", position=" + position +
                ", color=" + color +
                '}';
    }
}
