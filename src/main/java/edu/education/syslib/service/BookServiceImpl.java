package edu.education.syslib.service;

import edu.education.syslib.model.Book;
import edu.education.syslib.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book getBookById(long id) {
        Optional<Book> optional = bookRepository.findById(id);
        Book book = null;
        if(optional.isPresent()) {
            book = optional.get();
        } else throw new RuntimeException("Book by id " + id + " was not found");

        return book;
    }

    @Override
    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }
}
