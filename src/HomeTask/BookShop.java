package HomeTask;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "shop")
@XmlType(propOrder = {"name", "number", "books"})
public class BookShop {
    private String name;
    private String number;
    private List<Book> books= new ArrayList<>();

    public BookShop() {
    }

    public BookShop(String name, String number, List<Book> books) {
        this.name = name;
        this.number = number;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "phone")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @XmlElementWrapper(name = "books")
    @XmlElement(name = "book")
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public String toString() {
        return "BookShop{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", books=" + "\r\n"+ books+
                '}';
    }
}
