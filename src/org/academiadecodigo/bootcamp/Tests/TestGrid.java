package org.academiadecodigo.bootcamp.Tests;

import org.academiadecodigo.bootcamp.GameObjects.Bricks.Brick;
import org.academiadecodigo.bootcamp.GameObjects.ObjectFactory;
import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Grid.GridPosition;

public class TestGrid {

    public static void main(String[] args) {
        Grid grid = new Grid(612, 700); // OK de tamanho
        //GridPosition test = new GridPosition(40, 40, 60, 20);

        Brick[] test = ObjectFactory.createBricks(72);

        grid.init();

        for (int i = 0; i < test.length; i++) {
            test[i].getPosition().show();
        }


        System.out.println(test.toString());
    }
}
