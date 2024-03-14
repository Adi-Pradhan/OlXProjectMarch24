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

import com.nt.bean.AdvertisementStatus;
import com.nt.bean.Category;
import com.nt.service.AdvertiseCategorySrvcImpl;
import com.nt.service.AdvertiseStatusServiceImpl;
import com.nt.service.IAdvertiseCategory;

@RestController
@RequestMapping("/Master")
public class MasterDataController {

	@Autowired
	AdvertiseStatusServiceImpl advstsServ;
	
	@Autowired
	IAdvertiseCategory catSer;
	
	@PostMapping("/adv")
	public ResponseEntity<AdvertisementStatus> addAdvertiseSttatus(@RequestBody AdvertisementStatus advst) {
		AdvertisementStatus advs=   advstsServ.addAdvertiseStatus(advst);
		 
		 return new ResponseEntity<AdvertisementStatus>(advs,HttpStatus.CREATED) ;
	}
	
	@GetMapping("/adv")
	public ResponseEntity<List<AdvertisementStatus>> getAllAdvertisementStatus(){
		List<AdvertisementStatus> ads=advstsServ.findAllAdvertise();
		return new ResponseEntity<List<AdvertisementStatus>>(ads,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/advById/{id}")
	public ResponseEntity<AdvertisementStatus> findAdvertiseById(@PathVariable Integer id){
		AdvertisementStatus adv=advstsServ.findAdvertiseById(id);
	 	return new ResponseEntity<AdvertisementStatus>(adv,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/advByStatus/{name}")
	public ResponseEntity<AdvertisementStatus> findAdvertiseByName(@PathVariable String name){
		
		AdvertisementStatus adv=advstsServ.findAdvertiseByStatus(name);
		return new ResponseEntity<AdvertisementStatus>(adv,HttpStatus.ACCEPTED);
	}
	@PostMapping("/catg")
	public ResponseEntity<Category> addCategory(@RequestBody Category cat){
		Category catg=catSer.addcategory(cat);
		return new ResponseEntity<Category>(catg,HttpStatus.CREATED);
	}
	
	@GetMapping("/catg/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Integer id){
		System.out.println("Master data Category by Id method");
		Category cat=catSer.getCatgById(id);
		return new ResponseEntity<Category>(cat,HttpStatus.OK); 
	}
}
