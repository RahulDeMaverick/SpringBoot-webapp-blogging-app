package com.foodapp.myapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.foodapp.myapp.pojo.Image;




@Component
public class ImageDao extends DAO {
	
    public void save(Image image) throws Exception {
        try {
            begin();
            getSession().save(image);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new Exception("exception in ImageDao Save", e);
        }
    }

	public List<Image> postList() {
		
		List<Image> image = null;
        try {
        	Query query = getSession().createQuery("From Image");
        	image = (List<Image>) query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } 
       return image;
	}

	public boolean deletePost(String id) {
		try
		{
		Image image = new Image();
		image.setId(Integer.parseInt(id));
		begin();
		getSession().delete(image);
		commit();
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public Image getpostbyid(String id) {
		
		Query query = getSession().createQuery("FROM Image where id = '"+id +"'");
		Image image = (Image) query.uniqueResult();
		return image;
	}
	
	public boolean update(Image image)
	{
		try {
			begin();
			
		
			if(image.getImageFile().getSize()==0)
			{
				System.out.println("update Image set postName= '"+image.getPostName() +"',"+"description= '"+image.getDescription()+"',user_userID= " +image.getUser().getUserID()+ " where id ="+image.getId());
         	   Query query = getSession().createQuery("update Image set postName= '"+image.getPostName() +"',"+"description= '"+image.getDescription()+"',user_userID= " +image.getUser().getUserID()+ " where id ="+image.getId());
                int val = query.executeUpdate();
                commit();
			}
			else {
		System.out.println("update Image set postName= '"+image.getPostName() +"',"+"description= '"+image.getDescription()+"',user_userID= " +image.getUser().getUserID()+ " where id ="+image.getId());
            	   Query query = getSession().createQuery("update Image set postName= '"+image.getPostName() +"',"+"description= '"+image.getDescription()+"',"+"imagePath=  '"+image.getImagePath()+"',user_userID= " +image.getUser().getUserID()+ " where id ="+image.getId());
                   int val = query.executeUpdate();
                   commit(); 
			}
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
		return false;
		}
	}

}
