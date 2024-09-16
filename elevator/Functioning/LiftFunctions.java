package com.gr.elevator.Functioning;

import com.gr.elevator.db.domain.Direction;
import com.gr.elevator.db.domain.Lift;
import com.gr.elevator.db.domain.Notification;
import com.gr.elevator.db.repo.LiftRepo;
import com.gr.elevator.svc.impl.LiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Service

public class LiftFunctions {

    @Autowired
    private LiftService liftService;

    @Autowired
    private LiftRepo liftRepo;

    public void MovingLift(Long source, Long destination, Lift lift){

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // number of floor = abs(destination-source)
                // assuming it takes 2 seconds to move from one floor to other
                Long counter = 0L;

                if(counter%3 == 0 && !lift.getIsDoorOpen()) {
                    Notification notification = new Notification();

                    notification.setLift(lift);
                    notification.setCurrentFloor(lift.getCurrentFloor());
                    notification.setDestinationFloor(destination);
                    notification.setWeight(lift.getWeight());

                    // send notification

                }
                if(lift.getDirection() == Direction.UP)
                    lift.setCurrentFloor(source+counter%2);
                else
                    lift.setCurrentFloor(source-counter%2);

                counter++;

                if(lift.getCurrentFloor() == destination)
                    timer.cancel();
            }
        };

        timer.scheduleAtFixedRate(task,0,1000);
    }

    public Lift findBestSuitableLift(Long source, Long destination) throws Exception {

        Direction direction;
        if(destination>source)
            direction = Direction.UP;
        else if(source>destination)
            direction = Direction.DOWN;
        else
            return null;

        List<Lift> lifts = liftRepo.findByDirectionOrIdle(direction,true);

        Lift allocatedLift = null;
        Long distance = Long.MAX_VALUE;
        for (Lift lift : lifts) {
            Long currentDistance = Math.abs(lift.getCurrentFloor() - source);
            if (currentDistance < distance) {
                allocatedLift = lift;
                distance = currentDistance;
            }
        }

        if (allocatedLift != null) {
            return allocatedLift;
        } else {
            // if no lift is allocated
            throw new Exception("No Lift Available please try again later");
        }
    }
}
