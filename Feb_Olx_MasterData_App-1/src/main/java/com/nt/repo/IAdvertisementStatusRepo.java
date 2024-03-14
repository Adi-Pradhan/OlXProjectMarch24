package com.nt.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.bean.AdvertisementStatus;

@Repository
public interface IAdvertisementStatusRepo extends JpaRepository<AdvertisementStatus, Integer> {

	public Optional<AdvertisementStatus> findByStatus(String status);
	
}
