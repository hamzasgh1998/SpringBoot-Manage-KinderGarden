package tn.esprit.spring.service;

import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

import tn.esprit.spring.entities.ChargeRequest;

public interface StripeService {

	String createStripeCustomer(long idParent);



	PaymentIntent confirm(String id) throws StripeException;

	String paymentIntent(ChargeRequest chargerequest) throws StripeException;

	String createCustumorStripe(String customerId, String carta, String expMonth, String expYear, String cvc)
			throws StripeException;

	void Pay(long IdParent, String carta, int expMonth, int expYear, String cvc)
			throws AuthenticationException, InvalidRequestException, CardException, StripeException;

}
