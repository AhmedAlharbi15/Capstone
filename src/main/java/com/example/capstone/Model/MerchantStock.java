package com.example.capstone.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {
    @NotNull(message = "(must not be empty")
    private Integer id;
    @NotEmpty(message = "(must not be empty")
    private String productid;
    @NotEmpty(message = "(must not be empty")
    private String merchantid;
    @NotNull(message = "(must not be empty, have to be more than 10 at start")
    @Max(10)
    private Integer stock;
}
