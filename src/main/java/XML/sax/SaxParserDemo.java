package XML.sax;

import org.w3c.dom.UserDataHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SaxParserDemo {
    public static void main(String[] args) {
        try {
            File inputFile = new File("plants.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userHandler = new UserHandler();
            saxParser.parse(inputFile, userHandler);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class UserHandler extends DefaultHandler{
    boolean bType = false;
    boolean bFamily = false;
    boolean bSpecies = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("tag2")){
            String rollNo = attributes.getValue("tag2ID");
            System.out.println("Roll No : "+rollNo);
        }else if (qName.equalsIgnoreCase("type")){
            bType = true;
        }else if (qName.equalsIgnoreCase("family")){
            bFamily = true;
        }else if (qName.equalsIgnoreCase("species")){
            bSpecies = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase("tag2")){
            System.out.println("End element : "+ qName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(bType){
            System.out.println("Type: "+new String(ch, start, length));
            bType = false;
        }else if (bFamily){
            System.out.println("Family: "+new String(ch, start, length));
            bFamily = false;
        }else if (bSpecies){
            System.out.println("Specie: "+new String(ch, start, length));
            bSpecies = false;
        }
    }
}
