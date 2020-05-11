package com.app.service.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.app.service.bean.ItemBean;

@Repository
public class BuyerRepositoryImpl implements BuyerRepository {
	
	private Map<String, ItemBean> empData = new HashMap<String, ItemBean>();
		
		public BuyerRepositoryImpl() {
			ItemBean emp = new ItemBean("1000", "Vincent");
			empData.put("1000", emp);
			emp = new ItemBean("2000", "Harry");
			empData.put("2000", emp);
			emp = new ItemBean("3000", "Clark");
			empData.put("3000", emp);
			emp = new ItemBean("4000", "Stephen");
			empData.put("4000", emp);
		}
		
		@Override
		public List<ItemBean> getAllProfiles() {
			return new ArrayList<ItemBean>(empData.values());
		}
	
		@Override
		public ItemBean getProfile(String userId) {
			return empData.get(userId);
		}
}
