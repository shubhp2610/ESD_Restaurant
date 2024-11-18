package com.example.esd_restaurant.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.NumberFormat;

public class ProductRequest {

    public record ProductRequestBody(
            @NotNull(message = "Product name should be present")
            @NotEmpty(message = "Product name should be present")
            @NotBlank(message = "Product name should be present")
            @JsonProperty("name")
            String name,
            @NotNull(message = "Product price is required")
            @Digits(integer = 10, fraction = 2, message = "Price must be a valid number with up to 2 decimal places")
            @JsonProperty("price")
            Double price
    ) {
    }
}
