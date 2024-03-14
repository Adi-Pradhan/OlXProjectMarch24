package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bean.AdvertisementStatus;
import com.nt.repo.IAdvertisementStatusRepo;

@Service
public class AdvertiseStatusServiceImpl implements IAdvertisementStatus {

	@Autowired
	IAdvertisementStatusRepo advStsRepo;
	
	@Override
	public AdvertisementStatus addAdvertiseStatus(AdvertisementStatus advsts) {
		
		return advStsRepo.save(advsts);
	}

	@Override
	public List<AdvertisementStatus> findAllAdvertise() {
		
		return advStsRepo.findAll();
	}

	@Override
	public AdvertisementStatus findAdvertiseById(Integer id) {
		Optional<AdvertisementStatus> ad=advStsRepo.findById(id);
		if(ad.isEmpty())
			return null;
		return ad.get();
	}

	@Override
	public AdvertisementStatus findAdvertiseByStatus(String status) {
		Optional<AdvertisementStatus> ad= advStsRepo.findByStatus(status);
		if(ad.isEmpty())
			return null;
		return ad.get();
	}

}
