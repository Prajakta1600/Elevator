package com.gr.elevator.svc.Service;

import com.gr.elevator.db.domain.Lift;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILiftService extends IBaseService<Lift> {
    List<Lift> findByBuildingID(Long buildingID);
    void deleteByBuildingID(Long id);
}
