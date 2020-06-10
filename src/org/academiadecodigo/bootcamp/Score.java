package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Grid.GridPosition;

public class Score {

    private static int score = 0;
    private static GridPosition position;

    /*
    public Score(Grid grid){
        this.position = grid.makeGridPosition(20,20,"score");
    }
    */

    public static void createGridPosition(Grid grid) {
        position = grid.makeGridPosition(30, 30, "score");
    }

    public static void setScore(int sc) {
       score += sc;
       position.showScore();
    }

    public static String getScore(){
        return "Score: " + score;
    }





}
