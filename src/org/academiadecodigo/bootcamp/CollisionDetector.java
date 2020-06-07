package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.GameObjects.Ball;
import org.academiadecodigo.bootcamp.GameObjects.Bricks.Brick;
import org.academiadecodigo.bootcamp.GameObjects.Platform;

public class CollisionDetector {

    private final static int BALL_WIDTH = 10;
    private final int BRICK_WIDTH = 40;

    private Brick[] bricks;
    private Platform platform;
    private Ball ball;

    public CollisionDetector(Brick[] bricks, Platform platform, Ball ball) {
        this.bricks = bricks;
        this.platform = platform;
        this.ball = ball;
    }

    public boolean checkForCollision() {

        //precisa de ajustar as posições reais em pixels mas já da para testar

        if (ball.getPosition().getPosX() >= platform.getPosition().getPosX() &&
                ball.getPosition().getPosX() + BALL_WIDTH <= platform.getPosition().getPosX()




        ) {
            return true;
        }

        for (int i = 0; i < bricks.length; i++) {

            if (ball.getPosition() == bricks[i].getPosition()) {
                // if (brick is destroyed)
                  // return false;
                bricks[i].destroy();
                return true;
            }

        }

        return false;

    }






}
