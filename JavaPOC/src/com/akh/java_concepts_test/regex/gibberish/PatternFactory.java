package com.akh.java_concepts_test.regex.gibberish;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class PatternFactory {
	
	private static final String EXACT_MATCH_1 ="([@#$%^&*()_+\\-\\[\\]{};':\"\\\\|,.<>\\/?!~]{3})";
	private static final String THRESHOLD_PATTERN_1 ="[@#$%^&*()_+\\[\\]{};':\"\\|<>\\/?!~\\-]"; //6
	private static final String THRESHOLD_PATTERN_2 ="([.,])"; //6
	private static final String THRESHOLD_PATTERN_3 ="[@#$%^&*()_+\\-\\[\\]{};':\"\\\\|,.<>\\/?!~]"; //10
	
	
//	private static final String NEW_EXACT_MATCH_1 ="([!-/:-@\\[-`\\{-~]{3})";
//	private static final String NEW_THRESHOLD_PATTERN_1 ="[!-+:-@\\[-`{-~\\/\\-]"; //6
//	private static final String NEW_THRESHOLD_PATTERN_2 ="([.,])"; //6
//	private static final String NEW_THRESHOLD_PATTERN_3 ="[!-\\/:-@\\[-`{-~]"; //10
	
//	private static final String NEW_EXACT_MATCH_1 ="([!-\/:-@\[-`\{-~]{3})";
//	private static final String NEW_THRESHOLD_PATTERN_1 ="[!-+:-@\\[-`\\{-~\\/\\-]"; //6
//	private static final String NEW_THRESHOLD_PATTERN_2 ="([.,])"; //6
//	private static final String NEW_THRESHOLD_PATTERN_3 ="[!-\\/:-@\\[-`\\{-~]"; //10
	
	private static final String NEW_EXACT_MATCH_1 ="([!-/:-@\\[-`{-~]{3})";  	// This is the pattern from CALLOG ([!-/:-@\\\\[-`{-~]{3})
	private static final String NEW_THRESHOLD_PATTERN_1 ="[!-+:-@\\[-`{-~/-]"; //6
	private static final String NEW_THRESHOLD_PATTERN_2 ="([.,])"; //6
	private static final String NEW_THRESHOLD_PATTERN_3 ="[!-/:-@\\[-`{-~]"; //10
	

    public static List<Pattern> getCompiledPatternsList(String age) {
        if (age == "OLD") {
            return getOldCompiledPatternsList();
        } else {
            return getNewCompiledPatternsList();
        }
    }

    private static List<Pattern> getOldCompiledPatternsList() {
        List<Pattern> compiledPatternsList = new ArrayList<>();
        compiledPatternsList
                .add(Pattern.compile(EXACT_MATCH_1));
        return compiledPatternsList;
    }

    private static List<Pattern> getNewCompiledPatternsList() {
        List<Pattern> compiledPatternsList = new ArrayList<>();
        compiledPatternsList.add(Pattern.compile(NEW_EXACT_MATCH_1));
        return compiledPatternsList;
    }


    public static Map<Pattern, Integer> getCompiledPatternsMap(String age) {
        if (age == "OLD") {
            return getOldCompiledPatternsMap();
        } else {
            return getNewCompiledPatternsMap();
        }
    }

    private static Map<Pattern, Integer> getOldCompiledPatternsMap() {
        Map<Pattern, Integer> compiledPatternsMap =  new LinkedHashMap<>();
        compiledPatternsMap.put(Pattern.compile(THRESHOLD_PATTERN_1), 6);
		compiledPatternsMap.put(Pattern.compile(THRESHOLD_PATTERN_2), 6);
        compiledPatternsMap.put(Pattern.compile(THRESHOLD_PATTERN_3), 10);
        return compiledPatternsMap;
    }

    private static Map<Pattern, Integer> getNewCompiledPatternsMap() {
        Map<Pattern, Integer> compiledPatternsMap =  new LinkedHashMap<>();
        compiledPatternsMap.put(Pattern.compile(NEW_THRESHOLD_PATTERN_1), 6);
		compiledPatternsMap.put(Pattern.compile(NEW_THRESHOLD_PATTERN_2), 6);
        compiledPatternsMap.put(Pattern.compile(NEW_THRESHOLD_PATTERN_3), 10);
        return compiledPatternsMap;
    }
}


/**
 * 
 * new ArrayList<>();
		//		List<Pattern> compiledPatternsList =  compiledPatternsList.add(Pattern.compile("([@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]{3})"));
        compiledPatternsList.add(Pattern.compile("([!-\\/:-@\\[-`{-~]{3})"));
        

        		Map<Pattern, Integer> compiledPatternsMap =  new LinkedHashMap<>();
		// ([@#$%^&*()_+\\-\\[\\]{};':\"\\\\|,.<>\\/?]   {3})
		//  [@#$%^&*()_+\\-\\[\\]{};':\"\\\\|<>\\/?]     =6
		//  [@#$%^&*()_+\\-\\[\\]{};':\"\\\\|,.<>\\/?]   =10
		// ([.,])=6
 */