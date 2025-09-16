package com.example.expensetracker.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "transactions")

public class Transaction {

    @Id
    private String id;
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    private String note;
    private double amount;
    @Enumerated(EnumType.STRING)
    private Category category;
    private LocalDate date;

    public Transaction() {
        // Spring/JPA potrebuje prázdny konštruktor
    }

    public Transaction(TransactionType type, String note, double amount, Category category, LocalDate date) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.note = note;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    // Gettery a settery
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return type + " " + note + " (" + category + "): " + amount + "€ " + date;
    }
}
