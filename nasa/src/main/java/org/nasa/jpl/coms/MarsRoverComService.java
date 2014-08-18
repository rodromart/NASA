package org.nasa.jpl.coms;

import org.nasa.jpl.rover.MarsRover;
import org.nasa.jpl.rover.Orientation;

public class MarsRoverComService {

	MarsRover rover = null;
	public MarsRoverComService() {
			}
	
	public void setInitialPosition(int pX, int pY, String pO ){
		
		
		rover = new MarsRover(pX, pY,pO);
	}
	
	public String sendCommands(String pCommands) {
		
		rover.processCommands(pCommands);
		return rover.toString();
	}
	
	
}
