package com.bookstoreapi.controller;

import com.bookstoreapi.exception.CustomerNotFoundException;
import com.bookstoreapi.model.Customer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>();

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
        Customer customer = customers.stream()
                                     .filter(c -> c.getId() == id)
                                     .findFirst()
                                     .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + id));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Customer-Details");

        return new ResponseEntity<>(customer, headers, HttpStatus.OK); // 200 OK
    }

    // Other methods (createCustomer, etc.) can be added here
}


