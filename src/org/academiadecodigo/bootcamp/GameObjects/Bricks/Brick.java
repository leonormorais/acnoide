package org.academiadecodigo.bootcamp.GameObjects.Bricks;

import org.academiadecodigo.bootcamp.GameObjects.Hitable;
import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Grid.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;

abstract public class Brick implements Hitable {

    protected Grid grid;
    protected GridPosition position;
    protected Color color;
    protected BrickType type;
    protected boolean isDestroyed;

    public Brick (GridPosition position, BrickType type) {
        this.position = position;
        this.type = type;
        this.color = type.getColor();
        this.isDestroyed = false;

    }

    public boolean getIsDestroyed() {
        return isDestroyed;
    }

    public void destroy() {
        System.out.println("Destroyed");
        this.isDestroyed = true;
        position.hide();
    }

    public void move() {

    }

    public GridPosition getPosition() {
        return position;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public Color getColor() {
        return color;
    }



}
