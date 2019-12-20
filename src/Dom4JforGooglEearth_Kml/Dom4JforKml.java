package Dom4JforGooglEearth_Kml;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Dom4JforKml {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("file:D:/programming/IDEA_Dev/readkml4method/沪昆线12.11.kml");
        try {
            SAXReader reader = new SAXReader(new DocumentFactory());
            //reader.getDocumentFactory().setXPathNamespaceURIs(map);
            Document document = reader.read(url);
            Element root = document.getRootElement();
            Map namespace = new HashMap();
            String nsURI = root.getNamespaceURI();
            namespace.put("xmlns" , nsURI);
            //namespace.put("gx" , "http://www.google.com/kml/ext/2.2");
            namespace.put("kml" , "http://www.opengis.net/kml/2.2");
            //namespace.put("atom" , "http://www.w3.org/2005/Atom");

            //遍历kml节点
            /*Iterator it = root.elementIterator();
            while (it.hasNext()) {
                Element element = (Element) it.next();//读取第二层Document节点
                System.out.println(element.getName());
                Iterator it2 =  element.elementIterator();
                while (it2.hasNext()) {
                    Element element2 = (Element) it2.next();//读取第三层Folder节点
                    if(element2.getName().equals("Folder")) {
                        System.out.println("key:" + element2.getName());
                        //System.out.println("val:" + element2.getStringValue());
                    }
                    Iterator it3 = element2.elementIterator();
                    while (it3.hasNext()) {
                        Element element3 = (Element) it3.next();//读取第四层Folder
                        if (element3.getName().equals("Folder")) {
                            System.out.println("key:" + element3.getName());
                            //System.out.println("val:" + element3.getStringValue());
                        }
                    }
                }
            }*/

            XPath xPath_Folder = document.createXPath("/xmlns:kml/xmlns:Document/xmlns:Folder//xmlns:name");
            xPath_Folder.setNamespaceURIs(namespace);
            List<Node> nodeList = xPath_Folder.selectNodes(document);

            for (Node node : nodeList) {
                //System.out.println(node.getName());
                /*XPath xPath_Folder_2ed = document.createXPath("./xmlns:name");
                xPath_Folder_2ed.setNamespaceURIs(namespace);
                List<Node> nodeList_2ed = xPath_Folder_2ed.selectNodes(document);
                for (Node node2 :
                        nodeList_2ed) {
                    System.out.println(node2.getName());
                }*/

                if (node.getStringValue().equals("区间节点")) {
                    //todo
                    XPath xPath_Folder_2ed = node.createXPath("..");
                    xPath_Folder_2ed.setNamespaceURIs(namespace);
                    Node folder_2ed = xPath_Folder_2ed.selectSingleNode(node);
                    System.out.println(folder_2ed.getName());
                    XPath xPath_placemark = folder_2ed.createXPath("./xmlns:Folder/xmlns:Placemark//xmlns:name|./xmlns:Folder/xmlns:Placemark//xmlns:coordinates");
                    //LabEntity lab=new LabEntity();
                    //Object coordinates_lab=lab.setName_lab
                    //Object placemark_name_lab=
                    xPath_placemark.setNamespaceURIs(namespace);
                    List<Node> placemarkList = xPath_placemark.selectNodes(folder_2ed);
                    for (Node placemark : placemarkList) {
                        //System.out.println(placemark.getName());
                        System.out.println(placemark.getStringValue()+"----rs");
                    }
                }
            }
            } catch (DocumentException e1) {
            e1.printStackTrace();
        }
    }

    //1.创建SAXReader的对象reader
    public static Document parse(URL url) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        //todo
        // 按if返回null 并附带信息至console  还要写xmlhelper
        return document;
    }
    // 遍历xml节点
    public void selectnode(Document document) throws DocumentException {
        Element root = document.getRootElement();
        // iterate through child elements of root
        for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
            Element element = it.next();
        }
        List<Element> nodeList = root.elements();
        for (Element e:nodeList) {
            List<Element> nodeList2 = e.elements();
            for(Element e2:nodeList2) {
                System.out.println(e2.getName());
            }
            System.out.println(e.getName());
        }
    }
}
