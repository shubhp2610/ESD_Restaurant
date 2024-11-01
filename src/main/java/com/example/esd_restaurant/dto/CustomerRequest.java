package com.example.esd_restaurant.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public class CustomerRequest {

    public record CustomerCreateRequest(
            @NotNull(message = "Customer first name should be present")
            @NotEmpty(message = "Customer first name should be present")
            @NotBlank(message = "Customer first name should be present")
            @JsonProperty("first_name")
            String firstName,

            @JsonProperty("last_name")
            String lastName,

            @NotNull(message = "Customer email is required")
            @Email(message = "Email must be in correct format")
            @JsonProperty("email")
            String email,

            @NotNull(message = "Password should be present")
            @NotEmpty(message = "Password should be present")
            @NotBlank(message = "Password should be present")
            @Size(min = 6, max = 12)
            @JsonProperty("password")
            String password,

            @JsonProperty("address")
            String address,

            @JsonProperty("city")
            String city,

            @NotNull(message = "Pincode is required")
            @JsonProperty("pincode")
            Long pincode
    ) {
    }

    public record CustomerLoginRequest(
            @NotNull(message = "Email is required")
            @Email(message = "Email must be in correct format")
            @JsonProperty("email")
            String email,

            @NotNull(message = "Password should be present")
            @NotEmpty(message = "Password should be present")
            @NotBlank(message = "Password should be present")
            @JsonProperty("password")
            String password
    ) {
    }
}
