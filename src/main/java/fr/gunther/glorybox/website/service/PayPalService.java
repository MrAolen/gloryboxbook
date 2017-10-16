package fr.gunther.glorybox.website.service;

import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import fr.gunther.glorybox.website.configuration.PaypalPaymentIntent;
import fr.gunther.glorybox.website.configuration.PaypalPaymentMethod;

public interface PayPalService {
    Payment createPayment(Double total,
                                 String currency,
                                 PaypalPaymentMethod method,
                                 PaypalPaymentIntent intent,
                                 String description,
                                 String cancelUrl,
                                 String successUrl) throws PayPalRESTException;

    Payment executePayment(String paymentId, String payerId) throws PayPalRESTException;
}
