package org.academiadecodigo.bootcamp.Grid;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;

public class GridPosition {

    private final int BALL_POSITION_X = 400;
    private final int BALL_POSITION_Y = 450;

    private Grid grid;
    private int posX;
    private int posY;
    private int width;
    private int height;
    private Rectangle rectangle;
    private Ellipse ellipse;

    private Color color;

    public GridPosition(Grid grid, int posX, int posY, int width, int height, Color color) {
        this.grid = grid;

        rectangle = new Rectangle(posX, posY, width, height);
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.color = color;
        show();
    }

    public GridPosition (Grid grid, int width, int height) {
        this.grid = grid;

        this.posX = BALL_POSITION_X;
        this.posY = BALL_POSITION_Y;
        this.width = width;
        this.height = height;

        ellipse = new Ellipse(BALL_POSITION_X, BALL_POSITION_Y, width, height);
        this.color = Color.CYAN;

        showBall();

    }



    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }


    public void show() {
        rectangle.setColor(color);
        rectangle.fill();

    }


    private void showBall() {
        ellipse.setColor(color);
        ellipse.fill();
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

    //pensar numa solução única com o tipo de Game Object (Ball Or Brick)
    public void moveBall(GridDirection direction) {
        switch (direction) {
            case DOWN:
                this.posY += 1;
                ellipse.translate(0, 1);
        }
    }

    private void moveLeft() {
        //controlar limites

        this.posX -= 6;
        rectangle.translate(-6, 0);
    }

    private void moveRight() {
        //controlar limites

        this.posX += 6;
        rectangle.translate(6, 0);
    }

/*
    public boolean isOnEdge() {
        if (posX + width >= )
        return false;
    }

 */

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
