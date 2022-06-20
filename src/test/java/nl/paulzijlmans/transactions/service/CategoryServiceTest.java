package nl.paulzijlmans.transactions.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import nl.paulzijlmans.transactions.exception.ResourceNotFoundException;
import nl.paulzijlmans.transactions.model.Category;
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
  private static final Long CATEGORY_ID = 1L;

  @BeforeAll
  static void init() {
    var groceries = new Category();
    groceries.setName("Groceries");
    categories.add(groceries);

    var mortgage = new Category();
    mortgage.setName("Mortgage");
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
    when(categoryRepository.findById(1L)).thenReturn(Optional.ofNullable(categories.get(0)));

    var result = service.getCategory(1L);

    assertEquals("Groceries", result.getName());
  }

  @Test
  void createCategory() {
    var category = new Category();
    category.setName("Other");
    when(categoryRepository.save(category)).thenReturn(category);

    var result = service.createCategory(category);

    assertEquals("Other", result.getName());
  }

  @Test
  void updateCategory() throws ResourceNotFoundException {

  }
}