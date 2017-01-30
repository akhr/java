package com.akh.java_concepts_test.enumSetTest;

import java.util.EnumMap;  
//import java.util.HashMap;  
import java.util.EnumSet;  
import java.util.Map;  
import java.util.Set;  

import static java.lang.System.out;  

/** 
* Simple demonstration of EnumMap and EnumSet. 
* 
* http://download.oracle.com/docs/cd/E17409_01/javase/6/docs/api/java/util/EnumMap.html 
* http://download.oracle.com/docs/cd/E17409_01/javase/6/docs/api/java/util/EnumSet.html 
* 
* @author Dustin 
*/  
public class EnumCollections  
{  
 /** Preferred form feed/carriage return/line feed. */  
 private static final String NEW_LINE = System.getProperty("line.separator");  

 /** Demonstrate the EnumMap in action. */  
 public static void demonstrateEnumMap()  
 {  
//    final Map<ColorEnum, String> colorsAndCauses = new HashMap<ColorEnum, String>();  
    final Map<ColorEnum, String> colorsAndAwarenessRibbons = new EnumMap<ColorEnum, String>(ColorEnum.class);  
    colorsAndAwarenessRibbons.put(ColorEnum.BLUE, "Bipolar");  
    colorsAndAwarenessRibbons.put(ColorEnum.GRAY, "Diabetes");  
    colorsAndAwarenessRibbons.put(ColorEnum.PINK, "Breast Cancer");  
    colorsAndAwarenessRibbons.put(ColorEnum.RED, "Acquired Immunodeficiency Syndrome");  
    colorsAndAwarenessRibbons.put(ColorEnum.YELLOW, "Support the Troops");  
    displayMap("Awareness Ribbons Colors", colorsAndAwarenessRibbons);  

    // The EnumMap can also be constructed by passing another EnumMap to one  
    // of its constructors or by passing a general Map to one of its  
    // constructors.  
 }  

 /** Demonstrate the EnumSet in action. */  
 public static void demonstrateEnumSet()  
 {  
    // instantiate empty EnumSet and fill it individually  
    final Set<ColorEnum> denverBroncosColors = EnumSet.noneOf(ColorEnum.class);  
    denverBroncosColors.add(ColorEnum.BLUE);  
    denverBroncosColors.add(ColorEnum.ORANGE);  
    displaySet("Denver Broncos Colors", denverBroncosColors);  

    // instantiate EnumSet with single value  
    final Set<ColorEnum> orangeFruitColor = EnumSet.of(ColorEnum.ORANGE);  
    displaySet("What Color is an Orange?", orangeFruitColor);  

    // instantiate EnumSet with two values  
    final Set<ColorEnum> greeceFlagColors = EnumSet.of(ColorEnum.BLUE, ColorEnum.WHITE);  
    displaySet("Colors of Greek Flag", greeceFlagColors);  

    // instantiate EnumSet with three values  
    final Set<ColorEnum> usFlagColors =  
       EnumSet.of(ColorEnum.RED, ColorEnum.WHITE, ColorEnum.BLUE);  
    displaySet("Colors of United States Flag", usFlagColors);  

    // instantiate EnumSet with four values  
    final Set<ColorEnum> googleIconColors =  
       EnumSet.of(ColorEnum.BLUE, ColorEnum.RED, ColorEnum.YELLOW, ColorEnum.GREEN);  
    displaySet("Google Icon Colors", googleIconColors);  

    // instantite EnumSet with five values  
    final Set<ColorEnum> olympicsRingsColors =  
       EnumSet.of(ColorEnum.BLUE, ColorEnum.YELLOW, ColorEnum.BLACK, ColorEnum.GREEN, ColorEnum.RED);  
    displaySet("Olympics Rings Colors", olympicsRingsColors);  

    // place all enum choices in this Set  
    final Set<ColorEnum> allColors = EnumSet.allOf(ColorEnum.class);  
    displaySet("All Available Colors", allColors);  

    // Instantiate Set of ColorEnums that are complement to EnumSet of GRAY  
    // Note that the graySet passed to the complementOf method must be an  
    // EnumSet specifically rather than the more general Set.  
    final EnumSet<ColorEnum> graySet = EnumSet.of(ColorEnum.GRAY);  
    final Set<ColorEnum> allButGrayColors = EnumSet.complementOf(graySet);  
    displaySet("All Colors Except Gray", allButGrayColors);  

    final EnumSet<ColorEnum> btogColors = EnumSet.range(ColorEnum.BLACK, ColorEnum.GREEN);  
    displaySet("'B' Colors to 'G' Colors", btogColors);  
 }  

 /** 
  * Display the provided Map by writing its contents to standard output with 
  * a separating header that includes the provided header text. 
  * 
  * @param header Header text to demarcate the output. 
  * @param mapToDisplay Map whose contents should be written to standard output. 
  */  
 private static void displayMap(  
    final String header, final Map<ColorEnum, String> mapToDisplay)  
 {  
    out.println(buildHeaderSeparator(header));  
    for (final Map.Entry<ColorEnum, String> entry : mapToDisplay.entrySet())  
    {  
       final ColorEnum color = entry.getKey();  
       out.println(color + " is used to represent " + entry.getValue());  
       out.println(  
            "  (and it is represented in HTML as "  
          + color.getHtmlHexadecimalCode() + " and in RGB as "  
          + color.getRgbRepresentation() + ".");  
    }  
 }  

 /** 
  * Write the provided Set to standard output along with the provided header. 
  * 
  * @param header Header to be displayed before the set being printed. 
  * @param setToDisplay Set to be displayed by writing to standard output. 
  */  
 private static void displaySet(final String header, final Set<ColorEnum> setToDisplay)  
 {  
    out.println(buildHeaderSeparator(header));  
    out.println(setToDisplay);  
 }  

 /** 
  * Provide a separating header based on the provided header String. 
  * 
  * @param header The string to be placed in the header. 
  * @return Header separator with provided String and separation marks. 
  */  
 private static String buildHeaderSeparator(final String header)  
 {  
    return  
         NEW_LINE  
       + "=================================================================="  
       + NEW_LINE  
       + "= " + header  
       + NEW_LINE  
       + "==================================================================";  
 }  

 /** 
  * Main executable function. 
  * 
  * @param arguments Command-line arguments; none expected. 
  */  
 public static void main(final String[] arguments)  
 {  
    demonstrateEnumMap();  
    demonstrateEnumSet();  
 }  
}  