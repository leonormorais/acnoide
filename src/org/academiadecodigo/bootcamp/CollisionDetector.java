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

        //if bater na primeira metade da barra
        if(hitLeftHalf()) {
            if (ball.getXDirection() == -2) {
                ball.setNewXDirection(-1);
            }
            if (ball.getXDirection() == 1) {
                ball.setNewXDirection(-2);
            }
            return true;
        }

        //testing
        if(hitRightHalf()) {
            if (ball.getXDirection() == -2 || ball.getXDirection() == 1) {
                ball.setNewXDirection(-ball.getXDirection());
            }
            if (ball.getXDirection() == 2) {
                ball.setNewXDirection(1);
            }
            return true;
        }

    return false;
    }


    public boolean checkForCollisionBrick() {
        for (Brick brick : bricks) {

            //lógica para bater em todos
            //lógica para bater apenas em um lado (implementar)
            if (ball.getPosition().getPosY() <= brick.getPosition().getPosY() + brick.getPosition().getHeight() &&
                    ball.getPosition().getPosY() + ball.getPosition().getHeight() >= brick.getPosition().getHeight() &&
                    ball.getPosition().getPosX() + ball.getPosition().getWidth() >= brick.getPosition().getPosX() &&
                    ball.getPosition().getPosX() <= brick.getPosition().getPosX() + brick.getPosition().getWidth()) {

               if (!brick.getIsDestroyed()) {
                   brick.destroy();
                   return true;
               }

           }

        }
        return false;
    }

    //hit parte de cima lado esquerdo
    private boolean hitLeftHalf() {
        return ball.getPosition().getPosY() + ball.getBallHeight() == platform.getPosition().getPosY() &&
                ball.getPosition().getPosX() + ball.getBallWidth() >= platform.getPosition().getPosX() &&
                ball.getPosition().getPosX() <= platform.getPosition().getPosX() + (platform.getWIDTH() / 2);
    }

    //hit parte de cima lado direito
    private boolean hitRightHalf() {
        return ball.getPosition().getPosY() + ball.getBallHeight() == platform.getPosition().getPosY() &&
                ball.getPosition().getPosX() + ball.getBallWidth() >= platform.getPosition().getPosX() + (platform.getWIDTH() / 2) &&
                ball.getPosition().getPosX() <= platform.getPosition().getPosX() + (platform.getWIDTH());
    }

}
