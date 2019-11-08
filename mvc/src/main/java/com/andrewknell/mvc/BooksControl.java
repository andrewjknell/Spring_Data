package com.andrewknell.mvc;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.andrewknell.mvc.models.Book;
import com.andrewknell.mvc.services.BookService;

@Controller
public class BooksControl {
    private final BookService bookService;
    
    public BooksControl(BookService bookService) {
        this.bookService = bookService;
    }
    
    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "/books/index.jsp";
    }
    
    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "/books/new.jsp";
    }
    
    @RequestMapping(value="/books", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/new.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
    
    @RequestMapping("/books/show/{id}")
    public String showBook(@PathVariable("id")long id, Model model) {
    	List<Book> books = bookService.allBooks();
    	if(books.size()>= id) {
    		Book b = bookService.findBook(id);
    		model.addAttribute("book", b);
    		return "/books/show.jsp";
    	} else {
    		return "redirect:/books";
    	}
    	
    }
    
    @RequestMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "/books/edit.jsp";
    }
    
    @RequestMapping(value="/books/{id}", method=RequestMethod.POST)
    public String update(@Valid @ModelAttribute("book") Book newB, BindingResult result,@PathVariable("id")long id) {
        if (result.hasErrors()) {
            return "/books/edit.jsp";
        } else {
        	Book update = bookService.findBook(id);
        	update.setTitle(newB.getTitle());
        	update.setDescription(newB.getDescription());
        	update.setLanguage(newB.getLanguage());
        	update.setNumberOfPages(newB.getNumberOfPages());
            bookService.updateBook(update);
            return "redirect:/books";
        }
    }
    
    @PostMapping("/bookd/{id}")
    public String destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
