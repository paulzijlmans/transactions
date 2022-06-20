package nl.paulzijlmans.transactions.controller;

import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import nl.paulzijlmans.transactions.model.Transaction;
import nl.paulzijlmans.transactions.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class TransactionController {

  private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

  private TransactionService service;

  @GetMapping("/transactions")
  public List<Transaction> getAllTransactions() {
    logger.info("Get all the transactions.");
    return service.findAll();
  }

//  @GetMapping("/transactions/{id}")
//  public ResponseEntity<Transaction> getTransactionById(
//      @PathVariable(value = "id") long transactionId) throws ResourceNotFoundException {
//    logger.info("Get transaction by id...");
//    Transaction transaction = transactionRepository.findById(transactionId).orElseThrow(
//        () -> new ResourceNotFoundException(
//            "Transaction not found for this id:  " + transactionId));
//    return ResponseEntity.ok().body(transaction);
//  }
//
  @PostMapping("/transactions")
  public Transaction createTransaction(@Valid @RequestBody final Transaction transaction) {
    logger.info("Create transaction.");
    return service.save(transaction);
  }
//
//  @PutMapping("/transactions/{id}")
//  public ResponseEntity<Transaction> getTransactionById(
//      @PathVariable(value = "id") long transactionId, @RequestBody Transaction updatedTransaction)
//      throws ResourceNotFoundException {
//    logger.info("Update transaction...");
//    Transaction transaction = transactionRepository.findById(transactionId).orElseThrow(
//        () -> new ResourceNotFoundException("Transaction not found for this id: " + transactionId));
//    transaction.setDescription(updatedTransaction.getDescription());
//    transaction.setAmount(updatedTransaction.getAmount());
//    transaction.setComment(updatedTransaction.getComment());
//    transactionRepository.save(transaction);
//    return ResponseEntity.ok().body(transaction);
//  }
//
//  @DeleteMapping("/transactions/{id}")
//  public void deleteTransaction(@PathVariable(value = "id") long transactionId)
//      throws ResourceNotFoundException {
//    logger.info("Delete Transaction...");
//    Transaction transaction = transactionRepository.findById(transactionId).orElseThrow(
//        () -> new ResourceNotFoundException(
//            "Transaction not found for this id:: " + transactionId));
//    transactionRepository.delete(transaction);
//  }
}
