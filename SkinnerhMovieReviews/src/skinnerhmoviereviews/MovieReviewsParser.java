/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skinnerhmoviereviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 *
 * @author holt
 */
public class MovieReviewsParser {
    private static final String BASEURLSTRING = "https://api.nytimes.com/svc/movies/v2/reviews/search.json";
    private static final String API = "1ddd6c274b134de1bd7b496667303a5a";
    
    private static ArrayList<MovieReview> movieReviewList;
    
    public static ArrayList<MovieReview> getMovieReviews(String queryString) throws Exception {
        if (queryString == null || queryString.equals("")) {
            throw new Exception("Nothing to Search.");
        }
        
        URL url;
        try {
            url = convertQueryToURL(queryString);
        } catch (Exception ex) {
            throw ex; // rethrow exception
        }
        System.out.println(url);
//        String jsonString = "";
//        
//        try {
//            BufferedReader in = new BufferedReader(
//            new InputStreamReader(url.openStream()));
//
//            String inputLine;
//            while ((inputLine = in.readLine()) != null) {
//                jsonString += inputLine;
//            }
//            in.close();
//        } catch (IOException ioex) {
//            throw ioex;
//        }
        
//        try {
//            parseJson(jsonString);
//        } catch (Exception ex) {
//            throw ex;
//        }
        return null;
    }
    
    // moved all of this into its own method
    private static URL convertQueryToURL(String queryString) throws Exception {
                
        String encodedQueryString;
        //encode queryString
        try {
            // queryString must be URL encoded to put in URL
            encodedQueryString = URLEncoder.encode(queryString, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            throw ex;
        }
        
        // form full URL in string format from base url, wuery an
        String urlString = BASEURLSTRING + "?query=" + encodedQueryString + "&api-key=" + API;
        
        URL url;
        
        try {
            url = new URL(urlString);
        } catch(MalformedURLException muex) {
           throw muex;
        }
        return url;
    }
}
