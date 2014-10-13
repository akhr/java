package com.example.uri;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.*;

public class ConvertURLtoURI {


    public static void main(String[] args) {

        URL url = null;
        URI uri = null;
        String urlString = "http://www.idevelopment.info/data/Oracle/DBA_tips/Linux/LINUX_5.shtml";
        
        // Create a URL object
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Create a URI object from the String object returned by the URL object
        try {
            uri = new URI(url.toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        
        // Print the original URL object and the newly converted URI object
        System.out.println("Original URL  : " + url);
        System.out.println("Converted URI : " + uri);

    }

}
