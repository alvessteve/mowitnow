package org.xebia.mowitnow.domain.factory;

import org.xebia.mowitnow.domain.model.grass.Grass;
import org.xebia.mowitnow.domain.model.Coordinates;
import org.xebia.mowitnow.infrastructure.validator.StringValidator;

public class GrassFactory {

    private final static int X_COORDINATES_INDEX = 0;
    private final static int Y_COORDINATES_INDEX = 1;
    private final static String SEPARATOR = " ";

    public static Grass build(String content){
        if(StringValidator.isNullorEmpty(content))
            throw new IllegalArgumentException("An instruction content must be provided to build a valid grass");
        String[] positionDetails = content.split(SEPARATOR);
        Coordinates coordinates = new Coordinates(Integer.valueOf(positionDetails[X_COORDINATES_INDEX]),Integer.valueOf(positionDetails[Y_COORDINATES_INDEX]));
        return new Grass(coordinates);
    }

}
