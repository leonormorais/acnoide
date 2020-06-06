package org.academiadecodigo.bootcamp.GameObjects.Bricks;

import org.academiadecodigo.bootcamp.GameObjects.GameObject;
import org.academiadecodigo.bootcamp.Grid.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;

abstract public class Brick extends GameObject {


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

    public void destroy() {

    }

    public GridPosition getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }

}
