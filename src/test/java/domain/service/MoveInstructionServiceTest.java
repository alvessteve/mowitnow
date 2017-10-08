package domain.service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.xebia.mowitnow.domain.model.grass.Grass;
import org.xebia.mowitnow.domain.model.instructions.MoveInstruction;
import org.xebia.mowitnow.domain.model.Coordinates;
import org.xebia.mowitnow.domain.model.Orientation;
import org.xebia.mowitnow.domain.model.mow.Position;
import org.xebia.mowitnow.domain.repository.GrassRepository;
import org.xebia.mowitnow.domain.repository.MowRepository;
import org.xebia.mowitnow.domain.service.MoveInstructionService;
import org.xebia.mowitnow.domain.service.MoveInstructionServiceImpl;
import org.xebia.mowitnow.domain.service.MowService;
import org.xebia.mowitnow.domain.service.MowServiceImpl;
import org.xebia.mowitnow.infrastructure.di.DependencyInjector;

import static org.junit.Assert.*;

public class MoveInstructionServiceTest {

    private static MowService mowService;
    private static GrassRepository grassRepository;
    private static MowRepository mowRepository;
    private static MoveInstructionService moveInstructionService;

    @BeforeClass
    public static void setup(){
        mowRepository = DependencyInjector.newMowrepository();
        grassRepository = Mockito.mock(GrassRepository.class);
        mowService = new MowServiceImpl(mowRepository,grassRepository);
        Grass grass = new Grass(new Coordinates(5,5));
        Mockito.when(grassRepository.get()).thenReturn(grass);
        moveInstructionService = new MoveInstructionServiceImpl(mowService);
    }

    @Test
    public void send_spin_right_instruction(){
        Coordinates initialCoordinates = new Coordinates(0,0);
        Position initialPosition = new Position(initialCoordinates, Orientation.SOUTH);
        mowService.create(initialPosition);
        moveInstructionService.move(MoveInstruction.RIGHT);
        assertTrue(mowRepository.currentMowMoving().getPosition().getOrientation().equals(Orientation.WEST));
    }

    @Test
    public void send_spin_left_instruction(){
        Coordinates initialCoordinates = new Coordinates(0,0);
        Position initialPosition = new Position(initialCoordinates, Orientation.NORTH);
        mowService.create(initialPosition);
        moveInstructionService.move(MoveInstruction.LEFT);
        assertTrue(mowRepository.currentMowMoving().getPosition().getOrientation().equals(Orientation.WEST));
    }

    @Test
    public void send_move_instruction(){
        Coordinates coordinates = new Coordinates(0,1);
        Position expectedPostion = new Position(coordinates,Orientation.NORTH);
        Coordinates initialCoordinates = new Coordinates(0,0);
        Position initialPosition = new Position(initialCoordinates, Orientation.NORTH);
        mowService.create(initialPosition);
        moveInstructionService.move(MoveInstruction.FORWARD);
        assertTrue(mowRepository.currentMowMoving().getPosition().equals(expectedPostion));
    }

}
