package com.LAB.LabSystem.Service;

import com.LAB.LabSystem.Model.LoginResponse;
import com.LAB.LabSystem.Model.Register;
import com.LAB.LabSystem.Model.UserLoginDTO;
import com.LAB.LabSystem.Repo.RegisterRepo;
import com.LAB.LabSystem.Repo.RegisterServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private final RegisterRepo RegisterRepo;
    @Autowired
    private RegisterServiceInterface registerServiceInterface;

    public RegisterService(RegisterRepo RegisterRepo) {
        this.RegisterRepo = RegisterRepo;
    }

    public void saverUpdate(Register register) {

        RegisterRepo.save(register);
    }

    public Iterable<Register> listAll() {

        return this.RegisterRepo.findAll();
    }


    public void deleteUser(String Id) {

        RegisterRepo.deleteById(Id);
    }

    public Register getRegistertByID(String Id) {

        return RegisterRepo.findById(Id).get();
    }


    public LoginResponse LoggingUser(UserLoginDTO userLoginDTO) {
        return new LoginResponse(userLoginDTO);
    }

    public boolean existsByEmail(String email) {

            // Implement logic to check if email exists in the data store
            return RegisterRepo.existsByEmail(email);

    }


}
