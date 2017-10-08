package org.xebia.mowitnow.domain.factory;

import org.xebia.mowitnow.domain.model.instructions.MoveInstruction;
import org.xebia.mowitnow.infrastructure.validator.StringValidator;

import java.util.ArrayList;
import java.util.List;

public class MoveInstructionsFactory {

    public static List<MoveInstruction> build(String listOfMoves){
        if(StringValidator.isNullorEmpty(listOfMoves))
            throw new IllegalArgumentException("A list of direction an orientation must be provided to move the mow");
        List<MoveInstruction> moveInstructionList = new ArrayList<>();
        char[] splittedListOfMoves = listOfMoves.toCharArray();
        for (char direction : splittedListOfMoves) {
            MoveInstruction moveInstruction = MoveInstruction.fromLibelleIntsructions(direction);
            moveInstructionList.add(moveInstruction);
        }
        return moveInstructionList;
    }

}
