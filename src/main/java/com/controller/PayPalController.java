package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Orders;
import com.model.Product;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.service.PayPalServiceImpl;

@Controller
@ComponentScan("com")
@RequestMapping("/pay")
public class PayPalController {
	
	@Autowired
	private PayPalServiceImpl payPalServiceImpl;
	
	public static final String SUCCESS_URL = "pay/success";
	public static final String CANCEL_URL = "pay/cancel";
	
	
	
	
	@PostMapping(value = {"/shoppingCart"})
	public String payment(@ModelAttribute("order") Orders orders) {
		
		try {
			Payment payment =  payPalServiceImpl.createPayment(orders.getPrice(), orders.getCurrency(), orders.getMethod(), orders.getIntent(), orders.getDescription(), "http://localhost:8080/"+CANCEL_URL, "http://localhost:8080/"+SUCCESS_URL);
			
			
			for(Links links : payment.getLinks()) {
				if(links.getRel().equals("approval_url")) {
					return "redirect:"+links.getHref();
				}
			}
			
		} catch (PayPalRESTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/index";
		
	}
	
	@RequestMapping(value = CANCEL_URL)
	public String cancelPayment() {
		return "cancel";
	}
	
	@RequestMapping(value = SUCCESS_URL)
	public String successPayment(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
		
		try {
			Payment payment = payPalServiceImpl.executePayment(paymentId, payerId);
			System.out.println(payment.toJSON());
			if(payment.getState().equals("approved")) {
				return "succesp";
			}
		} catch (PayPalRESTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "redirect:/index";
	}
	

}
