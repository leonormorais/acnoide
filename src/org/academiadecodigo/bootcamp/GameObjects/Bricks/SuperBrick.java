package org.academiadecodigo.bootcamp.GameObjects.Bricks;
import org.academiadecodigo.bootcamp.Grid.GridDirection;
import org.academiadecodigo.bootcamp.Grid.GridPosition;

public class SuperBrick extends Brick {


    public SuperBrick(GridPosition position, BrickType type) {
        super(position, type);
    }

    /*
    ** Desencadear comportamento adicional do SuperBrick
    * Load nova imagem e moveDown.
     */
    @Override
    public void destroy() {
        this.isDestroyed = true;
       // position.transform(); //tem de ser criado no position método transform
        this.move();
    }

    @Override
    public void move() {
        if (isDestroyed) {
            position.move(GridDirection.DOWN);
        }
    }
}
