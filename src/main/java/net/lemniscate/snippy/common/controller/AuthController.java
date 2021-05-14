package net.lemniscate.snippy.common.controller;

import net.lemniscate.snippy.user.model.UserMaster;
import net.lemniscate.snippy.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public Integer createUser(@RequestBody UserMaster user) {
        return userService.createUser(user);
    }

    @PostMapping("/signin")
    public Map<String, String> verifyUser(@RequestBody Map<String, String> authData) {
        return userService.getTokenString(authData);
    }
}
