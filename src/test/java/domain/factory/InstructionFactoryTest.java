package domain.factory;

import org.junit.Test;
import org.xebia.mowitnow.domain.factory.InstructionFactory;
import org.xebia.mowitnow.domain.model.instructions.Instruction;
import org.xebia.mowitnow.domain.model.instructions.InstructionType;

import static org.junit.Assert.*;


public class InstructionFactoryTest {

    @Test
    public void non_valid_instruction(){
        Instruction instruction = InstructionFactory.build("GENARELY");
        assertNotNull(instruction);
        assertNull(instruction.getContent());
        assertTrue(instruction.isEmpty());
    }

    @Test
    public void create_grass_instruction(){
        Instruction instruction = InstructionFactory.build("5 5");
        assertNotNull(instruction);
        assertNotNull(instruction.getContent());
        assertTrue(instruction.getType().equals(InstructionType.GRASS_CREATION));
    }

    @Test
    public void create_mow_instruction(){
        Instruction instruction = InstructionFactory.build("1 2 N");
        assertNotNull(instruction);
        assertNotNull(instruction.getContent());
        assertTrue(instruction.getType().equals(InstructionType.MOW_CREATION));
    }

    @Test
    public void create_move_instruction(){
        Instruction instruction = InstructionFactory.build("GAGAGAGADD");
        assertNotNull(instruction);
        assertNotNull(instruction.getContent());
        assertTrue(instruction.getType().equals(InstructionType.MOVE_MOW));
    }

}
