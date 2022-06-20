package nl.paulzijlmans.transactions.service;

import java.util.List;
import nl.paulzijlmans.transactions.exception.ResourceNotFoundException;
import nl.paulzijlmans.transactions.model.Category;
import nl.paulzijlmans.transactions.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

  private CategoryRepository repository;

  public List<Category> getCategories() {
    return repository.findAll();
  }

  public Category findCategory(Long categoryId) throws ResourceNotFoundException {
    return repository.findById(categoryId)
        .orElseThrow(
            () -> new ResourceNotFoundException("Category not found for this id: " + categoryId));
  }

  public Category createCategory(Category category) {
    return repository.save(category);
  }

  public Category updateCategory(Long categoryId, Category updatedCategory)
      throws ResourceNotFoundException {
    var category = findCategory(categoryId);
    category.setName(updatedCategory.getName());
    category.setTransactions(updatedCategory.getTransactions());
    return repository.save(category);
  }

  public void deleteCategory(Long categoryId) throws ResourceNotFoundException {
    var category = findCategory(categoryId);
    repository.delete(category);
  }
}