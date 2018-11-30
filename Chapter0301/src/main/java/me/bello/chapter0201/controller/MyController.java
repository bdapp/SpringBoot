package me.bello.chapter0201.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@EnableAutoConfiguration
public class MyController {

    @RequestMapping("/")
//    @ResponseBody
    public String getHome(){
        return "index";
    }


}
