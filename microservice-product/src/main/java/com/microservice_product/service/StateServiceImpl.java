package com.microservice_product.service;

import com.microservice_product.dto.StateDTO;
import com.microservice_product.entity.State;
import com.microservice_product.persistence.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StateServiceImpl implements IStateService{

    @Autowired
    private StateRepository stateRepository;

    public List<StateDTO> getAllStates() {
        return stateRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public StateDTO getStateById(Integer id) {
        return stateRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public StateDTO createState(StateDTO stateDTO) {
        State state = convertToEntity(stateDTO);
        State savedState = stateRepository.save(state);
        return convertToDTO(savedState);
    }

    public StateDTO updateState(Integer id, StateDTO stateDTO) {
        if (stateRepository.existsById(id)) {
            State state = convertToEntity(stateDTO);
            state.setStateId(id);
            State updatedState = stateRepository.save(state);
            return convertToDTO(updatedState);
        }
        return null;
    }

    public void deleteState(Integer id) {
        stateRepository.deleteById(id);
    }

    private StateDTO convertToDTO(State state) {
        return StateDTO.builder()
                .stateId(state.getStateId())
                .stateName(state.getStateName())
                .build();
    }

    private State convertToEntity(StateDTO dto) {
        return State.builder()
                .stateId(dto.getStateId())
                .stateName(dto.getStateName())
                .build();
    }
}
