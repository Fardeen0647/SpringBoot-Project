package com.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Cart;
import com.model.Catagories;
import com.model.Orders;
import com.model.Product;
import com.model.ShoppingCart;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.repository.ShoppingCartRepImpl;
import com.service.CartSerimpl;
import com.service.CatagoryServImpl;
import com.service.PayPalServiceImpl;
import com.service.PdfServiceImpl;
import com.service.ProductServiceImple;
import com.service.ShoppingCartSerImpl;

@Controller
@ComponentScan("com")
@RequestMapping("/")
public class WebSiteController {
	@Autowired
	private CatagoryServImpl catagoryServImpl;
	@Autowired
	private ProductServiceImple serviceImple;
	@Autowired
	private CartSerimpl cartSerimpl;
	@Autowired
	private ShoppingCartSerImpl shoppingCartSerImpl; 
	@Autowired
	private PayPalServiceImpl payPalServiceImpl;
	@Autowired
	private PdfServiceImpl impl;
	
	
	public static final String SUCCESS_URL = "pay/success";
	public static final String CANCEL_URL = "pay/cancel";
	
	@RequestMapping(value = {"/","/index"},method = RequestMethod.GET)
	public String loadWebSite(ModelMap map) {
		 
		Cart cart = new Cart();
		
		List<Product> allProducts = serviceImple.findAll();
		
		List<Catagories>catagories = catagoryServImpl.list();
		
		map.addAttribute("categoriesList", catagories);
		
		map.addAttribute("allProducts", allProducts);
		
		map.addAttribute("cart", cart);
		
		return "NewFile";
		
	}
	@PostMapping(value = {"/add-to-cart"})
	public String saveCart(HttpServletRequest request,@RequestParam("id") int id,ModelMap map) {
		
		String sessionToken = (String)request.getSession(true).getAttribute("sessionToken");
		
		if(sessionToken == null) {
			sessionToken = UUID.randomUUID().toString();
			request.getSession().setAttribute("sessionToken",sessionToken);
			shoppingCartSerImpl.addtoShoppingCart(id,sessionToken);
		}
		else{
			
			shoppingCartSerImpl.addtoExisitingShoppingCart(id, sessionToken);
			
		}
		
		
		return "redirect:/index";
	}
	
	@RequestMapping(value = {"category-{cid}-cid"} ,method = RequestMethod.GET)
	public String categoryListing(@PathVariable("cid") int cid,ModelMap map) {
		
		//ModelAndView mv = new ModelAndView();
		 
	  
		Cart cart = new Cart();
		
		
		List<Product> categoryProducts = serviceImple.findByCat(cid);
		
        List<Catagories>catagories = catagoryServImpl.list();
		
		
		//mv.addObject("categoriesList", catagories);
		
		map.addAttribute("categoriesList", catagories);
		
		//mv.addObject("categoryProducts", categoryProducts);
		
		map.addAttribute("categoryProducts", categoryProducts);
		
		//mv.setViewName("NewFile");
		
		map.addAttribute("cart", cart);
		return "NewFile";
		
	}
	@RequestMapping(value = {"/shoppingCart"})
	public String shoppingCart(HttpServletRequest request ,ModelMap map) {
		
		String sessionToken = (String)request.getSession(true).getAttribute("sessionToken");
		
		if(sessionToken==null) {
			map.addAttribute("shoppingCart", new ShoppingCart());
		}
		else {
			ShoppingCart shoppingCart = shoppingCartSerImpl.findBySessionToken(sessionToken);
			
			map.addAttribute("shoppingCart", shoppingCart);
		}
		
		map.addAttribute("product", new Product());
		
	
		return "shoppingCart";
	}
	

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
	public String successPayment(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId,HttpServletResponse response) throws IOException {
		
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
	@RequestMapping(value = {"/generate_pdf"})
	public String pdftext(HttpServletResponse response) throws IOException {
		
		response.setContentType("application/pdf");
		DateFormat dateFormat =  new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormat.format(new Date());
		
		String headerKey= "Content-Disposition";
		String headerValue ="attachment; filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);
		
		impl.exportPdf(response);
		return "pdftest";
	}


}
