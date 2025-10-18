package com.klu.travelmanagement.controller;

import com.klu.travelmanagement.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // POST signup
    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String email = request.get("email");
        String password = request.get("password");
        return ResponseEntity.ok(userService.registerUser(username, email, password));
    }

    // POST login
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        return ResponseEntity.ok(userService.loginUser(username, password));
    }

    // GET signup (for testing in browser)
    @GetMapping("/signup")
    public String getSignupInfo() {
        return "Use POST /auth/signup with username, email, and password";
    }

    // GET login (for testing in browser)
    @GetMapping("/login")
    public String getLoginInfo() {
        return "Use POST /auth/login with username and password";
    }
}
