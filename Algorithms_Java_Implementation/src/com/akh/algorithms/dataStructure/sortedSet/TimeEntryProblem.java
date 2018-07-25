	package com.akh.algorithms.dataStructure.sortedSet;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

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

	public static class TimeSegment implements Comparable<TimeSegment>{
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

		@Override
		public int compareTo(TimeSegment o) {
			if(this == o){
				return 0;
			}else if((this.startTime == o.startTime) && (this.endTime == o.endTime)){
				return 0;
			}else {
				return -1;
			}
		}
		
		public boolean isOverlapping(TimeSegment o){
			if(this.endTime < o.startTime)
				return false;
			if(this.startTime > o.endTime)
				return false;
			return true;
			
			/*if((this.startTime == o.startTime) && (this.endTime == o.endTime))
				return true;
			if((this.startTime == o.startTime) && (this.endTime > o.endTime))
				return true;
			if((this.startTime == o.startTime) && (this.endTime < o.endTime))
				return true;
			
			if((this.startTime > o.startTime) && (this.endTime == o.endTime))
				return true;
			if((this.startTime > o.startTime) && (this.endTime > o.endTime))
				return true;
			if((this.startTime > o.startTime) && (this.endTime > o.endTime))
				return true;
			
			if((this.startTime < o.startTime) && (this.endTime == o.endTime))
				return true;
			if((this.startTime < o.startTime) && (this.endTime > o.endTime))
				return true;
			if((this.startTime < o.startTime) && (this.endTime > o.endTime))
				return true;*/
			
		}

	}

	
	/**
	 * 
	 * TO-DO - IMPLEMENT SEARCH AND THEN ADD LOGIC TO ADD SEGMENTS INTO THE SET
	 */
	public SortedSet<TimeSegment> buildSortedTimeSegments(List<TimeRecord> timeRecords){
		SortedSet<TimeSegment> set = new TreeSet<>();
		for(TimeRecord timeRecord : timeRecords){
			getSegmentForGivenTime(set, timeRecord.getEntryTime());
		}
		return set;
	}

	public TimeSegment getSegmentForGivenTime(SortedSet<TimeSegment> set, long searchTime){
		// Need to search through the SortedSet based on startTime and endTime and return a TimeSegment 
		// which contains this searchTime
		// Only one segment will exist (if at all) in the set containing this searchTime 
		return null;
		
	}



	public int getOnCampusEmployeesCount(SortedSet<TimeSegment> set, long searchTime){
		return getSegmentForGivenTime(set, searchTime).getOnCampusEmployeesCount();
	}

	//########################## FILE LOADING ########################################################################################
	private File loadFile(String fileName) {
		return new File(fileName);
	}

	public List<TimeRecord> parseFile(String fileName)throws FileNotFoundException, ParseException{
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
		List<TimeRecord> timeRecords = null;
		SortedSet<TimeSegment> timeSegmentsSet = null;

		// Generate TimeRecords by parsing the given log file
		try {
			timeRecords = prob.parseFile("TimeEntryProblemDataFile.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		
		if(timeRecords != null && !timeRecords.isEmpty())
			timeSegmentsSet = prob.buildSortedTimeSegments(timeRecords);

		
		//Create date format for the search time
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy HH:mm:ss");
		String searchDateString = "Jul 01 2018 11:30:00";
		
		//Search for the time and print crossponding employee count
		try {
			System.out.println(prob.getOnCampusEmployeesCount(timeSegmentsSet, dateFormat.parse(searchDateString).getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
