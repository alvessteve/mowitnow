package org.xebia.mowitnow.domain.model.instructions;

import org.xebia.mowitnow.infrastructure.validator.StringValidator;

public class Instruction {

    private String content;
    private InstructionType type;

    private Instruction() {
    }

    public Instruction(String content, InstructionType type) {
        if(StringValidator.isNullorEmpty(content))
            throw new IllegalArgumentException("A content must be provided to initialize correctly an instruction");
        if(type == null)
            throw new IllegalArgumentException("A type must be provided to initialize correctly an instruction");
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public InstructionType getType() {
        return type;
    }

    public static Instruction emptyInstruction(){
        return new Instruction();
    }

    public boolean isEmpty(){
        return type == null && content == null;
    }
}
