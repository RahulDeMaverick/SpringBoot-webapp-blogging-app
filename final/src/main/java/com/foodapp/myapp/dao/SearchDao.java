package com.foodapp.myapp.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.foodapp.myapp.pojo.Image;
import com.foodapp.myapp.pojo.User;

@Component
public class SearchDao extends DAO {

	public List<Image> fetch(String term) {
	
		List<Image> image = null;
        try {
        	Query query = getSession().createQuery("From Image");
        	image = (List<Image>) query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } 
       return image;
	}

	public Image searchPost(String postName) {
	

	
        	Query query = getSession().createQuery("From Image where postName = '"+postName+"'");
        	Image image = (Image) query.uniqueResult();
        	return image;
    	
	}

	public List<Image> searchimgbyser(String fname) {
		
		List<Image> image = null;
		try {
		Query query1 = getSession().createQuery(
				"FROM User where firstName= '"+fname+ "'");

		User user =  (User) query1.uniqueResult();
		
		int uid= user.getUserID();
        
        Query query = getSession().createQuery("From Image where user_userID = '"+uid+ "'");
        
        image = (List<Image>) query.list();
        
        } catch (HibernateException e) {
            e.printStackTrace();
        } 
       return image;
	}



	public List<Image> latestpost() {
		List<Image> image = null;
        try {
        	Query query = getSession().createQuery("From Image");
        	query.setMaxResults(5);
        	image = (List<Image>) query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } 
       return image;
	}
		
		
	


}
