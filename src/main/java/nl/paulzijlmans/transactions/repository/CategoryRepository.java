package nl.paulzijlmans.transactions.repository;

import nl.paulzijlmans.transactions.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}