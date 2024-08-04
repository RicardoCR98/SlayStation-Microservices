package com.microservice_product.controller;

import com.microservice_product.dto.StateDTO;
import com.microservice_product.service.IStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/states")
public class StateController {

    @Autowired
    private IStateService stateService;

    @GetMapping("/all")
    public ResponseEntity<List<StateDTO>> getAllStates() {
        return ResponseEntity.ok(stateService.getAllStates());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<StateDTO> getStateById(@PathVariable Integer id) {
        StateDTO state = stateService.getStateById(id);
        return state != null ? ResponseEntity.ok(state) : ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<StateDTO> createState(@RequestBody StateDTO stateDTO) {
        return ResponseEntity.ok(stateService.createState(stateDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StateDTO> updateState(@PathVariable Integer id, @RequestBody StateDTO stateDTO) {
        StateDTO updatedState = stateService.updateState(id, stateDTO);
        return updatedState != null ? ResponseEntity.ok(updatedState) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteState(@PathVariable Integer id) {
        stateService.deleteState(id);
        return ResponseEntity.noContent().build();
    }
}
