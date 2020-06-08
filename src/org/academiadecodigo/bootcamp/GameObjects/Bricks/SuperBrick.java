package org.academiadecodigo.bootcamp.GameObjects.Bricks;
import org.academiadecodigo.bootcamp.CollisionDetector;
import org.academiadecodigo.bootcamp.GameObjects.Platform;
import org.academiadecodigo.bootcamp.Grid.GridDirection;
import org.academiadecodigo.bootcamp.Grid.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class SuperBrick extends Brick {

    private CollisionDetector collisionDetector;

    public SuperBrick(GridPosition position, BrickType type) {
        super(position, type);
    }

    //pensar em como integrar o collisionDetector no SuperBrick, uma vez que ele vai precisar de verificar se bateu na pltaforma
    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }

    /*
    public void superPower(Platform platform) {
        platform.getPosition().setWidth(80); //test
    }
    */

    /*
    ** Desencadear comportamento adicional do SuperBrick
    * Load nova imagem e moveDown.
     */
    @Override
    public void destroy() {
        this.isDestroyed = true;
        this.position.transformBrick();
        this.move();

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
        if (isDestroyed) {
            position.moveBrick();

        }
    }

}
