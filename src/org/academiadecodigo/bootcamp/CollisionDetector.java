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
        for (int i = 0; i < bricks.length; i++) {

            if (bricks[i].getIsDestroyed()) {
                return false;
            } else {
                System.out.println(ball.getPosition().toString());
                System.out.println("# " + i + bricks[i].getPosition().toString());

                if (ball.getPosition().getPosY() <= bricks[i].getPosition().getPosY() + bricks[i].getPosition().getHeight() &&         //limite de colisão da parte de baixo do tijolo
                        ball.getPosition().getPosY() + ball.getPosition().getHeight() >= bricks[i].getPosition().getHeight() &&        //limite da colisão da parte de cima do tijolo
                        ball.getPosition().getPosX() + ball.getPosition().getWidth() >= bricks[i].getPosition().getPosX() &&           //limite de colisão da parte esquerda do tijolo
                        ball.getPosition().getPosX() <= bricks[i].getPosition().getPosX() + bricks[i].getPosition().getWidth()) {       //limite de colisão da parte direita do tijolo
                    System.out.println("collision");
                    bricks[i].destroy();
                    return true;
                }
            }

        }

        return false;
    }


}
