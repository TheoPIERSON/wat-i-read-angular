package com.example.watiread.watiread.books;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@AllArgsConstructor
@Service
public class BookService {
    private final BookRepository bookRepository;

    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
    @Transactional
    public Book updateBook(Book book){
        return bookRepository.save(book);
    }
    @Transactional
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
}
