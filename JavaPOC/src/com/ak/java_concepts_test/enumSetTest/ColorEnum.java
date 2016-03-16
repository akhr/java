package com.thesaka.eg.enumSetTest; 

import java.awt.Color;  
  
/** 
 * Enum representing colors. 
 * 
 * @author Dustin 
 */  
public enum ColorEnum  
{  
   BLACK("#000000", Color.BLACK, new RedGreenBlue(0, 0, 0)),  
   BLUE("#0000FF", Color.BLUE, new RedGreenBlue(0, 0, 255)),  
   CYAN("#00FFFF", Color.CYAN, new RedGreenBlue(0, 255, 255)),  
   GRAY("#808080", Color.GRAY, new RedGreenBlue(128, 128, 128)),  
   GREEN("#00FF00", Color.GREEN, new RedGreenBlue(0, 159, 107)),  
   MAGENTA("#FF00FF", Color.MAGENTA, new RedGreenBlue(255, 0, 255)),  
   ORANGE("#FF8040", Color.ORANGE, new RedGreenBlue(255, 127, 0)),  
   PINK("#FFC0CB", Color.PINK, new RedGreenBlue(255, 192, 203)),  
   RED("#FF0000", Color.RED, new RedGreenBlue(255, 0, 0)),  
   WHITE("#FFFFFF", Color.WHITE, new RedGreenBlue(255, 255, 255)),  
   YELLOW("#FFFF00", Color.YELLOW, new RedGreenBlue(255, 205, 0));  
  
   /** 
    * Parameterized constructor. 
    * 
    * @param newHtmlHex HTML hex code for this color. 
    * @param newJavaColor Color from java.awt package. 
    */  
   ColorEnum(  
      final String newHtmlHex,  
      final Color newJavaColor,  
      final RedGreenBlue newRgb)  
   {  
      this.htmlHexCode = newHtmlHex;  
      this.javaColorCode = newJavaColor;  
      this.rgb = newRgb;  
   }  
  
   /** HTML hexadecimal code for this color. */  
   private final String htmlHexCode;  
  
   /** java.awt.Color code. */  
   private final Color javaColorCode;  
  
   /** RGB. */  
   private final RedGreenBlue rgb;  
  
   /** 
    * Provide the java.awt.Color code for this color. 
    * 
    * @return The java.awt.Color code. 
    */  
   public Color getJavaColorCode()  
   {  
      return this.javaColorCode;  
   }  
  
   /** 
    * Provide the HTML hexadecimal code for this color. 
    * 
    * @return HTML hexadecimal code for this color. 
    */  
   public String getHtmlHexadecimalCode()  
   {  
      return this.htmlHexCode;  
   }  
  
   /** 
    * Provide RGB representation of this color. 
    * 
    * @return RGB representation of this color. 
    */  
   public String getRgbRepresentation()  
   {  
      return this.rgb.getRgbString();  
   }  
  
   /** 
    * Represents RGB. 
    */  
   public static class RedGreenBlue  
   {  
      /** Red portion of RGB. */  
      private final int redValue;  
  
      /** Green portion of RGB. */  
      private final int greenValue;  
  
      /** Blue portion of RGB. */  
      private final int blueValue;  
  
      public RedGreenBlue(  
         final int newRedValue, final int newGreenValue, final int newBlueValue)  
      {  
         this.redValue = newRedValue;  
         this.greenValue = newGreenValue;  
         this.blueValue = newBlueValue;  
      }  
  
      /** 
       * Provide the red value of my RGB. 
       * 
       * @return Red portion of my RGB. 
       */  
      public int getRedValue()  
      {  
         return this.redValue;  
      }  
  
      /** 
       * Provide the green value of my RGB. 
       * 
       * @return Green portion of my RGB. 
       */  
      public int getGreenValue()  
      {  
         return this.greenValue;  
      }  
  
      /** 
       * Provide the blue value of my RGB. 
       * 
       * @return Blue portion of my RGB. 
       */  
      public int getBlueValue()  
      {  
         return this.blueValue;  
      }  
  
      /** 
       * Provide my RGB settings in String format: (r,g,b). 
       * 
       * @return String version of my RGB values: (r, g, b). 
       */  
      public String getRgbString()  
      {  
         return "(" + this.redValue + ", " + this.greenValue + ", " + this.blueValue + ")";  
      }  
   }  
}  