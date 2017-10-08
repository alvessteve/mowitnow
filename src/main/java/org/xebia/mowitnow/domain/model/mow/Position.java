package org.xebia.mowitnow.domain.model.mow;

import org.xebia.mowitnow.domain.model.Coordinates;
import org.xebia.mowitnow.domain.model.Orientation;

public class Position {

    private Coordinates coordinates;
    private Orientation orientation;

    private Position() {
    }

    public Position(Coordinates coordinates, Orientation orientation) {
        if(coordinates == null){
            throw new IllegalArgumentException("Coordonnees manquantes pour initialiser une position");
        }
        if(orientation == null){
            throw new IllegalArgumentException("Orientation manquante pour initialiser une position");
        }
        this.coordinates = coordinates;
        this.orientation = orientation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (coordinates != null ? !coordinates.equals(position.coordinates) : position.coordinates != null)
            return false;
        return orientation == position.orientation;
    }

    @Override
    public int hashCode() {
        int result = coordinates != null ? coordinates.hashCode() : 0;
        result = 31 * result + (orientation != null ? orientation.hashCode() : 0);
        return result;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void spinRight() {
        switch (orientation){
            case NORTH:
                this.orientation = Orientation.EAST;
                break;
            case EAST:
                this.orientation = Orientation.SOUTH;
                break;
            case WEST:
                this.orientation = Orientation.NORTH;
                break;
            case SOUTH:
                this.orientation = Orientation.WEST;
                break;
        }
    }

    public void spinLeft() {
        switch (orientation){
            case NORTH:
                this.orientation = Orientation.WEST;
                break;
            case EAST:
                this.orientation = Orientation.NORTH;
                break;
            case WEST:
                this.orientation = Orientation.SOUTH;
                break;
            case SOUTH:
                this.orientation = Orientation.EAST;
                break;
        }
    }

    @Override
    public String toString() {
        return this.getCoordinates().toString() + " " + this.getOrientation().toString();
    }

    public void forward() {
        switch (this.orientation){
            case NORTH:
                this.getCoordinates().up();
                break;
            case EAST:
                this.getCoordinates().right();
                break;
            case WEST:
                this.getCoordinates().left();
                break;
            case SOUTH:
                this.getCoordinates().down();
                break;
        }
    }

    public static Position invalidPosition(){
        return new Position();
    }

    public boolean isValid(){
        return this.coordinates != null && this.orientation != null;
    }
}
