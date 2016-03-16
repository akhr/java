package com.thesaka.eg.dateTest;

public class TopCoderTime {

	public static String whatTime(int inputSecs) {
		String res = null;
		if(inputSecs < 0)
			return res;
		else if(inputSecs == 0){
			res = "0:0:0";
			return res; 	  
		}else if(inputSecs>86399){
			return res;
		}else{
			int hours = inputSecs/3600;
			int minutes = (inputSecs%3600)/60;
			int seconds = (inputSecs%3600)%60;
			res = hours+":"+minutes+":"+seconds;
			return res;
		}
	}
	
	public static void main(String[] agrs){
		System.out.println("Formatted 0 = "+whatTime(0));
		System.out.println("Formatted 3661 = "+whatTime(3661));
		System.out.println("Formatted 5436 = "+whatTime(5436));
		System.out.println("Formatted 29068 = "+whatTime(29068));
		System.out.println("Formatted 86399 = "+whatTime(86399));
		System.out.println("Formatted 86399 + 1 = "+whatTime(86400));
	}

}
