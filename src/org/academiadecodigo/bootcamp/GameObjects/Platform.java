package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Grid.GridDirection;
import org.academiadecodigo.bootcamp.Grid.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class Platform extends GameObject {

    private final int WIDTH = 40;
    private final int HEIGHT = 10;

    //private Grid grid;
    private GridPosition position;
    private Color color;

    public Platform (Grid grid) {
        this.color = Color.PINK;
        this.position = grid.makeGridPosition(300,675, WIDTH, HEIGHT, color);
    }

    /*
    public void setGrid(Grid grid) {
        this.grid = grid;
    }
*/
    public GridPosition getPosition() {
        return position;
    }

    public void moveRight() {
        //rever os limites
       //implementar isOnEdege
      /*  if (position.getPosX() + WIDTH >= grid.getWidth()) {
            return;
        } */
        position.move(GridDirection.RIGHT);
    }

    public void moveLeft() {
        //rever os limites
        //implementar is OnEdge
       /* if(position.getPosX() <= Grid.PADDING * 2) {
            return;
        } */
        position.move(GridDirection.LEFT);
    }


}
