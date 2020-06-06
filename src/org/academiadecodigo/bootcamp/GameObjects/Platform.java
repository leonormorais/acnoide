package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.Grid.GridDirection;
import org.academiadecodigo.bootcamp.Grid.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class Platform extends GameObject {

    private final int WIDTH = 40;
    private final int HEIGHT = 10;

    private GridPosition position;
    private Color color;

    public Platform () {
        this.color = Color.PINK;
        this.position = new GridPosition(300,675, WIDTH, HEIGHT, color);
    }

    public GridPosition getPosition() {
        return position;
    }

    public void moveRight() {
        //implementar limites
        position.move(GridDirection.RIGHT);
    }

    public void moveLeft() {
        //implementar limites
        position.move(GridDirection.LEFT);
    }

    /*
    moveRight()
        if (position.getX() + position.getWidth() > grid.getWidth())
                posX + tamanho> larguragrelha)
            return
    position.moveleft

     */


}
