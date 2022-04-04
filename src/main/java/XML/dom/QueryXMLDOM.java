package XML.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class QueryXMLDOM {
    public static void main(String[] args) {
        try{
            File inputFile = new File("plants.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.print("Root element : ");
            System.out.println(doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("category");
            System.out.println("------------------------------");

            for(int temp = 0; temp < nList.getLength(); temp++){
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element : ");
                System.out.print(nNode.getNodeName());

                if(nNode.getNodeType() == Node.ELEMENT_NODE){
                    Element eElment = (Element) nNode;
                    System.out.print("\nplant : ");
                    System.out.println(eElment.getAttribute("tag2ID"));
                    NodeList plantNameList = eElment.getElementsByTagName("001");

                    for(int count = 0; count < plantNameList.getLength(); count++){
                        Node node1 = plantNameList.item(count);

                        if(node1.getNodeType() == Node.ELEMENT_NODE){
                            Element plant = (Element) node1;
                            System.out.println("plant type : "
                                    +plant.getTextContent());
                            System.out.println("plant species : "
                                    +plant.getAttribute("species"));
                        }
                    }
                }
            }
        }catch (Exception e){

        }
    }
}
