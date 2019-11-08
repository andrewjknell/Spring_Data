package com.andrewknell.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.andrewknell.mvc.models.Book;
import com.andrewknell.mvc.repositories.BookRepo;

@Service
public class BookService {
	private final BookRepo bookRepo;
	
	public BookService(BookRepo bookRepo) {
		this.bookRepo = bookRepo;
	} 

	public List<Book> allBooks() {
        return bookRepo.findAll();
    }
	
    public Book updateBook(Book b) {
        return bookRepo.save(b);

	}

	public void deleteBook(Long x) {
		bookRepo.deleteById(x);
		return;
	}
	
    public Book createBook(Book b) {
        return bookRepo.save(b);
    }

    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }

}
