package com.example.practicaSpringModel.dto;

import com.example.practicaSpringModel.entity.Loan;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter @Setter
public class CustomerDto {
    private String name;
    private String dni;
    private String address;
    private List<Loan> loans;
}
