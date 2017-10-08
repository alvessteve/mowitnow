package domain.model;

import org.junit.Test;
import org.xebia.mowitnow.domain.model.Orientation;

import static org.junit.Assert.assertEquals;


public class OrientationTest {

    @Test
    public void from_libelle_orientation_north(){
        Orientation orientation = Orientation.fromLibelleOrientation('N');
        assertEquals(Orientation.NORTH, orientation);
    }

    @Test
    public void from_libelle_orientation_east(){
        Orientation orientation = Orientation.fromLibelleOrientation('E');
        assertEquals(Orientation.EAST, orientation);
    }

    @Test
    public void from_libelle_orientation_west(){
        Orientation orientation = Orientation.fromLibelleOrientation('W');
        assertEquals(Orientation.WEST, orientation);
    }

    @Test
    public void from_libelle_orientation_south(){
        Orientation orientation = Orientation.fromLibelleOrientation('S');
        assertEquals(Orientation.SOUTH, orientation);
    }
}
