package com.LAB.LabSystem.Controller;

import com.LAB.LabSystem.Model.AppointmentScheduler;
import com.LAB.LabSystem.Model.Register;
import com.LAB.LabSystem.Service.AppointmentService;
import com.LAB.LabSystem.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/Admin")
public class AdminController {

     @Autowired
     private AppointmentService appointmentService;
     @Autowired
     private RegisterService registerService;

    @GetMapping(value = "/getall")
    public Iterable<Register> getUsers() {
        return registerService.listAll();
    }
    @RequestMapping("/search/{ID}")
    private Register getUser(@PathVariable(name = "ID") String id) {
        return registerService.getRegistertByID(id);
    }
    @DeleteMapping("/delete/{ID}")
    private void deleteUser(@PathVariable("ID") String id, @PathVariable String ID) {
        registerService.deleteUser(id);
    }
    @RequestMapping(value = "/AllAppointments")
    private Iterable<AppointmentScheduler> getAllAppointments(){
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
