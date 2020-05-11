package com.app.service.dao;

import java.util.List;

import com.app.service.bean.ItemBean;


public interface BuyerRepository {
	
	List<ItemBean> getAllProfiles();
	ItemBean getProfile(String userId);

}
