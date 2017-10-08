package domain.model;

import org.junit.Test;
import org.xebia.mowitnow.domain.model.instructions.Instruction;
import org.xebia.mowitnow.domain.model.instructions.InstructionType;

public class InstructionTest {

    @Test(expected = IllegalArgumentException.class)
    public void no_content(){
        new Instruction("", InstructionType.MOW_CREATION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void no_type(){
        new Instruction("1 5", null);
    }
}
