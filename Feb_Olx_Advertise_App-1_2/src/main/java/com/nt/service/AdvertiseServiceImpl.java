package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.bean.Advertise;
import com.nt.bean.AdvertisementStatus;
import com.nt.bean.Category;
import com.nt.bean.User;
import com.nt.repo.IAdvertiseRepo;

@Service
public class AdvertiseServiceImpl implements IAdvertiseService {

	@Autowired
	IAdvertiseRepo advR;

	@Override
	public Advertise addAdvertise(Advertise adv) {

		return advR.save(adv);
	}

	@Override
	public List<Advertise> findAllAdvertise() {

		return advR.findAll();
	}

	@Override
	public Advertise findAdvertiseById(Integer id) {
		Optional<Advertise> ad=advR.findById(id);
		if(ad.isEmpty())
			return null;
		return ad.get();
	}

	@Override
	public Advertise findAdvertiseByTitle(String title) {
		Optional<Advertise> ad=advR.findByTitle(title);
		if(ad.isEmpty())
			return null;
		return ad.get();
	}

	@Override
	public List<Advertise> findAdvertiseByUser(User user) {
		
		List<Advertise> ad=advR.findByUser(user);
		if(ad.isEmpty())
			return null;
		return ad;
	}

	@Override
	public List<Advertise> findAdvertiseByCategory(Category category) {
		
		return advR.findByCategory(category);
	}

	@Override
	public List<Advertise> findAdvertiseBystatus(AdvertisementStatus status) {
	
		return advR.findByAdvertisementStatus(status);
	}



	@Override
	public Iterable<Advertise> findAllAdvertiseByPagination(Integer pageNo, Integer pageSize, Boolean orderType,
			String prop) {
		int pageCount=(int) advR.count();
		int noOfCoulmn=pageCount/pageSize;
		noOfCoulmn=(pageCount%pageSize==0)?noOfCoulmn:noOfCoulmn++;
		System.out.println(noOfCoulmn);
		Pageable pag=PageRequest.of(pageNo,pageSize,orderType?Direction.ASC:Direction.DESC,prop);
		return advR.findAll(pag);
	}

	@Override
	public Iterable<Advertise> findAll(Boolean orderType,String prop) {
		Sort so=Sort.by(orderType?Direction.ASC:Direction.DESC,prop );
		return advR.findAll(so);
	}

	

	

}
