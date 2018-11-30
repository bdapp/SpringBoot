package me.bello.chapter0305.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController extends BaseController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }


    @RequestMapping("/hello")
    public String hello() throws Exception {
        throw new Exception();
    }

    @RequestMapping("/test")
    public String test()  {
        int i= 5 / 0;
        return "success";
    }


}
