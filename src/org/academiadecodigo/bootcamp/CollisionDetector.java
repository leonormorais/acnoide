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

        return ball.getPosition().getPosY() + ball.getBallHeight() == platform.getPosition().getPosY() &&
                ball.getPosition().getPosX() + ball.getBallWidth() >= platform.getPosition().getPosX() &&
                ball.getPosition().getPosX() <= platform.getPosition().getPosX() + platform.getWIDTH();


    }
 

    public boolean checkForCollisionBrick() {
        for (Brick brick : bricks) {

            if (brick.getIsDestroyed()) {
                return false;
            }

            if (ball.getPosition().getPosY() <= brick.getPosition().getPosY() + brick.getPosition().getHeight() &&         //limite de colisão da parte de baixo do tijolo
                    ball.getPosition().getPosY() + ball.getPosition().getHeight() >= brick.getPosition().getHeight() &&        //limite da colisão da parte de cima do tijolo
                    ball.getPosition().getPosX() + ball.getPosition().getWidth() >= brick.getPosition().getPosX() &&         //limite de colisão da parte esquerda do tijolo
                    ball.getPosition().getPosX() <= brick.getPosition().getPosX() + brick.getPosition().getWidth())             //limite de colisão da parte direita do tijolo
            {
          // if (ball.getPosition().getPosY().equals(brick.getPosition().getPosY())) {
                System.out.println("collision");
                brick.destroy();
                return true;
            }
        }
        return false;
    }

}
