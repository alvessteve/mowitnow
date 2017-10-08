package domain.factory;


import org.junit.Test;
import org.xebia.mowitnow.domain.factory.MowFactory;
import org.xebia.mowitnow.domain.model.grass.Grass;
import org.xebia.mowitnow.domain.model.Coordinates;
import org.xebia.mowitnow.domain.model.mow.Mow;
import org.xebia.mowitnow.domain.model.Orientation;
import org.xebia.mowitnow.domain.model.mow.Position;

import static org.junit.Assert.*;

public class MowFactoryTest {

    @Test
    public void initialize_mow_correctly(){
        Position position = new Position(new Coordinates(8,5), Orientation.NORTH);
        Grass grass = new Grass(new Coordinates(8,5));
        Mow mow = MowFactory.build(position,grass);
        assertNotNull(mow);
        assertTrue(mow.getPosition().equals(position));
    }

    @Test(expected = IllegalArgumentException.class)
    public void mow_outside_grass(){
        Position position = new Position(new Coordinates(8,5), Orientation.NORTH);
        Grass grass = new Grass(new Coordinates(2,9));
        MowFactory.build(position,grass);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mow_without_grass(){
        Position position = new Position(new Coordinates(8,5), Orientation.NORTH);
        MowFactory.build(position,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mow_without_position(){
        Grass grass = new Grass(new Coordinates(2,9));
        MowFactory.build(Position.invalidPosition(),grass);
    }

}
