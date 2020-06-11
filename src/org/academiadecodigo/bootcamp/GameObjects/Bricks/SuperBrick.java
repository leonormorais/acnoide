package org.academiadecodigo.bootcamp.GameObjects.Bricks;
import org.academiadecodigo.bootcamp.CollisionDetector;
import org.academiadecodigo.bootcamp.Grid.GridPosition;
import org.academiadecodigo.bootcamp.GameObjects.Score;
import org.academiadecodigo.bootcamp.Tests.Sound;

public class SuperBrick extends Brick {

    private final int BRICK_SPEED = 5;
    private CollisionDetector collisionDetector;
    private int scoreWhenStartedSP; //Score quando começa o super poder
    private boolean isActive; // Super power está ativo ou não.
    private GridPosition additionalElement;

    public SuperBrick(GridPosition position, BrickType type) {
        super(position, type);
    }


    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }

    public void superPower() {

        scoreWhenStartedSP = Score.intGetScore();
        isActive = true;

        switch (type) {
            case SERGIO:
                Score.setScore(1000);
                additionalElement = grid.makeGridPosition(175, 350, 264, 88, "resources/1000.png");
                additionalElement.show();
                break;

            case LUIS:
                //Som do bebé a chorar
                if (collisionDetector.getBall().getIsLuisActive()) {
                    break;
                }
                additionalElement = grid.makeGridPosition(22, 690, 574, 20, "resources/baby.png");
                additionalElement.show();
                collisionDetector.getBall().setIsLuisActive(true);
                break;

            case PRIS:
                Sound.playMeow();
                collisionDetector.getPlatform().setPlatformSpeed(collisionDetector.getPlatform().getPlatformSpeed() * 2);
                break;

            case RITA:
                if (collisionDetector.getPlatform().getIsRitaActive()) {
                    break;
                }
                collisionDetector.getPlatform().getPosition().increaseWidthPlatform();
                collisionDetector.getPlatform().setIsRitaActive(true);
                break;

            case VANDO:
                collisionDetector.getBall().setBallSpeed(collisionDetector.getBall().getBallSpeed() / 2);
                break;
        }
    }

    public void deleteSuperPower(){

        isActive = false;

        switch (type) {
            case SERGIO:
                additionalElement.hide();
                break;

            case LUIS:
                collisionDetector.getBall().setIsLuisActive(false);
                additionalElement.hide();
                break;

            case PRIS:
                collisionDetector.getPlatform().setPlatformSpeed(collisionDetector.getPlatform().getPlatformSpeed() / 2);
                break;

            case RITA:
                collisionDetector.getPlatform().getPosition().decreaseWidthPlatform();
                collisionDetector.getPlatform().setIsRitaActive(false);

            case VANDO:
                collisionDetector.getBall().setBallSpeed(collisionDetector.getBall().getBallSpeed() * 2);
                break;

        }

    }

    @Override
    public void destroy() {

        this.isDestroyed = true;

        switch (type) {
            case SERGIO:
                this.position.transformBrick(BrickType.SERGIO.getSourceImg());
                break;
            case LUIS:
                this.position.transformBrick(BrickType.LUIS.getSourceImg());
                break;
            case PRIS:
                this.position.transformBrick(BrickType.PRIS.getSourceImg());
                break;
            case RITA:
                this.position.transformBrick(BrickType.RITA.getSourceImg());
                break;
            case VANDO:
                this.position.transformBrick(BrickType.VANDO.getSourceImg());
                break;
        }

        this.move();

    }

    @Override
    public void move() {
        for (int i = 0; i < BRICK_SPEED; i++) {

            if(isActive) {
                if (Score.intGetScore() - scoreWhenStartedSP >= 500
                   || (type == BrickType.SERGIO && Score.intGetScore() - scoreWhenStartedSP >= 50)) {

                    System.out.println(Score.intGetScore());
                    deleteSuperPower();

                }
            }

            if (isDestroyed) {
                if (collisionDetector.checkForCollisionSuperBrick(this)) {
                    superPower();
                    position.hide();
                }
                position.moveBrick();
            }

        }
    }

}
