package skinnerhxmlparser;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 *
 * @author holt
 */
public class StackParser {
    public XMLNode parse(File file) throws Exception {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
        } catch (Exception e) {
            throw e;
        }
        
        return null;
    }
}
