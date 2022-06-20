package nl.paulzijlmans.transactions.service;

import java.util.List;
import lombok.AllArgsConstructor;
import nl.paulzijlmans.transactions.exception.ResourceNotFoundException;
import nl.paulzijlmans.transactions.model.Category;
import nl.paulzijlmans.transactions.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {

  private CategoryRepository repository;

  public List<Category> getCategories() {
    return repository.findAll();
  }

  public Category getCategory(Long categoryId) throws ResourceNotFoundException {
    return repository.findById(categoryId)
        .orElseThrow(
            () -> new ResourceNotFoundException("Category not found for this id: " + categoryId));
  }

  public Category createCategory(Category category) {
    return repository.save(category);
  }

  public Category updateCategory(Long categoryId, Category newCategory)
      throws ResourceNotFoundException {
    var category = getCategory(categoryId);
    category.setName(newCategory.getName());
    category.setTransactions(newCategory.getTransactions());
    return repository.save(category);
  }

  public void deleteCategory(Long categoryId) throws ResourceNotFoundException {
    var category = getCategory(categoryId);
    repository.delete(category);
  }
}