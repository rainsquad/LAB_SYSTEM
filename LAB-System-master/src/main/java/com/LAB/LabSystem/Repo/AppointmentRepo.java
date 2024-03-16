package com.LAB.LabSystem.Repo;

import com.LAB.LabSystem.Model.AppointmentScheduler;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends MongoRepository<AppointmentScheduler, String> {
    AppointmentScheduler findByUserID(String userid);

}
