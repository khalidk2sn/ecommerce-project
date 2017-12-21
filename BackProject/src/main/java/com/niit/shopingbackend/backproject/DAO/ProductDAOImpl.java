package com.niit.shopingbackend.backproject.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shopingbackend.backproject.model.Product;


@Repository("productDAO")
@Transactional

public class ProductDAOImpl implements ProductDAO 
{

	private final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean addPro(Product p) 
	{
		 Session session = sessionFactory.getCurrentSession();		
		  try
		  {
			 session.persist(p);
			  return true;
		  }
		  catch (Exception e) 
		  {
		  e.printStackTrace();
		  return false;
		  }	
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAllProduct() 
	{
		Session session=sessionFactory.getCurrentSession();
		Query qu=session.createQuery("from Product");
		List<Product> listproduct=(List<Product>)qu.list();
		return listproduct;
	}

	public boolean update(Product p) 
	{
		Session ss=sessionFactory.getCurrentSession();
		try
		{
			ss.update(p);
			return true;
		}
		catch (Exception e) 
		{
		e.printStackTrace();
		return false;
		}
	}

	public boolean deletePro(int id) 
	{
		Session ss=sessionFactory.getCurrentSession();
		ss.delete(getProductId(id));
		return true;
	}

	public Product getProductId(int id) 
	{
		Session s=sessionFactory.getCurrentSession();
		return s.get(Product.class,id);
	}

	
	
	public List<Product> getProductByCategory(String categoryId) 
	{
    Session session=sessionFactory.getCurrentSession();
    Query query=session.createQuery("from Product where categoryId=?");
    query.setString(0, categoryId);
    List<Product> listCategoryProduct = (List<Product>) query.getResultList();
    return listCategoryProduct;
	}

	public Product getProductByName(String name) {
		// TODO Auto-generated method stub
				logger.info("Starting getProductByName method of ProductDao");
				try {
					Query query = sessionFactory.getCurrentSession().createQuery("from Product where name= '" + name + "'");
					Product product = (Product) query.uniqueResult();

					return product;
				} catch (HibernateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("Exception occured" + e);
					throw e;
				}

	}

	public List<Product> viewByStatus(String status) {
		// TODO Auto-generated method stub
				logger.info("Starting viewByStatus method of ProductDao");
				
					Query query = sessionFactory.getCurrentSession()
							.createQuery("from Product where status like '" + status + "'");
					List<Product> productList = query.list();

					return productList;
								

	}

	
	public Product getProductByID(int id) {
		// TODO Auto-generated method stub
				logger.info("Starting getProductById method of ProductDao");
				try {
					return sessionFactory.getCurrentSession().get(Product.class, id);
				} catch (HibernateException e) {
					// TODO: handle exception
					e.printStackTrace();
					logger.error("Exception occured" + e);
					throw e;
				}

	}

	

	

}







