package org.academiadecodigo.bootcamp.Grid;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class GridPosition {

    private int posX;
    private int posY;
    private int width;
    private int height;
    private Rectangle rectangle;

    private Color color;

    public GridPosition(int posX, int posY, int width, int height, Color color) {
        rectangle = new Rectangle(posX, posY, width, height);
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.color = color;
    }


    public void show() {

        rectangle.setColor(color);
        rectangle.fill();
    }

    public void hide() {

    }

    public void move(GridDirection direction) {
        switch (direction) {
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
        }
    }

    private void moveLeft() {
        //controlar limites

        this.posX--;
        rectangle.translate(-1, 0);
    }

    private void moveRight() {
        //controlar limites

        this.posX++;
        rectangle.translate(1, 0);
    }


    @Override
    public String toString() {
        return "GridPosition{" +
                "posX=" + posX +
                ", posY=" + posY +
                ", width=" + width +
                ", height=" + height +
                ", rectangle=" + rectangle +
                '}';
    }
}
