package domain.factory;

import org.junit.Test;
import org.xebia.mowitnow.domain.factory.PositionFactory;
import org.xebia.mowitnow.domain.model.instructions.Instruction;
import org.xebia.mowitnow.domain.model.instructions.InstructionType;
import org.xebia.mowitnow.domain.model.Coordinates;
import org.xebia.mowitnow.domain.model.Orientation;
import org.xebia.mowitnow.domain.model.mow.Position;

import static org.junit.Assert.*;

public class PositionFactoryTest {

    @Test
    public void position_creation_for_mow(){
        Instruction instruction = new Instruction("1 5 E", InstructionType.MOW_CREATION);
        Coordinates expectedCoordinates = new Coordinates(1,5);
        Position position = PositionFactory.fromInstructionContent(instruction);
        assertNotNull(position);
        assertTrue(position.isValid());
        assertTrue(position.getCoordinates().equals(expectedCoordinates));
        assertTrue(position.getOrientation().equals(Orientation.EAST));
    }

    @Test
    public void position_creation_invalid(){
        Instruction instruction = new Instruction("1 5", InstructionType.GRASS_CREATION);
        Position position = PositionFactory.fromInstructionContent(instruction);
        assertNotNull(position);
        assertFalse(position.isValid());
    }

    @Test(expected = IllegalArgumentException.class)
    public void no_instructions_sent(){
        PositionFactory.fromInstructionContent(null);
    }
}
