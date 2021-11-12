package com.example.practicaSpringModel.repository;

import com.example.practicaSpringModel.entity.Customer;
import com.example.practicaSpringModel.entity.Loan;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
@Getter @Setter
public class LoanRepository {
    private ArrayList<Loan> loanArrayList = new ArrayList<>();


    public Optional<Loan> searchLoan(String itemLoan){
        return loanArrayList.stream().filter(loan -> loan.getLoanItem().equalsIgnoreCase(itemLoan)).findFirst();
    }
}
