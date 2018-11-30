package me.bello.chapter0303.controller;

import me.bello.chapter0303.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
//@RestController
public class JsonController {

    @RequestMapping("/main")
    public String getIndex(){
        return "index";
    }

    @RequestMapping("/findBook")
    @ResponseBody
    public Book findBook(HttpServletRequest request){
        System.out.println(request.getParameter("name"));
        Book book = new Book();
        book.setName("Spring Boot Append!");
        book.setAuthor("balabala");
        book.setPrice(69.88f);
        return book;
    }

    @RequestMapping("/findBookList")
    @ResponseBody
    public List<Book> findBookList(){
        List<Book> list = new ArrayList<>();
        list.add(new Book("book1", "author1", 10.9f));
        list.add(new Book("book2", "author2", 20.9f));
        list.add(new Book("book3", "author3", 30.9f));
        list.add(new Book("book4", "author4", 40.9f));

        return list;
    }
}
