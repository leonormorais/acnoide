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
    private GridPosition textInformation;
    private boolean textOn;

    public SuperBrick(GridPosition position, BrickType type) {
        super(position, type);
    }


    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }

    public void superPower() {

        switch (type) {

            case SERGIO:
                System.out.println("Sérgio");
                Score.setScore(1000);
                scoreWhenStartedSP = Score.intGetScore();
                isActive = true;
                additionalElement = grid.makeGridPosition(175, 350, 264, 88, "resources/1000.png");
                additionalElement.show();
                break;


            case LUIS:
                System.out.println("Luís");
                //Som do bebé a chorar
                if (collisionDetector.getBall().getIsLuisActive()) {
                    break;
                }
                scoreWhenStartedSP = Score.intGetScore();
                System.out.println("Inicial " + scoreWhenStartedSP);
                isActive = true;
                additionalElement = grid.makeGridPosition(22, 690, 574, 20, "resources/baby.png");
                additionalElement.show();
                collisionDetector.getBall().setIsLuisActive(true);
                break;

            case PRIS:
                Sound.playMeow();
                System.out.println("Pris");
                //Bola torna-se um gato, toca som do gato
                scoreWhenStartedSP = Score.intGetScore();
                System.out.println("Inicial " + scoreWhenStartedSP);
                isActive = true;
                collisionDetector.getPlatform().setPlatformSpeed(collisionDetector.getPlatform().getPlatformSpeed() * 2);
                break;


            case RITA:
                System.out.println("Rita");
                if (collisionDetector.getPlatform().getIsRitaActive()) {
                    break;
                }
                scoreWhenStartedSP = Score.intGetScore();
                isActive = true;
                collisionDetector.getPlatform().getPosition().increaseWidthPlatform();
                collisionDetector.getPlatform().setIsRitaActive(true);
                break;


            case VANDO:
                System.out.println("Vando");
                scoreWhenStartedSP = Score.intGetScore();
                System.out.println("Inicial " + scoreWhenStartedSP);
                isActive = true;
                collisionDetector.getBall().setBallSpeed(collisionDetector.getBall().getBallSpeed() / 2);
                break;

        }


    }

    private void showInformation() {

        textOn = true;

        switch(type) {
            case SERGIO:
                textInformation = grid.makeGridPosition(175, 600, 264, 88, "resources/1000.png");
                textInformation.show();
                break;
            case LUIS:
                textInformation = grid.makeGridPosition(175, 600, 264, 88, "resources/1000.png");
                textInformation.show();
                break;
            case PRIS:
                textInformation = grid.makeGridPosition(175, 600, 264, 88, "resources/1000.png");
                textInformation.show();
                break;
            case RITA:
                textInformation = grid.makeGridPosition(175, 600, 264, 88, "resources/1000.png");
                textInformation.show();
                break;
            case VANDO:
                textInformation = grid.makeGridPosition(175, 600, 264, 88, "resources/1000.png");
                textInformation.show();
                break;
        }



    }

    public void deleteSuperPower(){

        switch (type) {
            case SERGIO:
                System.out.println("Delete Sergio 1000");
                System.out.println("Final " + Score.intGetScore());
                isActive = false;
                additionalElement.hide();
                break;


            case LUIS:
                System.out.println("Delete Luís");
                System.out.println("Final " + Score.intGetScore());
                isActive = false;
                collisionDetector.getBall().setIsLuisActive(false);
                additionalElement.hide();
                break;


            case PRIS:
                System.out.println("Delete Pris");
                System.out.println("Final " + Score.intGetScore());
                isActive = false;
                collisionDetector.getPlatform().setPlatformSpeed(collisionDetector.getPlatform().getPlatformSpeed() / 2);
                break;



            case RITA:
                System.out.println("Delete Rita");
                System.out.println("Final" + Score.intGetScore());
                isActive = false;
                collisionDetector.getPlatform().getPosition().decreaseWidthPlatform();
                collisionDetector.getPlatform().setIsRitaActive(false);


            case VANDO:
                isActive = false;
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
               /* if (Score.intGetScore() - scoreWhenStartedSP >= 50 || isVando()) {
                    textInformation.hide();
                    textOn = false;
                }
                */
                if (Score.intGetScore() - scoreWhenStartedSP >= 500) {
                    //textInformation.hide(); //test
                   deleteSuperPower();
                   break;
                }

                if (isTextOn()) {
                    //textInformation.moveText();
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

    private boolean isVando() {
        return type == BrickType.VANDO && Score.intGetScore() - scoreWhenStartedSP >= 50 / 2;
    }

    public boolean isTextOn() {
        return textOn;
    }


}
