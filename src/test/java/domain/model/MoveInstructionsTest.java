package domain.model;

import org.junit.Test;
import org.xebia.mowitnow.domain.model.instructions.MoveInstruction;

import static org.junit.Assert.assertEquals;


public class MoveInstructionsTest {

    @Test
    public void from_libelle_for_left(){
        MoveInstruction orientation = MoveInstruction.fromLibelleIntsructions('G');
        assertEquals(orientation,MoveInstruction.LEFT);
    }

    @Test
    public void from_libelle_for_right(){
        MoveInstruction orientation = MoveInstruction.fromLibelleIntsructions('D');
        assertEquals(orientation,MoveInstruction.RIGHT);
    }

    @Test
    public void from_libelle_for_forward(){
        MoveInstruction orientation = MoveInstruction.fromLibelleIntsructions('A');
        assertEquals(orientation,MoveInstruction.FORWARD);
    }

}
