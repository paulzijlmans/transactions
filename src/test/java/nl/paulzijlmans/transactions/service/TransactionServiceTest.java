package nl.paulzijlmans.transactions.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
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
  void getTransactions() {
    var transactions = new ArrayList<>(Collections.singletonList(new Transaction()));
    when(transactionRepository.findAll()).thenReturn(transactions);

    var result = service.getTransactions();

    assertEquals(1, result.size());
  }
}