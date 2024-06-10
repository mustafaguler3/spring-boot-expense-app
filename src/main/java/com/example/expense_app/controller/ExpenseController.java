package com.example.expense_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ExpenseController {

    @GetMapping("/expenses")
    public String showExpenses(){
        return "expenses-list";
    }
}




















