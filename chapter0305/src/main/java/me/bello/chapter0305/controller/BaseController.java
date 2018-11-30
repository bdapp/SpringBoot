package me.bello.chapter0305.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

    @ExceptionHandler(value=Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request,
                                            Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", request.getRequestURL());
        mav.setViewName("error");
        return mav;
    }
}
