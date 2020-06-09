package org.academiadecodigo.bootcamp.GameObjects.Bricks;

import org.academiadecodigo.simplegraphics.graphics.Color;

public enum BrickType {
    NORMAL(Color.DARK_GRAY),
    SERGIO(Color.GREEN),
    RITA(Color.CYAN),
    VANDO(Color.BLUE),
    PRIS(Color.RED),
    LUIS(Color.MAGENTA),
    SUPERBRICK(Color.YELLOW);

    private Color color;

    BrickType(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

}
