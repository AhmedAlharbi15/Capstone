package com.example.capstone.Controller;

import com.example.capstone.Api.Api;
import com.example.capstone.Model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    ArrayList<User> useer = new ArrayList<>();

    @GetMapping("/get")

    public ResponseEntity showuser() {
        return ResponseEntity.status(200).body(useer);
    }


    @PostMapping("/add")

    public ResponseEntity adduser(@RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        useer.add(user);
        return ResponseEntity.status(200).body(new Api("user added successfully! "));
    }

    @PutMapping("/update/{index}")


    public ResponseEntity updateuser(@PathVariable int index, @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        useer.set(index, user);
        return ResponseEntity.status(200).body(new Api("user updated successfully!"));
    }
    @DeleteMapping("/delete/{index}")

    public ResponseEntity deleteduser(@PathVariable int index) {
        useer.remove(index);
        return ResponseEntity.status(200).body(new Api("user deteled successfully!"));
    }
}
