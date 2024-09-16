package com.gr.elevator.svc.mapper;

import com.gr.elevator.db.domain.Address;
import com.gr.elevator.rest.model.AddressDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressMapper implements BaseMapper<AddressDto, Address> {

    /*
    private Long id;
    private Long buildingId;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private Integer zipcode;*/


    @Override
    public AddressDto toDTO(Address address) {
        AddressDto addressDto = new AddressDto();

        addressDto.setId(address.getId());
        addressDto.setAddressLine1(address.getAddressLine1());
        addressDto.setAddressLine2(address.getAddressLine2());
        addressDto.setCity(address.getCity());
        addressDto.setState(address.getState());
        addressDto.setCountry(address.getCountry());
        addressDto.setZipcode(address.getZipcode());
        addressDto.setBuildingID(address.getBuildingID());

        return addressDto;
    }

    @Override
    public Address toDomain(AddressDto addressDto) {
        Address address = new Address();

        address.setId(addressDto.getId());
        address.setAddressLine1(addressDto.getAddressLine1());
        address.setAddressLine2(addressDto.getAddressLine2());
        address.setCity(addressDto.getCity());
        address.setState(addressDto.getState());
        address.setCountry(addressDto.getCountry());
        address.setZipcode(addressDto.getZipcode());
        address.setBuildingID(addressDto.getBuildingID());

        return address;
    }
}
