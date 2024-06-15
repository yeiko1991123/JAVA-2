package co.com.ps.C23.controller;

import co.com.ps.C23.DOMAIN.Category;
import co.com.ps.C23.Service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final ICategoryService categoryService;

    @GetMapping("/name/{name}")
    public ResponseEntity<Optional<Category>> getCategoryByName(@PathVariable String name) {
        try {
            return ResponseEntity.ok(categoryService.findByName(name));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        try {
            return ResponseEntity.ok(categoryService.save(category));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping()
    public ResponseEntity<List<Category>> getAllCategory() {
        try {
            return ResponseEntity.ok(categoryService.findAll());
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/id/{idCategory}")
    public ResponseEntity<Optional<Category>> getCategoryById(@PathVariable Long idCategory) {
        try {
            return ResponseEntity.ok(Optional.ofNullable(categoryService.findById(idCategory)));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/id/{idCategory}")
    public ResponseEntity<String> DeleteCategoryById(@PathVariable Long idCategory) {
        try {
            categoryService.delete(idCategory);
            return ResponseEntity.ok("Ok");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        try {
            return ResponseEntity.ok(categoryService.update(category));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}