package com.example.springcrudharsh.controller;

import com.example.springcrudharsh.dao.AdminRepository;
import com.example.springcrudharsh.dao.BookRepository;
import com.example.springcrudharsh.dao.UserRepository;
import com.example.springcrudharsh.entity.Admin;
import com.example.springcrudharsh.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
//        EmpEntity obj = new EmpEntity();
//        obj.setName("harsh sachin said");
//        EmpEntity user = this.bookRepository.save(obj);
//        System.out.println(user);
        return "index";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin() {
        Admin admin = new Admin("admin");
        this.adminRepository.save(admin);
        System.out.println(admin);
        return "admin";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") int id, Model model) {
        Users user = this.userRepository.getById(id);
        model.addAttribute("user", user);
        System.out.println(user);
        return "update";
    }


    // update user
    @RequestMapping(value = "/update/updateuser", method = RequestMethod.POST)
    public void updateUser(@ModelAttribute Users users, HttpServletResponse httpServletResponse) throws Exception {
        try {
            this.userRepository.save(users);
        } catch (Exception e) {
            e.printStackTrace();
        }
        httpServletResponse.sendRedirect("/register");
    }
}
