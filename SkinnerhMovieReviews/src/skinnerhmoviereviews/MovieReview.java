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
