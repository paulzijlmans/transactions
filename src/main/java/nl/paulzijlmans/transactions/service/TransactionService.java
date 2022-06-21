package nl.paulzijlmans.transactions.service;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.paulzijlmans.transactions.model.Transaction;
import nl.paulzijlmans.transactions.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class TransactionService {

  private TransactionRepository repository;

  public List<Transaction> getTransactions() {
    log.info("Get all transactions.");
    return repository.findAll();
  }
}
