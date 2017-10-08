package org.xebia.mowitnow.domain.model;

public enum Orientation {
    NORTH('N'),
    EAST('E'),
    WEST('W'),
    SOUTH('S');

    private char code;

    Orientation(char code) {
        this.code = code;
    }

    public char getCode() {
        return code;
    }

    public static Orientation fromLibelleOrientation(char libelleOrientation){
        if(libelleOrientation == Orientation.NORTH.code)
            return Orientation.NORTH;
        if(libelleOrientation == Orientation.SOUTH.code)
            return Orientation.SOUTH;
        if(libelleOrientation == Orientation.EAST.code)
            return Orientation.EAST;
        if(libelleOrientation == Orientation.WEST.code)
            return Orientation.WEST;
        throw new IllegalArgumentException("invalid orientation");
    }

    @Override
    public String toString() {
        return Character.toString(code);
    }
}
