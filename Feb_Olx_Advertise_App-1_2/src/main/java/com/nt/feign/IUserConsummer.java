package com.nt.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nt.bean.User;

@FeignClient("OlxUserApp")
public interface IUserConsummer {

	@GetMapping("/Per/userbyid/{id}")
	public User getUserById(@PathVariable Integer id);
}
