package co.com.ps.C23.controller;

import co.com.ps.C23.DOMAIN.Products;
import co.com.ps.C23.Service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final IProductService productService;

    @GetMapping("/name/{name}")
public ResponseEntity<Optional<Products>> getProductsByName (@PathVariable String name) {
        try {
            return ResponseEntity.ok(productService.findByName(name));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Products> saveProduct(@RequestBody Products products) {
        try {
            return ResponseEntity.ok(productService.save(products));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Products>> getProductById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(Optional.ofNullable(productService.findById(id)));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<Products>> getAllProducts() {
        try {
            return ResponseEntity.ok(productService.findAll());
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/id/{idProduct}")
    public ResponseEntity<String> DeleteCategoryById(@PathVariable Long idProduct) {
        try {
            productService.delete(idProduct);
            return ResponseEntity.ok("Ok");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping
    public ResponseEntity<Products> updateProduct(@RequestBody Products products) {
        try {
            return ResponseEntity.ok(productService.update(products));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}


