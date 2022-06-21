package nl.paulzijlmans.transactions.service;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.paulzijlmans.transactions.model.Category;
import nl.paulzijlmans.transactions.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CategoryService {

  private CategoryRepository repository;

  public List<Category> getCategories() {
    log.info("Get all categories.");
    return repository.findAll();
  }
}