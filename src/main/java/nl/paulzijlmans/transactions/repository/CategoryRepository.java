package nl.paulzijlmans.transactions.repository;

import nl.paulzijlmans.transactions.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
