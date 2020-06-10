package org.academiadecodigo.bootcamp.GameObjects.Bricks;
import org.academiadecodigo.bootcamp.CollisionDetector;
import org.academiadecodigo.bootcamp.Grid.GridPosition;
import org.academiadecodigo.bootcamp.Score;

public class SuperBrick extends Brick {

    private final int BRICK_SPEED = 5;
    private CollisionDetector collisionDetector;
    private int scoreWhenStartedSP; //Score quando começa o super poder
    private boolean isActived; // Super power está ativo ou não.

    public SuperBrick(GridPosition position, BrickType type) {
        super(position, type);
    }

    //pensar em como integrar o collisionDetector no SuperBrick, uma vez que ele vai precisar de verificar se bateu na pltaforma
    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }


    public void superPower() {
        switch (type) {

            case SERGIO:
                System.out.println("Sérgio");
                Score.setScore(1000);
                //1000 em grande
                break;

            case LUIS:
                System.out.println("Luís");
                //Som do bebé a chorar
                break;

            case PRIS:
                System.out.println("Pris");
                //Bola torna-se um gato e torna-se mais rápido, toca som do gato
                scoreWhenStartedSP = Score.intGetScore();
                System.out.println("Inicial " + scoreWhenStartedSP);
                isActived = true;
                collisionDetector.getPlatform().setPlataformSpeed(collisionDetector.getPlatform().getPlataformSpeed() * 2);
                break;

            case RITA:
                System.out.println("Rita");
                scoreWhenStartedSP = Score.intGetScore();
                isActived = true;
                collisionDetector.getPlatform().getPosition().increaseWidthPlatform();

                break;

            case VANDO:
                System.out.println("Vando");
                scoreWhenStartedSP = Score.intGetScore();
                System.out.println("Inicial " + scoreWhenStartedSP);
                isActived = true;
                collisionDetector.getBall().setBallSpeed(collisionDetector.getBall().getBallSpeed() / 2);
                break;
        }
    }

    public void deleteSuperPower(){
        switch (type) {

            case VANDO:
                System.out.println("Delete Vando");
                System.out.println("Final " + Score.intGetScore());
                isActived = false;
                collisionDetector.getBall().setBallSpeed(collisionDetector.getBall().getBallSpeed() * 2);
                break;

            case PRIS:
                System.out.println("Delete Pris");
                System.out.println("Final " + Score.intGetScore());
                isActived = false;
                collisionDetector.getPlatform().setPlataformSpeed(collisionDetector.getPlatform().getPlataformSpeed() / 2);
                break;
            case RITA:
                System.out.println("Delete Rita");
                System.out.println("Final" + Score.intGetScore());
                isActived = false;
                collisionDetector.getPlatform().getPosition().decreaseWidthPlatform();

        }

    }




    /*
    ** Desencadear comportamento adicional do SuperBrick
    * Load nova imagem e moveDown.
     */
    @Override
    public void destroy() {

        this.isDestroyed = true;

        switch (type) {
            case SERGIO:
                this.position.transformBrickInPris(BrickType.SERGIO.getSourceImg());
                break;
            case LUIS:
                this.position.transformBrickInPris(BrickType.LUIS.getSourceImg());
                break;
            case PRIS:
                this.position.transformBrickInPris(BrickType.PRIS.getSourceImg());
                break;
            case RITA:
                this.position.transformBrickInPris(BrickType.RITA.getSourceImg());
                break;
            case VANDO:
                this.position.transformBrickInPris(BrickType.VANDO.getSourceImg());
                break;
        }

        this.move();

    }

    @Override
    public void move() {
        for (int i = 0; i < BRICK_SPEED; i++) {

            if(isActived) {
                if (Score.intGetScore() - scoreWhenStartedSP >= 500) {
                    System.out.println(Score.intGetScore());
                    deleteSuperPower();
                }
            }

            if (isDestroyed) {
                if (collisionDetector.checkForCollisionSuperBrick(this)) {
                    superPower();
                    System.out.println("super power ");
                    position.hide();
                }
                position.moveBrick();
            }



        }
    }


}
