package com.activa.programa.service.crudService;


import com.activa.programa.model.ProductModel;
import com.activa.programa.repository.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
     private final IProductRepository productRepository;

    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductModel getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public ProductModel createProduct(ProductModel product) {
        return productRepository.save(product);
    }

    public ProductModel updateProduct(Long id, ProductModel productDetails) {
        ProductModel product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return null;
        }
        product.setProductName(productDetails.getProductName());
 
        return productRepository.save(product);
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    
}
