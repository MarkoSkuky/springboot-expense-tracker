package com.example.expensetracker.repository;

import com.example.expensetracker.model.Transaction;
import com.example.expensetracker.model.TransactionType;
import com.example.expensetracker.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
    List<Transaction> findByType(TransactionType type);
    List<Transaction> findByCategory(Category category);
    List<Transaction> findByDate(LocalDate date);
    List<Transaction> findByDateBetween(LocalDate start, LocalDate end);
}