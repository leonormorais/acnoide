package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Grid.GridPosition;

public class Score {

    private static final int SCORE_POSITION_X = 30;
    private static final int SCORE_POSITION_Y = 30;

    private static int score;
    private static GridPosition position;

    public static void createGridPosition(Grid grid) {
        position = grid.makeGridPosition(SCORE_POSITION_X, SCORE_POSITION_Y);
    }
    public static int intGetScore() { return score; }

    public static String stringGetScore(){
        return "Score: " + score;
    }

    public static void setScore(int sc) {
       score += sc;
       position.showScore();
    }





}
