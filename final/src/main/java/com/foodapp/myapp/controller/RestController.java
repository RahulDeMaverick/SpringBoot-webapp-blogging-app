package com.foodapp.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.foodapp.myapp.dao.SearchDao;
import com.foodapp.myapp.dao.UserDao;
import com.foodapp.myapp.pojo.Image;
import com.foodapp.myapp.pojo.LableValue;
import com.foodapp.myapp.pojo.User;

@Controller
public class RestController {
	
	@Autowired
	SearchDao searchdao;
	
	@Autowired
	UserDao userdao;
	
	
	
	@RequestMapping(value="/autocomplete")
	@ResponseBody
	public List<LableValue> Autocomplete(@RequestParam(value="term", required = false, defaultValue="") String term)  {
		List<LableValue> suggestions = new ArrayList<LableValue>();
		try {
			// only update when term is three characters.
			if (term.length() >= 3) {
				
				List<Image> post = (List<Image>) searchdao.fetch(term);
				
				for (Image image : post) {
					if (image.getPostName().contains(term)) {
						LableValue lv = new LableValue();
						lv.setLabel(image.getPostName());
						lv.setValue(Long.toString(image.getId()));
						suggestions.add(lv);
					}
				}
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("Exception in autocomplete");
		}
		
		return suggestions;
		
	}
	
	@RequestMapping(value="/getusers")
	@ResponseBody
	public List<LableValue> getusers(@RequestParam(value="term", required = false, defaultValue="") String term)  {
		List<LableValue> suggestions = new ArrayList<LableValue>();
		try {
			// only update when term is three characters.
			if (term.length() >= 3) {

				List<User> userlist = (List<User>) userdao.fetch(term);
		
				
				for (User user : userlist) {
					if (user.getFirstName().contains(term)) {
						LableValue lv = new LableValue();
						lv.setLabel(user.getFirstName());
						lv.setValue(Long.toString(user.getUserID()));
						suggestions.add(lv);
					}
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("Exception in autocomplete");
		}
		
		return suggestions;
		
	}

}
