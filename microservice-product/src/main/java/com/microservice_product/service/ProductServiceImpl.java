package com.microservice_product.service;

import com.microservice_product.dto.ProductDTO;
import com.microservice_product.entity.Product;
import com.microservice_product.persistence.ProductRepository;
import com.microservice_product.persistence.CategoryRepository;
import com.microservice_product.persistence.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private StateRepository stateRepository;

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(Integer id) {
        return productRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = convertToEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        return convertToDTO(savedProduct);
    }

    public ProductDTO updateProduct(Integer id, ProductDTO productDTO) {
        if (productRepository.existsById(id)) {
            Product product = convertToEntity(productDTO);
            product.setProductId(id);
            Product updatedProduct = productRepository.save(product);
            return convertToDTO(updatedProduct);
        }
        return null;
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    private ProductDTO convertToDTO(Product product) {
        return ProductDTO.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .productDescription(product.getProductDescription())
                .productPrice(product.getProductPrice())
                .productStock(product.getProductStock())
                .productImage(product.getProductImage())
                .categoryId(product.getCategory().getCategoryId())
                .stateId(product.getState().getStateId())
                .build();
    }

    private Product convertToEntity(ProductDTO dto) {
        return Product.builder()
                .productId(dto.getProductId())
                .productName(dto.getProductName())
                .productDescription(dto.getProductDescription())
                .productPrice(dto.getProductPrice())
                .productStock(dto.getProductStock())
                .productImage(dto.getProductImage())
                .category(categoryRepository.findById(dto.getCategoryId()).orElse(null))
                .state(stateRepository.findById(dto.getStateId()).orElse(null))
                .build();
    }
}
