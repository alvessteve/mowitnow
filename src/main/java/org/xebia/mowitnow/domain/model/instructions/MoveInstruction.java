package org.xebia.mowitnow.domain.model.instructions;

public enum MoveInstruction {
    RIGHT('D'),
    LEFT('G'),
    FORWARD('A');

    private char code;

    MoveInstruction(char code) {
        this.code = code;
    }

    public char getCode() {
        return code;
    }

    public static MoveInstruction fromLibelleIntsructions(char label){
       if(label == MoveInstruction.FORWARD.code)
           return MoveInstruction.FORWARD;
       if(label == MoveInstruction.LEFT.code)
           return MoveInstruction.LEFT;
       if(label == MoveInstruction.RIGHT.code)
           return MoveInstruction.RIGHT;
       throw new IllegalArgumentException("invalid move");
    }

    @Override
    public String toString() {
        return Character.toString(code);
    }
}
