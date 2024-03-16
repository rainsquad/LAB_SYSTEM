package com.LAB.LabSystem.Model;

public class LoginResponse {
    String message;
    boolean status;

    public LoginResponse(UserLoginDTO userLoginDTO) {
        if (userLoginDTO!= null && isValidEmail(userLoginDTO.getEmail())) {
            this.message = userLoginDTO.getEmail();
            this.status = true;
        } else {
            // Handle invalid userLoginDTO or email
            this.message = "Invalid email";
            this.status = false;
        }

    }
//     Method to validate email format (you can implement it as per your requirements)

    private boolean isValidEmail(String email) {
        // Your email validation logic here
        return email != null && email.contains("@");
    }

    // Method to validate password (you can implement it as per your requirements)
    private boolean isValidPassword(String password) {
        // Your password validation logic here
        return password != null && password.length() >= 8; // Example: password must be at least 8 characters
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public LoginResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }


}
