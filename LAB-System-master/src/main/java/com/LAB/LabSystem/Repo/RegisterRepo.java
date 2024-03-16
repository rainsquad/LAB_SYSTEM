package com.LAB.LabSystem.Repo;

import com.LAB.LabSystem.Model.Register;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterRepo extends MongoRepository<Register,String> {

    Optional<Register> findOneByEmailAndPassword(String email, String encodedPassword);

    Register findByEmail(String email);


    boolean existsByEmail(String email);
}
