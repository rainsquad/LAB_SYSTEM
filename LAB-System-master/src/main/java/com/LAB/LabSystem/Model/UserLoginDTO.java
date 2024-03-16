package com.LAB.LabSystem.Model;

public class UserLoginDTO {
    private String Email;
    private String Password;

    public UserLoginDTO() {
    }

    public UserLoginDTO(String email, String password) {
       this.Email = email;
       this.Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
