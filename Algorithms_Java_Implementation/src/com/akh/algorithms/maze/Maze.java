package com.akh.algorithms.maze;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Maze {

	public static int rCounter;
	public static int fCounter;
	public static int endPtDiscoverRCounter;

	private int sizeX, sizeY;
	private char[][] maze;

	public Maze(int sizeX, int sizeY){

		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.maze = new char[sizeX][sizeY];

		for(int x=0; x<sizeX; x++){
			for(int y=0; y<sizeY; y++){

				if(x==0 && y<5)
					maze[x][y]= '*';

				/*else if(x==1 && y==4)
					maze[x][y]= '*';*/

				else if(x<7 && y==0)
					maze[x][y]= '*';

				else if(x==2 && y<5)
					maze[x][y]= '*';
				
				else if(x==3 && y>=4)
					maze[x][y]= '*';

				else if(x==4 && (y==2 || y==7))
					maze[x][y]= '*';

				else if(x==5 &&(y==4 || y==7))
					maze[x][y]= '*';

				else if(x==6 && (y<=4 || y==7))
					maze[x][y]= '*';

				else if(x==7 && y>=4)
					maze[x][y]= '*';

				else
					maze[x][y]= '-';

				
				//Placing the start and end points. Also gate opening points to define route. 
				if(x==5 && y==3)
					maze[x][y]= 'S';

				if(x==3 && y==7)
					maze[x][y]= 'E';
				
				if(x==2 && y==1)
					maze[x][y]= '-';
			}
		}
	}

	public void printMaze(){
		for(int x=0; x<sizeX; x++){
			for(int y=0; y<sizeY; y++){
				if(y==0)
					System.out.print("\t|   ");
				System.out.print(maze[x][y]+"   ");
				if(y==sizeY-1)
					System.out.print(" |\t");
			}
			System.out.print("\n");
		}
	}

	public Coordinate getStartPoint(){
		Coordinate startPt = new Coordinate(-1, -1);

		for(int x=0; x<sizeX; x++){
			for (int y=0; y<sizeY; y++) {
				fCounter++;
				if(maze[x][y]=='S'){
					startPt.pointX = x;
					startPt.pointY = y;
					return startPt;
				}
			}
		}
		return startPt;
	}

	public Coordinate getStartPointRecursively(int locX, int locY, boolean[][] visitedMatrix){
		rCounter++;

		Coordinate startPt = new Coordinate(-1, -1);

		if(locX<0 || locX>sizeX-1 || locY<0 || locY>sizeY-1)
			return startPt;

		if(visitedMatrix[locX][locY] == true)
			return startPt;
		else
			visitedMatrix[locX][locY] = true;

		if(maze[locX][locY] == 'S'){
			startPt.pointX = locX;
			startPt.pointY = locY;
			return startPt;
		}else{
			startPt = getStartPointRecursively(locX, locY-1, visitedMatrix);
			if(startPt.pointX != -1 || startPt.pointY != -1) 
				return startPt;

			startPt = getStartPointRecursively(locX, locY+1, visitedMatrix);
			if(startPt.pointX != -1 || startPt.pointY != -1) 
				return startPt;

			startPt = getStartPointRecursively(locX-1, locY, visitedMatrix);
			if(startPt.pointX != -1 || startPt.pointY != -1) 
				return startPt;

			startPt = getStartPointRecursively(locX+1, locY, visitedMatrix);
			if(startPt.pointX != -1 || startPt.pointY != -1) 
				return startPt;

		}
		return startPt;
	}
	
	public Coordinate discoverAndPrintRoute(int locX, int locY){
		boolean[][] visitedMatrix = new boolean[sizeX][sizeY];
		Stack<Coordinate> route = new Stack<Coordinate>();
		route.push(new Coordinate(locX, locY));
		Coordinate ePoint = discoverEndPoint(locX, locY, visitedMatrix, route);
		System.out.println("\n\nRoute : ");
		for (Coordinate coordinate : route) {
			System.out.print("{"+coordinate.pointX+" , "+coordinate.pointY+"}\t");
		}
		
		System.out.println("\n\nFor Loop call count --> " + endPtDiscoverRCounter);
		
		for(int x=0; x<sizeX; x++){
			for(int y=0; y<sizeY; y++){
				if(y==0)
					System.out.print("\t|   ");
				System.out.print(visitedMatrix[x][y]==true? "T  ":"F  ");
				if(y==sizeY-1)
					System.out.print(" |\t");
			}
			System.out.print("\n");
		}
		return ePoint;
	}

	public Coordinate discoverEndPoint(int locX, int locY, boolean[][] visitedMatrix, Stack<Coordinate> route){
		endPtDiscoverRCounter++;

		Coordinate endPt = new Coordinate(-1, -1);

		if(locX<0 || locX>sizeX-1 || locY<0 || locY>sizeY-1)
			return endPt;
		
		if(visitedMatrix[locX][locY] == true){
			return endPt;
		}else{
			visitedMatrix[locX][locY] = true;
		}
		
		if(maze[locX][locY]== '*')
			return endPt;

		if(maze[locX][locY] == 'E'){
			endPt.pointX =locX;
			endPt.pointY =locY;
			return endPt;
		}else{
			route.push(new Coordinate(locX, locY-1));
			endPt = discoverEndPoint(locX, locY-1, visitedMatrix, route);
			if(endPt.pointX!=-1 && endPt.pointY!=-1){
				return endPt;
			}else{
				route.pop();
			}

			route.push(new Coordinate(locX, locY+1));
			endPt = discoverEndPoint(locX, locY+1, visitedMatrix, route);
			if(endPt.pointX!=-1 && endPt.pointY!=-1){
				return endPt;
			}else{
				route.pop();
			}

			route.push(new Coordinate(locX-1, locY));
			endPt = discoverEndPoint(locX-1, locY, visitedMatrix, route);
			if(endPt.pointX!=-1 && endPt.pointY!=-1){
				return endPt;
			}else{
				route.pop();
			}

			route.push(new Coordinate(locX+1, locY));
			endPt = discoverEndPoint(locX+1, locY, visitedMatrix, route);
			if(endPt.pointX!=-1 && endPt.pointY!=-1){
				return endPt;
			}else{
				route.pop();
			}
		}
		return endPt;
	}
}
