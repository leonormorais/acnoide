package org.academiadecodigo.bootcamp.Grid;


import org.academiadecodigo.bootcamp.Score;
import org.academiadecodigo.simplegraphics.graphics.*;
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
    private Text text;
    private Picture additional;


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

    //Refactor grid position
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

    public GridPosition (Grid grid, int posX, int posY, String futureEnum) {
        this.grid = grid;
        this.posX = posX;
        this.posY = posY;


        switch (futureEnum) {
            case "platform":
                this.width = PLATFORM_WIDTH;
                this.height = PLATFORM_HEIGHT;

                pepino = new Picture(posX, posY, "resources/pepino.png");

                showPlatform();
                break;

            case "score":
                this.text = new Text(posX, posY, Score.stringGetScore());
                showScore();
                break;
/*
            case "additional":
                this.width = 264;
                this.height = 88;

                additional = new Picture(posX, posY, "resources/1000.png");
*/
        }


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

    //Original 50
    //Final 75


    public void increaseWidthPlatform() {
        int test = width / 2;
        this.width += width / 2 ;
        posX -= width / 2;
        pepino.grow(test, 0);
    }

    //Original 75 ->
    //final 50
    public void decreaseWidthPlatform() {
        int cucumber = -(this.width / 3);
        this.width -= width / 3;
        posX += width / 3;
        pepino.grow(cucumber , 0);
    }

    public void show() {
        brickImage.draw();
    }

    public void showScore(){
        text.setColor(Color.WHITE);
        text.setText(Score.stringGetScore());
        text.draw();
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
    }

    public void showAdditional() {
        additional.draw();
    }
    public void hideAdditional() {
        additional.delete();
    }

    public void hideBall() {
        ellipse.delete();
    }


    public void transformBrick(String source) {
        //brickImage.grow(-10, 39);
        width = 50;
        height = 69;
        brickImage.load(source);
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
        brickImage.translate(0, 1);

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
