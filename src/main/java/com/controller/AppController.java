package com.controller;

import java.time.LocalDate;
import java.util.Base64;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import com.model.Catagories;
import com.model.Product;
import com.service.CatagoryServImpl;
import com.service.ProductServiceImple;

@Controller
@RequestMapping("/")
@ComponentScan("com")
public class AppController {
	@Autowired
	private ProductServiceImple serviceimpl;
	@Autowired
	private CatagoryServImpl catservImpl;
	
	

	
	@RequestMapping(value = {"/list","/listn"} , method = RequestMethod.GET)
	public String listofProducts(ModelMap map) {
		
		List<Product> list = serviceimpl.findAll();
		
		map.addAttribute("plist", list);
		
		return "product_list";
	}
	
	
	@RequestMapping(value = {"/new"}, method = RequestMethod.GET)
	public String saveStudents(ModelMap modelMap) {
		
		Product product = new Product();
		List<Catagories> catagories = catservImpl.list();
		
		modelMap.addAttribute("catagories", catagories);
		modelMap.addAttribute("product",product);
		return "add_product";
	}
	
	@PostMapping(value = {"/new"})
	public String save(@RequestParam("name") String name,@RequestParam("description") String description, @RequestParam("price") int price,
			@RequestParam("image") MultipartFile image ,@RequestParam("cat") int cid,ModelMap map) {
		
		System.out.println(cid);
		
		
		serviceimpl.saveStudent(image, name, description, price , cid);
		
		map.addAttribute("success", "product "+cid+" has saved Successfully");
		
		return "success";
	}
	@RequestMapping(value = {"/change-{id}-ok"}, method = RequestMethod.GET)
	public String productUpdate(@PathVariable("id") int id,ModelMap map) {
		
		Product product = serviceimpl.findByid(id);
		
        List<Catagories> catagories = catservImpl.list();
		
		map.addAttribute("catagories", catagories);
		
		map.addAttribute("product", product);
		
		
		return "add_product";
	}
	
	@PostMapping(value = {"/change-{id}-ok"})
	public String update(@PathVariable("id")int pid,
			@RequestParam("name") String name,@RequestParam("description") String description, @RequestParam("price") int price,
			@RequestParam("image") MultipartFile image ,@RequestParam("cat") int cid,ModelMap map) {
		
		
		serviceimpl.updateProduct(pid, image, name, description, price, cid);
		
		
		return "redirect:/list";
	}
	
	@RequestMapping(value = {"/obj"} , method = RequestMethod.GET)
	public String list(ModelMap map) {
		
		List<Product> list = serviceimpl.findByCat(2);
		System.out.println(list.size());
//		for(Product p : list) {
//			System.err.println(p.getName());
//		}
		map.addAttribute("mobiles", list);
		
		return "index";
	}
	
	@RequestMapping(value = {"/catagory"}, method = RequestMethod.GET)
	public String cata(ModelMap map) {
		
		Catagories catagories = new Catagories();
		
		map.addAttribute("catagories", catagories);
		
		return"add_catagory";
	}
	@RequestMapping(value = {"/catagory"}, method = RequestMethod.POST)
	public String saveCat(Catagories catagories){
		
		catservImpl.saveCatagory(catagories);
		
		return"redirect:/listn";
		
	}
	@RequestMapping(value = {"/delete-{pid}-product"} , method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("pid") int pid ) {
		
		
		Product product = serviceimpl.findByid(pid);
		
		serviceimpl.deleteProduct(product);
		
		return "redirect:/listn";
	}

	
	
	
	
	
	
	
	
	

}
