package org.xebia.mowitnow.domain.factory;

import org.xebia.mowitnow.domain.model.instructions.Instruction;
import org.xebia.mowitnow.domain.model.instructions.InstructionType;
import org.xebia.mowitnow.infrastructure.validator.StringValidator;

public class InstructionFactory {

    private final static String CREATION_GRASS_INSTRUCTION = "^\\d \\d$";
    private final static String CREATION_MOW_INSTRUCTION = "^\\d \\d [N,E,W,S]{1}$";
    private final static String CREATION_MOVE_INSTRUCTION = "^[G,A,D]+$";

    public static Instruction build(String content){
        if(StringValidator.isNullorEmpty(content))
            throw new IllegalArgumentException("A content must be provided to generate an instruction");
        if(content.matches(CREATION_GRASS_INSTRUCTION))
            return new Instruction(content, InstructionType.GRASS_CREATION);
        if(content.matches(CREATION_MOW_INSTRUCTION))
            return new Instruction(content,InstructionType.MOW_CREATION);
        if(content.matches(CREATION_MOVE_INSTRUCTION))
            return new Instruction(content,InstructionType.MOVE_MOW);
        return Instruction.emptyInstruction();
    }
}
