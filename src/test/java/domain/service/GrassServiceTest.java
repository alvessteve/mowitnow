package domain.service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.xebia.mowitnow.domain.model.grass.Grass;
import org.xebia.mowitnow.domain.model.Coordinates;
import org.xebia.mowitnow.domain.repository.GrassRepository;
import org.xebia.mowitnow.domain.service.GrassService;
import org.xebia.mowitnow.infrastructure.di.DependencyInjector;

import static org.junit.Assert.assertEquals;

public class GrassServiceTest {

    private static String COORDINATES = "5 5";
    private static GrassService grassService;
    private static GrassRepository grassRepository;

    @BeforeClass
    public static void setup(){
        grassRepository = DependencyInjector.newGrassRepository();
        grassService = DependencyInjector.newGrassService();
    }

    @Test
    public void create_grass_with_correct_formatted_coordinates(){
        Grass expectedGrass = new Grass(new Coordinates(5,5));
        grassService.create(COORDINATES);
        Grass result = grassRepository.get();
        assertEquals(result,expectedGrass);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_grass_with_wrong_coordinates(){
        String COORDINATES = "x 5";
        grassService.create(COORDINATES);
    }

}
