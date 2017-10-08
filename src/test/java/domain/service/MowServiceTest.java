package domain.service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.xebia.mowitnow.domain.model.grass.Grass;
import org.xebia.mowitnow.domain.model.Coordinates;
import org.xebia.mowitnow.domain.model.Orientation;
import org.xebia.mowitnow.domain.model.mow.Position;
import org.xebia.mowitnow.domain.repository.GrassRepository;
import org.xebia.mowitnow.domain.repository.MowRepository;
import org.xebia.mowitnow.domain.service.MowService;
import org.xebia.mowitnow.domain.service.MowServiceImpl;
import org.xebia.mowitnow.infrastructure.di.DependencyInjector;

import static org.junit.Assert.assertTrue;

public class MowServiceTest {

    private static MowService mowService;
    private static GrassRepository grassRepository;
    private static MowRepository mowRepository;

    @BeforeClass
    public static void setup(){
        mowRepository = DependencyInjector.newMowrepository();
        grassRepository = Mockito.mock(GrassRepository.class);
        mowService = new MowServiceImpl(mowRepository,grassRepository);
        Grass grass = new Grass(new Coordinates(5,5));
        Mockito.when(grassRepository.get()).thenReturn(grass);
    }

    @Test
    public void create_mow(){
        Coordinates initialCoordinates = new Coordinates(1,2);
        Position initialPosition = new Position(initialCoordinates, Orientation.EAST);
        mowService.create(initialPosition);
        assertTrue(mowRepository.currentMowMoving().getPosition().equals(initialPosition));
    }

    @Test
    public void move_mow_up(){
        Coordinates initialCoordinates = new Coordinates(1,1);
        Position initialPosition = new Position(initialCoordinates,Orientation.NORTH);
        mowService.create(initialPosition);
        mowService.moveIfWithinGrass();
        Coordinates expectedCoordinates = new Coordinates(1,2);
        Position expectedPosition = new Position(expectedCoordinates,Orientation.NORTH);
        assertTrue(mowRepository.currentMowMoving().getPosition().equals(expectedPosition));
    }

    @Test
    public void move_mow_down(){
        Coordinates initialCoordinates = new Coordinates(1,1);
        Position initialPosition = new Position(initialCoordinates,Orientation.SOUTH);
        mowService.create(initialPosition);
        mowService.moveIfWithinGrass();
        Coordinates expectedCoordinates = new Coordinates(1,0);
        Position expectedPosition = new Position(expectedCoordinates,Orientation.SOUTH);
        assertTrue(mowRepository.currentMowMoving().getPosition().equals(expectedPosition));
    }

    @Test
    public void move_mow_left(){
        Coordinates initialCoordinates = new Coordinates(1,1);
        Position initialPosition = new Position(initialCoordinates,Orientation.WEST);
        mowService.create(initialPosition);
        mowService.moveIfWithinGrass();
        Coordinates expectedCoordinates = new Coordinates(0,1);
        Position expectedPosition = new Position(expectedCoordinates,Orientation.WEST);
        assertTrue(mowRepository.currentMowMoving().getPosition().equals(expectedPosition));
    }

    @Test
    public void move_mow_right(){
        Coordinates initialCoordinates = new Coordinates(1,1);
        Position initialPosition = new Position(initialCoordinates,Orientation.EAST);
        mowService.create(initialPosition);
        mowService.moveIfWithinGrass();
        Coordinates expectedCoordinates = new Coordinates(2,1);
        Position expectedPosition = new Position(expectedCoordinates,Orientation.EAST);
        assertTrue(mowRepository.currentMowMoving().getPosition().equals(expectedPosition));
    }

    @Test
    public void move_outside_grass_dimension_from_bottom_right(){
        Coordinates initialCoordinates = new Coordinates(6,0);
        Position initialPosition = new Position(initialCoordinates,Orientation.EAST);
        mowService.create(initialPosition);
        mowService.moveIfWithinGrass();
        assertTrue(mowRepository.currentMowMoving().getPosition().equals(initialPosition));
    }

    @Test
    public void move_outside_grass_dimension_from_origin_to_down(){
        Coordinates initialCoordinates = new Coordinates(0,0);
        Position initialPosition = new Position(initialCoordinates,Orientation.SOUTH);
        mowService.create(initialPosition);
        mowService.moveIfWithinGrass();
        assertTrue(mowRepository.currentMowMoving().getPosition().equals(initialPosition));
    }

    @Test
    public void move_outside_grass_dimension_from_origin_to_left(){
        Coordinates initialCoordinates = new Coordinates(0,6);
        Position initialPosition = new Position(initialCoordinates,Orientation.WEST);
        mowService.create(initialPosition);
        mowService.moveIfWithinGrass();
        assertTrue(mowRepository.currentMowMoving().getPosition().equals(initialPosition));
    }

    @Test
    public void move_outside_grass_dimension_from_top_right(){
        Coordinates initialCoordinates = new Coordinates(6,6);
        Position initialPosition = new Position(initialCoordinates,Orientation.NORTH);
        mowService.create(initialPosition);
        mowService.moveIfWithinGrass();
        assertTrue(mowRepository.currentMowMoving().getPosition().equals(initialPosition));
    }

}
