package com.example.capstone.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Merchant {
    @NotNull(message = "must not be empty")
    private Integer id;
    @NotEmpty(message = "(must not be empty, have to be more than 3 length long")
    @Max(3)
    private String name;
}
