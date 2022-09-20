package com.mikeulrich.stripepayments.web.controller;

import com.mikeulrich.stripepayments.dto.CreatePayment;
import com.mikeulrich.stripepayments.dto.CreatePaymentResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PaymentsController {

    @PostMapping("/create-payment-intent")
    public CreatePaymentResponse createPaymentIntent(CreatePayment createPayment) throws StripeException {
            PaymentIntentCreateParams createParams = new PaymentIntentCreateParams.Builder()
                            .setAmount(15*100L)
                            .setCurrency("usd")
                            .build();

            // Create a PaymentIntent with the order amount and currency
            PaymentIntent intent = PaymentIntent.create(createParams);
            return new CreatePaymentResponse(intent.getClientSecret());


    }
}


