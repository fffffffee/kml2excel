package SAX2ed;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import SAX2ed.Entity.Book;
import java.util.ArrayList;


public class SAXParserHandler extends DefaultHandler {

    String value = null;
    Book book = null;
    private ArrayList<Book> bookList = new ArrayList<Book>();

    public ArrayList<Book> getBookList() {
        return bookList;
    }
    /*
    XML解析开始
     */
    public void startDocumnet() throws SAXException {
        // TODO Auto-generated method stub
        super.startDocument();
        System.out.println("xml解析开始");
    }
    /*
    XML解析结束
     */
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("xml解析结束");
    }
    /*
    解析XML元素开始
     */
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //TODO Auto-generated method stub
        super.startElement(uri, localName, qName, attributes);

        if (qName.equals("student")) {
            book = new Book();

            System.out.println("==================开始某本书解析===============");

            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.print("book属性名：" + attributes.getQName(i) + "---");
                System.out.println("book属性值：" + attributes.getValue(i));

                if (attributes.getQName(i).equals("id")){
                    book.setId(attributes.getValue(i));
                }
            }
        } else if (!qName.equals("class")){
            System.out.print("节点名：" + qName + "---");
        }
    }

    /*
    解析XML元素 结束
     */
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //TODO
        super.endElement(uri, localName, qName);
        if (qName.equals("student")){
            bookList.add(book);
            book = null;
            System.out.println("=================结束某本书解析================");

        } else if (qName.equals("firstname")){
            book.setFirstname(value);
        } else if (qName.equals("lastname")){
            book.setLastname(value);
        } else if (qName.equals("nickname")){
            book.setNickname(value);
        } else if (qName.equals("marks")){
            book.setMarks(value);
        } else if (qName.equals("id")){
            book.setId(value);
        }

    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        //TODO
        super.characters(ch, start, length);

        value = new String(ch, start, length);
        if (!value.trim().equals("")){
            System.out.println("节点值" + value);
        }
    }

}
