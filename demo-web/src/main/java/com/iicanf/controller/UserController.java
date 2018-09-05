package com.iicanf.controller;

import com.iicanf.model.User;
import com.iicanf.service.UserService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by iicanf on 2018/08/08.
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @RequestMapping("add")
    @ResponseBody
    public String add(User user) {
        userService.save(user);
        return "";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(@RequestParam Integer id) {
        userService.deleteById(id);
        return "";
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(User user) {
        userService.update(user);
        return "";
    }

    @RequestMapping("detail")
    @ResponseBody
    public String detail(@RequestParam Integer id) {
        User user = userService.findById(id);
        return user.toString();
    }

    @RequestMapping("list")
    @ResponseBody
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<User> list = userService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return list.toString();
    }
}
