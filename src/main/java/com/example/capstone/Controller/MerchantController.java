package com.example.capstone.Controller;

import com.example.capstone.Api.Api;
import com.example.capstone.Model.Merchant;
import com.example.capstone.Model.MerchantStock;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/MerchantController")
public class MerchantController {
    ArrayList<Merchant> merchants = new ArrayList<>();

    @GetMapping("/get")

    public ResponseEntity showmer() {
        return ResponseEntity.status(200).body(merchants);
    }


    @PostMapping("/add")

    public ResponseEntity addmerr(@RequestBody Merchant merchant, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchants.add(merchant);
        return ResponseEntity.status(200).body(new Api("Merchant added successfully! "));
    }

    @PutMapping("/update/{index}")


    public ResponseEntity updatmerr(@PathVariable int index, @RequestBody Merchant merchant, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchants.set(index, merchant);
        return ResponseEntity.status(200).body(new Api("Merchant updated successfully!"));
    }
    @DeleteMapping("/delete/{index}")

    public ResponseEntity deletedmerr(@PathVariable int index) {
        merchants.remove(index);
        return ResponseEntity.status(200).body(new Api("Merchant deteled successfully!"));
    }
}
