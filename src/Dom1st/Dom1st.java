package Dom1st;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Dom1st {

    public static void main(String[] args) {
        //创建DocumentBuilderFactory对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //创建DocumentBuilder对象
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            //Document d = builder.parse("E://readkml4methed/test.xml");
            Document d = builder.parse("E://test2.xml");
            NodeList sList = d.getElementsByTagName("student");
            //element(slist)
            int nodecnt = sList.getLength();
            System.out.println("获取了"+nodecnt+"个节点。");
            //node(sList);
            for (int i = 0; i <nodecnt ; i++) {
                Node student = sList.item(i);
                NamedNodeMap attrs = student.getAttributes();
                System.out.println("第" + (i + 1) + "个节点共有" + attrs.getLength() + "个属性。");
                for (int j = 0; j <attrs.getLength(); j++) {
                    Node attr = attrs.item(j);
                    System.out.print("属性名：" + attr.getNodeName() + "---");
                    System.out.println("属性值：" + attr.getNodeValue());
                }
                NodeList childNodes = student.getChildNodes();
                for (int k = 0; k < childNodes.getLength() ; k++) {
                    if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
                        System.out.print("第" + k + "节点的节点名称：" + childNodes.item(k).getNodeName());
                        System.out.println("节点值：" + childNodes.item(k).getTextContent());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*public static void node(NodeList list) {
        int nodecnt = list.getLength();
        System.out.println(nodecnt);
        for (int i = 0; i <nodecnt ; i++) {
            Node student = list.item(i);
            NamedNodeMap attrs = student.getAttributes();
            System.out.println("第"+(i+1)+"个节点共有"+attrs.getLength()+"个属性。");
            NodeList childNodes = student.getChildNodes();
            for (int j = 0; j <childNodes.getLength() ; j++) {
                if (childNodes.item(j).getNodeType()==Node.ELEMENT_NODE)
                    System.out.print(childNodes.item(j).getNodeName()+":");
                    System.out.print(childNodes.item(j).getFirstChild().getNodeValue());
            }

        }
    }*/
}
