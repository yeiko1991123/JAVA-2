package co.com.ps.C23.Service;

import co.com.ps.C23.DOMAIN.Category;
import java.util.List;
import java.util.Optional;

public interface ICategoryService {

    List<Category>findAll();
    Category findById(Long idCategory);
    Category save(Category category);
    Category update(Category category);
    Optional<Category> findByName(String name);
    void delete(Long idCategory);
}
