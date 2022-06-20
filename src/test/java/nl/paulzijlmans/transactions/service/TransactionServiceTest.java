package nl.paulzijlmans.transactions.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import nl.paulzijlmans.transactions.model.Category;
import nl.paulzijlmans.transactions.model.Transaction;
import nl.paulzijlmans.transactions.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

  @Mock
  TransactionRepository transactionRepository;

  @InjectMocks
  TransactionService service;

  @Test
  void findAll() {
    var groceries = new Category();
    groceries.setName("Groceries");
    var transactions = new ArrayList<>(List.of(
        new Transaction(0L, "Grocery store", 99.95, "Amsterdam", groceries),
        new Transaction(1L, "Bakery", 19.90, "The Bakery", groceries)
    ));
    when(transactionRepository.findAll()).thenReturn(transactions);

    var result = service.findAll();

    assertEquals(2, result.size());
    assertEquals("Grocery store", result.get(0).getDescription());
    assertEquals("Bakery", result.get(1).getDescription());
  }
}