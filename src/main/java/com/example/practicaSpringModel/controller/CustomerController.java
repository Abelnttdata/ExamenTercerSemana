package com.example.practicaSpringModel.controller;


import com.example.practicaSpringModel.entity.Customer;
import com.example.practicaSpringModel.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    //@Autowired
    //ModelMapper modelMapper;

    @GetMapping
    public ArrayList<Customer> getCustomers() {
        return customerRepository.getCustomers();
    }

    @GetMapping("/{dni}")
    public ResponseEntity<Customer> getCustomers(@PathVariable String dni) throws nonexistentClientException {
        Optional<Customer> optionalCustomer= customerRepository.searchCustomer(dni);
        if(optionalCustomer.isEmpty()){
            throw new nonexistentClientException();
        }
        return ResponseEntity.ok(optionalCustomer.get());
    }

    @PostMapping
    public void createCustomer(@RequestBody Customer customer){
        customerRepository.getCustomers().add(customer);
    }


    @DeleteMapping("/{dni}")
    public ResponseEntity<Customer> deleteCustomerException(@PathVariable String dni) throws nonexistentClientException {
        Optional<Customer> optionalCustomer = customerRepository.searchCustomer(dni);
        if(optionalCustomer.isEmpty()){
            throw new nonexistentClientException();
        }
        deleteCustomer(dni);
        return ResponseEntity.ok(optionalCustomer.get());
    }


    public void deleteCustomer(String dni){
        Optional<Customer> optionalCustomer= customerRepository.searchCustomer(dni);
        optionalCustomer.ifPresent(value -> customerRepository.getCustomers().remove(value));
    }

    @PutMapping("/{dni}")
    public ResponseEntity<Customer> updateCustomerException(@PathVariable String dni) throws nonexistentClientException{
        Optional<Customer> optionalCustomer = customerRepository.searchCustomer(dni);
        if(optionalCustomer.isEmpty()){
            throw new nonexistentClientException();
        }
       // updateCustomer();
        return ResponseEntity.ok(optionalCustomer.get());
    }



    public void updateCustomer(Customer customer){
        deleteCustomer(customer.getDni());
        customerRepository.getCustomers().add(customer);
    }


}
