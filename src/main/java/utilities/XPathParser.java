package utilities;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;

public class XPathParser {

    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger( XPathParser.class.getName() );

    public String readAndFind(File f, String expression){

        String result = "error";

        try{
            FileInputStream fileIS = new FileInputStream(f);
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(fileIS);
            XPath xPath = XPathFactory.newInstance().newXPath();
            result = xPath.evaluate(expression, xmlDocument);
        }
        catch (XPathExpressionException | SAXException | IOException | ParserConfigurationException e){
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }

        return result;
    }

}
