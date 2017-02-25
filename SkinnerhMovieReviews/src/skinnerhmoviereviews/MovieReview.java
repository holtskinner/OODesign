/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skinnerhmoviereviews;

/**
 *
 * @author holt
 */

public class MovieReview {
    // treat it like a struct
    public final String url;
    public final String title;
    public final String summary;
    public final String mpaa;
    public final boolean criticsChoice;
    
    public MovieReview(String url, String title, String summary, String mpaa, 
                       Boolean criticsChoice) {
        this.url = url;
        this.title = title;
        this.summary = summary;
        this.mpaa = mpaa;
        this.criticsChoice = criticsChoice;
    }
    
}
