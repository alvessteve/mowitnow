package application;

import org.junit.Before;
import org.junit.Test;
import org.xebia.mowitnow.application.MowLauncher;
import org.xebia.mowitnow.domain.model.Coordinates;
import org.xebia.mowitnow.domain.model.mow.Mow;
import org.xebia.mowitnow.domain.model.Orientation;
import org.xebia.mowitnow.domain.model.mow.Position;
import org.xebia.mowitnow.domain.repository.MowRepository;
import org.xebia.mowitnow.infrastructure.di.DependencyInjector;

import java.util.List;

import static org.junit.Assert.*;


public class MowLauncherTest {

    private final static String FILE_PATH = "./src/test/resources/";

    private MowRepository mowRepository;
    private Position expectedPositionForMow1;
    private Position expectedPositionForMow2;

    @Before
    public void setup(){
        mowRepository = DependencyInjector.newMowrepository();
        expectedPositionForMow1 = new Position(new Coordinates(1,3), Orientation.NORTH);
        expectedPositionForMow2 = new Position(new Coordinates(5,1), Orientation.EAST);
    }

    @Test(expected = IllegalArgumentException.class)
    public void generate_from_wrong_file_move_wrong(){
        MowLauncher.main(FILE_PATH + "move_instruction_corrupted.txt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void generate_from_wrong_file_no_grass(){
        MowLauncher.main(FILE_PATH + "mows_without_grass.txt");
    }

    @Test
    public void generate_from_string(){
        MowLauncher.main("5 5","1 2 N","GAGAGAGAA","3 3 E","AADAADADDA");
        List<Mow> mowList = mowRepository.all();
        assertNotNull(mowList);
        assertFalse(mowList.isEmpty());
        assertTrue(mowList.get(0).getPosition().equals(expectedPositionForMow1));
        assertTrue(mowList.get(1).getPosition().equals(expectedPositionForMow2));
    }

    @Test
    public void generate_from_file(){
        MowLauncher.main(FILE_PATH + "mows.txt");
        List<Mow> mowList = mowRepository.all();
        assertNotNull(mowList);
        assertFalse(mowList.isEmpty());
        assertTrue(mowList.get(0).getPosition().equals(expectedPositionForMow1));
        assertTrue(mowList.get(1).getPosition().equals(expectedPositionForMow2));
    }

}
