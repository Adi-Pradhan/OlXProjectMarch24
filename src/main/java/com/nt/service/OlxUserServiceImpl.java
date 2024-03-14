package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bean.User;
import com.nt.repo.IOlxUserRepo;

@Service
public class OlxUserServiceImpl implements IOlxUserService{

	@Autowired
	IOlxUserRepo userRepo;
	
	@Override
	public User registerUser(User user) {
		System.out.println(user);
		return userRepo.save(user) ;
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@Override
	public User findUserById(Integer id) {
		Optional<User>  us=userRepo.findById(id);
		if(us.isEmpty())
			return null;
		return us.get();
	}

	@Override
	public User findUserByName(String name) {
		Optional<User > us=userRepo.findByuserName(name);
		if(us.isEmpty()) 
		   return null;
		return us.get();
		
	}

}
