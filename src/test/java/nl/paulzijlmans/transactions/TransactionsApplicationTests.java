package nl.paulzijlmans.transactions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import nl.paulzijlmans.transactions.controller.TransactionController;
import nl.paulzijlmans.transactions.model.Category;
import nl.paulzijlmans.transactions.model.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
@Profile("integration")
class TransactionsApplicationTests {

  @Autowired
  public TransactionController controller;

  @Test
  void contextLoads() {
    Assertions.assertFalse(controller.getAllTransactions().iterator().hasNext(),
        "There should be no transactions.");
    var transaction = new Transaction();
    transaction.setAmount(100);
    transaction.setComment("Hello");
    transaction.setDescription("This is a transaction");
    var category = new Category();
    category.setName("Boodschappen");
    transaction.setCategory(category);
    controller.createTransaction(transaction);
    assertTrue(controller.getAllTransactions().iterator().hasNext(),
        "There should be transactions.");
    assertEquals(1, controller.getAllTransactions().size());
  }

}
