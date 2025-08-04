package com.yaway.controller;

import com.yaway.model.Expenses;
import com.yaway.repository.ExpensesRepository;
import com.yaway.service.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin("*")
public class ExpensesController {

    @Autowired
    private ExpensesService expensesService;

    @PostMapping
    public Expenses createExpense(@RequestBody Expenses expense) {
        return expensesService.createExpense(expense);
    }
}