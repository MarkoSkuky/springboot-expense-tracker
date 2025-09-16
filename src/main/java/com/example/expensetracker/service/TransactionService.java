package com.example.expensetracker.service;

import com.example.expensetracker.model.Transaction;
import com.example.expensetracker.model.TransactionType;
import com.example.expensetracker.model.Category;
import com.example.expensetracker.repository.TransactionRepository;
import org.hibernate.dialect.function.array.ArrayViaElementArgumentReturnTypeResolver;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    // uložiť transakciu
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    // vymazať transakciu
    public void deleteTransaction(String id) {
        transactionRepository.deleteById(id);
    }

    // získať všetky transakcie
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> findById(String id) {
        return transactionRepository.findById(id);
    }

    // filtrovať podľa typu
    public List<Transaction> getTransactionsByType(TransactionType type) {
        return transactionRepository.findByType(type);
    }

    // filtrovať podľa kategórie
    public List<Transaction> getTransactionsByCategory(Category category) {
        return transactionRepository.findByCategory(category);
    }

    // filtrovať podľa dátumu
    public List<Transaction> getTransactionsByDate(LocalDate date) {
        return transactionRepository.findByDate(date);
    }

    // filtrovať medzi dátumami
    public List<Transaction> getTransactionsBetweenDates(LocalDate start, LocalDate end) {
        return transactionRepository.findByDateBetween(start, end);
    }
}