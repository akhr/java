/**
 * 
 */
package com.akh.java_concepts_test.equalsAndHashcodeTest;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Akhash Ramamurthy
 *
 * Feb 16, 2016 12:28:47 PM
 * EqualsAndHashCodeTest.java
 */
public class EqualsAndHashCodeTest {

	public EqualsAndHashCodeTest() {

	}

	public static void main(String[] args) {
		Car camry_1 = new Camry(2010);
		Car camry_2 = new Camry(2015);
		Automobile camry_3 = (Automobile) camry_1;
		Toyota corolla_1 = new Corolla(2015);

		System.out.println("Camry_1 == Camry_2 ==> "+ (camry_1.equals(camry_2)));
		System.out.println("\nCamry_1 == Camry_3 ==> "+ (camry_1 == camry_3));
		System.out.println("\nCamry_2 == Corolla_1 ==> "+ (camry_2.equals(corolla_1)));

		Set<Car> garage = new HashSet<Car>();
		garage.add(camry_1);
		garage.add(camry_2);
		garage.add(corolla_1);
		System.out.println("\nGarage contains ==> "+garage.toString());
		System.out.println("\nDoes Garage have - "+corolla_1.toString()+" ==> "+garage.contains(new Corolla(2015)));

	}

	private static interface Automobile{
		int getMaxSpeed();
		int getNoOfGears();
		String getGearType();
		String getDriveTrainType();
	}

	private static abstract class Car{
		String make;
		String model;
		int year;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			/*		result = prime * result + ((make == null) ? 0 : make.hashCode());
			result = prime * result + ((model == null) ? 0 : model.hashCode());
			result = prime * result + year;*/
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (!(obj instanceof Car)) {
				return false;
			}
			Car other = (Car) obj;
			if (make == null) {
				if (other.make != null) {
					return false;
				}
			} else if (!make.equals(other.make)) {
				System.out.println("Makes are different");
				return false;
			}
			if (model == null) {
				if (other.model != null) {
					return false;
				}
			} else if (!model.equals(other.model)) {
				System.out.println("Models are different");
				return false;
			}
			if (year != other.year) {
				System.out.println("Years are different");
				return false;
			}
			return true;
		}

		@Override
		public String toString() {
			return this.make+" "+this.model+" "+this.year;
		}


	}

	private static abstract class Toyota extends Car{
		Toyota(){
			this.make = "Toyota";
		}

		@Override
		public int hashCode() {
			return super.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			return super.equals(obj);
		}
	}

	private static class Camry extends Toyota implements Automobile{

		Camry(int year){
			this.model = "Camry";
			this.year = year;
		}

		@Override
		public int getMaxSpeed() {
			return 120;
		}


		@Override
		public int getNoOfGears() {
			return 6;
		}

		@Override
		public String getGearType() {
			return "auto";
		}

		@Override
		public String getDriveTrainType() {
			return "front";
		}
	}

	private static class Corolla extends Toyota implements Automobile{

		Corolla(int year){
			this.model = "Corolla";
			this.year = year;
		}

		@Override
		public int getMaxSpeed() {
			return 80;
		}


		@Override
		public int getNoOfGears() {
			return 5;
		}

		@Override
		public String getGearType() {
			return "auto";
		}

		@Override
		public String getDriveTrainType() {
			return "front";
		}
	}
}
