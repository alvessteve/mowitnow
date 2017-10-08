package org.xebia.mowitnow.domain.factory;

import org.xebia.mowitnow.domain.model.grass.Grass;
import org.xebia.mowitnow.domain.model.mow.Position;
import org.xebia.mowitnow.domain.model.mow.Mow;

public class MowFactory {

    public static Mow build(Position initialPosition, Grass grass){
        if(grass == null){
            throw new IllegalArgumentException("Lacking grass informations to create a new mow");
        }
        if(!initialPosition.isValid()){
            throw new IllegalArgumentException("Initial position needed to create a new mow");
        }
        if(grass.outOfBounds(initialPosition.getCoordinates())){
            throw new IllegalArgumentException("Trying to place the mow outside the grass");
        }
        return new Mow(initialPosition);
    }
}
