package com.thesaka.eg.annotationTest;

public class Tester {

	public Tester() {
		System.out.println("Tester***** > Tester Created");
	}

	public static void main(String[] args){
		PersonRecord personRecord = new PersonRecord();
		Person person = personRecord.getClass().getAnnotation(Person.class);
		if(person == null){
			System.out.println("Tester***** > Person is null");
		}else{
			System.out.println("Tester***** > Person Name = "+ person.name());
			System.out.println("Tester***** > Person Age = "+ person.age());
			System.out.println("Tester***** > Person State = "+ person.state());
			System.out.println("Tester***** > Person Country = "+ person.country());
		}
	}
}
