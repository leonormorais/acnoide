package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Grid.GridPosition;

public class Score {

    private int score;
    private GridPosition position;

    public Score(Grid grid){
        this.position = grid.makeGridPosition(20,20,"score");
    }


    public void setScore(int sc){
       this.score += sc;
    }

    public int getScore(){
        return score;
    }





}
