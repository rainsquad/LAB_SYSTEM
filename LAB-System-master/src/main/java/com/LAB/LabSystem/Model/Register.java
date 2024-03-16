package com.LAB.LabSystem.Model;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Setter
@Getter
@Data
@Document(collection ="RegisterDetails")
public class Register {

    @Id
    private String _id;
    @NotEmpty(message = "Username must not be empty")
    private String UserName;
    @NotEmpty(message = "Email must not be empty")
    private String Email;
    @NotEmpty(message = "Password must not be empty")
    private String Password;
    @NotEmpty(message = "Mobile must not be empty")
    private String Mobile;

    public Register(String _id, String userName, String email, String password, String mobile) {
        this._id = _id;
        this.UserName = userName;
        this.Email = email;
        this.Password = password;
        this.Mobile = mobile;
    }

    public Register() {
    }

    public Register(String email, String encode) {
    }


    @Override
    public String toString() {
        return "Register{" +
                "_id='" + _id + '\'' +
                ", UserName='" + UserName + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", Mobile='" + Mobile + '\'' +
                '}';
    }
}
