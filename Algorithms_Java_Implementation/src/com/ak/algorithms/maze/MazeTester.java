package com.thesaka.algorithms.maze;

public class MazeTester {

	public static void main(String[] args) {
		Maze maze = new Maze(9, 9);
		maze.printMaze();
		boolean[][] visitedMatrix = new boolean[9][9];

		Coordinate sPoint = maze.getStartPointRecursively(0, 0, visitedMatrix);
		System.out.println("S point --> "+sPoint.pointX+", "+ sPoint.pointY);
		System.out.println("Recursive Func call count --> " + Maze.rCounter);

		Coordinate ePoint = maze.discoverAndPrintRoute(sPoint.pointX, sPoint.pointY);
		System.out.println("E point --> "+ePoint.pointX+", "+ ePoint.pointY);
	}

}
