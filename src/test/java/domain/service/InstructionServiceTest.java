package domain.service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.xebia.mowitnow.domain.model.grass.Grass;
import org.xebia.mowitnow.domain.model.instructions.Instruction;
import org.xebia.mowitnow.domain.model.instructions.InstructionType;
import org.xebia.mowitnow.domain.model.Coordinates;
import org.xebia.mowitnow.domain.model.Orientation;
import org.xebia.mowitnow.domain.model.mow.Position;
import org.xebia.mowitnow.domain.repository.GrassRepository;
import org.xebia.mowitnow.domain.repository.MowRepository;
import org.xebia.mowitnow.domain.service.InstructionService;
import org.xebia.mowitnow.infrastructure.di.DependencyInjector;

import static org.junit.Assert.assertEquals;

public class InstructionServiceTest {

    private static InstructionService instructionService;
    private static MowRepository mowRepository;
    private static GrassRepository grassRepository;

    @BeforeClass
    public static void setup(){
        grassRepository = DependencyInjector.newGrassRepository();
        mowRepository = DependencyInjector.newMowrepository();
        instructionService = DependencyInjector.newInstructionService();
    }

    @Test
    public void create_grass_instruction(){
        Instruction createGrass = new Instruction("5 5", InstructionType.GRASS_CREATION);
        instructionService.process(createGrass);
        Grass expectedGrass = new Grass(new Coordinates(5,5));
        assertEquals(grassRepository.get(), expectedGrass);
    }

    @Test
    public void create_mow_instruction(){
        Instruction createGrass = new Instruction("5 5", InstructionType.GRASS_CREATION);
        instructionService.process(createGrass);

        Instruction mowCreation = new Instruction("5 5 N", InstructionType.MOW_CREATION);
        instructionService.process(mowCreation);

        Position expectedPosition = new Position(new Coordinates(5,5), Orientation.NORTH);

        assertEquals(mowRepository.currentMowMoving().getPosition(), expectedPosition);
    }

    @Test
    public void move_mow_instruction(){
        Instruction createGrass = new Instruction("5 5", InstructionType.GRASS_CREATION);
        instructionService.process(createGrass);

        Instruction mowCreation = new Instruction("5 5 N", InstructionType.MOW_CREATION);
        instructionService.process(mowCreation);

        Instruction moveInstruction = new Instruction("GAA",InstructionType.MOVE_MOW);
        instructionService.process(moveInstruction);

        Position expectedPosition = new Position(new Coordinates(3,5),Orientation.WEST);
        assertEquals(mowRepository.currentMowMoving().getPosition(), expectedPosition);
    }

    @Test
    public void empty_instructions(){
        Instruction createGrass = new Instruction("5 5", InstructionType.GRASS_CREATION);
        instructionService.process(createGrass);

        Instruction mowCreation = new Instruction("5 5 N", InstructionType.MOW_CREATION);
        instructionService.process(mowCreation);

        Instruction moveInstruction = Instruction.emptyInstruction();
        instructionService.process(moveInstruction);

        Position expectedPosition = new Position(new Coordinates(5,5),Orientation.NORTH);
        assertEquals(mowRepository.currentMowMoving().getPosition(), expectedPosition);
    }
}
