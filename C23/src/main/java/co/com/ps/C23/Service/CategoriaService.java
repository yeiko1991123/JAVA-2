package co.com.ps.C23.Service;

import co.com.ps.C23.DOMAIN.Category;
import co.com.ps.C23.repository.CategoriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
 @RequiredArgsConstructor
public class CategoriaService implements ICategoryService{

private final CategoriesRepository categoryRepository;
    @Override
    @Transactional (readOnly = true)
    public List<Category> findAll() {
    return categoryRepository.findAll();
    }

    @Override
    @Transactional (readOnly = true)
    public Category findById(Long idCategory) {
        Optional<Category> categoryTmp = categoryRepository.findById(idCategory);
        if (categoryTmp.isPresent()) {
            return categoryTmp.get();
        }else {
            throw new RuntimeException("Category not found" + idCategory);
        }
    }

    @Transactional (readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    @Transactional (readOnly = false, propagation = Propagation.REQUIRED)
    public Category update(Category category) {
        if (categoryRepository.existsById(category.getCategoryId())){
        return categoryRepository.save(category);}
     else {
        throw new RuntimeException("Category not found with id: " + category.getCategoryId());
    }};

    @Override
    @Transactional (readOnly = true)
    public Optional<Category> findByName(String name) {
        return categoryRepository.findByCategoryName(name);
    }

    @Override
    public void delete(Long idCategory) {
        if (categoryRepository.existsById(idCategory)) {
            categoryRepository.deleteById(idCategory);
        }
        else {throw new RuntimeException("Category not found with id: " + idCategory);}
    }
}
