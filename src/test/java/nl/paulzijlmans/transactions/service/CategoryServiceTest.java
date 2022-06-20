package nl.paulzijlmans.transactions.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import nl.paulzijlmans.transactions.exception.ResourceNotFoundException;
import nl.paulzijlmans.transactions.model.Category;
import nl.paulzijlmans.transactions.model.Transaction;
import nl.paulzijlmans.transactions.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeAll;
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

  private static final List<Category> categories = new ArrayList<>();

  @BeforeAll
  static void init() {
    var groceries = new Category();
    groceries.setName("Groceries");
    groceries.setTransactions(Collections.singletonList(new Transaction()));
    categories.add(groceries);

    var mortgage = new Category();
    mortgage.setName("Mortgage");
    mortgage.setTransactions(Collections.singletonList(new Transaction()));
    categories.add(mortgage);
  }

  @Test
  void getCategories() {
    when(categoryRepository.findAll()).thenReturn(categories);

    var result = service.getCategories();

    assertEquals(2, result.size());
    assertEquals("Groceries", result.get(0).getName());
    assertEquals("Mortgage", result.get(1).getName());
  }

  @Test
  void getCategory() throws ResourceNotFoundException {
    when(categoryRepository.findById(0L)).thenReturn(Optional.of(categories.get(0)));

    var result = service.getCategory(0L);

    assertEquals("Groceries", result.getName());
    assertEquals(1, result.getTransactions().size());
  }

  @Test
  void createCategory() {
    when(categoryRepository.save(categories.get(0))).thenReturn(categories.get(0));

    var result = service.createCategory(categories.get(0));

    assertEquals("Groceries", result.getName());
  }

  @Test
  void updateCategory() throws ResourceNotFoundException {
    var oldCategory = new Category();
    oldCategory.setId(0L);
    oldCategory.setName("Groceries");
    oldCategory.setTransactions(Collections.singletonList(new Transaction()));
    var newCategory = new Category();
    newCategory.setId(0L);
    newCategory.setName("Mortgage");
    newCategory.setTransactions(Collections.singletonList(new Transaction()));
    when(categoryRepository.findById(0L)).thenReturn(Optional.of(oldCategory));
    when(categoryRepository.save(newCategory)).thenReturn(newCategory);

    var result = service.updateCategory(0L, categories.get(1));

    assertEquals(0L, result.getId());
    assertEquals("Mortgage", result.getName());
  }

  @Test
  void deleteCategory() throws ResourceNotFoundException {
    when(categoryRepository.findById(1L)).thenReturn(Optional.of(categories.get(1)));

    service.deleteCategory(1L);

    verify(categoryRepository, times(1)).delete(categories.get(1));
  }
}