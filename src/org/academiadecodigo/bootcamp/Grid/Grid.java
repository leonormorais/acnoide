package org.academiadecodigo.bootcamp.Grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    public static final int PADDING = 10;
    private Rectangle background; //substituido por picture
    private int width; //em px
    private int height; //em px

    //este contrutor deve ser invocado pelo Game init
    public Grid (int width, int height) {
        this.width = width;
        this.height = height;

        background = new Rectangle(PADDING, PADDING, width, height); //substituido por picture

    }

    //init dentro ou fora do construtor
    public void init() {
        background.draw();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public GridPosition makeGridPosition(int posX, int posY, int width, int height, Color color) {
        return new GridPosition(this, posX, posY, width, height, color);

    }

    public GridPosition makeGridPosition(int width, int height) {
        return new GridPosition(this, width, height);
    }

}
