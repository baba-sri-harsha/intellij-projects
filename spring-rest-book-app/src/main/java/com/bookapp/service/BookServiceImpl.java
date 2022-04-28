package com.bookapp.service;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Service
public class BookServiceImpl implements IBookService{
    @Override
    public Book getById(int bookId) throws BookNotFoundException {
        return showBooks().stream().filter(book -> book.getBookId()==bookId).findFirst().get();
    }

    @Override
    public List<Book> getAll() throws BookNotFoundException  {
        List<Book> books = showBooks();
        if (books.isEmpty())
            throw new BookNotFoundException("Book Not Found");
        return books;
    }

    @Override
    public List<Book> getByAuthor(String author) throws BookNotFoundException {
        List<Book> books = showBooks().stream().filter(book -> book.getAuthor().equals(author)).sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
        if (books.isEmpty())
            throw new BookNotFoundException("Book Not Found");
        return books;
    }

    @Override
    public List<Book> getByCategory(String category) throws BookNotFoundException {
        List<Book> books = showBooks().stream().filter(book -> book.getCategory().equals(category)).sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
        if (books.isEmpty())
            throw new BookNotFoundException("Book Not Found");
        return books;
    }

    @Override
    public List<Book> getByLesserPrice(double price) throws BookNotFoundException {
        List<Book> books = showBooks().stream().filter(book -> book.getPrice()<=price).sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
        if (books.isEmpty())
            throw new BookNotFoundException("Book Not Found");
        return books;
    }

    private List<Book> showBooks(){
        return Arrays.asList(
                new Book(1,"java in action","baba","tech",200),
                new Book(2,"html in force","sandeep","etech",500),
                new Book(3,"css in styles","harsha","comedy",454),
                new Book(4,"js in action","akash","tech",9000)
        );
    }
}
