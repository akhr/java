package com.akh.algorithms.dataStructure.sortedSet;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *  @fileName: TimeEntryProblem.java
 *  @author: Akhash Ramamurthy
 *  Created on: Jul 23, 2018
 *  
 *  Given a log file --> it contains multiple records --> each record contains employee ID, entry time and exit time. 
 *  Write a function which takes time(ms) (date and time) as input and returns the count of employees on-campus at that given time.
 *  
 *  
 */

public class TimeEntryProblem {
	
	public static class Employee{
		private String empID;
		public Employee(String empID) {
			this.empID = empID;
		}
		public String getEmpID() {
			return empID;
		}
	}
	
	public static class TimeRecord{
		private Employee emp;
		private long entryTime;
		private long exitTime;
		
		public TimeRecord(Employee emp, long entryTime, long exitTime) {
			this.emp = emp;
			this.entryTime = entryTime;
			this.exitTime = exitTime;
		}
		public Employee getEmp() {
			return emp;
		}
		public long getEntryTime() {
			return entryTime;
		}
		public long getExitTime() {
			return exitTime;
		}
	}
	
	public static class TimeSegment{
		private long startTime;
		private long endTime;
		private List<Employee> onCampusEmployees;
		public TimeSegment(long startTime, long endTime) {
			super();
			this.startTime = startTime;
			this.endTime = endTime;
		}
		public long getStartTime() {
			return startTime;
		}
		public long getEndTime() {
			return endTime;
		}
		public List<Employee> getOnCampusEmployees() {
			return onCampusEmployees;
		}
		public int getOnCampusEmployeesCount(){
			return onCampusEmployees.size();
		}
	}

	public void buildSortedTimeSegments(List<TimeRecord> timeRecords){
		
	}
	
	
	
	public int getOnCampusEmployeesCount(long searchTime){
		
	}
	
	//########################## FILE LOADING ########################################################################################
	private File loadFile(String fileName) {
		return new File(fileName);
	}

	public List<TimeRecord> parseFile(String fileName)throws FileNotFoundException{
		File f = loadFile(fileName);
		Scanner scanner = new Scanner(f);
		List<TimeRecord> timeRecords = new ArrayList<>();

		while(scanner.hasNextLine()){
			String data = scanner.nextLine();
			String[] spliData =  data.split("-");
			//Create employee record
			
			//Date Format 
			//create time record for the employee
			//return list of TimeRecords
		}
		
		return timeRecords;
	}
	
	//##############################  TEST  ####################################################################################
	public static void main(String[] args) {
		TimeEntryProblem prob = new TimeEntryProblem();
		List<TimeRecord> timeRecords = prob.parseFile("TimeEntryProblemDataFile.txt");
		
		prob.buildSortedTimeSegments(timeRecords);
		
		
		//Create date format for the search time
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy HH:mm:ss");
		String searchDateString = "Jul 01 2018 11:30:00";
		System.out.println(prob.getOnCampusEmployeesCount(dateFormat.parse(searchDateString).getTime()));
		//Print count
	}

}
