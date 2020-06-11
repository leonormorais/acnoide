package org.academiadecodigo.bootcamp.Grid;

import org.academiadecodigo.bootcamp.GameObjects.Score;
import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GridPosition {

    private Grid grid;
    private int posX;
    private int posY;
    private int width;
    private int height;
    private Picture picture;
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

    public GridPosition (Grid grid, int posX, int posY, String text) {

        this.grid = grid;
        this.posX = posX;
        this.posY = posY;

        this.text = new Text(posX, posY, text);
        this.text.setColor(Color.WHITE);
        this.text.setText(text);
        this.text.draw();

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

    public void increaseWidthPlatform() {
        if(posX > 500) {
            posX -= 50;
            picture.translate(-25, 0);
            picture.grow(width / 2,0);
            width += width;
            return;
        }
        if (posX < 70) {
            picture.translate(25,0);
            picture.grow(width / 2,0);
            this.width += width;
            return;
        }

        int temp = width / 2;
        picture.grow(temp, 0);
        width += width;
        posX -= width / 4;



    }

    public void decreaseWidthPlatform() {
        int temp = -(this.width / 4);
        picture.grow(temp, 0);
        posX += width / 4;
        width -= width / 2;

    }

    public void show() {
        picture.draw();
    }

    public void showScore(){
        text.setColor(Color.WHITE);
        text.setText(Score.stringConcat());
        text.draw();
    }

    public void growScore(int x, int y) {
        text.grow(x, y);
    }

    public void hide() {
        picture.delete();
    }

    public void transformBrick(String source) {
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
    }

   public void moveBrick() {
        this.posY += 1;
        picture.translate(0, 1);

        if (posY + getHeight() == grid.getHeight()) {
            hide();
        }
   }

   public void moveText() {
        this.posY -= 1;
        picture.translate(0, -1);
   }

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
