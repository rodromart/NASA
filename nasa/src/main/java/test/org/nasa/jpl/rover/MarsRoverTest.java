package test.org.nasa.jpl.rover;

import static org.junit.Assert.*;

import org.junit.Test;
import org.nasa.jpl.rover.MarsRover;
import org.nasa.jpl.rover.Orientation;

public class MarsRoverTest {

	
	@Test
	public void moveLeft() {

		Object[] expectPosition = new Object[3];
		expectPosition[0]=1;
		expectPosition[1]=0;
		expectPosition[2]=Orientation.EAST;

		MarsRover rover = new MarsRover(1, 1, Orientation.SOUTH);
		rover.processCommands("ML");
		
		assertTrue(rover.equals(expectPosition));
	}

	@Test
	public void moveRight() {
		
		Object[] expectPosition = new Object[3];
		expectPosition[0]=1;
		expectPosition[1]=0;
		expectPosition[2]=Orientation.NORTH;

		MarsRover rover = new MarsRover(1, 0, Orientation.WEST);
		rover.processCommands("R");
		
		assertTrue(rover.equals(expectPosition));
	}

	@Test
	public void move() {
		
		Object[] expectPosition = new Object[3];
		expectPosition[0]=1;
		expectPosition[1]=5;
		expectPosition[2]=Orientation.NORTH;

		MarsRover rover = new MarsRover(1, 0, Orientation.NORTH);
		rover.processCommands("MMMMM");
		
		assertTrue(rover.equals(expectPosition));
	}
	
	@Test
	public void moveOutPlanteau(){
	
		Object[] expectPosition = new Object[3];
		expectPosition[0]=1;
		expectPosition[1]=-3;
		expectPosition[2]=Orientation.WEST;

		MarsRover rover = new MarsRover(1, 0, Orientation.SOUTH);
		rover.processCommands("MMMR");
		
		assertTrue(rover.equals(expectPosition));
	}
	
	@Test
	public void test1() {
		
		String commands = "LMLMLMLMM";
		Object[] expectPosition = new Object[3];
		expectPosition[0]=1;
		expectPosition[1]=3;
		expectPosition[2]=Orientation.NORTH;

		MarsRover rover = new MarsRover(1, 2, Orientation.NORTH);
		rover.processCommands(commands);
		
		assertTrue(rover.equals(expectPosition));
		
		
	}

	@Test
	public void test1Str() {
		
		String commands = "LMLMLMLMM";
		Object[] expectPosition = new Object[3];
		expectPosition[0]=1;
		expectPosition[1]=3;
		expectPosition[2]=Orientation.NORTH;

		MarsRover rover = new MarsRover(1, 2, "NORTH");
		rover.processCommands(commands);
		
		assertTrue(rover.equals(expectPosition));
		
		
	}

	@Test
	public void test2() {
		
		String commands = "MMRMMRMRRM";
		Object[] expectPosition = new Object[3];
		expectPosition[0]=5;
		expectPosition[1]=1;
		expectPosition[2]=Orientation.EAST;

		MarsRover rover = new MarsRover(3, 3, Orientation.EAST);
		rover.processCommands(commands);
		
		assertTrue(rover.equals(expectPosition));

	}

}
