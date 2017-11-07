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
import java.io.FileNotFoundException;
import java.io.IOException;

public class XPathParser {

    public String readAndFind(File f, String expression){

        String result = "error";

        try{
            FileInputStream fileIS = new FileInputStream(f);
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(fileIS);
            XPath xPath = XPathFactory.newInstance().newXPath();
            //Node node = (Node) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
            //result = node.getTextContent();
            result = xPath.evaluate(expression, xmlDocument);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (ParserConfigurationException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (SAXException e){
            e.printStackTrace();
        }
        catch (XPathExpressionException e){
            e.printStackTrace();
        }

        return result;
    }

}
