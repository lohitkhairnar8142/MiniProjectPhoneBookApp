package com.BikkadIT.Service;

import java.util.List;
import java.util.Optional;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.Model.Contact;
import com.BikkadIT.Repository.ContactRepo;

@Service
public class ContactServiceIMPL implements ContactServiceI {

	@Autowired
	private ContactRepo contactRepo;
	
	@Override
	public boolean saveContact(Contact contact) {
		Contact save = contactRepo.save(contact);
		if(save !=null)
		{
			return true; 
		}else
		return false;
	
	}

	@Override
	public List<Contact> getAllContact() {
        List<Contact> findAll = contactRepo.findAll();
       
		return findAll ;
	}

	@Override
	public Contact getContactById(Integer cId) {
       Contact contact = contactRepo.findById(cId).get();
       return contact;
	}

	@Override
	public boolean deleteContactById(Integer cId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateContact(Contact contact) {
       Contact update = contactRepo.save(contact);
       if(update==null) {
    	   return false;
       }else {
		return true;
		}
	}
 
	
}
