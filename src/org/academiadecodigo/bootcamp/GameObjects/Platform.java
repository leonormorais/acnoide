package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Grid.GridDirection;
import org.academiadecodigo.bootcamp.Grid.GridPosition;

public class Platform implements Hittable {

    private int WIDTH = 40;
    private int HEIGHT = 10;
    private int plataformSpeed = 15;
    private int superSize = 0;

    //private Grid grid;
    private GridPosition position;

    public void setSuperSize(String superPower){
        // fazer um switch por superpower;
        switch (superPower){
            case "Sergio": //dizer qual caso;
                setSuperSize(20);
                setWIDTH(getWIDTH() + superSize);
                break;
        }
    }

    public Platform (Grid grid) {
        this.position = grid.makeGridPosition(300,675 , "platform");
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public void setPlataformSpeed(int speed){
        plataformSpeed = speed;
    }

    public int getPlataformSpeed(){
        return plataformSpeed;
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
        for (int i = 0; i < plataformSpeed; i++) {
            if (position.isOnEdgePlatform(GridDirection.RIGHT)) {
                return;
            }
            position.move(GridDirection.RIGHT);
        }
    }

    public void moveLeft() {
        for (int i = 0; i < plataformSpeed; i++) {
            if (position.isOnEdgePlatform(GridDirection.LEFT)) {
                return;
            }
            position.move(GridDirection.LEFT);

        }
    }

    public void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
    }

    public int getSuperSize() {
        return superSize;
    }

    public void setSuperSize(int superSize) {
        this.superSize = superSize;
    }



    @Override
    public String toString() {
        return "Platform{" +
                "WIDTH=" + WIDTH +
                ", HEIGHT=" + HEIGHT +
                ", position=" + position +
                '}';
    }
}
