package nl.paulzijlmans.transactions.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import nl.paulzijlmans.transactions.model.Category;
import nl.paulzijlmans.transactions.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class CategoryController {

  private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

  private CategoryRepository repository;

  @GetMapping("/categories")
  public List<Category> getAllCategories() {
    logger.info("Get all the categories...");
    return repository.findAll();
  }
}
