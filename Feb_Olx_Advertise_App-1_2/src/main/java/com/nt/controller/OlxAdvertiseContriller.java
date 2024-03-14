package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.bean.Advertise;
import com.nt.bean.AdvertiseReq;
import com.nt.bean.User;
import com.nt.feign.IMasterDataFeignClient;
import com.nt.feign.IUserConsummer;
import com.nt.service.IAdvertiseService;

@RestController
@RequestMapping("/Olx")
public class OlxAdvertiseContriller {

	@Autowired
	IAdvertiseService advS;

	@Autowired
	IMasterDataFeignClient mastrClient;

	@Autowired
	IUserConsummer userClient;

	@PostMapping("/regAdv")
	public ResponseEntity<Advertise> addAdvertise(@RequestBody AdvertiseReq adv) {

		Advertise advt = new Advertise();
		advt.setTitle(adv.getTitle());
		advt.setDescription(adv.getDescription());
		advt.setPrice(adv.getPrice());
		System.out.println("Reached till Category");
		advt.setCategory(mastrClient.getCategoryById(adv.getCategoryId()));
		System.out.println("Reached after Category the value " + adv.getCategoryId());
		System.out.println(mastrClient.getCategoryById(adv.getCategoryId()).toString());
		advt.setAdvertisementStatus(mastrClient.getAdvById(adv.getAdvertisementStatusId()));
		System.out.println("the value of advertiseStatus " + adv.getAdvertisementStatusId());
		System.out.println(mastrClient.getAdvById(adv.getAdvertisementStatusId()).toString());
		advt.setUser(userClient.getUserById(adv.getUserId()));
		User us = userClient.getUserById(adv.getUserId());
		System.out.println("user details " + adv.getUserId());
//		System.out.println(us.getEmail() + " " + us.getFirstName() + " " + us.getUserID());
//		advt.setLastModifiedTime(adv.getLastModifiedTime());
//		advt.setCreatedTime(adv.getCreatedTime());
		advt.setPictueDetails(adv.getPictueDetails());

		Advertise advert = advS.addAdvertise(advt);
		return new ResponseEntity<Advertise>(advert, HttpStatus.CREATED);
	}

	@GetMapping("/advertise")
	public ResponseEntity<List<Advertise>> getAllAdvertise() {
		return new ResponseEntity<List<Advertise>>(advS.findAllAdvertise(), HttpStatus.OK);
	}
	
	@GetMapping("/pageAdvertise/{pageNo}/{noOfpage}/{asc}/{prop}")
	public ResponseEntity<Iterable<Advertise>> getAllAdvertiseByPaging(@PathVariable int pageNo,@PathVariable int noOfpage,@PathVariable Boolean asc,@PathVariable String prop){
		
		return new ResponseEntity<Iterable<Advertise>>( advS.findAllAdvertiseByPagination(pageNo, noOfpage, asc, prop),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/pageAdvertiseSort/{direction}/{prop}")
	public ResponseEntity<Iterable<Advertise>> getAllAdvertiseBySort(@PathVariable Boolean direction,@PathVariable String prop){
		Iterable<Advertise> as= advS.findAll(direction, prop);
		return new ResponseEntity<Iterable<Advertise>>(as,HttpStatus.ACCEPTED);
	}

	@GetMapping("/advertiseById/{id}")
	public ResponseEntity<Advertise> getAdvertiseById(@PathVariable Integer id) {
		return new ResponseEntity<Advertise>(advS.findAdvertiseById(id), HttpStatus.OK);
	}

	@GetMapping("/advertiseByTitle/{title}")
	public ResponseEntity<Advertise> getAdvertiseByTitle(@PathVariable String title) {
		return new ResponseEntity<Advertise>(advS.findAdvertiseByTitle(title), HttpStatus.OK);
	}

	@GetMapping("/advByUser/{id}")
	public ResponseEntity<List<Advertise>> getAllAdvertiseByUser(@PathVariable Integer id) {
		return new ResponseEntity<List<Advertise>>(advS.findAdvertiseByUser(userClient.getUserById(id)), HttpStatus.OK);
	}

	@GetMapping("/advByCat/{id}")
	public ResponseEntity<List<Advertise>> getAllAdvertiseBtCategory(@PathVariable Integer id) {
		return new ResponseEntity<List<Advertise>>(advS.findAdvertiseByCategory(mastrClient.getCategoryById(id)),
				HttpStatus.OK);
	}

	@GetMapping("/advByStatus/{id}")
	public ResponseEntity<List<Advertise>> getAllAdvertiseByStatus(@PathVariable Integer id) {
		return new ResponseEntity<List<Advertise>>(advS.findAdvertiseBystatus(mastrClient.getAdvById(id)),
				HttpStatus.OK);
	}
}
