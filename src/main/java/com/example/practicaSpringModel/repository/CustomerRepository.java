package com.example.practicaSpringModel.repository;

import com.example.practicaSpringModel.entity.Customer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
@Getter @Setter
public class CustomerRepository {

    private ArrayList<Customer> customers = new ArrayList<>();

    public Optional<Customer> searchCustomer(String dni){
        return customers.stream().filter(customer -> customer.getDni().equalsIgnoreCase(dni)).findFirst();
    }
}
