package com.niit.shopingbackend.backproject.DAO;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shopingbackend.backproject.model.Supplier;



@Repository("supplierDAO")
@Transactional

public class SupplierDAOImpl implements SupplierDAO
{
	
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public boolean addSup(Supplier s) 
	{
	  Session session = sessionFactory.getCurrentSession();		
	  try
	  {
		 
		  s.setSupplierId(s.getSuppliername());
		  session.persist(s);
		  return true;
	  }
	  catch (Exception e) 
	  {
	  e.printStackTrace();
	  return false;
	  }	  
	}

	@SuppressWarnings("unchecked")
	public List<Supplier> getAllSupplier() {
		Session session=sessionFactory.getCurrentSession();
		Query qu=session.createQuery("from Supplier");
		List<Supplier> listsupplier=(List<Supplier>)qu.list();
		return listsupplier;
	}
	
	public boolean update(Supplier s) 
	{
		Session ss=sessionFactory.getCurrentSession();
		try
		{
			ss.update(s);
			return true;
		}
		catch (Exception e) 
		{
		e.printStackTrace();
		return false;
		}
		}
    
	public boolean deleteSup(String id) 
	{
		Session ss=sessionFactory.getCurrentSession();
		ss.delete(getSupplierId(id));
		return true;
	}
	
	public Supplier getSupplierId(String id) 
	{
		Session s=sessionFactory.getCurrentSession();
		return s.get(Supplier.class,id);
	}
}
