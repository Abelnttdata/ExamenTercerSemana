package com.example.practicaSpringModel.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {
    private String name;
    private String dni;
    private String address;
    private List<Loan> loans;

    public String getDni() {
        return dni;
    }

    public Customer(String name, String dni, String address) {
        this.name = name;
        this.dni = dni;
        this.address = address;
    }

    public String addLoan(){
        return null;
    }
}
