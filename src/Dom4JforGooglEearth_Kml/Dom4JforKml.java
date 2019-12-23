package Dom4JforGooglEearth_Kml;

import Dom4JforGooglEearth_Kml.Entity.PlacemarkEntity;
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
            Document document = parse(url);
            XPath xPath_Folder = document.createXPath("/xmlns:kml/xmlns:Document/xmlns:Folder/xmlns:Folder/xmlns:name[text() = '区间节点']/../xmlns:Folder//xmlns:Placemark");  //读取placemark
            xPath_Folder.setNamespaceURIs(createNamespace());

            List<Node> placemarkList = xPath_Folder.selectNodes(document);
            System.out.println("共找到" + placemarkList.size() + "个节点。");

            PlacemarkEntity placemarkEntity = new PlacemarkEntity();

            for (Node placemark : placemarkList) {
                XPath xPath_Name_Coordinates = placemark.createXPath("./xmlns:name|.//xmlns:coordinates");
                xPath_Name_Coordinates.setNamespaceURIs(createNamespace());
                List<Node> attsofNode = xPath_Name_Coordinates.selectNodes(placemark);
                /*for (Node n :
                     attsofNode) {
                    System.out.println(n.getStringValue());
                }*/
                placemarkEntity.setName_Placemark(attsofNode.get(0).getStringValue());
                placemarkEntity.setCoordinates_Placemark(attsofNode.get(1).getStringValue());
                System.out.println(placemarkEntity.getName_Placemark());
                System.out.println(placemarkEntity.getCoordinates_Placemark());


                    }
            } catch (DocumentException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * 创建SAXReader的对象reader
     * @param url xml文件路径
     * @return
     * @throws DocumentException
     */
    public static Document parse(URL url) throws DocumentException {
        SAXReader reader = new SAXReader(new DocumentFactory());
        Document document = reader.read(url);
        if ( document == null) {
            return null;
        } else {
            return document;
        }
    }

    /**
     * 创建命名空间
     * @return 返回命名空间变量
     */
    public static Map createNamespace() {
        //Todo
        Map namespace = new HashMap();
        //String nsURI = root.getNamespaceURI();
        namespace.put("xmlns" , "http://www.opengis.net/kml/2.2");
        namespace.put("kml" , "http://www.opengis.net/kml/2.2");
        return namespace;
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
