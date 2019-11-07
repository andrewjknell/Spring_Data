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
	
    public Book updateBook(Long x, String t, String desc, String lang, int num) {
        Optional<Book> b = bookRepo.findById(x);
        if(b.isPresent()) {
        	Book c = b.get();
            c.setTitle(t);
            c.setDescription(desc);
            c.setLanguage(lang);
            c.setNumberOfPages(num);
            return bookRepo.save(c);
        } else {
            return null;
        }
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
