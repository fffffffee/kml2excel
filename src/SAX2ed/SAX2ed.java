package SAX2ed;


import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import SAX2ed.Entity.Book;
import java.io.IOException;

public class SAX2ed {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();

            SAXParserHandler handler = new SAXParserHandler();

            parser.parse("E://test2.xml", handler);

            System.out.println("共有" + handler.getBookList().size() + "书");

            for (Book book : handler.getBookList()) {
                System.out.println(book.getFirstname());
                System.out.println("id=" + book.getId());
                System.out.println(book.getLastname());
                System.out.println(book.getNickname());
                System.out.println(book.getMarks());
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
