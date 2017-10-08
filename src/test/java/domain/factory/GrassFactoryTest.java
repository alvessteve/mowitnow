package domain.factory;

import org.junit.Test;
import org.xebia.mowitnow.domain.factory.GrassFactory;
import org.xebia.mowitnow.domain.model.grass.Grass;
import org.xebia.mowitnow.domain.model.Coordinates;

import static org.junit.Assert.*;

public class GrassFactoryTest {

    @Test
    public void grass_instanciation_ok(){
        Coordinates expectedCoordinates = new Coordinates(1,2);
        Grass grass = GrassFactory.build("1 2");
        assertNotNull(grass);
        assertTrue(grass.getDimension().equals(expectedCoordinates));
    }

    @Test(expected = IllegalArgumentException.class)
    public void no_valid_coodinates_input(){
        GrassFactory.build("");
    }

}
