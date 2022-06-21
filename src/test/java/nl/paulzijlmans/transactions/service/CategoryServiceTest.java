package nl.paulzijlmans.transactions.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import nl.paulzijlmans.transactions.model.Category;
import nl.paulzijlmans.transactions.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

  @Mock
  CategoryRepository categoryRepository;

  @InjectMocks
  CategoryService service;

  @Test
  void getCategories() {
    var categories = new ArrayList<>(Collections.singletonList(new Category()));
    when(categoryRepository.findAll()).thenReturn(categories);

    var result = service.getCategories();

    assertEquals(1, result.size());
  }
}