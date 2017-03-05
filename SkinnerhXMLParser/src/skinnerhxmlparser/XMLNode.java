package skinnerhxmlparser;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author holt
 */
public class XMLNode {
    public String name;
    public String content;
    public HashMap<String, String> attributes;
    public ArrayList<XMLNode> children;
    
    public XMLNode() {}
}
