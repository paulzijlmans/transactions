package nl.paulzijlmans.transactions.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.paulzijlmans.transactions.model.Transaction;
import nl.paulzijlmans.transactions.service.TransactionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/transactions")
@AllArgsConstructor
public class TransactionController {

  private TransactionService service;

  @GetMapping()
  public List<Transaction> getAllTransactions() {
    log.info("Get all transactions.");
    return service.getTransactions();
  }
}
