package com.gr.elevator.rest.controllers;

import com.gr.elevator.db.domain.Address;
import com.gr.elevator.rest.model.AddressDto;
import com.gr.elevator.svc.manager.IAddressManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")

public class AddressController {

    @Autowired
    private IAddressManager addressManager;

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> getAddress(@PathVariable Long id) {
        System.out.println("Fetching address with ID : " + id);
        AddressDto addressDto =  addressManager.findById(id);
        return new ResponseEntity<>(addressDto, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<AddressDto>> getAddress() {
        System.out.println("Fetching all addresses");
        List<AddressDto> addressDtoList = addressManager.findAll();
        return new ResponseEntity<>(addressDtoList, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<AddressDto> createAddress(@RequestBody AddressDto addressDto) {
        System.out.println("Creating a new address");
        AddressDto addressDto1 = addressManager.createAddress(addressDto);
        return new ResponseEntity<>(addressDto1, HttpStatus.CREATED);
    }

    @PutMapping("/{addressID}")
    public ResponseEntity<String> updateBuildingAddress(@RequestBody Address address, @PathVariable Long addressId) {
        System.out.println("Updating address for building ID: " + addressId);

        AddressDto addressDto =  addressManager.findById(addressId);
        if (addressDto != null && addressDto.getId().equals(addressId)) {
            addressManager.updateAddress(addressDto);
            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        } else {
            System.out.println("No Building Found");
            return new ResponseEntity<>("Building not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping()
    public Boolean deleteAddress() {
        System.out.println("Deleting all addresses");
        return addressManager.deleteAll();
    }

    @DeleteMapping("/{id}")
    public Long deleteAddress(@PathVariable Long id) {
        System.out.println("Deleting address with id " + id);
        return addressManager.deleteById(id);
    }

    public AddressDto findByBuildingID(Long buildingID){
        AddressDto addressDto = addressManager.findByBuildingID(buildingID);
        return addressDto;
    }

    public Boolean deleteByBuildingID(Long buildingID){
         addressManager.deleteByBuildingID(buildingID);
        return true;
    }
}