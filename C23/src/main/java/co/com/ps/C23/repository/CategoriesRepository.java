package co.com.ps.C23.repository;

import co.com.ps.C23.DOMAIN.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriesRepository extends JpaRepository <Category,Long> {
Optional<Category> findByCategoryName(String name);
}

