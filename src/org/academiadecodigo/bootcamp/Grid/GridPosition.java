package org.academiadecodigo.bootcamp.Grid;


import org.academiadecodigo.bootcamp.Score;
import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GridPosition {


    private final int PLATFORM_WIDTH = 50;
    private final int PLATFORM_HEIGHT = 20;

    private Grid grid;
    private int posX;
    private int posY;
    private int width;
    private int height;
    private Picture picture;
    private Picture pepino;
    private Text text;

    public GridPosition(Grid grid, int posX, int posY, int width, int height, String source) {
        this.grid = grid;

        picture = new Picture(posX, posY, source);

        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;

        show();
    }

    public GridPosition (Grid grid, int posX, int posY) {

        this.grid = grid;
        this.posX = posX;
        this.posY = posY;

        this.text = new Text(posX, posY, Score.stringGetScore());
        showScore();

    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    //Original 50
    //Final 75


    public void increaseWidthPlatform() {
        int cucumber = width / 2;
        pepino.grow(cucumber, 0);
        width += width;
        posX -= width / 4;

    }

    //Original 75
    //final 50

    public void decreaseWidthPlatform() {
        int cucumber = -(this.width / 4);
        pepino.grow(cucumber, 0);
        posX += width / 4;
        width -= width / 2;

    }

    public void show() {
        picture.draw();
    }

    public void showScore(){
        text.setColor(Color.WHITE);
        text.setText(Score.stringGetScore());
        text.draw();
    }

    private void showPlatform() {
        picture.draw();
    }

    public void hide() {
        picture.delete();
    }

    public void transformBrick(String source) {
        //picture.grow(-10, 39);
        width = 50;
        height = 69;
        picture.load(source);
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
        //System.out.println(toString());
    }

   public void moveBrick() {
        this.posY += 1;
        picture.translate(0, 1);

        if (posY + getHeight() == grid.getHeight()) {
            hide();
        }
   }

   //pensar numa solução única com o tipo de Game Object (Ball Or Brick)
   public void moveBall(int[] direction) {
       this.posX += direction[0];
       this.posY += direction[1];
       picture.translate(direction[0], direction[1]);
   }


   //move platform
    private void moveLeft() {
        this.posX -= 1;
        picture.translate(-1, 0);
    }

    //move platform
    private void moveRight() {
        this.posX += 1;
        picture.translate(1, 0);
    }


    public boolean isOnEdge() {
        return (posX + width >= grid.getWidth() || posX <= Grid.PADDING * 2);
    }

    public boolean isOnTopEdge() {
        return posY == Grid.PADDING * 2;
    }

    public boolean isOnBottomEdge() {
        return posY + height == grid.getHeight() + Grid.PADDING;
    }

    public boolean isOnBottomBabies() {
        return posY + height == grid.getHeight();
    }

    public boolean isOnEdgePlatform(GridDirection direction) {
        switch (direction) {
            case RIGHT:
                return posX + width == grid.getWidth();
            case LEFT:
                return posX == Grid.PADDING * 2;
        }
        return false;
    }



    @Override
    public String toString() {
        return "GridPosition{" +
                "posX=" + posX +
                ", posY=" + posY +
                ", width=" + width +
                ", height=" + height +
                '}';
    }



}
