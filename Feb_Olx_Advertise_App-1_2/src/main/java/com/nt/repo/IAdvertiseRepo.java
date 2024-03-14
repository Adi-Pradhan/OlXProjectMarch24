package com.nt.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.bean.Advertise;
import com.nt.bean.AdvertisementStatus;
import com.nt.bean.Category;
import com.nt.bean.User;

@Repository
public interface IAdvertiseRepo extends JpaRepository<Advertise,Integer> {

	public  Optional<Advertise> findByTitle(String title);

	public List<Advertise> findByUser(User user);
	
	public List<Advertise> findByCategory(Category category);
	
	public List<Advertise> findByAdvertisementStatus(AdvertisementStatus status);
	
}
