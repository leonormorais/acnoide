package org.academiadecodigo.bootcamp.GameObjects.Bricks;
import org.academiadecodigo.bootcamp.CollisionDetector;
import org.academiadecodigo.bootcamp.GameObjects.Hittable;
import org.academiadecodigo.bootcamp.GameObjects.Platform;
import org.academiadecodigo.bootcamp.Grid.GridDirection;
import org.academiadecodigo.bootcamp.Grid.GridPosition;
import org.academiadecodigo.bootcamp.Score;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class SuperBrick extends Brick {

    private final int BRICK_SPEED = 5;
    private CollisionDetector collisionDetector;

    private int scoreWhenStartedSP;

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
                collisionDetector.getBall().setBallSpeed(collisionDetector.getBall().getBallSpeed() * 2);
                break;

            case RITA:
                System.out.println("Rita");
                break;

            case VANDO:
                System.out.println("Vando");
                break;
        }
    }




    /*
    ** Desencadear comportamento adicional do SuperBrick
    * Load nova imagem e moveDown.
     */
    @Override
    public void destroy() {
        this.isDestroyed = true;
        if (type == BrickType.PRIS) {
            this.position.transformBrickInPris(BrickType.PRIS.getSourceImg());  //testing concept before implementing
        } else {
            this.position.transformBrick();
        }
        this.move();
        
        //collisionDetector.checkForCollisionPlatform();


       // position.transform(); //tem de ser criado no position método transform

       /* if (this.position.getColor() == Color.YELLOW) {
            this.position.hide();
            return;
        }
        this.position.setColor(Color.YELLOW);

        */
    }

    @Override
    public void move() {
        for (int i = 0; i < BRICK_SPEED; i++) {
            if (isDestroyed) {
                if (collisionDetector.checkForCollisionSuperBrick(this)) {
                    superPower();
                    System.out.println("super power");
                    position.hide();
                }
                position.moveBrick();
            }
        }
    }


}
