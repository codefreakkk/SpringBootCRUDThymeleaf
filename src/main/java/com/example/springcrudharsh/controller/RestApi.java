package com.example.springcrudharsh.controller;

import com.example.springcrudharsh.dao.UserRepository;
import com.example.springcrudharsh.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class RestApi {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/process")
    public ResponseEntity<Users> process(@RequestBody Users users) {
        try {
            Users saved = this.userRepository.save(users);
            System.out.println(saved);
            return ResponseEntity.status(HttpStatus.OK).body(users);
        } catch(Exception e) {
            System.out.println("Exception for process form");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getusers")
    public ResponseEntity<List<Users>> getAllUsers() {
        try {
            List<Users> users = this.userRepository.findAll();
//            System.out.println(users);
            return ResponseEntity.status(HttpStatus.OK).body(users);
        } catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/deleteuser")
    public ResponseEntity<Integer> deleteUser(@RequestBody String id) {
        try {
            String[] i = id.split("=");
            this.userRepository.deleteById(Integer.parseInt(i[1]));
            return ResponseEntity.status(HttpStatus.OK).body(1);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
