package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.GameObjects.Bricks.Brick;
import org.academiadecodigo.bootcamp.GameObjects.Bricks.BrickType;
import org.academiadecodigo.bootcamp.GameObjects.Bricks.NormalBrick;
import org.academiadecodigo.bootcamp.GameObjects.Bricks.SuperBrick;
import org.academiadecodigo.bootcamp.Grid.GridPosition;

public class ObjectFactory {

    private final static int MARGIN_LEFT = 40;
    private final static int BRICK_WIDTH = 60;
    private final static int BRICK_HEIGHT = 20;
    private final static double NORMAL_BRICK_PROB = 0.2;

    private static int posX = 40;
    private static int posY = 40;

   // private Brick[] bricks;

    public static Brick[] createBricks(int numberOfBricks) {
        /* if (numberOfBricks % 9 != 0) {
            System.out.println("error.");
            return;
        } */
        Brick[] bricks = new Brick[numberOfBricks];

        for (int i = 0; i < bricks.length; i++) {
            int j = i + 1;
            bricks[i] = getRandomBrick();

            posX += (BRICK_WIDTH + 1);

            if (j % 9 == 0) {
                posY += (BRICK_HEIGHT + 1);
                posX = MARGIN_LEFT;
            }
        }
        return bricks;
    }

    private static Brick getRandomBrick() {
        return (Math.random() > NORMAL_BRICK_PROB) ? new NormalBrick(new GridPosition(posX, posY, BRICK_WIDTH, BRICK_HEIGHT, BrickType.NORMAL.getColor())) : createSuperBrick();
    }


    private static SuperBrick createSuperBrick() {
        BrickType[] bricksType = BrickType.values();
        int random = (int) (Math.random() * bricksType.length);

        if (random == 0) {
            return createSuperBrick();
        }

        BrickType newBrick = bricksType[random];

        return new SuperBrick(new GridPosition(posX, posY, BRICK_WIDTH, BRICK_HEIGHT, newBrick.getColor()), newBrick);

    }


}
