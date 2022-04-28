package com.bookapp.service;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;

import java.util.List;
import java.util.stream.Stream;

public interface IBookService {
    Book getById(int bookId) throws BookNotFoundException;

    List<Book> getAll() throws BookNotFoundException;
    List<Book> getByAuthor(String author) throws BookNotFoundException;
    List<Book> getByCategory(String category) throws BookNotFoundException;
    List<Book> getByLesserPrice(double price) throws BookNotFoundException;
}
