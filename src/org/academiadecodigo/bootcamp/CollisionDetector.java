package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.GameObjects.Ball;
import org.academiadecodigo.bootcamp.GameObjects.Bricks.Brick;
import org.academiadecodigo.bootcamp.GameObjects.Bricks.SuperBrick;
import org.academiadecodigo.bootcamp.GameObjects.Hitable;
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

    //platform
    public boolean checkForCollisionPlatform() {

        if(hitTopLeftHalf(platform)) {
            if(ball.getXDirection() == 0) {
                ball.setNewXDirection(-1);
            }
            if (ball.getXDirection() == 2) {
                ball.setNewXDirection(1);
            }
            if (ball.getXDirection() == -1) {
                ball.setNewXDirection(-2);
            }
            return true;
        }

        if(hitTopCenter(platform)) {
            ball.setNewXDirection(0);
            return true;
        }

        if(hitTopRightHalf(platform)) {
            if(ball.getXDirection() == 0) {
                ball.setNewXDirection(1);
            }
            if (ball.getXDirection() == -2) {
                ball.setNewXDirection(-1);
            }
            if (ball.getXDirection() == 1) {
                ball.setNewXDirection(2);
            }
            return true;
        }

    return false;
    }


    //bricks
    public boolean checkForCollisionBrick() {
        for (Brick brick : bricks) {

            if (!brick.getIsDestroyed()) {
                   if(checkForHits(brick))  {
                    brick.destroy();
                    return true;
                }
            }
            /*
            //lógica para bater apenas em um lado (implementar)
            if (ball.getPosition().getPosY() <= brick.getPosition().getPosY() + brick.getPosition().getHeight() &&
                    ball.getPosition().getPosY() + ball.getPosition().getHeight() >= brick.getPosition().getHeight() &&
                    ball.getPosition().getPosX() + ball.getPosition().getWidth() >= brick.getPosition().getPosX() &&
                    ball.getPosition().getPosX() <= brick.getPosition().getPosX() + brick.getPosition().getWidth()) {

               if (!brick.getIsDestroyed()) {

               }

           }
            */
        }
        return false;
    }

    private boolean checkForHits(Hitable hitable) {
        if (hitBottomLeftHalf(hitable)) {
            ball.setNewXDirection(-1); // test
            System.out.println("hit bottom left half");
            return true;
        }
        if (hitBottomRightHalf(hitable)) {
            ball.setNewXDirection(1); // test
            System.out.println("hit bottom right half");
            return true;
        }
        return false;
    }



    private boolean hitBottomRightHalf(Hitable hitable) {
        return ball.getPosition().getPosY() == hitable.getPosition().getPosY() + hitable.getPosition().getHeight() &&
                ball.getPosition().getPosX() >= hitable.getPosition().getPosX() + (hitable.getPosition().getWidth() / 2) &&
                ball.getPosition().getPosX() <= hitable.getPosition().getPosX() + hitable.getPosition().getWidth();
    }

    private boolean hitBottomLeftHalf(Hitable hitable) {
        return ball.getPosition().getPosY() == hitable.getPosition().getPosY() + hitable.getPosition().getHeight() &&
                ball.getPosition().getPosX() >= hitable.getPosition().getPosX() &&
                ball.getPosition().getPosX() <= hitable.getPosition().getPosX() + (hitable.getPosition().getWidth() / 2);
    }




    //hit parte de cima lado esquerdo
    private boolean hitTopLeftHalf(Hitable hitable) {
        return ball.getPosition().getPosY() + ball.getBallHeight() == hitable.getPosition().getPosY() &&
                ball.getPosition().getPosX() + ball.getBallWidth() >= hitable.getPosition().getPosX() &&
                ball.getPosition().getPosX() <= hitable.getPosition().getPosX() + (hitable.getPosition().getWidth() / 2) - 10;
    }

    //hit parte de cima lado direito
    private boolean hitTopRightHalf(Hitable hitable) {
        return ball.getPosition().getPosY() + ball.getBallHeight() == hitable.getPosition().getPosY() &&
                ball.getPosition().getPosX() + ball.getBallWidth() >= hitable.getPosition().getPosX() + (hitable.getPosition().getWidth() / 2) + 10 &&
                ball.getPosition().getPosX() <= hitable.getPosition().getPosX() + (hitable.getPosition().getWidth());
    }

    //hit parte de cima centro
    private boolean hitTopCenter(Hitable hitable) {
        return ball.getPosition().getPosY() + ball.getBallHeight() == hitable.getPosition().getPosY() &&
                ball.getPosition().getPosX() + ball.getBallWidth() >= hitable.getPosition().getPosX() + (hitable.getPosition().getWidth() / 2) - 10 &&
                ball.getPosition().getPosX() <= hitable.getPosition().getPosX() + (hitable.getPosition().getWidth() / 2) + 10;
    }

}
