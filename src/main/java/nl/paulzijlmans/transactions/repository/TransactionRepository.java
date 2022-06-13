package nl.paulzijlmans.transactions.repository;

import nl.paulzijlmans.transactions.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
