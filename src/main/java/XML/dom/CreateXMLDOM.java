package XML.dom;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class CreateXMLDOM {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            Document doc = dbBuilder.newDocument();

            Element rootElement = doc.createElement("plants");
            doc.appendChild(rootElement);

            Element commonObjects = doc.createElement("category");
            Attr commonAtr1 = doc.createAttribute("name");
            commonAtr1.setValue("Aquatic");
            commonObjects.setAttributeNode(commonAtr1);
            rootElement.appendChild(commonObjects);

            Element plant1 = doc.createElement("plant");
            Attr attr1 = doc.createAttribute("tag2ID");
            attr1.setValue("001");
            plant1.setAttributeNode(attr1);
            commonObjects.appendChild(plant1);

            Element plant11 = doc.createElement("type");
            plant11.appendChild(doc.createTextNode("Submerged"));
            plant1.appendChild(plant11);

            Element plant21 = doc.createElement("family");
            plant21.appendChild(doc.createTextNode("Pondweed"));
            plant1.appendChild(plant21);

            Element plant31 = doc.createElement("species");
            plant31.appendChild(doc.createTextNode("Curly-leaf Pondweed"));
            plant1.appendChild(plant31);

            Element plant41 = doc.createElement("description");
            Element list1 = doc.createElement("desc");
            Element list2 = doc.createElement("desc");
            Element list3 = doc.createElement("desc");
            list1.appendChild(doc.createTextNode("water less than 10 feet deep"));
            list2.appendChild(doc.createTextNode("are rooted in the pond bottom"));
            list3.appendChild(doc.createTextNode("can help to add dissolved oxygen to the water"));
            plant41.appendChild(list1);
            plant41.appendChild(list2);
            plant41.appendChild(list3);
            plant1.appendChild(plant41);

            Element plant2 = doc.createElement("plant");
            Attr attr2 = doc.createAttribute("tag2ID");
            attr2.setValue("002");
            plant2.setAttributeNode(attr2);
            commonObjects.appendChild(plant2);

            Element plant51 = doc.createElement("type");
            plant51.appendChild(doc.createTextNode("Emergents "));
            plant2.appendChild(plant51);

            Element plant61 = doc.createElement("family");
            plant61.appendChild(doc.createTextNode("Gramineae"));
            plant2.appendChild(plant61);

            Element plant71 = doc.createElement("species");
            plant71.appendChild(doc.createTextNode("Phragmites Australis"));
            plant2.appendChild(plant71);

            Element plant81 = doc.createElement("description");
            Element list11 = doc.createElement("desc");
            Element list21 = doc.createElement("desc");
            Element list31 = doc.createElement("desc");
            list11.appendChild(doc.createTextNode("includes floating emergents"));
            list21.appendChild(doc.createTextNode("found in wetlands and along the shoreline"));
            list31.appendChild(doc.createTextNode("could cause problems with accessing your pond"));
            plant81.appendChild(list11);
            plant81.appendChild(list21);
            plant81.appendChild(list31);
            plant2.appendChild(plant81);

            Element commonObjects1 = doc.createElement("category");
            Attr commonAtr2 = doc.createAttribute("name");
            commonAtr2.setValue("Bulbs");
            commonObjects1.setAttributeNode(commonAtr2);
            rootElement.appendChild(commonObjects1);

            Element plant3 = doc.createElement("plant");
            Attr attr3 = doc.createAttribute("tag2ID");
            attr3.setValue("001");
            plant3.setAttributeNode(attr3);
            commonObjects1.appendChild(plant3);

            Element plant111 = doc.createElement("type");
            plant111.appendChild(doc.createTextNode("Corms"));
            plant3.appendChild(plant111);

            Element plant211 = doc.createElement("family");
            plant211.appendChild(doc.createTextNode("Gladiolus"));
            plant3.appendChild(plant211);

            Element plant311 = doc.createElement("species");
            plant311.appendChild(doc.createTextNode("Alocasia macrorrhizos"));
            plant3.appendChild(plant311);

            Element plant4 = doc.createElement("plant");
            Attr attr4 = doc.createAttribute("tag2ID");
            attr4.setValue("002");
            plant4.setAttributeNode(attr4);
            commonObjects1.appendChild(plant4);

            Element plant411 = doc.createElement("type");
            plant411.appendChild(doc.createTextNode("Tubers"));
            plant4.appendChild(plant411);

            Element plant511 = doc.createElement("family");
            plant511.appendChild(doc.createTextNode("Oxalis"));
            plant4.appendChild(plant511);

            Element plant611 = doc.createElement("species");
            plant611.appendChild(doc.createTextNode("Potato"));
            plant4.appendChild(plant611);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("plants.xml"));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
