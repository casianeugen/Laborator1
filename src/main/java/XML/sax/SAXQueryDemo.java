package XML.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SAXQueryDemo {
    public static void main(String[] args) {
        try {
            File inputFile = new File("plants.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler2 userHandler = new UserHandler2();
            saxParser.parse(inputFile, userHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class UserHandler2 extends DefaultHandler {

    boolean bType = false;
    boolean bFamily = false;
    boolean bSpecies = false;
    String rollNo = null;

    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("plant")) {
            rollNo = attributes.getValue("tag2ID");
        }
        if("001".equals(rollNo) && qName.equalsIgnoreCase("plant")) {
            System.out.println("Start Element :" + qName);
        }
        if (qName.equalsIgnoreCase("Type")) {
            bType = true;
        } else if (qName.equalsIgnoreCase("Family")) {
            bFamily = true;
        } else if (qName.equalsIgnoreCase("Species")) {
            bSpecies = true;
        }
    }

    @Override
    public void endElement(
            String uri, String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("plant")) {
                System.out.println("End Element :" + qName);
        }
    }


    @Override
    public void characters(
            char ch[], int start, int length) throws SAXException {

        if (bType && ("001").equals(rollNo)) {
            System.out.println("Type: " + new String(ch, start, length));
            bType = false;
        } else if (bFamily && ("001").equals(rollNo)) {
            System.out.println("Family: " + new String(ch, start, length));
            bFamily = false;
        } else if (bSpecies && ("001").equals(rollNo)) {
            System.out.println("Species: " + new String(ch, start, length));
            bSpecies = false;
        }
    }
}
