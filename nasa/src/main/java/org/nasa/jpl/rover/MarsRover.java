package org.nasa.jpl.rover;

public class MarsRover {
	
	//Posicion
	private int x;
	private int y;
	private Orientation o; //N,O,S,E
	
	public MarsRover(int X, int Y, Orientation O){
		//Posicion Inicial
		this.x = X;
		this.y = Y;
		this.o = O;
		
		System.out.println("-- Mars Rover online and ready --");
		System.out.println("-- Start position is:");
		printPosition();
	}
	
	public MarsRover(int X, int Y, String O){
		//Posicion Inicial
		this.x = X;
		this.y = Y;
		this.o = getOrientationObject(O);
		
		System.out.println("-- Mars Rover online and ready --");
		System.out.println("-- Start position is:");
		printPosition();
	}
	
	private Orientation getOrientationObject(String pO){
		
		switch (pO) {
		case "N":
				return Orientation.NORTH;
		case "W":
	    	return Orientation.WEST;
		case "S":
			return Orientation.SOUTH;
		case "E":
			return Orientation.EAST;
		}
		return Orientation.NORTH;
		
	}
	
	public void processCommands(String p_commands){
		System.out.println("Commands line recived =" +p_commands);
		StringBuilder commands = new StringBuilder(p_commands);
		for(int i=0; i<commands.length();i++){
			processCommand(commands.charAt(i));
			//printPosition();
		}
	}

	private void processCommand(char charAt) {
		
		switch (charAt) {
		case'L':
			if(this.o.equals(Orientation.NORTH))this.o=Orientation.NORTH.left();
			else if(this.o.equals(Orientation.EAST))this.o=Orientation.EAST.left();
			else if(this.o.equals(Orientation.SOUTH))this.o=Orientation.SOUTH.left();
			else this.o=Orientation.WEST.left();
			break;
		case'R':
			if(this.o.equals(Orientation.NORTH))this.o=Orientation.NORTH.right();
			else if(this.o.equals(Orientation.EAST))this.o=Orientation.EAST.right();
			else if(this.o.equals(Orientation.SOUTH))this.o=Orientation.SOUTH.right();
			else this.o=Orientation.WEST.right();
			break;
		case'M':
			move();
			break;

		default:
			break;
		}
	}
	
	private void move(){

		switch (this.o.toString()) {
		case  "NORTH":
			this.y++;
			break;
		case "EAST":
			this.x++;
			break;
		case "SOUTH":	
			this.y--;
			break;
		case "WEST":
			this.x--;
			break;
		}
	}
	
	public void printPosition()
	{
		System.out.println("Position -> " +this.x+","+this.y+" "+this.o);
	}
	
	public boolean equals(Object[] position){
		
		Object[] finalPosition = getFinalPosition();
		if(finalPosition[0]==position[0])
			if (finalPosition[1]==position[1])
				if(finalPosition[2]==position[2])
					return true;
		
		return false;
	}
	
	public Object[] getFinalPosition(){
		
		Object[] finalPosition = new Object[3];
		finalPosition[0]=this.x;
		finalPosition[1]=this.y;
		finalPosition[2]=this.o;
		
		return finalPosition;
	}
	
	public String toString(){
		
		return this.x+","+this.y+" "+this.o;
	}
	
	

}
