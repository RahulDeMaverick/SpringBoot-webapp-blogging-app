package com.foodapp.myapp.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.foodapp.myapp.pojo.Image;
import com.foodapp.myapp.pojo.User;


@Component
public class UserDao extends DAO {
	
	
	public UserDao() {
    }

    public void save(User user)
             {
        try {
            begin();
            getSession().save(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            
        }
    }
    
	public User searchUser(String username) throws Exception {
		try {
			System.out.println("FROM User where email= '"+username+ "'");
			Query query = getSession().createQuery(
					"FROM User where email= '"+username+ "'");

			User user =  (User) query.uniqueResult();
			return user;

		} catch (HibernateException e) {
			rollback();
			throw new Exception("Error while finidng User", e);
		} finally {
			close();
		}

	}

	public List<User> fetch(String term) {

		List<User> user = null;
        try {
        	Query query = getSession().createQuery("From User");
        	user = (List<User>) query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } 
       return user;
	
	}

}
