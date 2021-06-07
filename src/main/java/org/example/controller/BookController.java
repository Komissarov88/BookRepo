package org.example.controller;

import org.example.entity.Book;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/viewBooks", method = RequestMethod.GET)
    public String viewBooks(Model uiModel) {
        uiModel.addAttribute("books", bookService.getBooks());
        return "view-books";
    }

    @RequestMapping("/addBook")
    public String addProduct(Model uiModel) {
        uiModel.addAttribute("book", new Book());
        return "add-book";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("book") Book book) {
        bookService.addBook(book);
        return "redirect:viewBooks";
    }
}
