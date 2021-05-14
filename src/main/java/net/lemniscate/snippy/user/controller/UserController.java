package net.lemniscate.snippy.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import net.lemniscate.snippy.user.model.UserMaster;
import net.lemniscate.snippy.user.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/find/{userName}")
    public UserMaster findByUserName(@PathVariable("userName") String userName) {
        return userService.findUserByUserName(userName);
    }

    @GetMapping("/findAll")
    public List<UserMaster> findAll() {
        return userService.findAll();
    }
}
