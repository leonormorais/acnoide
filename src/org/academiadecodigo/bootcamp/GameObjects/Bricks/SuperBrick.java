package org.academiadecodigo.bootcamp.GameObjects.Bricks;

import org.academiadecodigo.bootcamp.CollisionDetector;
import org.academiadecodigo.bootcamp.GameObjects.Ball;
import org.academiadecodigo.bootcamp.GameObjects.Platform;
import org.academiadecodigo.bootcamp.Grid.GridPosition;
import org.academiadecodigo.bootcamp.GameObjects.Score;
import org.academiadecodigo.bootcamp.Sound;

public class SuperBrick extends Brick {

    private Sound sound = new Sound();
    private final int BRICK_SPEED = 5;
    private CollisionDetector collisionDetector;
    private int scoreWhenStartedSP; //Score when superpower starts
    private boolean isActive; // if super power is active or not
    private GridPosition additionalElement;
    private GridPosition textInformation;
    private boolean textOn;

    public SuperBrick(GridPosition position, BrickType type) {
        super(position, type);
        this.isActive = false;
    }


    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }

    public void superPower() {

        switch (type) {

            case SERGIO:
                sound.playTadaSound();
                Score.setScore(1000);
                scoreWhenStartedSP = Score.intGetScore();
                isActive = true;
                showInformation();
                break;

            case LUIS:
                if (collisionDetector.getBall().getIsLuisActive()) {
                    break;
                }
                sound.playBaby();
                scoreWhenStartedSP = Score.intGetScore();
                additionalElement = grid.makeGridPosition(22, 690, 574, 20, "resources/baby.png");
                additionalElement.show();
                collisionDetector.getBall().setIsLuisActive(true);
                isActive = true;
                showInformation();
                break;

            case PRIS:
                if (collisionDetector.getBall().getIsPrisActive()){
                    break;
                }
                sound.playMeow();
                scoreWhenStartedSP = Score.intGetScore();
                collisionDetector.getPlatform().setPlatformSpeed(Platform.MAXIMUM_SPEED);
                collisionDetector.getBall().setIsPrisActive(true);
                isActive = true;
                showInformation();
                break;

            case RITA:
                if (collisionDetector.getPlatform().getIsRitaActive()) {
                    break;
                }
                sound.playRitaSound();
                scoreWhenStartedSP = Score.intGetScore();
                collisionDetector.getPlatform().getPosition().increaseWidthPlatform();
                collisionDetector.getPlatform().setIsRitaActive(true);
                isActive = true;
                showInformation();
                break;

            case VANDO:
                if (collisionDetector.getBall().getIsVandoActive()) {
                    break;
                }
                sound.playVandoSound();
                scoreWhenStartedSP = Score.intGetScore();
                collisionDetector.getBall().setBallSpeed(Ball.MINOR_SPEED);
                collisionDetector.getBall().setIsVandoActive(true);
                isActive = true;
                showInformation();
                break;

        }

    }

    private void showInformation() {

        textOn = true;

        switch(type) {
            case SERGIO:
                textInformation = grid.makeGridPosition(175, 600, 280, 20, "resources/1000score.png");
                textInformation.show();
                break;
            case LUIS:
                textInformation = grid.makeGridPosition(175, 600, 280, 20, "resources/babynet.png");
                textInformation.show();
                break;
            case PRIS:
                textInformation = grid.makeGridPosition(175, 600, 280, 20, "resources/CucumberSpeed.png");
                textInformation.show();
                break;
            case RITA:
                textInformation = grid.makeGridPosition(175, 600, 280, 20, "resources/cucumberx2.png");
                textInformation.show();
                break;
            case VANDO:
                textInformation = grid.makeGridPosition(175, 600, 280, 20, "resources/ballspeed.png");
                textInformation.show();
                break;
        }



    }

    public void deleteSuperPower(){

        switch (type) {

            case LUIS:
                collisionDetector.getBall().setIsLuisActive(false);
                additionalElement.hide();
                break;

            case PRIS:
                collisionDetector.getPlatform().setPlatformSpeed(Platform.MINIMUM_SPEED);
                collisionDetector.getBall().setIsPrisActive(false);
                break;

            case RITA:
                collisionDetector.getPlatform().getPosition().decreaseWidthPlatform();
                collisionDetector.getPlatform().setIsRitaActive(false);
                break;

            case VANDO:
                collisionDetector.getBall().setBallSpeed(Ball.MAXIMUM_SPEED);
                collisionDetector.getBall().setIsVandoActive(false);
                break;

        }
        isActive = false;

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

            if (isActive) {
               if (Score.intGetScore() - scoreWhenStartedSP >= 50 || isVando()) {
                    textInformation.hide();
                    textOn = false;
                }

                if (Score.intGetScore() - scoreWhenStartedSP >= 500) {
                   deleteSuperPower();
                }

                if (isTextOn()) {
                    textInformation.moveText();
                }

            } else {
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

    private boolean isVando() {
        return collisionDetector.getBall().getIsVandoActive() && Score.intGetScore() - scoreWhenStartedSP >= 50 / 2;
    }

    public boolean isTextOn() {
        return textOn;
    }


}
