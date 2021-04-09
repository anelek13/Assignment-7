package edu.education.syslib.service;

import edu.education.syslib.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();
    void saveBook(Book book);
    Book getBookById(long id);
    void deleteBook(long id);
}
