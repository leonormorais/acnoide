package org.academiadecodigo.bootcamp.Grid;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GridPosition {

    private final int BALL_POSITION_X = 295;
    private final int BALL_POSITION_Y = 400;
    private final int PLATFORM_WIDTH = 50;
    private final int PLATFORM_HEIGHT = 20;

    private Grid grid;
    private int posX;
    private int posY;
    private int width;
    private int height;
    //private Rectangle rectangle;
    private Picture brickImage;
    private Picture pepino;
    private Ellipse ellipse;

    private Color color;

    public GridPosition(Grid grid, int posX, int posY, int width, int height, String source) {
        this.grid = grid;

        //rectangle = new Rectangle(posX, posY, width, height);

        brickImage = new Picture(posX, posY, source);

        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;

        //this.color = color;

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

    public GridPosition (Grid grid, int posX, int posY, String platform) {
        this.grid = grid;
        this.posX = posX;
        this.posY = posY;

        this.width = PLATFORM_WIDTH;
        this.height = PLATFORM_HEIGHT;

        pepino = new Picture(posX, posY, "resources/pepino.png");

        showPlatform();

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

    public Color getColor() {
        return this.color;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

   /* public void setColor(Color color) {
        rectangle.setColor(color);
    }
    */

    public void setWidth(int width) {
        this.width = width;
    }

    public void show() {
        //rectangle.setColor(color);
        //rectangle.fill();

        brickImage.draw();
    }


    private void showBall() {
        ellipse.setColor(color);
        ellipse.fill();
    }

    private void showPlatform() {
        pepino.draw();
    }


    public void hide() {
        brickImage.delete();
        //rectangle.delete();
    }

    public void hideBall() {
        ellipse.delete();
    }

    //Transformação de SuperBrick em Cara de MC
    public void transformBrick() {
        brickImage.grow(-10, -5);
        //rectangle.grow(-10,-5);
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
        brickImage.translate(0, 1);

        //rectangle.translate(0, 1);

        if (posY + getHeight() == grid.getHeight()) {
            hide();
        }
   }

    //pensar numa solução única com o tipo de Game Object (Ball Or Brick)
   public void moveBall(int[] direction) {
       this.posX += direction[0];
       this.posY += direction[1];
       ellipse.translate(direction[0], direction[1]);
   }


   //move platform
    private void moveLeft() {
        this.posX -= 1;
        pepino.translate(-1, 0);
    }

    //move platform
    private void moveRight() {
        this.posX += 1;
        pepino.translate(1, 0);
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
