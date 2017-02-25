package skinnerhmoviereviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.simple.*;

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
        String jsonString = "";
        try {
            BufferedReader in = new BufferedReader(
            new InputStreamReader(url.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                jsonString += inputLine;
            }
            in.close();
        } catch (IOException ioex) {
            throw ioex;
        }
        
        ArrayList<MovieReview> movieReviews;
        try {
            movieReviews = parseJson(jsonString);
        } catch (Exception ex) {
            throw ex;
        }
        
        return movieReviews; // will be null if parseJson didn't find anything
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
    
    private static ArrayList<MovieReview> parseJson(String jsonString) throws Exception {
        if (jsonString == null || jsonString.equals("")) {
            return null;
        }
        
        JSONObject jsonObj;
        try {
            jsonObj = (JSONObject)JSONValue.parse(jsonString);
        } catch (Exception ex) {
            throw ex;
        }
        
        if (jsonObj == null) {
            return null;
        }
        
        String status = "";
        try {
            status = (String)jsonObj.get("status");
        } catch (Exception ex) {
            throw ex;
        }
        
        if (status == null || !status.equals("OK")) {
            throw new Exception("Status returned from API was not OK.");
        }
        
        JSONArray results;
        try {
            results = (JSONArray)jsonObj.get("results");
        } catch (Exception ex) {
            throw ex;
        }
        
        if (results == null) {
            return null;
        }
        
        ArrayList<MovieReview> movieReviews = new ArrayList<>();
        
        for (Object result : results) {
            try {
                JSONObject movie = (JSONObject)result;
                
                JSONObject urlObj = (JSONObject)movie.getOrDefault("link", null);
                String url = null;
                if (urlObj != null) {
                    url = (String)urlObj.getOrDefault("url", null);
                }
                
                String title = (String)movie.getOrDefault("display_title", null);
                String mpaa = (String)movie.getOrDefault("mpaa_rating", null);
                String summary = (String)movie.getOrDefault("summary_short", null);
                long criticsChoiceInt = (long)movie.getOrDefault("critics_pick", 0);
                boolean criticsChoice = (criticsChoiceInt != 0); // turn int into boolean
                movieReviews.add(new MovieReview(url, title, summary, mpaa, criticsChoice));
                
            } catch (Exception ex) {
                throw ex;
            }
        }
        
        return movieReviews;
    }
}
