package com.LAB.LabSystem.Model;

import com.LAB.LabSystem.Repo.RegisterRepo;
import com.LAB.LabSystem.Repo.RegisterServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginImpl implements RegisterServiceInterface {
    @Autowired
    private RegisterRepo Rrepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUsers(Register register) {
        this.passwordEncoder.encode(register.getPassword());
        Rrepo.save(register);
        return register.getEmail();
    }

    Register register;
    @Override
    public LoginResponse LOGIN_RESPONSE(UserLoginDTO userLoginDTO) {
        String msg = "";
        Register register2 = Rrepo.findByEmail(userLoginDTO.getEmail());
        if (register2 != null) {
            String password = userLoginDTO.getPassword();
            String encodedPassword = register2.getPassword();
            boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Register> employee = Rrepo.findOneByEmailAndPassword(userLoginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exits", false);
        }
    }

    @Override
    public UserLoginDTO LogginUser(UserLoginDTO userLoginDTO) {
        return LogginUser(userLoginDTO);
    }


}
