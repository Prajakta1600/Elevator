package com.gr.elevator.svc.manager;

import com.gr.elevator.rest.model.AddressDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAddressManager {

    AddressDto createAddress(AddressDto addressDto);

    AddressDto updateAddress(AddressDto addressDto);

    AddressDto findById(Long id);

    List<AddressDto> findAll();

    Boolean deleteAll();

    Long deleteById(Long id);

    AddressDto findByBuildingID(Long buildingID);

    void deleteByBuildingID(Long buildingID);
//updateLiftSatus, updateFloorStatus, updateMode,
}
