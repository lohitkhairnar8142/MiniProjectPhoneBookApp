package com.BikkadIT.Service;

import java.util.List;
import com.BikkadIT.Model.Contact;

public interface ContactServiceI {
 
	 boolean saveContact(Contact contact);
	 
	 List<Contact> getAllContact();
	 
	 Contact getContactById(Integer cId);
	 
	 public boolean updateContact(Contact contact);
	 
	 boolean deleteContactById(Integer cId);
}
