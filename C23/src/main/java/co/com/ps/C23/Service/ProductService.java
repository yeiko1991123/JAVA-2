package co.com.ps.C23.Service;

import co.com.ps.C23.DOMAIN.Products;
import co.com.ps.C23.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    @Override
    @Transactional (readOnly = true)
    public Products findById(Long idProducts) {
        Optional<Products> productsTmp = productRepository.findById(idProducts);
        if (productsTmp.isPresent()) {
            return productsTmp.get();
        }else {
            throw new RuntimeException("Product not found" + idProducts);
        }
    }

    @Override
    @Transactional (readOnly = true)
    public Optional<Products> findByName(String name) {
            return productRepository.findByProductName(name);
    }

    @Override
    @Transactional (readOnly = true)
    public List<Products> findAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional (readOnly = false, propagation = Propagation.REQUIRED)
    public Products save(Products products) {
        return productRepository.save(products);
    }

    @Override
    @Transactional (readOnly = false, propagation = Propagation.REQUIRED)
    public Products update(Products products) {
        if (productRepository.existsById(products.getProductId())){
            return productRepository.save(products);}
        else {
            throw new RuntimeException("Product not found with id: " + products.getProductId());
        }
    }

    @Override
    public void delete(Long idProduct) {
if (productRepository.existsById(idProduct)) {
    productRepository.deleteById(idProduct);
}
else {throw new RuntimeException("Product not found with id:" + idProduct);}
    }
}
