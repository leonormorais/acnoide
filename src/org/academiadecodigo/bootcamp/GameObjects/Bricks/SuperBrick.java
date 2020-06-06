package org.academiadecodigo.bootcamp.GameObjects.Bricks;
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

    }
}
