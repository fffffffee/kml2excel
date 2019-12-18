package Dom4JforGooglEearth_Kml;

import Dom4j.Entity.Book;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Dom4JforKml {
    public static void main(String[] args) throws MalformedURLException {
        ArrayList<Book> bookList = new ArrayList<Book>();
        //1.创建SAXReader的对象reader
        SAXReader reader = new SAXReader();
        try {
            //2.通过reader对象的read（）方法加载books.xml文件，获取document对象
            Document document = reader.read(new File("沪昆线12.11.kml"));
            //3.通过document对象获取根节点bookstore
            Element documentRootElement = document.getRootElement();
            System.out.println("RootElement : " + documentRootElement.getName());
            //4.通过element对象的elementIterator获取迭代器
            Iterator it = documentRootElement.elementIterator();
            //5.遍历迭代器，获取根节点中的信息
            while (it.hasNext()){
                System.out.println("==========开始遍历某一本书==========");
                Element book = (Element)it.next();
                if(book.getName() == "Folder") {

                }

                Book bookData = new Book();

                //6.获取book的属性名和属性值
                List<Attribute> bookAttrs = book.attributes();
                for (Attribute attr : bookAttrs) {
                    System.out.println("属性名：" + attr.getName() + "--" + "属性值：" + attr.getValue());

                    if (attr.getName().equals("id")) {
                        bookData.setId(attr.getValue());
                    }
                }
                //7.通过book对象的elementIterator获取节点元素迭代器
                Iterator itt = book.elementIterator();

                //8.遍历迭代器，获取子节点中的信息
                while (itt.hasNext()) {
                    Element bookChild = (Element)itt.next();

                    //9.获取节点名和节点值
                    System.out.println("节点名：" + bookChild.getName() + "---节点值：" + bookChild.getStringValue());

                }

            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }


    }
}
