package org.academiadecodigo.bootcamp.Grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    public static final int PADDING = 10;
    private int width; //em px
    private int height; //em px
    private Picture backgroundTest;

    public Grid (int width, int height, String source) {
        this.width = width;
        this.height = height;

        backgroundTest = new Picture(PADDING,PADDING, source);
    }

    public void init() {
        backgroundTest.draw();
    }

    public void hide() {
        backgroundTest.delete();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public GridPosition makeGridPosition(int posX, int posY, int width, int height, String source) {
        return new GridPosition(this, posX, posY, width, height, source);

    }

    public GridPosition makeGridPosition(int posX, int posY) {
        return new GridPosition(this, posX, posY);

    }

}
