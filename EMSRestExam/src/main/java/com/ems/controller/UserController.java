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
import com.ems.model.User;
import com.ems.service.EnquiryService;
import com.ems.service.UserService;

@RestController
@RequestMapping("ems/api/v1")
public class UserController {

	@Autowired
	UserService uService;

	@Autowired
	EnquiryService eService;

	/*
	 * ems/api/v1/users
	 * Get Users
	 *
	 * INPUT = null
	 * Output = List of users
	 *
	 */

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getUsers(){

		return uService.getUsers();

	}

	/*
	 * ems/api/v1/users/{userId}
	 * Get User by User Id
	 *
	 * INPUT = user Id
	 * Output = Details of user
	 *
	 */

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
	public User getUser(@PathVariable int userId) {

		User user = uService.getUserById(userId);
		if(user==null) {
			throw new NotFoundException("User Id not found exception " + userId);
		}
		return user;

	}
	/*
	 * ems/api/v1/users/
	 * Save User
	 *
	 * INPUT = user details
	 *
	 {
	"name": "Kishan",
    "email": "k@gmail.com",
    "password": "k",
    "number": 8877665545,
    "role": 1
	  }
	 * Output = Details of user
	 *
	 */



	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public User saveUser(@RequestBody User user){
		user.setId(0);
		uService.registerUser(user);
		return user;

	}

	/*
	 * ems/api/v1/users/
	 * Update User
	 *
	 * INPUT = user details with update
	 *
	 {
	 "id" :1,
	"name": "Kishan",
    "email": "k@gmail.com",
    "password": "k",
    "number": 8877665545,
    "role": 1
	  }
	 * Output = Details of user
	 *
	 */

	@RequestMapping(value = "/users", method = RequestMethod.PUT)
	public User updateUser(@RequestBody User user){
		uService.registerUser(user);
		return user;

	}

	/*
	 * ems/api/v1/users/{userId}
	 * Delete User
	 *
	 * INPUT = user Id
	 *
	 * Output = String confirmation message
	 *
	 */

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable int userId) {
		User user = uService.getUserById(userId);
		if(user==null) {
			throw new NotFoundException("User Id not found exception " + userId);
		}
		uService.deleteUser(userId);
		return "User has been deleted with userId "+ userId;
	}

	/*
	 * ems/api/v1/users/authenticate
	 * Authenticate User
	 *
	 * INPUT = user credential
	 {
	"email": "k@gmail.com",
    "password": "k",
	 }
	 * Output = String confirmation Login/ Failed
	 *
	 */

	@RequestMapping( value = "/authenticate",method = RequestMethod.POST)
	public String authenticate(@RequestBody User tuser) {
		String email = tuser.getEmail();
		String password = tuser.getPassword();
		User user = uService.authenticate(email, password);
		if(user!=null) {
			return "Login successfully as " + user.getName();
		}
		else
		{
			return "Login failed";

		}

	}

	/* Get Enquiry by Selected users
	 *
	 * ems/api/v1/users/{userId}/enquiries
	 *
	 *
	 * INPUT = userId
	 * Output = List of Enquiries
	 *
	 */


	@RequestMapping(value = "/users/{userId}/enquiries", method = RequestMethod.GET)
	public List<Enquiry> getQueryByUserID(@PathVariable int userId){

		User u = uService.getUserById(userId);
		if(u==null) {
			throw new NotFoundException("User Id not found exception " + userId);
		}
		return u.getQueries();
	}


	/* Get Enquiry by name of user
	 *
	 * ems/api/v1/users/{name}/enquiries
	 *
	 *
	 * INPUT = name of user
	 * Output = Query details by given user
	 *
	 */

	@RequestMapping(value = "/users/{name}/enquiries", method = RequestMethod.GET)
	public List<Enquiry> getQueryByName(@RequestBody Enquiry query,@PathVariable String name){
		User u = uService.getUserByName(name);
		if(u==null) {
			throw new NotFoundException("User with given not found exception " + name);
		}
		return u.getQueries();
	}



	/* Save Enquiry to Selected users
	 *
	 * ems/api/v1/users/{userId}/enquiries
	 *
	 *
	 * INPUT = userId and query
	 {
	 "query": "Cutoff of Stats hons branch"
	 }
	 * Output = User details in which query saved
	 *
	 */

	@RequestMapping(value = "/users/{userId}/enquiries", method = RequestMethod.POST)
	public User saveQueryByUser(@PathVariable int userId,@RequestBody Enquiry query){
		User u = uService.getUserById(userId);
		if(u==null) {
			throw new NotFoundException("User Id not found exception " + userId);
		}
		u.addQueries(query);
		Date date = new Date(System.currentTimeMillis());
		query.setDate(date);
		query.setEnquiryId(0);
		eService.registerQuery(query);

		return u;
	}




	/* Update Enquiry to Selected users
	 *
	 * ems/api/v1/users/{userId}/enquiries
	 *
	 *
	 * INPUT = userId and updated query
	 {
	 "enquiryId" : 1,
	 "query": "Cutoff of Stats hons branch"
	 }
	 * Output = Query details which get updated
	 *
	 */

	@RequestMapping(value = "/users/{userId}/enquiries", method = RequestMethod.PUT)
	public Enquiry updateQuery(@RequestBody Enquiry query,@PathVariable int userId){
		User u = uService.getUserById(userId);
		if(u==null) {
			throw new NotFoundException("User Id not found exception " + userId);
		}
		eService.updateQuery(query.getEnquiryId());
		return query;

	}

	/*
	 * ems/api/v1/users/{userId}/enquiries/{enquiryId}
	 * Delete Query for user
	 *
	 * INPUT = user Id and enquiry Id
	 *
	 * Output = String confirmation message
	 *
	 */

	@RequestMapping(value = "/users/{userId}/enquiries/{enquiryId}", method = RequestMethod.DELETE)
	public String deletedQuery(@PathVariable int enquiryId,@PathVariable int userId){
		User u = uService.getUserById(userId);
		if(u==null) {
			throw new NotFoundException("User Id not found exception " + userId);
		}
		else
		{
			System.out.println("Deleting query of user: " + u.getName() + "Enquiry Id:" + enquiryId);
			eService.deleteQuery(enquiryId);
		}
		return "Enquiry Deleted successfully with query id "+ enquiryId;
	}





}
