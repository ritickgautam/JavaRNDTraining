package com.ritick.lms.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritick.lms.service.FineService;

@RestController
@RequestMapping("lms/api/v1")
public class FineController {
	@Autowired
	private FineService fineService;

	@PostMapping("fine/fineDetails")
	public String fineDetails() throws SQLException {
		return "Fine";
	}

	/*
	@PostMapping("Fine")
	public float findFineDetails(Model model,@ModelAttribute("fine")Fine fine,
			@PathVariable(value="expiryDate") String expiryDate,  @PathVariable(value="paymentDate") String paymentDate) throws SQLException, ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
		return fineService.getFineAmount(formatter.parse(paymentDate), formatter.parse( expiryDate));
	}
	 */

}
