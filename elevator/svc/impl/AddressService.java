package com.gr.elevator.svc.impl;

import com.gr.elevator.db.domain.Address;
import com.gr.elevator.db.repo.AddressRepo;
import com.gr.elevator.svc.Service.IAddressService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IAddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Override
    public Address create(Address address) {
        System.out.println("Creating new address in service");
        return addressRepo.save(address);
    }

    @Override
    public Address update(Address address) {
        System.out.println("Updating address in service");
        return addressRepo.save(address);
    }

    @Override
    public Address findById(Long id) {
        System.out.println("Finding address in service");
        Optional<Address> optionalAddress = addressRepo.findById(id);
        if (optionalAddress.isPresent()) {
            return optionalAddress.get();
        } else {
            throw new EntityNotFoundException("Address not found with id " + id);
        }
    }

    @Override
    public Long deleteById(Long id) {
        System.out.println("Deleting address in service");
        addressRepo.deleteById(id);
        return id;
    }

    @Override
    public Boolean deleteAll() {
        System.out.println("Deleting addresses in service");
        addressRepo.deleteAll();
        return null;
    }

    @Override
    public List<Address> findAll() {
        System.out.println("Finding addresses in service");
        Iterable<Address> addresses = addressRepo.findAll();
        return new ArrayList<>((Collection) addresses);
    }

    @Override
    public Address findByBuildingID(Long buildingID){
        return addressRepo.findByBuildingID(buildingID);
    }

    @Override
    @Transactional
    public void deleteByBuildingID(Long buildingID){
        addressRepo.deleteByBuildingID(buildingID);
    }
}