package co.com.ps.C23.Service;

import co.com.ps.C23.DOMAIN.Products;
import java.util.List;
import java.util.Optional;

public interface IProductService {

    Optional<Products> findByName(String name);
    Products findById(Long idProducts);
    List<Products> findAll();
    Products save(Products products);
    Products update(Products products);
    void delete(Long idProducts);



}
