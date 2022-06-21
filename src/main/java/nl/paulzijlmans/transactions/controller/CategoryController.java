package nl.paulzijlmans.transactions.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.paulzijlmans.transactions.model.Category;
import nl.paulzijlmans.transactions.service.CategoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

  private CategoryService service;

  @GetMapping()
  public List<Category> getAllCategories() {
    log.info("Get all categories.");
    return service.getCategories();
  }
}
