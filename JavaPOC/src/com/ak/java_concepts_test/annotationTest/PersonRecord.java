package com.thesaka.eg.annotationTest;

@Person(
		name = "Akhash",
		age=28,
		state="NYC",
		country="USA, India"
		)
public class PersonRecord {

	public PersonRecord() {
		System.out.println("PersonRecord==== > Person Record Created");

		Person person = getClass().getAnnotation(Person.class);
		if(person == null){
			System.out.println("PersonRecord==== > Person is null");
		}else{
			System.out.println("PersonRecord==== > Person Record created with .........");
			System.out.println("PersonRecord==== > Person Name = "+ person.name());
			System.out.println("PersonRecord==== > Person Age = "+ person.age());
			System.out.println("PersonRecord==== > Person State = "+ person.state());
			System.out.println("PersonRecord==== > Person Country = "+ person.country());
		}
	}
}
