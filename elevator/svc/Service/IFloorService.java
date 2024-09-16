package com.gr.elevator.svc.Service;

import com.gr.elevator.db.domain.Floor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IFloorService extends IBaseService<Floor> {
    List<Floor> findByBuildingID(Long buildingID);
    void deleteByBuildingID(Long id);

}
