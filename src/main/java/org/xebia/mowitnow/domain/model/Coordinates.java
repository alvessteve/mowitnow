package org.xebia.mowitnow.domain.model;

public class Coordinates {

    private int x;
    private int y;

    public Coordinates(int x, int y) {
        if(x < 0 || y < 0){
            throw new IllegalArgumentException("Negative coordinates input... x:" + x + " y:" + y);
        }
        this.x = x;
        this.y = y;
    }

    public static boolean areValid(int x, int y){
        return x >= 0 && y >= 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }

    public void up() {
        this.y += 1;
    }

    public void down(){
        this.y -=1 ;
    }

    public void right(){
        this.x +=1;
    }

    public void left(){
        this.x -=1;
    }
}
