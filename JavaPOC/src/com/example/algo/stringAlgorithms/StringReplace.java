package com.example.algo.stringAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class StringReplace {

	public static void main(String[] args) {
		char[] cA = new char[]{'M','r',' ','J','o','h','n',' ','S','m','i','t','h',' ',' ',' ',' '};
		String s = "Mr John Smith    ";
		encodeSpace(s, 13);
//		System.out.println("PlaceHolders - "+makePlaceholders(4));
		List<String> ids = new ArrayList<String>();
		ids.add("122");
		ids.add("143");
		ids.add("876");
		ids.add("897");
		ids.add("434");
		ids.add("675");
		queryBuilder(ids);
		
	}


	/** Code from Gayle**/
	/*	public static void replace(char[] str, int length){
		int spaceCount = 0, newLength, i;
		 for(i=0; i<length; i++){
			 if(str[i]==' ')
				 spaceCount++;
		 }
		 newLength = length+spaceCount*2;
		// str[newLength] = '\0';
		 for(i=length-1; i>=0; i--){
			 if(str[i] == ' '){
				 str[newLength -1] = '0';
				 str[newLength -2] = '2';
				 str[newLength -3] = '%';
				 newLength = newLength-3;
			 }else{
				 str[newLength -1] = str[i];
				 newLength = newLength-1;
			 }
		 }
		 System.out.println(str);
	}*/


	/** AK Design 
	 * Input : 	"Mr John Smith    " , len - 13 (true length of the string i.e, len = no of alphabetic chars - space not included)
	 * Output:	"Mr%20John%20Smith"
	 * **/
	public static void encodeSpace(String s, int trueLength){
		char[] str = new char[s.length()];
		System.out.println("Input String - ");
		for(int i=0; i<s.length(); i++){
			str[i] = s.charAt(i);
			System.out.println(str[i]);
		}

		int resultLength = str.length-1;
		for(int i=trueLength-1; i>=0; i--){
			if(str[i]==' '){
				str[resultLength] = '0';
				str[resultLength-1] = '2';
				str[resultLength-2] = '%';
				resultLength = resultLength-3;
			}else{
				str[resultLength] = str[i];
				resultLength--;
			}
		}

		System.out.println("Result - "+ new String(str));
	}

	private static String makePlaceholders(int length){
		if(length <=0)
			return "";

		StringBuilder strBuilder = new StringBuilder(); 
		for(int i=0; i<length; i++){
			if(i==0)
				strBuilder.append("\"");
			else
				strBuilder.append(",\"");
			strBuilder.append("%s");
			strBuilder.append("\"");
		}

		System.out.println("Placeholders : "+ strBuilder.toString());
		return strBuilder.toString();
	}

	public static void queryBuilder(List<String> packageIds){

		if(packageIds == null || packageIds.isEmpty()){
			return;
		}

		String[] packageIdArray = new String[packageIds.size()];
		for(int i=0; i<packageIds.size(); i++){
			packageIdArray[i] = packageIds.get(i);
		}

		String TABLE_DOWNLOADS = "DOWNLOADS";
		String COL_PACKAGE_ID = "Column_PackageId";
		
		String selectQuery = "SELECT  * FROM " + TABLE_DOWNLOADS + " WHERE "+COL_PACKAGE_ID+ " IN ("+ makePlaceholders(packageIds.size())+" )";
		System.out.println("Un-Formatted : "+selectQuery);
		String formatted = String.format(selectQuery, packageIdArray);
		System.out.println("Formatted : "+formatted);
		

		//db.query(TABLE_DOWNLOADS, null, COL_PACKAGE_ID+" IN ("+ makePlaceholders(packageIds.size())+" )", packageIdArray, null, null, null, null);

	}

}
