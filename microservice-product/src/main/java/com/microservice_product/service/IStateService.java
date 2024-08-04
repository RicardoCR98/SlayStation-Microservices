package com.microservice_product.service;

import com.microservice_product.dto.StateDTO;
import java.util.List;

public interface IStateService {
    List<StateDTO> getAllStates();
    StateDTO getStateById(Integer id);
    StateDTO createState(StateDTO stateDTO);
    StateDTO updateState(Integer id, StateDTO stateDTO);
    void deleteState(Integer id);
}