package com.LAB.LabSystem.Service;

import com.LAB.LabSystem.Model.Payment;
import com.LAB.LabSystem.PaymentRequestPOJO.PaymentRequest;
import com.LAB.LabSystem.Repo.PaymentRepository;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.param.ChargeCreateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Value("${stripe.secretKey}")
    private String secretKey;

    @Autowired
    private PaymentRepository paymentRepository;

    public void chargeCreditCard(String token, int amount) throws StripeException {
        Stripe.apiKey = secretKey;

        ChargeCreateParams params =
                ChargeCreateParams.builder()
                        .setAmount((long) amount)
                        .setCurrency("usd")
                        .setSource(token)
                        .build();

        Charge charge = Charge.create(params);
        // Handle charge response
    }

    public void savePayment(PaymentRequest paymentRequest) {
        Payment payment = new Payment();
        payment.setToken(paymentRequest.getToken());
        payment.setAmount(paymentRequest.getAmount());
        // Set other payment details as needed
        paymentRepository.save(payment);
    }
}