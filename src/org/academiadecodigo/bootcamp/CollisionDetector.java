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
            ball.setNewXDirection(-2);
            return true;
        }

        if(hitRightHalf()) {
            ball.setNewXDirection(2);
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

    private boolean hitLeftHalf() {
        return ball.getPosition().getPosY() + ball.getBallHeight() == platform.getPosition().getPosY() &&
                ball.getPosition().getPosX() + ball.getBallWidth() >= platform.getPosition().getPosX() &&
                ball.getPosition().getPosX() <= platform.getPosition().getPosX() + (platform.getWIDTH() / 2);
    }

    private boolean hitRightHalf() {
        return ball.getPosition().getPosY() + ball.getBallHeight() == platform.getPosition().getPosY() &&
                ball.getPosition().getPosX() + ball.getBallWidth() >= platform.getPosition().getPosX() + (platform.getWIDTH() / 2) &&
                ball.getPosition().getPosX() <= platform.getPosition().getPosX() + (platform.getWIDTH());
    }

}

   /*
            if (ball.getPosition().getPosY() <= brick.getPosition().getPosY() + brick.getPosition().getHeight() &&         //limite de colisão da parte de baixo do tijolo
                    ball.getPosition().getPosY() + ball.getPosition().getHeight() >= brick.getPosition().getHeight() &&        //limite da colisão da parte de cima do tijolo
                    ball.getPosition().getPosX() + ball.getPosition().getWidth() >= brick.getPosition().getPosX() &&         //limite de colisão da parte esquerda do tijolo
                    ball.getPosition().getPosX() <= brick.getPosition().getPosX() + brick.getPosition().getWidth())             //limite de colisão da parte direita do tijolo
            { */
// if (ball.getPosition().getPosY().equals(brick.getPosition().getPosY())) {

        /* lógica para de baixo (Se quisermos separar)
        if (ball.getPosition().getPosY() <= (brick.getPosition().getPosY() + brick.getPosition().getHeight()) &&
        ball.getPosition().getPosX() >= brick.getPosition().getPosX() &&
        ball.getPosition().getPosX() + ball.getPosition().getWidth() <= brick.getPosition().getPosX() + brick.getPosition().getWidth()) {
        */
