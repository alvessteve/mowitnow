package org.xebia.mowitnow.domain.model.grass;

import org.xebia.mowitnow.domain.model.Coordinates;

public class Grass {

    private Coordinates dimension;

    public Grass(Coordinates dimension) {
        if(dimension == null){
            throw new IllegalArgumentException("null sizing to generate a grass...");
        }
        this.dimension = dimension;
    }

    public Coordinates getDimension() {
        return dimension;
    }

    public boolean outOfBounds(Coordinates coordinates){
        if( coordinates.getX() < 0 || coordinates.getX() > dimension.getX() + 1){
            return true;
        }
        if(coordinates.getY() < 0 || coordinates.getY() > dimension.getY() + 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grass grass = (Grass) o;

        return dimension != null ? dimension.equals(grass.dimension) : grass.dimension == null;
    }

    @Override
    public int hashCode() {
        return dimension != null ? dimension.hashCode() : 0;
    }
}
