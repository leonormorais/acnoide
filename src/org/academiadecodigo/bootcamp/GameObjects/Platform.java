package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Grid.GridDirection;
import org.academiadecodigo.bootcamp.Grid.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class Platform implements Hitable {

    private final int WIDTH = 40;
    private final int HEIGHT = 10;
    private final static int PLATFORM_SPEED = 20;

    //private Grid grid;
    private GridPosition position;
    private Color color;

    public Platform (Grid grid) {
        this.color = Color.PINK;
        this.position = grid.makeGridPosition(300,675, WIDTH, HEIGHT, color);
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

}
