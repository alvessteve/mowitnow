package domain.model;

import org.junit.Test;
import org.xebia.mowitnow.domain.model.Coordinates;
import org.xebia.mowitnow.domain.model.Orientation;
import org.xebia.mowitnow.domain.model.mow.Position;

import static org.junit.Assert.*;

public class PositionTest {

    @Test(expected = IllegalArgumentException.class)
    public void creation_position_with_no_coordinates(){
        new Position(null, Orientation.NORTH);
    }

    @Test(expected = IllegalArgumentException.class)
    public void creation_position_with_no_orientation(){
        new Position(new Coordinates(1,2), null);
    }

    @Test
    public void spin_left_position_from_north(){
        Position position = new Position(new Coordinates(1,2), Orientation.NORTH);
        position.spinLeft();
        assertTrue(position.getOrientation().equals(Orientation.WEST));
    }

    @Test
    public void spin_left_position_from_west(){
        Position position = new Position(new Coordinates(1,2), Orientation.WEST);
        position.spinLeft();
        assertTrue(position.getOrientation().equals(Orientation.SOUTH));
    }

    @Test
    public void spin_left_position_from_south(){
        Position position = new Position(new Coordinates(1,2), Orientation.SOUTH);
        position.spinLeft();
        assertTrue(position.getOrientation().equals(Orientation.EAST));
    }

    @Test
    public void spin_left_position_from_east(){
        Position position = new Position(new Coordinates(1,2), Orientation.EAST);
        position.spinLeft();
        assertTrue(position.getOrientation().equals(Orientation.NORTH));
    }

    @Test
    public void spin_right_position_from_north(){
        Position position = new Position(new Coordinates(1,2), Orientation.NORTH);
        position.spinRight();
        assertTrue(position.getOrientation().equals(Orientation.EAST));
    }

    @Test
    public void spin_right_position_from_east(){
        Position position = new Position(new Coordinates(1,2), Orientation.EAST);
        position.spinRight();
        assertTrue(position.getOrientation().equals(Orientation.SOUTH));
    }

    @Test
    public void spin_right_position_from_south(){
        Position position = new Position(new Coordinates(1,2), Orientation.SOUTH);
        position.spinRight();
        assertTrue(position.getOrientation().equals(Orientation.WEST));
    }

    @Test
    public void spin_right_position_from_west(){
        Position position = new Position(new Coordinates(1,2), Orientation.WEST);
        position.spinRight();
        assertTrue(position.getOrientation().equals(Orientation.NORTH));
    }

    @Test
    public void move_up(){
        Position position = new Position(new Coordinates(1,2), Orientation.NORTH);
        position.forward();
        assertTrue(position.getCoordinates().getY() == 3);
    }

    @Test
    public void move_down(){
        Position position = new Position(new Coordinates(1,2), Orientation.SOUTH);
        position.forward();
        assertTrue(position.getCoordinates().getY() == 1);
    }

    @Test
    public void move_right(){
        Position position = new Position(new Coordinates(1,2), Orientation.EAST);
        position.forward();
        assertTrue(position.getCoordinates().getX() == 2);
    }

    @Test
    public void move_left(){
        Position position = new Position(new Coordinates(1,2), Orientation.WEST);
        position.forward();
        assertTrue(position.getCoordinates().getX() == 0);
    }

}
