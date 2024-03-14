package com.nt.bean;

import java.util.List;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Advertisement")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Advertise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String title;
	
	private String description;
	
	private Double price;
	
	@Embedded
	private Category category;
	
	@Embedded
	private User user;
	
	@Embedded
	private AdvertisementStatus advertisementStatus;
	
	private List<String> pictueDetails;
	
}
