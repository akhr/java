package com.akh.java_concepts_test.regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest2 {
	public static void main(String[] args){
		
		List<Pattern> compiledPatternsList = new ArrayList<>();
//		compiledPatternsList.add(Pattern.compile("([@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]{3})"));
		compiledPatternsList.add(Pattern.compile("([!-\\/:-@\\[-`{-~]{3})"));
		
		Map<Pattern, Integer> compiledPatternsMap =  new LinkedHashMap<>();
		// ([@#$%^&*()_+\\-\\[\\]{};':\"\\\\|,.<>\\/?]   {3})
		//  [@#$%^&*()_+\\-\\[\\]{};':\"\\\\|<>\\/?]     =6
		//  [@#$%^&*()_+\\-\\[\\]{};':\"\\\\|,.<>\\/?]   =10
		// ([.,])=6

		compiledPatternsMap.put(Pattern.compile("[!-+:-@\\[-`{-~\\/\\-]"), 6);
		compiledPatternsMap.put(Pattern.compile("([.,])"), 6);
		compiledPatternsMap.put(Pattern.compile("[!-\\/:-@\\[-`{-~]"), 10);
		
		List<String> escapedAddr = new ArrayList<>();
		int gibberishCount = 0;
		
		for(String address : getGibExamples_Quick()){
			boolean isGib = matchesGibberishPatterns(address, compiledPatternsList, compiledPatternsMap);
			System.out.println("Addr :: "+address+" - Is Gib - "+isGib+"\n");
			
			if (isGib){
				gibberishCount++;
			}else {
				escapedAddr.add(address);
			}
		}
		
		System.out.println("\n\nSample Size-"+getGibExamples_Quick().size());
		System.out.println("Gibberish Count-"+gibberishCount);
		System.out.println("Escaped Count-"+escapedAddr.size());
		System.out.println("\n\nEscaped Addresses : ");
		for (String str : escapedAddr)
		{ 		      
			System.out.println(str); 		
		}

	}


	private static boolean matchesGibberishPatterns(String address,
			List<Pattern> exactMatchPatternList,
			Map<Pattern, Integer> charThresholdPatternMap) {

		for(Pattern pattern: exactMatchPatternList) {
			if (matchesExactGibberishPattern(address, pattern))
				return true;
		}

		Set<Entry<Pattern, Integer>> patternsMap = charThresholdPatternMap.entrySet();
		Iterator<Entry<Pattern, Integer>> iterator = patternsMap.iterator();
		while(iterator.hasNext()){
			Entry<Pattern, Integer> entry = iterator.next();
			if (exceedsGibberishCharThreshold(address, entry.getKey(), entry.getValue()))
				return true;
		}

		return false;
	}
	
	public static boolean exceedsGibberishCharThreshold(String address, Pattern pattern, int threshold){
		Matcher m = pattern.matcher(address);
		int count = 0;
		while(m.find()){
			count++;
		}
		if (count >= threshold) {
			System.out.println("Exceed Thr : "+pattern.pattern()+" thrs - "+threshold);
			return true;
		} 
		return false;
	}

	public static boolean matchesExactGibberishPattern(String address, Pattern pattern){
		Matcher m = pattern.matcher(address);
		if (m.find()) {
			System.out.println("Matched Pattern : "+pattern.pattern());
			return true;
		} 
		return false;
	}
	
	public static List<String> getGibExamples_Quick(){
		ArrayList<String> arr = new ArrayList<String>(
				Arrays.asList(
						"$(123) Hamilton# [Ave/",
						"nkkdcndncn@^!$",
						"nkkdcndncn@^5~",
						"nkkdcndncn@=~",
						"nkkdcndncn4..st,,",
						"8....34---6 N@@@&&&&&@&&@W 66TH,,, S...T",
						"8..95,,2 N@@W 2@4th Te-rra-ce",
						"7672 Dixon rd @@@@@@@@@@198",
						"(*&&(*&*(",
						"7672 ^& &^ $ ()Dixon rd @ @ @ @ @ @ @ @ @ @198",
						"{121}, ",
						"a bc d e ff 1 23 44",
						"8..34--6 N..323,34,33.44.W 66TH,,2, S.4..T#$ 344",
						"8..34--6 N32$33%^43*3%4#4W 66TH2 S4T#$ 344"
						
						));
		return arr;
	}
}
