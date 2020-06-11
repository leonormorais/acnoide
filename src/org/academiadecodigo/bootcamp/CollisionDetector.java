package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.GameObjects.Ball;
import org.academiadecodigo.bootcamp.GameObjects.Bricks.Brick;
import org.academiadecodigo.bootcamp.GameObjects.Hittable;
import org.academiadecodigo.bootcamp.GameObjects.Platform;

public class CollisionDetector {

    private final int BRICK_CENTER = 8;

    private Brick[] bricks;
    private Platform platform;
    private Ball ball;
    private int destroyedBricksCounter = 0;
    private boolean isCollidedPlatform;

    public CollisionDetector(Brick[] bricks, Platform platform, Ball ball) {
        this.bricks = bricks;
        this.platform = platform;
        this.ball = ball;
    }

    public Ball getBall() {
        return ball;
    }

    public Platform getPlatform(){ return platform;}

    public int getDestroyedBricksCounter() {
        return destroyedBricksCounter;
    }

    public boolean getIsCollidedPlatform() {
        return isCollidedPlatform;
    }

    public void setIsCollidedPlatform(boolean isCollidedPlatform) {
        this.isCollidedPlatform = isCollidedPlatform;
    }

    public void resetDestroyedBricks() {
        this.destroyedBricksCounter = 0;
    }

    //platform
    public boolean checkForCollisionPlatform() {
        return checkForHits(platform);
    }

    //bricks
    public boolean checkForCollisionBrick() {
        for (Brick brick : bricks) {
            if (!brick.getIsDestroyed()) {
                   if(checkForHits(brick))  {
                    brick.destroy();
                    this.destroyedBricksCounter++;
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
        if (hitBottomLeft(hittable)) {
            if(ball.getXDirection() == 0) {
                ball.setNewXDirection(1);
            }
            if (ball.getXDirection() == 2) {
                ball.setNewXDirection(1);
            }
            if (ball.getXDirection() == -1) {
                ball.setNewXDirection(-2);
            }
            return true;
        }

        if (hitBottomRight(hittable)) {
            if(ball.getXDirection() == 0) {
                ball.setNewXDirection(-1);
            }
            if (ball.getXDirection() == -2) {
                ball.setNewXDirection(-1);
            }
            if (ball.getXDirection() == 1) {
                ball.setNewXDirection(2);
            }
            return true;
        }

        if (hitBottomCenter(hittable)) {
            ball.setNewXDirection(0);
            return true;
        }

        //edges
        if (hitEdges(hittable)) {
            ball.setNewXDirection(-ball.getXDirection());
            ball.setNewYDirection(-ball.getYDirection());
            return true;
        }

        //top
        if (hitTopLeft(hittable)) {
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

        if (hitTopRight(hittable)) {
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

        if (hitTopCenter(hittable)) {
            ball.setNewXDirection(0);
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

    private boolean hitBottomRight(Hittable hittable) {

        return (ball.getPosition().getPosY() == hittable.getPosition().getPosY() + hittable.getPosition().getHeight() ||
                ball.getPosition().getPosY() == hittable.getPosition().getPosY() + hittable.getPosition().getHeight() + 1) &&
                ball.getPosition().getPosX() >= hittable.getPosition().getPosX() + ((hittable.getPosition().getWidth() / 2) + BRICK_CENTER) &&
                ball.getPosition().getPosX() <= hittable.getPosition().getPosX() + hittable.getPosition().getWidth();
    }

    private boolean hitBottomLeft(Hittable hittable) {

        return (ball.getPosition().getPosY() == hittable.getPosition().getPosY() + hittable.getPosition().getHeight() ||
                ball.getPosition().getPosY() == hittable.getPosition().getPosY() + hittable.getPosition().getHeight() + 1) &&
                ball.getPosition().getPosX() + ball.getPosition().getWidth() >= hittable.getPosition().getPosX() &&
                ball.getPosition().getPosX() <= hittable.getPosition().getPosX() + ((hittable.getPosition().getWidth() / 2) - BRICK_CENTER);
    }

    private boolean hitTopLeft(Hittable hittable) {

        return (ball.getPosition().getPosY() + ball.getPosition().getHeight() == hittable.getPosition().getPosY() ||
                ball.getPosition().getPosY() + ball.getPosition().getHeight() == hittable.getPosition().getPosY() + 1) &&
                ball.getPosition().getPosX() + ball.getPosition().getWidth() >= hittable.getPosition().getPosX() &&
                ball.getPosition().getPosX() <= hittable.getPosition().getPosX() + (hittable.getPosition().getWidth() / 2) - BRICK_CENTER;
    }

    private boolean hitTopRight(Hittable hittable) {

        return (ball.getPosition().getPosY() + ball.getPosition().getHeight() == hittable.getPosition().getPosY() ||
                ball.getPosition().getPosY() + ball.getPosition().getHeight() == hittable.getPosition().getPosY() + 1) &&
                ball.getPosition().getPosX() + ball.getPosition().getWidth() >= hittable.getPosition().getPosX() + (hittable.getPosition().getWidth() / 2) + BRICK_CENTER &&
                ball.getPosition().getPosX() <= hittable.getPosition().getPosX() + (hittable.getPosition().getWidth());
    }

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
