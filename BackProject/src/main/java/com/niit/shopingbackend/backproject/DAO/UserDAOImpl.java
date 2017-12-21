package com.niit.shopingbackend.backproject.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shopingbackend.backproject.model.Authorization;
import com.niit.shopingbackend.backproject.model.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO
{
	
	@Autowired
	private SessionFactory sessionFactory;
	
    
	
	public boolean addUser(User u)
	{
		Session session=sessionFactory.getCurrentSession();
		
		try
		{
			u.setUserid(u.getUsername());
			Authorization auth=new Authorization();
			auth.setUsername(u.getUserid());
			auth.setRole("ROLE_USER");
			u.setActive(true);
			session.persist(u);
			session.persist(auth);

			return true;
		}
		catch (Exception e)
		{
			
	   e.printStackTrace();	
		return false;
	}
	}



	public List<User> getAllUser() 
	{
		Session ss=sessionFactory.getCurrentSession();
		Query qu=ss.createQuery("from User");
		List<User> listUser=(List<User>)qu.list();
		return listUser;

	}
	
	
	
}
