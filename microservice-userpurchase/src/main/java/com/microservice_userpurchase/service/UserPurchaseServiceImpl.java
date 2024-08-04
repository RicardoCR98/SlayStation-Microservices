package com.microservice_userpurchase.service;

import com.microservice_product.dto.ProductDTO;
import com.microservice_user.dto.UserDTO;
import com.microservice_userpurchase.dto.UserPurchaseDTO;
import com.microservice_userpurchase.entity.UserPurchase;
import com.microservice_userpurchase.persistence.UserPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.microservice_userpurchase.client.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserPurchaseServiceImpl implements IUserPurchaseService {

    @Autowired
    private UserPurchaseRepository userPurchaseRepository;

    @Autowired
    private UserClient userClient;

    @Autowired
    private ProductClient productClient;

    @Override
    public List<UserPurchaseDTO> getAllPurchases() {
        return userPurchaseRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserPurchaseDTO getPurchaseById(Integer id) {
        return userPurchaseRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Override
    public UserPurchaseDTO createPurchase(UserPurchaseDTO userPurchaseDTO) {
        // Validate user and product existence
        UserDTO user = userClient.getUserById(userPurchaseDTO.getUserId());
        ProductDTO product = productClient.getProductById(userPurchaseDTO.getProductId());

        if (user == null || product == null) {
            throw new RuntimeException("User or Product not found");
        }

        // Calculate total price
        double totalPrice = userPurchaseDTO.getQuantity() * product.getProductPrice();
        userPurchaseDTO.setTotalPrice(totalPrice);

        UserPurchase userPurchase = convertToEntity(userPurchaseDTO);
        UserPurchase savedPurchase = userPurchaseRepository.save(userPurchase);
        return convertToDTO(savedPurchase);
    }

    @Override
    public UserPurchaseDTO updatePurchase(Integer id, UserPurchaseDTO userPurchaseDTO) {
        if (userPurchaseRepository.existsById(id)) {
            UserDTO user = userClient.getUserById(userPurchaseDTO.getUserId());
            ProductDTO product = productClient.getProductById(userPurchaseDTO.getProductId());

            if (user == null || product == null) {
                throw new RuntimeException("User or Product not found");
            }

            // Calculate total price
            double totalPrice = userPurchaseDTO.getQuantity() * product.getProductPrice();
            userPurchaseDTO.setTotalPrice(totalPrice);

            UserPurchase userPurchase = convertToEntity(userPurchaseDTO);
            userPurchase.setPurchaseId(id);
            UserPurchase updatedPurchase = userPurchaseRepository.save(userPurchase);
            return convertToDTO(updatedPurchase);
        }
        return null;
    }

    @Override
    public void deletePurchase(Integer id) {
        userPurchaseRepository.deleteById(id);
    }

    private UserPurchaseDTO convertToDTO(UserPurchase userPurchase) {
        return UserPurchaseDTO.builder()
                .purchaseId(userPurchase.getPurchaseId())
                .quantity(userPurchase.getQuantity())
                .totalPrice(userPurchase.getTotalPrice())
                .userId(userPurchase.getUserId())
                .productId(userPurchase.getProductId())
                .build();
    }

    private UserPurchase convertToEntity(UserPurchaseDTO userPurchaseDTO) {
        return UserPurchase.builder()
                .purchaseId(userPurchaseDTO.getPurchaseId())
                .quantity(userPurchaseDTO.getQuantity())
                .totalPrice(userPurchaseDTO.getTotalPrice())
                .userId(userPurchaseDTO.getUserId())
                .productId(userPurchaseDTO.getProductId())
                .build();
    }
}
