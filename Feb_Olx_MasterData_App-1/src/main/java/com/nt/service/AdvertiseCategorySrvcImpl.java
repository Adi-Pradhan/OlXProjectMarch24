package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bean.Category;
import com.nt.repo.ICategoryRepo;

@Service
public class AdvertiseCategorySrvcImpl implements IAdvertiseCategory {

	@Autowired
	ICategoryRepo catgRepo;
	
	@Override
	public Category addcategory(Category ctgry) {
		
		return catgRepo.save(ctgry);
	}

	@Override
	public Category getCatgById(Integer id) {
		
		Optional<Category> cat=catgRepo.findById(id);
		if(cat.isEmpty())
			return null;
		return cat.get();
	}

}
