package org.academiadecodigo.bootcamp.GameObjects.Bricks;

import org.academiadecodigo.bootcamp.GameObjects.Hittable;
import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Grid.GridPosition;

abstract public class Brick implements Hittable {

    protected Grid grid;
    protected GridPosition position;
    protected BrickType type;
    protected boolean isDestroyed;

    public Brick (GridPosition position, BrickType type) {
        this.position = position;
        this.type = type;
        this.isDestroyed = false;

    }

    public boolean getIsDestroyed() {
        return isDestroyed;
    }

    public void destroy() {
        this.isDestroyed = true;
        position.hide();
    }

    public void move() { }


    public GridPosition getPosition() {
        return position;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

}
