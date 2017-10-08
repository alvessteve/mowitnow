package org.xebia.mowitnow.domain.factory;

import org.xebia.mowitnow.domain.model.instructions.Instruction;
import org.xebia.mowitnow.domain.model.Coordinates;
import org.xebia.mowitnow.domain.model.Orientation;
import org.xebia.mowitnow.domain.model.mow.Position;
import org.xebia.mowitnow.infrastructure.validator.StringValidator;

public class PositionFactory {

    private final static int X_COORDINATES_INDEX = 0;
    private final static int Y_COORDINATES_INDEX = 1;
    private final static int ORIENTATION_INDEX = 2;
    private final static String SEPARATOR = " ";

    public static Position fromInstructionContent(Instruction instruction){
        if(instruction == null)
            throw new IllegalArgumentException("An instruction must be provided to build a valid position");
        switch (instruction.getType()){
            case MOW_CREATION:
                return forMowCreation(instruction);
            default:
                return Position.invalidPosition();
        }
    }

    private static Position forMowCreation(Instruction instruction) {
        if(StringValidator.isNullorEmpty(instruction.getContent()))
            throw new IllegalArgumentException("An instruction content must be provided to build a valid position");
        String[] positionDetails = instruction.getContent().split(SEPARATOR);
        Coordinates coordinates = new Coordinates(Integer.valueOf(positionDetails[X_COORDINATES_INDEX]),Integer.valueOf(positionDetails[Y_COORDINATES_INDEX]));
        Orientation orientation = Orientation.fromLibelleOrientation(positionDetails[ORIENTATION_INDEX].charAt(0));
        return new Position(coordinates,orientation);
    }

}
