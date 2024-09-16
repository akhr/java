package com.akh.java_concepts_test.serialization.basics;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeExample {
	public static void main(String[] args) {
		Student student = new Student("John Doe", 20);

		try (FileOutputStream fileOut = new FileOutputStream("./student.txt");
		     ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

			out.writeObject(student);
			System.out.println("Serialized data is saved in student.ser");
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
}