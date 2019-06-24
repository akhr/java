package com.akh.aa.mudField;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.sun.corba.se.impl.logging.OMGSystemException;

/**
 *  @fileName: Contest_110.java
 *  @author: Akhash Ramamurthy
 *  Created on: Nov 10, 2018
 *  ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 */

public class Contest_110 {


	public int minAreaRect(int[][] points) {
		Coordinate lB;
		Coordinate lT;
		Coordinate rB;
		Coordinate rT;

		int minArea = Integer.MAX_VALUE;
		int got4Points = 0;
		List<Coordinate> coordinates = new ArrayList<>();
		
		
		for(int i = 0; i<points.length; i++) {
			coordinates.add(new Coordinate(points[i][0], points[i][1]));
		}
		
		for(int i=1; i<coordinates.size(); i++) {
			if(got4Points == 4) {
				/*if(isRect(lB, lT, rB, rT)) {
					minArea = Math.min(minArea, area(lB, lT, rB, rT));
					
				}*/
			}
			
			
			
			if(isValidLine(coordinates.get(i-1), coordinates.get(i))) {
				if(got4Points == 0) {
					lB = coordinates.get(i-1);
					lT = coordinates.get(i);
				}else {
					rB = coordinates.get(i-1);
					rT = coordinates.get(i);
				}
				got4Points +=2;
			}
		}
		
		return minArea == Integer.MAX_VALUE ? 0 : minArea;
	}
	
	private boolean isValidLine(Coordinate bottom, Coordinate top) {
		return bottom.x == top.x;
	}
	
	private boolean isRect(Coordinate lB, Coordinate lT, Coordinate rB, Coordinate rT) {
		return (lB.y == rB.y && lT.y == rT.y);
	}
	
	private int area(Coordinate lB, Coordinate lT, Coordinate rB, Coordinate rT) {
		return (rB.x-lB.x)*(rT.y-rB.y);
	}
	
	private static class Coordinate{
		int x, y;
		Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
