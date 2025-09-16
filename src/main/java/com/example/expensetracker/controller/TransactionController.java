package com.example.expensetracker.controller;

import com.example.expensetracker.model.Category;
import com.example.expensetracker.model.Transaction;
import com.example.expensetracker.model.TransactionType;
import com.example.expensetracker.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    //  Získať všetky transakcie
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    //  Pridať novú transakciu
    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }

    //⃣ Získať transakciu podľa ID
    @GetMapping("/{id}")
    public Transaction getTransaction(@PathVariable String id) {
        return transactionService.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    //⃣ Vymazať transakciu podľa ID
    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable String id) {
        transactionService.deleteTransaction(id);
    }

    //⃣ Získať transakcie podľa typu (INCOME alebo EXPENSE)
    @GetMapping("/type/{type}")
    public List<Transaction> getTransactionsByType(@PathVariable TransactionType type) {
        return transactionService.getTransactionsByType(type);
    }

    // Získať transakcie podľa kategórie
    @GetMapping("/category/{category}")
    public List<Transaction> getTransactionsByCategory(@PathVariable Category category) {
        return transactionService.getTransactionsByCategory(category);
    }

    // Získať transakcie podľa konkrétneho dátumu
    @GetMapping("/date/{date}")
    public List<Transaction> getTransactionsByDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date); // formát: yyyy-MM-dd
        return transactionService.getTransactionsByDate(localDate);
    }

    // Získať transakcie medzi dvoma dátumami
    @GetMapping("/between")
    public List<Transaction> getTransactionsBetweenDates(
            @RequestParam String start,
            @RequestParam String end
    ) {
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        return transactionService.getTransactionsBetweenDates(startDate, endDate);
    }
}