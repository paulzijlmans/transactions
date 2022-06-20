package nl.paulzijlmans.transactions;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import nl.paulzijlmans.transactions.controller.CategoryController;
import nl.paulzijlmans.transactions.controller.TransactionController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TransactionsApplicationTests {

  @Autowired
  public TransactionController transactionController;

  @Autowired
  public CategoryController categoryController;

  @Test
  void contextLoads() {
    assertNotNull(transactionController, "Transaction controller should be initialized.");
    assertNotNull(categoryController, "Category controller should be initialized.");
  }
}
