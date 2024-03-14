package com.nt.service;

import java.util.List;

import com.nt.bean.Advertise;
import com.nt.bean.AdvertisementStatus;
import com.nt.bean.Category;
import com.nt.bean.User;

public interface IAdvertiseService {

	public Advertise addAdvertise(Advertise adv);
	public List<Advertise> findAllAdvertise();
	public Advertise findAdvertiseById(Integer id);
	public Advertise findAdvertiseByTitle(String title);
//	public List<Advertise> findAdvertiseByUser(Integer UserId);
	public List<Advertise> findAdvertiseByUser(User user);
	public List<Advertise> findAdvertiseByCategory(Category category);
	public List<Advertise> findAdvertiseBystatus(AdvertisementStatus status);
	
	
	public Iterable<Advertise> findAll(Boolean orderType,String prop);
	public Iterable<Advertise> findAllAdvertiseByPagination(Integer pageNo,Integer pageSize,Boolean orderType,String prop);
	
}
