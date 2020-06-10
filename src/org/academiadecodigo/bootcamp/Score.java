package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Grid.GridPosition;

public class Score {

    private static int score;
    private static GridPosition position;


    public static void createGridPosition(Grid grid) {
        position = grid.makeGridPosition(30, 30, "score");
    }

    public static void setScore(int sc) {
       score += sc;
       position.showScore();
    }

    public static String stringGetScore(){
        return "Score: " + score;
    }

    public static int intGetScore() { return score; }





}
