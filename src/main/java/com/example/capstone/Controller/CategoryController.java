package com.example.capstone.Controller;

import com.example.capstone.Api.Api;
import com.example.capstone.Model.Category;
import com.example.capstone.Model.Merchant;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/CategoryController")
public class CategoryController {
    ArrayList<Category> categories = new ArrayList<>();

    @GetMapping("/get")

    public ResponseEntity showmer() {
        return ResponseEntity.status(200).body(categories);
    }


    @PostMapping("/add")

    public ResponseEntity addCategory(@RequestBody Category category, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        categories.add(category);
        return ResponseEntity.status(200).body(new Api("Category added successfully! "));
    }

    @PutMapping("/update/{index}")


    public ResponseEntity updatCategory(@PathVariable int index, @RequestBody Category category, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        categories.set(index, category);
        return ResponseEntity.status(200).body(new Api("Category updated successfully!"));
    }
    @DeleteMapping("/delete/{index}")

    public ResponseEntity deleteCategory(@PathVariable int index) {
        categories.remove(index);
        return ResponseEntity.status(200).body(new Api("Category deteled successfully!"));
    }
}
