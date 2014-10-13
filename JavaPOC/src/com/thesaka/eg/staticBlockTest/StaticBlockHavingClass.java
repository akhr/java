package com.thesaka.eg.staticBlockTest;

import java.util.HashMap;
import java.util.Map;

public class StaticBlockHavingClass {

	public static final String name = "NAME";

	{
		System.out.println("HELLO");
	}

	static {
		show();
	}

	public StaticBlockHavingClass() {
		System.out.println("CONSTRUCTOR");
	}

	public static void show() {
		System.out.println("MESSAGE");
	}

	public static void main(String[] args) {
		System.out.println("MAIN");

		StaticBlockHavingClass s = new StaticBlockHavingClass();
		StaticBlockHavingClass s2 = new StaticBlockHavingClass();
	}

	static {
		System.out.println("STATIC BLOCK");
		System.out.println("StaticBlockHavingClass.name = " + name);
	}
}
