package com.LAB.LabSystem.Service;


import com.LAB.LabSystem.Model.AppointmentScheduler;
import com.LAB.LabSystem.Repo.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private EmailService emailService;

    public void saveAppointment(AppointmentScheduler appointmentScheduler) {
        // Save the appointment to the repository
        appointmentRepo.save(appointmentScheduler);

        // Send a confirmation email
        sendConfirmationEmail(appointmentScheduler);
    }

    private void sendConfirmationEmail(AppointmentScheduler appointmentScheduler) {
        String userEmail = appointmentScheduler.getClientEmail();
        String username = appointmentScheduler.getClientName();
        String Appdate = appointmentScheduler.getAppDate();
        String Datetime = appointmentScheduler.getDateTime();
        String Umail = appointmentScheduler.getClientEmail();
        String ClientPhone = appointmentScheduler.getClientPhone();
        String checktype = appointmentScheduler.getCheckingType();

        emailService.sendBookingConfirmationEmail(userEmail, username,Appdate ,Datetime,Umail,ClientPhone,checktype);
    }


    public void deleteAppointment(String userid) {
        appointmentRepo.deleteById(userid);
    }
    public AppointmentScheduler getAppointmentByUserid(String userid) {
        return appointmentRepo.findByUserID(userid);
    }

    public Iterable<AppointmentScheduler> listAll() {
        return appointmentRepo.findAll();
    }

}
