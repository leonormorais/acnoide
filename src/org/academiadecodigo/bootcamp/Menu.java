package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Grid.Grid;

public class Menu {

    private Grid grid;
    private User user;
    private boolean isRunning;


    public Menu () {
        this.grid = new Grid(600, 700);

    }

    public void init() {
        grid.init();
        user = new User();
    }

    public void start() {
        while (!user.isKeyPressed()) {


        }
    }
}
