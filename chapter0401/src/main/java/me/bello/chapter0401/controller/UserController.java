package me.bello.chapter0401.controller;

import me.bello.chapter0401.bean.User;
import me.bello.chapter0401.repository.UserRepository;
import me.bello.chapter0401.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    @RequestMapping("/save")
    public String save(){
        User user = new User();
        user.setLoginName("aaa");
        user.setUsername("bbb");
        user.setSex('男');
        user.setAge(30);
        userService.save(user);
        return "保存数据成功！";
    }


    @RequestMapping("/update")
    public String update(){
        User user = userService.getById(2);
        userService.update(user);
        return "修改成功!";
    }


    @RequestMapping("/delete")
    public String delete(){
        userService.delte(2);
        return "删除成功！";
    }

    @RequestMapping("/getAll")
    public Iterable<User> getAll(){
        return userService.getAll();
    }
}
