package com.microservice_userpurchase.controller;

import com.microservice_userpurchase.dto.UserPurchaseDTO;
import com.microservice_userpurchase.service.IUserPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userpurchases")
public class UserPurchaseController {

    @Autowired
    private IUserPurchaseService userPurchaseService;

    @GetMapping("/all")
    public ResponseEntity<List<UserPurchaseDTO>> getAllPurchases() {
        return ResponseEntity.ok(userPurchaseService.getAllPurchases());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<UserPurchaseDTO> getPurchaseById(@PathVariable Integer id) {
        UserPurchaseDTO userPurchase = userPurchaseService.getPurchaseById(id);
        return userPurchase != null ? ResponseEntity.ok(userPurchase) : ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<UserPurchaseDTO> createPurchase(@RequestBody UserPurchaseDTO userPurchaseDTO) {
        return ResponseEntity.ok(userPurchaseService.createPurchase(userPurchaseDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserPurchaseDTO> updatePurchase(@PathVariable Integer id, @RequestBody UserPurchaseDTO userPurchaseDTO) {
        UserPurchaseDTO updatedPurchase = userPurchaseService.updatePurchase(id, userPurchaseDTO);
        return updatedPurchase != null ? ResponseEntity.ok(updatedPurchase) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchase(@PathVariable Integer id) {
        userPurchaseService.deletePurchase(id);
        return ResponseEntity.noContent().build();
    }
}
