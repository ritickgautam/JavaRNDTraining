package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Customer;
import com.service.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService service;


	@GetMapping("addCustomerForm")
	public String addCustomerForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "sign-up-form";
	}

	@PostMapping("saveCustomer")
	public String saveCustomer(Model model,@ModelAttribute("customer")Customer customer) {
		service.registerCustomer(customer);

		model.addAttribute("message", "Registered Successfully");
		return "redirect:..";
	}

	@GetMapping("list")
	private String getCustomer(Model model) {
		List<Customer> customers = service.getCustomers();
		model.addAttribute("customers", customers);
		return "list-customers";
	}

	@GetMapping("showUpdatedForm")
	public String showUpdatedForm(Model model, @RequestParam("userId") int userId) {
		System.out.println("Update user: "+userId);
		Customer customer = service.getCustomerById(userId);
		model.addAttribute("customer", customer);
		System.out.println("updated...");
		return "sign-up-form";
	}

	@GetMapping("delete")
	public String deleteCustomer(@RequestParam("userId") int id) {
		service.deleteCustomer(id);
		return "redirect:/customer/list";
	}

	@GetMapping("logIn")
	public String login() {
		return "log-in";
	}

	@RequestMapping(method = RequestMethod.POST, value = "authenticate")
	public String authenticate(Model model,@RequestParam("email") String email,@RequestParam("password") String password) {
		Customer customer = service.authenticate(email, password);
		if(customer!=null) {
			System.out.println(customer.getName() + " Logged In ");
			model.addAttribute("customer", customer);
			return "customerView";
		}
		else
		{
			model.addAttribute("message", "Incorrect credential!");
			return "redirect:..";

		}

	}

}
