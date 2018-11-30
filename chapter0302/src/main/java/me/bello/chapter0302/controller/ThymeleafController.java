package me.bello.chapter0302.controller;

import me.bello.chapter0302.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {

    @RequestMapping("/regExpTest")
    public String regExpTest(
            HttpServletRequest request,
            HttpSession session){
        request.setAttribute("book", "spring boot book");
        session.setAttribute("school", "crazy school");

        request.getServletContext().setAttribute("name", "test thymeleaf");
        return "success1";
    }


    @RequestMapping("/ifTest")
    public String ifTest(WebRequest webRequest){
        webRequest.setAttribute("user", "admin", webRequest.SCOPE_REQUEST);
        webRequest.setAttribute("age", 21, webRequest.SCOPE_REQUEST);
        webRequest.setAttribute("role", "root", webRequest.SCOPE_REQUEST);
        return "success2";
    }


    @RequestMapping("/eachTest")
    public String eachTest(WebRequest webRequest){
        List<Book> books = new ArrayList<>();
        books.add(new Book("book1", 80.9f));
        books.add(new Book("book2", 80.9f));
        books.add(new Book("book3", 80.9f));
        books.add(new Book("book4", 80.9f));
        books.add(new Book("book5", 80.9f));
        books.add(new Book("book6", 80.9f));
        webRequest.setAttribute("books", books, webRequest.SCOPE_REQUEST);
        return "success3";
    }
}
