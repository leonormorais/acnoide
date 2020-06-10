package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.GameObjects.Ball;
import org.academiadecodigo.bootcamp.GameObjects.Bricks.Brick;
import org.academiadecodigo.bootcamp.GameObjects.Bricks.SuperBrick;
import org.academiadecodigo.bootcamp.GameObjects.Hittable;
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

    public Ball getBall() {
        return ball;
    }

    public Platform getPlatform(){ return platform;}

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

        if(hitEdges(platform)) {
            ball.setNewXDirection(-ball.getXDirection());
            ball.setNewYDirection(-ball.getYDirection());
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

                    /*

                    if (brick instanceof SuperBrick) {
                        ((SuperBrick) brick).setCollisionDetector(this);
                    }

                    */

                    return true;

                }
            }
        }
        return false;
    }

    public boolean checkForCollisionSuperBrick(Hittable superBrick) {
        return hitSuperBrick(superBrick);
    }

    private boolean checkForHits(Hittable hittable) {
        //bottom
        if (hitBottomLeftHalf(hittable)) {
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


        if (hitBottomRightHalf(hittable)) {
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


        if (hitBottomCenter(hittable)) {
            ball.setNewXDirection(0);
            System.out.println("Hit bottom center");
            return true;
        }

        //edges
        if (hitEdges(hittable)) {
            ball.setNewXDirection(-ball.getXDirection());
            ball.setNewYDirection(-ball.getYDirection());
            System.out.println("hit edge");
            return true;
        }

        //top
        if (hitTopLeftHalf(hittable)) {              // Igual à plataforma
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

        if (hitTopRightHalf(hittable)) {
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

        if (hitTopCenter(hittable)) {
            ball.setNewXDirection(0);
            System.out.println("hit top center");
            return true;
        }


        return false;
    }

    private boolean hitEdges(Hittable hittable) {

        return ball.getPosition().getPosY() <= hittable.getPosition().getPosY() + hittable.getPosition().getHeight() &&
               ball.getPosition().getPosY() + ball.getPosition().getHeight() >= hittable.getPosition().getPosY() &&
               (ball.getPosition().getPosX() + ball.getPosition().getWidth() == hittable.getPosition().getPosX() ||
               ball.getPosition().getPosX() + ball.getPosition().getWidth() == hittable.getPosition().getPosX() + 1) ||
               ball.getPosition().getPosY() <= hittable.getPosition().getPosY() + hittable.getPosition().getHeight() &&
               ball.getPosition().getPosY() + ball.getPosition().getHeight() >= hittable.getPosition().getPosY() &&
               (ball.getPosition().getPosX() == hittable.getPosition().getPosX() + hittable.getPosition().getWidth() ||
               ball.getPosition().getPosX() == hittable.getPosition().getPosX() + hittable.getPosition().getWidth() -1);
    }

    private boolean hitBottomCenter(Hittable hittable) {
        return (ball.getPosition().getPosY() == hittable.getPosition().getPosY() + hittable.getPosition().getHeight() ||
                ball.getPosition().getPosY() == hittable.getPosition().getPosY() + hittable.getPosition().getHeight() + 1) &&
                ball.getPosition().getPosX() >= hittable.getPosition().getPosX() +  ((hittable.getPosition().getWidth() / 2) - BRICK_CENTER) &&
                ball.getPosition().getPosX() <= hittable.getPosition().getPosX() +  ((hittable.getPosition().getWidth() / 2) + BRICK_CENTER);
    }

    private boolean hitBottomRightHalf(Hittable hittable) { //falta aqui qq coisa, não está a funcionar bem.
        return (ball.getPosition().getPosY() == hittable.getPosition().getPosY() + hittable.getPosition().getHeight() ||
                ball.getPosition().getPosY() == hittable.getPosition().getPosY() + hittable.getPosition().getHeight() + 1) &&
                ball.getPosition().getPosX() >= hittable.getPosition().getPosX() + ((hittable.getPosition().getWidth() / 2) + BRICK_CENTER) &&
                ball.getPosition().getPosX() <= hittable.getPosition().getPosX() + hittable.getPosition().getWidth();
    }

    private boolean hitBottomLeftHalf(Hittable hittable) {
        return (ball.getPosition().getPosY() == hittable.getPosition().getPosY() + hittable.getPosition().getHeight() ||
                ball.getPosition().getPosY() == hittable.getPosition().getPosY() + hittable.getPosition().getHeight() + 1) &&
                ball.getPosition().getPosX() + ball.getPosition().getWidth() >= hittable.getPosition().getPosX() &&
                ball.getPosition().getPosX() <= hittable.getPosition().getPosX() + ((hittable.getPosition().getWidth() / 2) - BRICK_CENTER);
    }

    //hit parte de cima lado esquerdo
    private boolean hitTopLeftHalf(Hittable hittable) {
        return (ball.getPosition().getPosY() + ball.getPosition().getHeight() == hittable.getPosition().getPosY() ||
                ball.getPosition().getPosY() + ball.getPosition().getHeight() == hittable.getPosition().getPosY() + 1) &&
                ball.getPosition().getPosX() + ball.getPosition().getWidth() >= hittable.getPosition().getPosX() &&
                ball.getPosition().getPosX() <= hittable.getPosition().getPosX() + (hittable.getPosition().getWidth() / 2) - BRICK_CENTER;
    }

    //hit parte de cima lado direito
    private boolean hitTopRightHalf(Hittable hittable) {
        return (ball.getPosition().getPosY() + ball.getPosition().getHeight() == hittable.getPosition().getPosY() ||
                ball.getPosition().getPosY() + ball.getPosition().getHeight() == hittable.getPosition().getPosY() + 1) &&
                ball.getPosition().getPosX() + ball.getPosition().getWidth() >= hittable.getPosition().getPosX() + (hittable.getPosition().getWidth() / 2) + BRICK_CENTER &&
                ball.getPosition().getPosX() <= hittable.getPosition().getPosX() + (hittable.getPosition().getWidth());
    }

    //hit parte de cima centro
    private boolean hitTopCenter(Hittable hittable) {
        return (ball.getPosition().getPosY() + ball.getPosition().getHeight() == hittable.getPosition().getPosY() ||
                ball.getPosition().getPosY() + ball.getPosition().getHeight() == hittable.getPosition().getPosY() + 1) &&
                ball.getPosition().getPosX() + ball.getPosition().getWidth() >= hittable.getPosition().getPosX() + (hittable.getPosition().getWidth() / 2) - BRICK_CENTER &&
                ball.getPosition().getPosX() <= hittable.getPosition().getPosX() + (hittable.getPosition().getWidth() / 2) + BRICK_CENTER;
    }

    private boolean hitSuperBrick(Hittable superBrick) {
        return superBrick.getPosition().getPosY() + superBrick.getPosition().getHeight() == platform.getPosition().getPosY() &&
                superBrick.getPosition().getPosX() + superBrick.getPosition().getWidth() >= platform.getPosition().getPosX() &&
                superBrick.getPosition().getPosX() <= platform.getPosition().getPosX() + platform.getPosition().getWidth();
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
