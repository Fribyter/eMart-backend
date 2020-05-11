package com.app.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.bean.ItemBean;
import com.app.service.dao.BuyerRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
/*
 Commented as its been called from Zuul Gateway Service
 Uncomment if to call directly
@CrossOrigin

*/
@RestController
public class BuyerController {
	
	@Autowired
	BuyerRepository profileRepository;
	
	@RequestMapping("/profiles")
	public ItemBean[] all() {
		List<ItemBean> profiles = profileRepository.getAllProfiles();
		return profiles.toArray(new ItemBean[profiles.size()]);
	}
	
	@RequestMapping("/profiles/{id}")
	@HystrixCommand(fallbackMethod = "getDefaultProfile")
	public ItemBean byId(@PathVariable("id") String userId) {
		ItemBean itemBean = profileRepository.getProfile(userId);
		return itemBean;
	}
	
	public ItemBean getDefaultProfile(String userId) {
		ItemBean itemBean = new ItemBean("0000", "No employee");
		return itemBean;
	}
}
