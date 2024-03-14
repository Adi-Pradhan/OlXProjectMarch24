package com.nt.service;

import java.util.List;

import com.nt.bean.AdvertisementStatus;

public interface IAdvertisementStatus {

	public AdvertisementStatus addAdvertiseStatus(AdvertisementStatus advsts);
	public List<AdvertisementStatus> findAllAdvertise();
	public AdvertisementStatus findAdvertiseById(Integer id);
	public AdvertisementStatus findAdvertiseByStatus(String status);
}
