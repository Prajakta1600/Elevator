package com.gr.elevator.svc.impl;

import com.gr.elevator.db.domain.Lift;
import com.gr.elevator.db.repo.LiftRepo;
import com.gr.elevator.svc.Service.ILiftService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
public class LiftService implements ILiftService {
    @Autowired
    private LiftRepo liftRepo;

    @Override
    public Lift create(Lift lift) {
        System.out.println("Creating a new lift in service");
        return liftRepo.save(lift);
    }

    @Override
    public Lift update(Lift lift) {
        System.out.println("Updating lift in service");
        return liftRepo.save(lift);
    }

    @Override
    public Lift findById(Long id) {
        System.out.println("Finding lift in service");
        Optional<Lift> optionalLift = liftRepo.findById(id);
        if (optionalLift.isPresent()) {
            return optionalLift.get();
        } else {
            throw new EntityNotFoundException("Lift not found with id " + id);
        }
    }

    @Override
    public Long deleteById(Long id) {
        System.out.println("Deleting lift in service");
        liftRepo.deleteById(id);
        return id;
    }

    @Override
    public Boolean deleteAll() {
        System.out.println("Deleting lifts in service");
        liftRepo.deleteAll();
        return null;
    }

    @Override
    public List<Lift> findAll() {
        System.out.println("Finding Lifts in service");
        Iterable<Lift> lifts = liftRepo.findAll();
        return new ArrayList<>((Collection) lifts);
    }

    public List<Lift> findByBuildingID(Long buildingID) {
        System.out.println("Finding lift by building ID in service");
        return liftRepo.findByBuildingID(buildingID);
    }

    @Transactional
    public void deleteByBuildingID(Long id) {
        System.out.println("Finding lift by building ID in service");
        liftRepo.deleteByBuildingID(id);
    }
}
