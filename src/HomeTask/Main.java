package HomeTask;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> book = new ArrayList<>();
        BookShop bookShop = new BookShop("AkademyBook", "+375293894233", book);

        bookShop.addBook(new Book(1, "Java Filosophy", "Author", 2010));
        bookShop.addBook(new Book(2, "Java8", "Shild", 2014));
        bookShop.addBook(new Book(3, "Java in examples", "Sierra", 2016));

        File file = new File("BookShop.xml");
        try {
            JAXBContext context = JAXBContext.newInstance(BookShop.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(bookShop, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        try {
            JAXBContext context = JAXBContext.newInstance(BookShop.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Object bookShop1 = unmarshaller.unmarshal(file);
            System.out.println(bookShop1);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
