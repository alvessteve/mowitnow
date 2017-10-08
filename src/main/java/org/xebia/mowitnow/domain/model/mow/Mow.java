package org.xebia.mowitnow.domain.model.mow;


public class Mow {

    private Position position;

    public Mow(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void spinRight(){
        this.position.spinRight();
    }

    public void spinLeft(){
        this.position.spinLeft();
    }

    public void moveForward(){
        this.position.forward();
    }

}
