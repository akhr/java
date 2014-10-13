package com.example.algo.maze;

public class Coordinate {
	
	public int pointX;
	public int pointY;
	
	public Coordinate(){
		
	}
	
	public Coordinate(int pointX, int pointY) {
		super();
		this.pointX = pointX;
		this.pointY = pointY;
	}

	@Override
	public int hashCode() {
		int hash = 31*pointX*pointY;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Coordinate))
			return false;
		else{
			Coordinate otherPoint = (Coordinate)obj;
			if(this.pointX == otherPoint.pointX && this.pointY == otherPoint.pointY)
				return true;
		}
		return false;
	}
	
	
}
