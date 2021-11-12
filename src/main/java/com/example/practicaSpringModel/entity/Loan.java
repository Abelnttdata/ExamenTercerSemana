package com.example.practicaSpringModel.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Loan {
    private String date;
    private  String loanItem;
    private String dateOfDevolution;
    private String estado;

    public Loan(String date, String loanItem, String dateOfDevolution) {
        this.date = date;
        this.loanItem = loanItem;
        this.dateOfDevolution = dateOfDevolution;
    }
}
