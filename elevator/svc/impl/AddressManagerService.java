package com.gr.elevator.svc.impl;

import com.gr.elevator.db.domain.Address;
import com.gr.elevator.rest.model.AddressDto;
import com.gr.elevator.svc.Service.IAddressService;
import com.gr.elevator.svc.mapper.AddressMapper;
import com.gr.elevator.svc.manager.IAddressManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressManagerService implements IAddressManager {

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private IAddressService addressService;

    @Override
    public AddressDto createAddress(AddressDto addressDto) {
        System.out.println("Creating a new address in manager");
        Address address = addressMapper.toDomain(addressDto);
        return addressMapper.toDTO(addressService.create(address));
    }

    @Override
    public AddressDto updateAddress(AddressDto addressDto) {
        System.out.println("Updating address in manager");
        Address address = addressMapper.toDomain(addressDto);
        return addressMapper.toDTO(addressService.update(address));
    }

    @Override
    public AddressDto findById(Long id) {
        System.out.println("Finding address in manager");
        return addressMapper.toDTO(addressService.findById(id));
    }

    @Override
    public List<AddressDto> findAll() {
        System.out.println("Finding addresses in manager");
        List<Address> addressList  =  addressService.findAll();
        return addressMapper.toDTO(addressList);
    }

    @Override
    public Boolean deleteAll() {
        System.out.println("Deleting addresses in manager");
        return addressService.deleteAll();
    }

    @Override
    public Long deleteById(Long id) {
        System.out.println("Deleting address in manager");
        return addressService.deleteById(id);
    }

    @Override
    public AddressDto findByBuildingID(Long buildingID){
        return addressMapper.toDTO(addressService.findByBuildingID(buildingID));
    }

    @Override
    public void deleteByBuildingID(Long buildingID){
        addressService.deleteByBuildingID(buildingID);
    }
}
