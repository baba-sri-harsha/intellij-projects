package com.bookapp.controller;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private IBookService iBookService;


    @GetMapping("/books")
    public List<Book> showBooks() throws BookNotFoundException {
        return  iBookService.getAll();
    }

    @GetMapping("/books/author/{myauthor}")
    public List<Book> showByAuthor(@PathVariable("myauthor") String author ) throws BookNotFoundException {
        return  iBookService.getByAuthor(author);
    }

//?category=tech
    @GetMapping("/books/category")
    public List<Book> shoeByAuthor(@RequestParam("mycategory") String category ) throws BookNotFoundException {
        return  iBookService.getByAuthor(category);

    }
//books/id/1
    @GetMapping("/books/id/{bookId}")
    public Book showByAuthor(@PathVariable("bookId") int bookId ) throws BookNotFoundException {
        return  iBookService.getById(bookId);
    }

    @GetMapping("books/price/{price}")
    public  List<Book> showByPrice(@PathVariable("price")double price) throws BookNotFoundException {
        return iBookService.getByLesserPrice(price);
    }




}
