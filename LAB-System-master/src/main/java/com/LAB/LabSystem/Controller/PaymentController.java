package com.LAB.LabSystem.Controller;

import com.LAB.LabSystem.PaymentRequestPOJO.PaymentRequest;
import com.LAB.LabSystem.Service.PaymentService;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/charge")
    public String chargeCreditCard(@RequestBody PaymentRequest paymentRequest) {
        try {
            paymentService.chargeCreditCard(paymentRequest.getToken(), paymentRequest.getAmount());
            // Save payment details to MongoDB
            paymentService.savePayment(paymentRequest);
            return "Payment successful!";
        } catch (StripeException e) {
            return "Payment failed: " + e.getMessage();
        }
    }
}