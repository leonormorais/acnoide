package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.GameObjects.Ball;
import org.academiadecodigo.bootcamp.GameObjects.Bricks.Brick;
import org.academiadecodigo.bootcamp.GameObjects.Bricks.SuperBrick;
import org.academiadecodigo.bootcamp.GameObjects.Hitable;
import org.academiadecodigo.bootcamp.GameObjects.Platform;

public class CollisionDetector {

    private final int BRICK_WIDTH = 40;
    private final int BRICK_CENTER = 8;

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

                       /* if (brick instanceof SuperBrick) {
                            ((SuperBrick) brick).setCollisionDetector(this);
                        }

                        */

                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkForHits(Hitable hitable) {
        //bottom
        if (hitBottomLeftHalf(hitable)) {
            if(ball.getXDirection() == 0) {  // Só mudou este em relação à plataforma.
                ball.setNewXDirection(1);
            }
            if (ball.getXDirection() == 2) {
                ball.setNewXDirection(1);
            }
            if (ball.getXDirection() == -1) {
                ball.setNewXDirection(-2);
            }
            System.out.println("Hit bottom left");
            return true;
        }


        if (hitBottomRightHalf(hitable)) {
            if(ball.getXDirection() == 0) {  // Só mudou este em relação à plataforma.
                ball.setNewXDirection(-1);
            }
            if (ball.getXDirection() == -2) {
                ball.setNewXDirection(-1);
            }
            if (ball.getXDirection() == 1) {
                ball.setNewXDirection(2);
            }
            System.out.println("Hit bottom right");
            return true;
        }


        if (hitBottomCenter(hitable)) {
            ball.setNewXDirection(0);
            System.out.println("Hit bottom center");
            return true;
        }

        //edges
        if (hitEdges(hitable)) {
            ball.setNewXDirection(-ball.getXDirection());
            ball.setNewYDirection(-ball.getYDirection()); //
            System.out.println("hit edge");
            return true;
        }

        //top
        if (hitTopLeftHalf(hitable)) {              // Igual à plataforma
            if(ball.getXDirection() == 0) {
                ball.setNewXDirection(-1);
            }
            if (ball.getXDirection() == 2) {
                ball.setNewXDirection(1);
            }
            if (ball.getXDirection() == -1) {
                ball.setNewXDirection(-2);
            }
            System.out.println("hit top left");
            return true;
        }

        if (hitTopRightHalf(hitable)) {
            if(ball.getXDirection() == 0) {
                ball.setNewXDirection(1);
            }
            if (ball.getXDirection() == -2) {
                ball.setNewXDirection(-1);
            }
            if (ball.getXDirection() == 1) {
                ball.setNewXDirection(2);
            }
            System.out.println("hit top right");
            return true;
        }

        if (hitTopCenter(hitable)) {
            ball.setNewXDirection(0);
            System.out.println("hit top center");
            return true;
        }


        return false;
    }

    private boolean hitEdges(Hitable hitable) {

        return ball.getPosition().getPosY() <= hitable.getPosition().getPosY() + hitable.getPosition().getHeight() &&
               ball.getPosition().getPosY() + ball.getPosition().getHeight() >= hitable.getPosition().getPosY() &&
               (ball.getPosition().getPosX() + ball.getPosition().getWidth() == hitable.getPosition().getPosX() ||
               ball.getPosition().getPosX() + ball.getPosition().getWidth() == hitable.getPosition().getPosX() + 1) ||
               ball.getPosition().getPosY() <= hitable.getPosition().getPosY() + hitable.getPosition().getHeight() &&
               ball.getPosition().getPosY() + ball.getPosition().getHeight() >= hitable.getPosition().getPosY() &&
               (ball.getPosition().getPosX() == hitable.getPosition().getPosX() + hitable.getPosition().getWidth() ||
               ball.getPosition().getPosX() == hitable.getPosition().getPosX() + hitable.getPosition().getWidth() -1);
    }

    private boolean hitBottomCenter(Hitable hitable) {
        return ball.getPosition().getPosY() == hitable.getPosition().getPosY() + hitable.getPosition().getHeight() &&
               ball.getPosition().getPosX() >= hitable.getPosition().getPosX() +  ((hitable.getPosition().getWidth() / 2) - BRICK_CENTER) &&
               ball.getPosition().getPosX() <= hitable.getPosition().getPosX() +  ((hitable.getPosition().getWidth() / 2) + BRICK_CENTER);
    }

    private boolean hitBottomRightHalf(Hitable hitable) { //falta aqui qq coisa, não está a funcionar bem.
        return ball.getPosition().getPosY() == hitable.getPosition().getPosY() + hitable.getPosition().getHeight() &&
                ball.getPosition().getPosX() >= hitable.getPosition().getPosX() + ((hitable.getPosition().getWidth() / 2) + BRICK_CENTER) &&
                ball.getPosition().getPosX() <= hitable.getPosition().getPosX() + hitable.getPosition().getWidth();
    }

    private boolean hitBottomLeftHalf(Hitable hitable) {
        return ball.getPosition().getPosY() == hitable.getPosition().getPosY() + hitable.getPosition().getHeight() &&
                ball.getPosition().getPosX() + ball.getPosition().getWidth() >= hitable.getPosition().getPosX() &&
                ball.getPosition().getPosX() <= hitable.getPosition().getPosX() + ((hitable.getPosition().getWidth() / 2) - BRICK_CENTER);
    }

    //hit parte de cima lado esquerdo
    private boolean hitTopLeftHalf(Hitable hitable) {
        return (ball.getPosition().getPosY() + ball.getPosition().getHeight() == hitable.getPosition().getPosY() ||
                ball.getPosition().getPosY() + ball.getPosition().getHeight() == hitable.getPosition().getPosY() + 1) &&
                ball.getPosition().getPosX() + ball.getPosition().getWidth() >= hitable.getPosition().getPosX() &&
                ball.getPosition().getPosX() <= hitable.getPosition().getPosX() + (hitable.getPosition().getWidth() / 2) - BRICK_CENTER;
    }

    //hit parte de cima lado direito
    private boolean hitTopRightHalf(Hitable hitable) {
        return (ball.getPosition().getPosY() + ball.getPosition().getHeight() == hitable.getPosition().getPosY() ||
                ball.getPosition().getPosY() + ball.getPosition().getHeight() == hitable.getPosition().getPosY() + 1) &&
                ball.getPosition().getPosX() + ball.getPosition().getWidth() >= hitable.getPosition().getPosX() + (hitable.getPosition().getWidth() / 2) + BRICK_CENTER &&
                ball.getPosition().getPosX() <= hitable.getPosition().getPosX() + (hitable.getPosition().getWidth());
    }

    //hit parte de cima centro
    private boolean hitTopCenter(Hitable hitable) {
        return ball.getPosition().getPosY() + ball.getPosition().getHeight() == hitable.getPosition().getPosY() &&
                ball.getPosition().getPosX() + ball.getPosition().getWidth() >= hitable.getPosition().getPosX() + (hitable.getPosition().getWidth() / 2) - BRICK_CENTER &&
                ball.getPosition().getPosX() <= hitable.getPosition().getPosX() + (hitable.getPosition().getWidth() / 2) + BRICK_CENTER;
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
