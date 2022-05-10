package com.foodapp.myapp.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foodapp.myapp.dao.ImageDao;
import com.foodapp.myapp.pojo.Image;
import com.foodapp.myapp.pojo.User;






@Controller
public class PostController {
	
	@Autowired
	ImageDao imagedao;
	
	@Autowired
	Image image;
	
	@Autowired
	User user;
	
	
	@RequestMapping(value = "/post.htm", method = RequestMethod.POST)
	public String addpost(@ModelAttribute("image") Image image, HttpServletRequest request,BindingResult result, HttpSession session, ImageDao imagedao) {
		//File is in the memory, need to transfer to a file
		String fileName = "img_" + System.currentTimeMillis() + "" + new Random().nextInt(100000000) + "" + new Random().nextInt(100000000) + ".jpg";
		image.setImagePath(fileName);
		try {
			image.getImageFile().transferTo(new File(System.getProperty("user.dir")+"/src/main/webapp/images/"+ fileName));
		} catch (IllegalStateException e1) {
			System.out.println("IllegalStateException: " + e1.getMessage());
		} catch (IOException e1) {
			System.out.println("IOException: " + e1.getMessage());
		}
	
		try {
			User user =  (User) session.getAttribute("user");
			image.setUser(user);
			imagedao.save(image);
		} catch (Exception e) {
			System.out.println("Exceptio: " + e.getMessage());
		}
		

		return "redirect:/view.htm";
		
	}
	
	
	@RequestMapping(value = "/view.htm", method = RequestMethod.GET)
	public String viewproducts(HttpServletRequest request,HttpSession session,ImageDao imagedao)
	{ 	
		List<Image> post = (List<Image>) imagedao.postList();
		session.setAttribute("posting",post);
		   System.out.println(request.getSession().getAttribute("posting"));
		   
		Enumeration keys = session.getAttributeNames();
		while (keys.hasMoreElements()){
		   String key = (String)keys.nextElement();
		   System.out.println(key + ": " + session.getValue(key) + "<br>");
		}
		return "feed";
	}
	
	@RequestMapping(value = "/delete.htm/{id}", method = RequestMethod.GET)
	public String deleteproduct(ImageDao imagedao,@PathVariable String id)
	{
		boolean isDelete = imagedao.deletePost(id);
		
		return "redirect:/view.htm";
	}

	
	@RequestMapping(value = "/update.htm/{id}", method = RequestMethod.GET)
	public String updateproduct(HttpServletRequest request,HttpSession session,@PathVariable String id,ModelMap model)
	{ 	
		Image image = imagedao.getpostbyid(id);
		request.setAttribute("posting",image);
		model.addAttribute("image",image);
		return "edit";
	}
	
	@RequestMapping(value = "/update.htm", method = RequestMethod.POST)
	public String updateImage(@ModelAttribute("image")Image image,HttpSession session,HttpServletRequest request )
	{	
		image.setId(Long.parseLong(request.getParameter("id")));
		System.out.print("inside update");
		System.out.print(image.getId());
		User user =  (User) session.getAttribute("user");
		
		if(image.getImageFile().getSize()>0)
		{
			String fileName = "img_" + System.currentTimeMillis() + "" + new Random().nextInt(100000000) + "" + new Random().nextInt(100000000) + ".jpg";
			image.setImagePath(fileName);
			try {
				image.getImageFile().transferTo(new File(System.getProperty("user.dir")+"/src/main/webapp/images/"+ fileName));
			} catch (IllegalStateException e1) {
				System.out.println("IllegalStateException: " + e1.getMessage());
			} catch (IOException e1) {
				System.out.println("IOException: " + e1.getMessage());
			}
		}
	        
		
		image.setUser(user);
		imagedao.update(image);
		return "redirect:/view.htm";
	}


}
