package com.LAB.LabSystem.Repo;

import com.LAB.LabSystem.Model.LoginResponse;
import com.LAB.LabSystem.Model.Register;
import com.LAB.LabSystem.Model.UserLoginDTO;

public interface RegisterServiceInterface {
//    String addUsers(Register register);
//    LoginResponse loginUser(UserLoginDTO userLoginDTO);

    String addUsers(Register register1);

    //     Register register;
    LoginResponse LOGIN_RESPONSE(UserLoginDTO userLoginDTO);

    UserLoginDTO LogginUser(UserLoginDTO userLoginDTO);
}
