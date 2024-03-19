package com.example.capstone.Controller;

import com.example.capstone.Api.Api;
import com.example.capstone.Model.MerchantStock;
import com.example.capstone.Model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merchan")
public class MerchantStockController {
    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();

    @GetMapping("/get")

    public ResponseEntity showmer() {
        return ResponseEntity.status(200).body(merchantStocks);
    }


    @PostMapping("/add")

    public ResponseEntity addmer(@RequestBody MerchantStock merchantStock, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantStocks.add(merchantStock);
        return ResponseEntity.status(200).body(new Api("merchantStock added successfully! "));
    }

    @PutMapping("/update/{index}")


    public ResponseEntity updatmer(@PathVariable int index, @RequestBody MerchantStock merchantStock, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantStocks.set(index, merchantStock);
        return ResponseEntity.status(200).body(new Api("merchantStock updated successfully!"));
    }
    @DeleteMapping("/delete/{index}")

    public ResponseEntity deletedmer(@PathVariable int index) {
        merchantStocks.remove(index);
        return ResponseEntity.status(200).body(new Api("merchantStock deteled successfully!"));
    }

}
