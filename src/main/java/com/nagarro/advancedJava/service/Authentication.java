package com.nagarro.advancedJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.nagarro.advancedJava.domain.UserDetails;

@Component
public class Authentication {

	@Autowired
	HibernateTemplate hibernateTemplate;

	public boolean validateUser(String username, String password) {

		UserDetails user = this.hibernateTemplate.get(UserDetails.class, username);
		if (user != null && user.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}

}
