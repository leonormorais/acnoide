package org.academiadecodigo.bootcamp.GameObjects.Bricks;

import org.academiadecodigo.simplegraphics.graphics.Color;

public enum BrickType {
    NORMAL(""),
    SERGIO(""),
    RITA(""),
    VANDO(""),
    PRIS("resources/pris.png"),
    LUIS("");

    private String sourceImg;

    BrickType (String img) {
        this.sourceImg = img;
    }

    public String getSourceImg() {
        return sourceImg;
    }
}
