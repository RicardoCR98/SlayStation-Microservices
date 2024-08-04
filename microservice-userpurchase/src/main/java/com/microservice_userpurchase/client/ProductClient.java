package com.microservice_userpurchase.client;

import com.microservice_product.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-product")
public interface ProductClient {
    @GetMapping("/api/products/search/{id}")
    ProductDTO getProductById(@PathVariable Integer id);
}
