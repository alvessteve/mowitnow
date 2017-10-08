package domain.model;

import org.junit.Test;
import org.xebia.mowitnow.domain.model.Coordinates;

import static org.junit.Assert.*;

public class CoordinatesTest {

    @Test(expected = IllegalArgumentException.class)
    public void wrong_x_input(){
        new Coordinates(-5,8);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrong_y_input(){
        new Coordinates(8,-1);
    }

    @Test
    public void valid_coodinates(){
        assertTrue(Coordinates.areValid(2,3));
    }

    @Test
    public void invalid_coodinates_in_x_axis(){
        assertFalse(Coordinates.areValid(-2,3));
    }

    @Test
    public void invalid_coodinates_in_y_axis(){
        assertFalse(Coordinates.areValid(2,-3));
    }

    @Test
    public void invalid_coodinates_in_both_axis(){
        assertFalse(Coordinates.areValid(-2,-3));
    }
}
