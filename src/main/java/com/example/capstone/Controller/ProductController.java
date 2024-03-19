package com.example.capstone.Controller;

import com.example.capstone.Api.Api;
import com.example.capstone.Model.Product;
import com.example.capstone.Model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    ArrayList<Product> products = new ArrayList<>();

    @GetMapping("/get")

    public ResponseEntity showprodu() {
        return ResponseEntity.status(200).body(products);
    }


    @PostMapping("/add")

    public ResponseEntity addpro(@RequestBody Product product, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        products.add(product);
        return ResponseEntity.status(200).body(new Api("product added successfully! "));
    }

    @PutMapping("/update/{index}")


    public ResponseEntity updatpro(@PathVariable int index, @RequestBody Product product, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        products.set(index, product);
        return ResponseEntity.status(200).body(new Api("product updated successfully!"));
    }
    @DeleteMapping("/delete/{index}")

    public ResponseEntity deletedpro(@PathVariable int index) {
        products.remove(index);
        return ResponseEntity.status(200).body(new Api("product deteled successfully!"));
    }
}
