package nl.paulzijlmans.transactions.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
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
  void findAll() {
    var groceries = new Category();
    groceries.setName("Groceries");
    var mortgage = new Category();
    mortgage.setName("Mortgage");
    var categories = new ArrayList<>(List.of(groceries, mortgage));
    when(categoryRepository.findAll()).thenReturn(categories);

    var result = service.getCategories();

    assertEquals(2, result.size());
    assertEquals("Groceries", result.get(0).getName());
    assertEquals("Mortgage", result.get(1).getName());
  }
}