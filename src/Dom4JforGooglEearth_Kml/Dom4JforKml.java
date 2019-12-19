package Dom4JforGooglEearth_Kml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class Dom4JforKml {

    public static void main(String[] args) throws MalformedURLException {
        //ArrayList<Book> bookList = new ArrayList<Book>();
        URL url = new URL("file:D:/programming/IDEA_Dev/readkml4method/沪昆线12.11.kml");
        try {
            //2.通过reader对象的read（）方法加载books.xml文件，获取document对象
            Document document = parse(url);
            //3.通过document对象获取根节点
            Element root = document.getRootElement();
            System.out.println(root.getName());

            List<Node> nodeList = document.selectNodes("Document/Folder");

            for (Node node : nodeList) {
                System.out.println(node.getName());
            }

            } catch (DocumentException e1) {
            e1.printStackTrace();
        }
    }


    //1.创建SAXReader的对象reader
    public static Document parse(URL url) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
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
