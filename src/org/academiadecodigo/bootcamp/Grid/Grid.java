package org.academiadecodigo.bootcamp.Grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    public static final int PADDING = 10;
    private Rectangle background; //substituido por picture
    private int width; //em px
    private int height; //em px
    private Picture backgroundTest;

    //este contrutor deve ser invocado pelo Game init
    public Grid (int width, int height) {
        this.width = width;
        this.height = height;

       // background = new Rectangle(PADDING, PADDING, width, height); //substituido por picture

        backgroundTest = new Picture(PADDING,PADDING, "src/org/academiadecodigo/bootcamp/assets/background_test.jpg");
    }

    //init dentro ou fora do construtor
    public void init() {
        backgroundTest.draw();
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

    public GridPosition makeGridPosition(int posX, int posY, String name) {
        return new GridPosition(this, posX, posY, "platform");

    }

}
