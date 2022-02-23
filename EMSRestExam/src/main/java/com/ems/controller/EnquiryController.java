<<<<<<< HEAD
package com.ems.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ems.exception.NotFoundException;
import com.ems.model.Enquiry;
import com.ems.service.EnquiryService;

@RestController
@RequestMapping("ems/api/v1")
public class EnquiryController {

	@Autowired
	EnquiryService eService;

	/*
	 * ems/api/v1/enquiries
	 * Get Enquiries
	 *
	 * INPUT = null
	 * Output = List of Enquiries
	 *
	 */

	@RequestMapping(value = "/enquiries", method = RequestMethod.GET)
	public List<Enquiry> getQueries(){

		return eService.getQueries();
	}

	/*
	 * ems/api/v1/enquiries/{enquiryId}
	 * Get Enquiry by id
	 *
	 * INPUT = Enquiry id
	 * Output = Selected Enquiry
	 *
	 */

	@RequestMapping(value = "/enquiries/{enquiryId}", method = RequestMethod.GET)
	public Enquiry getQuery(@PathVariable int enquiryId){
		Enquiry query= eService.getQueryById(enquiryId);
		if(query==null) {
			throw new NotFoundException("Enquiry Id not found exception " + enquiryId);
		}
		return query;
	}


	/*
	 *  Save Enquiry
	 *
	 * ems/api/v1/enquiries/
	 *
	 *
	 * INPUT = Enquiry details
	 *
	{
    "query": "Cutoff of Stats hons branch"
	}
	 * Output = Details of Enquiry
	 *
	 */


	@RequestMapping(value = "/enquiries", method = RequestMethod.POST)
	public Enquiry saveQuery(@RequestBody Enquiry query){
		Date date = new Date(System.currentTimeMillis());
		query.setDate(date);
		query.setEnquiryId(0);
		eService.registerQuery(query);
		return query;

	}
	/*
	 *  Update Enquiry
	 *
	 * ems/api/v1/enquiries/
	 *
	 *
	 * INPUT = Updated Enquiry details
	 *
	{
	    "enquiryId": 4,
	    "query": "Cutoff of Maths hons branch",
	    "date": 1643234947424
	}
	 * Output = Details of Enquiry
	 *
	 */


	@RequestMapping(value = "/enquiries", method = RequestMethod.PUT)
	public Enquiry updateQuery(@RequestBody Enquiry query){
		eService.registerQuery(query);
		return query;

	}

	/*
	 * ems/api/v1/enquiries/{enquiryId}
	 * Delete Enquiry
	 *
	 * INPUT = Enquiry Id
	 *
	 * Output = String confirmation message
	 *
	 */

	@RequestMapping(value = "/enquiries/{enquiryId}", method = RequestMethod.DELETE)
	public String deletedQuery(@PathVariable int enquiryId){
		Enquiry query= eService.getQueryById(enquiryId);
		if(query==null) {
			throw new NotFoundException("Enquiry Id not found exception " + enquiryId);
		}
		else
			eService.deleteQuery(enquiryId);
		return "Enquiry Deleted successfully with query id "+ enquiryId;
	}


}
=======
package com.ems.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ems.exception.NotFoundException;
import com.ems.model.Enquiry;
import com.ems.service.EnquiryService;

@RestController
@RequestMapping("ems/api/v1")
public class EnquiryController {

	@Autowired
	EnquiryService eService;

	/*
	 * ems/api/v1/enquiries
	 * Get Enquiries
	 *
	 * INPUT = null
	 * Output = List of Enquiries
	 *
	 */

	@RequestMapping(value = "/enquiries", method = RequestMethod.GET)
	public List<Enquiry> getQueries(){

		return eService.getQueries();
	}

	/*
	 * ems/api/v1/enquiries/{enquiryId}
	 * Get Enquiry by id
	 *
	 * INPUT = Enquiry id
	 * Output = Selected Enquiry
	 *
	 */

	@RequestMapping(value = "/enquiries/{enquiryId}", method = RequestMethod.GET)
	public Enquiry getQuery(@PathVariable int enquiryId){
		Enquiry query= eService.getQueryById(enquiryId);
		if(query==null) {
			throw new NotFoundException("Enquiry Id not found exception " + enquiryId);
		}
		return query;
	}


	/*
	 *  Save Enquiry
	 *
	 * ems/api/v1/enquiries/
	 *
	 *
	 * INPUT = Enquiry details
	 *
	{
    "query": "Cutoff of Stats hons branch"
	}
	 * Output = Details of Enquiry
	 *
	 */


	@RequestMapping(value = "/enquiries", method = RequestMethod.POST)
	public Enquiry saveQuery(@RequestBody Enquiry query){
		Date date = new Date(System.currentTimeMillis());
		query.setDate(date);
		query.setEnquiryId(0);
		eService.registerQuery(query);
		return query;

	}
	/*
	 *  Update Enquiry
	 *
	 * ems/api/v1/enquiries/
	 *
	 *
	 * INPUT = Updated Enquiry details
	 *
	{
	    "enquiryId": 4,
	    "query": "Cutoff of Maths hons branch",
	    "date": 1643234947424
	}
	 * Output = Details of Enquiry
	 *
	 */


	@RequestMapping(value = "/enquiries", method = RequestMethod.PUT)
	public Enquiry updateQuery(@RequestBody Enquiry query){
		eService.registerQuery(query);
		return query;

	}

	/*
	 * ems/api/v1/enquiries/{enquiryId}
	 * Delete Enquiry
	 *
	 * INPUT = Enquiry Id
	 *
	 * Output = String confirmation message
	 *
	 */

	@RequestMapping(value = "/enquiries/{enquiryId}", method = RequestMethod.DELETE)
	public String deletedQuery(@PathVariable int enquiryId){
		Enquiry query= eService.getQueryById(enquiryId);
		if(query==null) {
			throw new NotFoundException("Enquiry Id not found exception " + enquiryId);
		}
		else
			eService.deleteQuery(enquiryId);
		return "Enquiry Deleted successfully with query id "+ enquiryId;
	}


}
>>>>>>> ca98932d9306c6218e14d6b42efd1c68119703d8
