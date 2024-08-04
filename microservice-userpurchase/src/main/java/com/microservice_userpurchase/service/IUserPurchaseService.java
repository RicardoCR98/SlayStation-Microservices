package com.microservice_userpurchase.service;

import com.microservice_userpurchase.dto.UserPurchaseDTO;

import java.util.List;

public interface IUserPurchaseService {
    List<UserPurchaseDTO> getAllPurchases();
    UserPurchaseDTO getPurchaseById(Integer id);
    UserPurchaseDTO createPurchase(UserPurchaseDTO userPurchaseDTO);
    UserPurchaseDTO updatePurchase(Integer id, UserPurchaseDTO userPurchaseDTO);
    void deletePurchase(Integer id);
}
