package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.Token;
import com.stripe.model.PaymentIntent;

import tn.esprit.spring.entities.Cart;
import tn.esprit.spring.entities.ChargeRequest;
import tn.esprit.spring.entities.ItemList;
import tn.esprit.spring.entities.Parent;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.entities.enumerations.Status;
import tn.esprit.spring.repository.CartRepository;
import tn.esprit.spring.repository.ItemListRepository;
import tn.esprit.spring.repository.UserRepository;


@Service
public class StripeServiceImpl implements StripeService {
	
	
	@Autowired
	CartRepository cartRepository;
	@Autowired
	ItemListRepository itemListRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired 
	CartService cartService ;
	
	
	@Value("${stripe.keys.secret:defaultValue}")
	private String secretKey;
	
	
	
	@PostConstruct
	public void init() {
		Stripe.apiKey = secretKey;
	}
	
	
	@Override
public String createStripeCustomer(long idParent) {
		
		// stripe key
		Stripe.apiKey = "sk_test_51IZEi1DMHcCfkipSFOyEwTH9jVTNfpsxxIcIVno3JOSTZYyPvJWkntSDVhxSRyZySAZ2MFPGz3Jsxe5VatA8kYvH000puBCYh1";

		Parent P = (Parent) userRepository.findById(idParent).get();
		Map<String, Object> params = new HashMap<>();
		params.put("description", "My First Test Customer (created for API docs)");
		params.put("email", P.getEmail());

		// affichage id du customer
		try {
			Customer customer = Customer.create(params);

			System.out.println("create customer id: {}");
			return customer.getId();
		} catch (StripeException e) {

			throw new RuntimeException(e);
		}
		// TODO Auto-generated method stub
//		return null;
	}
	@Override
public String createCustumorStripe(String customerId, String carta, String expMonth, String expYear, String cvc)
		throws StripeException {
	// TODO Auto-generated method stub
	//return null;
	// stripe key
	Stripe.apiKey = "sk_test_51IZEi1DMHcCfkipSFOyEwTH9jVTNfpsxxIcIVno3JOSTZYyPvJWkntSDVhxSRyZySAZ2MFPGz3Jsxe5VatA8kYvH000puBCYh1";

	Customer customer = Customer.retrieve(customerId);

	Map<String, Object> cardParam = new HashMap<String, Object>();
	cardParam.put("number", carta);
	cardParam.put("exp_month", expMonth);
	cardParam.put("exp_year", expYear);
	cardParam.put("cvc", cvc);

	Map<String, Object> tokenParam = new HashMap<String, Object>();
	tokenParam.put("card", cardParam);

	Token token = Token.create(tokenParam);

	Map<String, Object> source = new HashMap<String, Object>();
	
	//bech tzidou lel user el token tawa
	source.put("source", token.getId());

	customer.getSources().create(source);
	return token.getId();
}
	@Override
public String paymentIntent(ChargeRequest chargerequest)throws StripeException{
	// TODO Auto-generated method stub
	//return null;
	// stripe key
	Stripe.apiKey = "sk_test_51IZEi1DMHcCfkipSFOyEwTH9jVTNfpsxxIcIVno3JOSTZYyPvJWkntSDVhxSRyZySAZ2MFPGz3Jsxe5VatA8kYvH000puBCYh1";

	// `source` is obtained with Stripe.js; see
	// https://stripe.com/docs/payments/accept-a-payment-charges#web-create-token
	List<String> paymentMethodTypes = new ArrayList();
	paymentMethodTypes.add("card");
	
	
	Map<String, Object> params = new HashMap<>();
	params.put("amount",chargerequest.getAmount());
	params.put("currency", chargerequest.getCurrency());
	params.put("description", chargerequest.getDescription());
	params.put("payment_method_types", paymentMethodTypes);
	
	PaymentIntent p = PaymentIntent.create(params);
	p.getId();
	//Charge charge = Charge.create(params);
	return p.getId();
}
	@Override
public PaymentIntent confirm(String id) throws StripeException {
	Stripe.apiKey = "sk_test_51IZEi1DMHcCfkipSFOyEwTH9jVTNfpsxxIcIVno3JOSTZYyPvJWkntSDVhxSRyZySAZ2MFPGz3Jsxe5VatA8kYvH000puBCYh1";
	PaymentIntent paymentIntent = PaymentIntent.retrieve(id);
	Map<String, Object> params = new HashMap<>();
	params.put("payment_method", "pm_card_visa");
	// params.put("customer", "cus_H1OvsnwEn1KX36");
	paymentIntent.confirm(params);
	
	return paymentIntent;
	
}
	@Override
public void Pay(long IdParent,String carta, int expMonth, int expYear, String cvc) throws AuthenticationException, InvalidRequestException, CardException, StripeException{
    
		
		Parent P = (Parent) userRepository.findById(IdParent).get();
	float montant=cartService.findbyPrixConfirmer(IdParent);
	//Cart car = cartRepository.findCartbyidParentone(IdParent);
	List<ItemList>il = (List<ItemList>) cartService.getAllItemConfirmer(IdParent);
	
		
		Map<String, Object> params = new HashMap<>();
        Map<String, Object> tokenParams = new HashMap<>();
        Map<String, Object> cardParams = new HashMap<>();
    	Stripe.apiKey = "sk_test_51IZEi1DMHcCfkipSFOyEwTH9jVTNfpsxxIcIVno3JOSTZYyPvJWkntSDVhxSRyZySAZ2MFPGz3Jsxe5VatA8kYvH000puBCYh1";
        cardParams.put("number", carta);
        cardParams.put("exp_month", expMonth);
        cardParams.put("exp_year", expYear);
        cardParams.put("cvc", cvc);
        
        tokenParams.put("card", cardParams);
        Token token =Token.create(tokenParams);
      //  System.out.println(token.getCard().getId());
        if (token.getId()!=null){
        params.put("amount", (int)montant*100);
        params.put("description", "Ahmed stripe");
        params.put("currency", "eur");
        params.put("source", token.getId());
        Charge charge = Charge.create(params);
        for (ItemList i : il){
            cartService.Payeeligne(i.getId());
           
              }
        /*
       SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(P.getEmail());
        msg.setSubject("Payment");
        msg.setText("le Client "+P.getName()+P.getLastName()+"a bien payé le montant"+montant);
      
	JavaMailSender.send(msg);
	*/
	}

      
        
      
	
	
}
	 @Bean
	 public JavaMailSender getJavaMailSender() {
	     JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	     mailSender.setHost("smtp.gmail.com");
	     mailSender.setPort(587);

	     mailSender.setUsername("");
	     mailSender.setPassword("");

	     Properties props = mailSender.getJavaMailProperties();
	     props.put("mail.transport.protocol", "smtp");
	     props.put("mail.smtp.auth", "true");
	     props.put("mail.smtp.starttls.enable", "true");
	     props.put("mail.debug", "true");

	     return mailSender;
	 }


}
