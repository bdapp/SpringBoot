package me.bello.chapter0304.controller;

import me.bello.chapter0304.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
public class RegisterController {

    @RequestMapping("/reg")
    public String reg() {
        return "register";
    }


    @RequestMapping("register")
    public String register(HttpServletRequest request,
                           @ModelAttribute User user,
                           Model model) throws Exception {

        if (user.getHeader().isEmpty())
        return "error";

        String path = request.getServletContext().getRealPath("/upload/");
        System.out.println("path: "+path);

        String fileName = user.getHeader().getOriginalFilename();

        File filePath = new File(path, fileName);
        if (!filePath.getParentFile().exists()){
            filePath.getParentFile().mkdir();
        }
        user.getHeader().transferTo(new File(path+File.separator+fileName));

        model.addAttribute("user", user);
        return "userInfo";
    }
}
