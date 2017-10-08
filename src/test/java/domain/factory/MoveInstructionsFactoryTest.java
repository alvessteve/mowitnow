package domain.factory;

import org.junit.Test;
import org.xebia.mowitnow.domain.factory.MoveInstructionsFactory;
import org.xebia.mowitnow.domain.model.instructions.MoveInstruction;

import static org.junit.Assert.*;
import java.util.List;

public class MoveInstructionsFactoryTest {

    @Test
    public void move_instructions_ok(){
        List<MoveInstruction> moves = MoveInstructionsFactory.build("AADAADADDAGGGDDDD");
        assertNotNull(moves);
        assertTrue(moves.size() == 17);
        assertTrue(moves.get(0) == MoveInstruction.FORWARD);
    }

    @Test(expected = IllegalArgumentException.class)
    public void move_instructions_ko(){
        MoveInstructionsFactory.build("AADAADADKAGGGDDDD");
    }

    @Test(expected = IllegalArgumentException.class)
    public void input_null(){
        MoveInstructionsFactory.build("");
    }
}
