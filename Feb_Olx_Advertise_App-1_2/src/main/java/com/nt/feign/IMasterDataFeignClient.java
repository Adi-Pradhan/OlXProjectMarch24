package com.nt.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nt.bean.AdvertisementStatus;
import com.nt.bean.Category;

@FeignClient("OlxMasterdataApp")
public interface IMasterDataFeignClient {

	@GetMapping("/Master/advById/{id}")
	public AdvertisementStatus getAdvById(@PathVariable Integer id);
	@GetMapping("/Master/catg/{id}")
	public Category getCategoryById(@PathVariable Integer id);
}
