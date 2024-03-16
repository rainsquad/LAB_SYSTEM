package com.LAB.LabSystem.Controller;


import com.LAB.LabSystem.Model.Register;
import com.LAB.LabSystem.Service.RegisterService;
import com.LAB.LabSystem.Repo.RegisterServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/Register")
public class RegisterControlle {

    @Autowired
    private RegisterService registerService;
      @Autowired
      private RegisterServiceInterface registerServiceInterface;

    @PostMapping(value = "/save")
    private String  saveUser(@RequestBody Register register)
    {
        registerService.saverUpdate(register);
        return  register.get_id();

    }
//    private ResponseEntity<String> saveUsers(@Valid @RequestBody Register register, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            // If there are validation errors, return appropriate response
//            StringBuilder errors = new StringBuilder();
//            for (FieldError error : bindingResult.getFieldErrors()) {
//                errors.append(error.getDefaultMessage()).append("; ");
//            }
////            return ResponseEntity.badRequest().body(errors.toString());
////        } else {
////            // Check if email already exists
////            if (registerService.existsByEmail(register.getEmail())) {
////                return ResponseEntity.badRequest().body("Email already exists");
////            } else {
////                // If email is unique, proceed with saving the user
////                registerService.saveorUpdate(register);
////                return ResponseEntity.ok(register.getEmail());
////            }
//        }
  //  }

    @GetMapping(value = "/getall")
    public Iterable<Register> getUsers() {
        return registerService.listAll();
    }

    @PutMapping(value = "/edit/{Id}")
    private Register update(@RequestBody Register register, @PathVariable(name = "Id") String id) {
        register.get_id();
        registerService.saverUpdate(register);
        return register;
    }

    @DeleteMapping("/delete/{ID}")
    private void deleteUser(@PathVariable("Id") String id) {
        registerService.deleteUser(id);
    }

    @RequestMapping("/search/{id}")
    private Register getUser(@PathVariable(name = "Id") String id) {
        return registerService.getRegistertByID(id);
    }

}
