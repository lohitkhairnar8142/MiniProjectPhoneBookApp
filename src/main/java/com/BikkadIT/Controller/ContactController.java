package com.BikkadIT.Controller;

import java.net.http.HttpRequest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.Model.Contact;
import com.BikkadIT.Repository.ContactRepo;
import com.BikkadIT.Service.ContactServiceI;

@RestController 
public class ContactController {

	@Autowired
	private ContactServiceI contactServiceI;
	
	@PostMapping(value = "/saveContact" , produces = "application/json")
	public ResponseEntity<String> saveContact(@RequestBody Contact contact)
	{
		boolean saveContact = contactServiceI.saveContact(contact);
		
		if(saveContact==true) {
			String msg= "Contact Saved successfully";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}else {
			String msg="Contact not saved!";
					return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/getAllContacts",produces = "application/json")
	public ResponseEntity<List<Contact>> getAllContact()
	{
		List<Contact> allContact = contactServiceI.getAllContact();
		String msg="All Contact's";
		
		
		
		return new ResponseEntity<List<Contact>>(allContact,HttpStatus.OK);
	}
	
	@GetMapping(value = "/getById/{cId}",produces="application/json")
	public ResponseEntity<Contact>getContactById(@PathVariable Integer cId)
	{
	Contact contactById = contactServiceI.getContactById(cId);
	
		return new ResponseEntity<Contact>(contactById,HttpStatus.OK);
	
	}
	
	@PutMapping(value = "/updateContact/{cId}",produces = "application/json")
	public ResponseEntity<String>updateContact(@RequestBody  Contact contact,@PathVariable Integer cId){
		boolean saveContact = contactServiceI.updateContact(contact);
		
		if(saveContact==true) {
			String msg="Contact Updated Successfully";
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}else {
			String msg="Contact not updated!";
			return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
		}
	}
}
