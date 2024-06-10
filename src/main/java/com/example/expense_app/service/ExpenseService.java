package com.example.expense_app.service;

import com.example.expense_app.dto.ExpenseDto;
import com.example.expense_app.entity.Expense;
import com.example.expense_app.repository.ExpenseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository, ModelMapper modelMapper) {
        this.expenseRepository = expenseRepository;
        this.modelMapper = modelMapper;
    }

    public List<ExpenseDto> getAllExpenses(){
        List<Expense> expenses = expenseRepository.findAll();
        var expenseDto = expenses.stream().map(this::mapToDto).collect(Collectors.toList());

        return expenseDto;
    }


    private ExpenseDto mapToDto(Expense expense){
        ExpenseDto expenseDto = modelMapper.map(expense,ExpenseDto.class);
        return expenseDto;
    }
}



















