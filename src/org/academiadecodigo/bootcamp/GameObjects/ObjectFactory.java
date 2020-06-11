package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.GameObjects.Bricks.Brick;
import org.academiadecodigo.bootcamp.GameObjects.Bricks.BrickType;
import org.academiadecodigo.bootcamp.GameObjects.Bricks.NormalBrick;
import org.academiadecodigo.bootcamp.GameObjects.Bricks.SuperBrick;
import org.academiadecodigo.bootcamp.Grid.Grid;

public class ObjectFactory {

    private final static int MARGIN_LEFT = 41;

    public final static int BRICK_WIDTH = 60;
    public final static int BRICK_HEIGHT = 20;
    private final static double NORMAL_BRICK_PROB = 0.2;

    private final static int BALL_POSITION_X = 295;
    private final static int BALL_POSITION_Y = 400;
    private final static int BALL_WIDTH = 10;
    private final static int BALL_HEIGHT = 10;

    private static int posX = 41;
    private static int posY = 100;

    private static String[] sourceImg = {
            "resources/brickBlue.jpg",
            "resources/BrickCyan.jpg",
            "resources/BrickGray.jpg",
            "resources/brickGreen.jpg",
            "resources/brickOrange.jpg",
            "resources/brickPink.jpg",
            "resources/brickRed.jpg",
            "resources/brickYellow.jpg",
    };

    private static int colorCounter = 0;

    public static Brick[] createBricks(int numberOfBricks, Grid grid) {

        colorCounter = 0;
        posX = 41;
        posY = 100;

        Brick[] bricks = new Brick[numberOfBricks];

        for (int i = 0; i < bricks.length; i++) {
            int j = i + 1;
            bricks[i] = getRandomBrick(grid);

            posX += BRICK_WIDTH;

            if (j % 9 == 0) {
                posY += BRICK_HEIGHT;
                posX = MARGIN_LEFT;
                colorCounter++;
            }
        }
        return bricks;
    }

    private static Brick getRandomBrick(Grid grid) {
        return (Math.random() > NORMAL_BRICK_PROB) ? new NormalBrick(grid.makeGridPosition(posX, posY, BRICK_WIDTH, BRICK_HEIGHT, sourceImg[colorCounter])) : createSuperBrick(grid);
    }

    private static SuperBrick createSuperBrick(Grid grid) {

        BrickType[] bricksType = BrickType.values();
        int random = (int) (Math.random() * bricksType.length);

        if (random == 0) {
            return createSuperBrick(grid);
        }

        BrickType newBrick = bricksType[random];
        return new SuperBrick(grid.makeGridPosition(posX, posY, BRICK_WIDTH, BRICK_HEIGHT, sourceImg[colorCounter]), newBrick);

    }

    public static Ball createBall(Grid grid) {
        return new Ball(grid.makeGridPosition(BALL_POSITION_X, BALL_POSITION_Y, BALL_WIDTH, BALL_HEIGHT, "resources/ball.png"));
    }


}
