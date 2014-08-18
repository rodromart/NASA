package org.nasa.jpl.rover;

public enum Orientation {

	NORTH
 {
		@Override
		public Orientation right() {
			// TODO Auto-generated method stub
			return Orientation.EAST;
		}

		@Override
		public Orientation left() {
			// TODO Auto-generated method stub
			return Orientation.WEST;
		}
	},
	
	EAST
 {
		@Override
		public Orientation right() {
			// TODO Auto-generated method stub
			return Orientation.SOUTH;
		}

		@Override
		public Orientation left() {
			// TODO Auto-generated method stub
			return Orientation.NORTH;
		}
	},
	
	SOUTH
 {
		@Override
		public Orientation right() {
			// TODO Auto-generated method stub
			return Orientation.WEST;
		}

		@Override
		public Orientation left() {
			// TODO Auto-generated method stub
			return Orientation.EAST;
		}
	},	
	
	WEST
	
 {
		@Override
		public Orientation right() {
			// TODO Auto-generated method stub
			return Orientation.NORTH;
		}

		@Override
		public Orientation left() {
			// TODO Auto-generated method stub
			return Orientation.SOUTH;
		}
	};
	
	public abstract Orientation right();
	public abstract Orientation left();
}
