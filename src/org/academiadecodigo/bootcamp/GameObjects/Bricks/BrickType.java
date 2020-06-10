package org.academiadecodigo.bootcamp.GameObjects.Bricks;

import org.academiadecodigo.simplegraphics.graphics.Color;

public enum BrickType {
    NORMAL(""),
    SERGIO("resources/sergio.png"),
    RITA("resources/rita.png"),
    VANDO("resources/vando.png"),
    PRIS("resources/pris.png"),
    LUIS("resources/luis.png");

    private String sourceImg;

    BrickType (String img) {
        this.sourceImg = img;
    }

    public String getSourceImg() {
        return sourceImg;
    }
}
