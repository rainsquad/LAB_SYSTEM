package com.LAB.LabSystem.Controller;

import com.LAB.LabSystem.Model.AppointmentScheduler;
import com.LAB.LabSystem.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/Doctors/controller")
public class DoctorController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping(value = "/AllAppointments")
    private Iterable<AppointmentScheduler> getAllAppointments()
    {
        return appointmentService.listAll();
    }
    @DeleteMapping(value = "/DeleteAppointment/{UserID}")
    private void deleteAppointment(@PathVariable("UserID") String Userid){
        appointmentService.deleteAppointment(Userid);
    }
    @RequestMapping(value = "/Search/{UserID}")
    private AppointmentScheduler searchAppointment(@PathVariable("UserID") String Userid){
        return appointmentService.getAppointmentByUserid(Userid);
    }
}
