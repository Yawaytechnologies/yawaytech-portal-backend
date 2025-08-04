package com.yaway.service;

import com.yaway.model.Expenses;
import com.yaway.repository.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpensesServiceImp implements ExpensesService {

    @Autowired
    private ExpensesRepository expensesRepository;

    @Override
    public Expenses createExpense(Expenses expense) {
        // Any future business logic can be placed here
        return expensesRepository.save(expense);
    }
}