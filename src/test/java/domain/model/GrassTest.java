package domain.model;

import org.junit.Before;
import org.junit.Test;
import org.xebia.mowitnow.domain.model.grass.Grass;
import org.xebia.mowitnow.domain.model.Coordinates;

import static org.junit.Assert.*;

public class GrassTest {

    private Grass grass;

    @Before
    public void setup(){
        Coordinates coordinates = new Coordinates(5,8);
        grass = new Grass(coordinates);
    }

    @Test(expected = IllegalArgumentException.class)
    public void no_dimensions(){
        new Grass(null);
    }

    @Test
    public void out_of_bounds_ko(){
        Coordinates testCoordinates = new Coordinates(1,2);
        assertFalse(grass.outOfBounds(testCoordinates));
    }

    @Test
    public void out_of_bounds_ok(){
        Coordinates testCoordinates = new Coordinates(5,10);
        assertTrue(grass.outOfBounds(testCoordinates));
    }

}
