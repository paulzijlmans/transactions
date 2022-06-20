package nl.paulzijlmans.transactions.service;

import java.util.List;
import lombok.AllArgsConstructor;
import nl.paulzijlmans.transactions.model.Transaction;
import nl.paulzijlmans.transactions.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionService {

  private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);

  private TransactionRepository repository;

  public List<Transaction> findAll() {
    logger.info("Get all transactions.");
    return repository.findAll();
  }

  public Transaction save(final Transaction transaction) {
    logger.info("Save transaction.");
    return repository.save(transaction);
  }
}
