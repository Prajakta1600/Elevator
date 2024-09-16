package com.gr.elevator.svc.Service;

import com.gr.elevator.db.domain.Address;
import org.springframework.stereotype.Service;

@Service
public interface IAddressService extends IBaseService<Address> {

    Address findByBuildingID(Long buildingID);

    void deleteByBuildingID(Long buildingID);
}
