package com.example.watiread.watiread.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks (){
        List<Book> books = (List<Book>) bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book newBook = bookService.addBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        Book updateCustomer = bookService.updateBook(book);
        return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long book_id){
        bookService.deleteBook(book_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

