package nl.paulzijlmans.transactions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.paulzijlmans.transactions.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
