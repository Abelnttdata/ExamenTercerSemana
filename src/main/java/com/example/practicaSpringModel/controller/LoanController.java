package com.example.practicaSpringModel.controller;

import com.example.practicaSpringModel.entity.Customer;
import com.example.practicaSpringModel.entity.Loan;
import com.example.practicaSpringModel.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    LoanRepository loanRepository;

    @GetMapping
    public ArrayList<Loan> getLoans() {
        return loanRepository.getLoanArrayList();
    }

    @GetMapping("/{loanItem}")
    public ResponseEntity<Loan> getLoan(@PathVariable String loanItem) throws nonexistentLoanException {
        Optional<Loan> optionalLoan= loanRepository.searchLoan(loanItem);
        if(optionalLoan.isEmpty()){
            throw new nonexistentLoanException();
        }
        return ResponseEntity.ok(optionalLoan.get());
    }

    @PostMapping
    public void createCustomer(@RequestBody Loan loan){
        loanRepository.getLoanArrayList().add(loan);
    }


    @DeleteMapping("/{loanItem}")
    public ResponseEntity<Loan> deleteLoanException(@PathVariable String loanItem) throws nonexistentLoanException {
        Optional<Loan> optionalLoan = loanRepository.searchLoan(loanItem);
        if(optionalLoan.isEmpty()){
            throw new nonexistentLoanException();
        }
        deleteLoan(loanItem);
        return ResponseEntity.ok(optionalLoan.get());
    }


    public void deleteLoan(String loanItem){
        Optional<Loan> optionalLoan= loanRepository.searchLoan(loanItem);
        optionalLoan.ifPresent(value -> loanRepository.getLoanArrayList().remove(value));
    }

    @PutMapping("/{loanItem}")
    public ResponseEntity<Loan> updateLoanException(@PathVariable String loanItem) throws nonexistentLoanException{
        Optional<Loan> optionalLoan = loanRepository.searchLoan(loanItem);
        if(optionalLoan.isEmpty()){
            throw new nonexistentLoanException();
        }
        // updateCustomer();
        return ResponseEntity.ok(optionalLoan.get());
    }


    public void updateLoan(Loan loan){
        deleteLoan(loan.getLoanItem());
        loanRepository.getLoanArrayList().add(loan);
    }



}
