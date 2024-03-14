package com.nt.bean;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;


@Data
public class AdvertiseReq {

	private String title;

	private String description;

	private Double price;

	private Integer categoryId;

	private Integer userId;
	private Integer advertisementStatusId;

	private LocalDate createdTime;

	private LocalDate lastModifiedTime;

	private List<String> pictueDetails;
}
