package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.GameObjects.Ball;
import org.academiadecodigo.bootcamp.GameObjects.Bricks.Brick;
import org.academiadecodigo.bootcamp.GameObjects.Platform;

public class CollisionDetector {

    private final int BRICK_WIDTH = 40;

    private Brick[] bricks;
    private Platform platform;
    private Ball ball;

    public CollisionDetector(Brick[] bricks, Platform platform, Ball ball) {
        this.bricks = bricks;
        this.platform = platform;
        this.ball = ball;
    }

    public boolean checkForCollisionPlatform() {

        //necessário verificar

        return ball.getPosition().getPosY() + ball.getBallHeight() == platform.getPosition().getPosY() &&
                ball.getPosition().getPosX() + ball.getBallWidth() >= platform.getPosition().getPosX() &&
                ball.getPosition().getPosX() <= platform.getPosition().getPosX() + platform.getPosition().getPosX() + platform.getHEIGHT();


    }
/*
    public boolean checkForCollisionBrick() {
        for (int i = 0; i < bricks.length; i++) {

            if (bricks[i].getIsDestroyed()) {
                return false;
            }

            if (ball.getPosition().getPosY() <= bricks[i].getPosition().getPosY() + ) {
                bricks[i].destroy();
                return true;
            }

        }

    }

 */

}
