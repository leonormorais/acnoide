package org.academiadecodigo.bootcamp.Grid;

import javax.print.DocFlavor;

public enum GridDirection {
    LEFT,
    RIGHT,
    DOWN,
    UP,
    ENE,
    NE,
    NNE,
    NNW,
    NW,
    WNW,
    WSW,
    SW,
    SSW,
    SSE,
    SE,
    ESE;


    public static GridDirection getNewDirection(GridDirection current) {
        switch (current){
            case UP:
                return DOWN;
            case NNW:
                return SSW;
            case NW:
                return SW;
            case WNW:
                return WSW;
            case WSW:
                return ESE;
            case SW:
                return SE;
            case SSW:
                return SSE;
            case SSE:
                return NNE;
            case SE:
                return NE;
            case ESE:
                return ENE;
            case ENE:
                return WNW;
            case NE:
                return NW;
            case NNE:
                return NNW;

        }
        return null;
    }

    //Rafael rever
    public static GridDirection getNewTopDirection(GridDirection current) {
        switch (current){
            case UP:
                return DOWN;
            case NNW:
                return SSW;
            case NW:
                return SW;
            case WNW:
                return WSW;
            case WSW:
                return ESE;
            case SW:
                return SE;
            case SSW:
                return SSE;
            case SSE:
                return NNE;
            case SE:
                return NE;
            case ESE:
                return ENE;
            case ENE:
                return WNW;
            case NE:
                return SW; // corrigir, foi um teste
            case NNE:
                return NNW;

        }
        return null;
    }

}


