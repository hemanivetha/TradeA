package com.hcl.trade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.trade.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
}
