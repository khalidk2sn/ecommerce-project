package com.niit.shopingbackend.backproject.DAO;

import java.io.IOException;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.Status;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shopingbackend.backproject.model.Cart;

@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO 
{

	private final Logger logger = LoggerFactory.getLogger(CartDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public List<Cart> getCartList(String username) 
	{
		logger.info("Starting getCartList method in cartDao");
		try 
		{
			Query query = sessionFactory.getCurrentSession()
			.createQuery("from Cart where username = '" + username + "' and status='NEW'");
			return query.list();
	    } 
		
		catch (Exception e) 
		{
			logger.error("Exception occured" + e);
			return (List<Cart>) e;
		}
	}

	public boolean save(Cart cart) 
	{
			logger.info("Starting save method of cartdaoimpl");
				try 
				{
					sessionFactory.getCurrentSession().save(cart);
					return true;
				} 
				catch (Exception e) 
				{
					// TODO: handle exception
					e.printStackTrace();
					logger.error("Exception occured" + e);
					return false;
				}
	}

	public boolean delete(int id) 
	{
		// TODO Auto-generated method stub
		logger.info("Starting delete method of cartdaoimpl");
		try 
		{
			sessionFactory.getCurrentSession().delete(getCartById(id));
			return true;
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
			logger.error("Exception occured" + e);
			return false;
		}

	}

	public boolean update(Cart cart) 
	{
		// TODO Auto-generated method stub
				logger.info("Starting update method in cartDao");
				try 
				{
					sessionFactory.getCurrentSession().update(cart);
					return true;
				} 
				catch (Exception e)
				{
					// TODO: handle exception
					e.printStackTrace();
					logger.error("Exception occured" + e);
					return false;
				}
			
	}

	public int getQuantity(String username, String productname) 
	{
		// TODO Auto-generated method stub
		try 
		{
			logger.info("Starting getquantity method of cartdaoimpl");

			Query query = sessionFactory.getCurrentSession().createQuery("SELECT quantity from Cart WHERE username='"
					+ username + "' and productname='" + productname + "' and status = 'NEW'");
			logger.info("Ending getquantity method of cartdaoimpl");
		/*	query.setString(0,username);
			query.setString(1,productname);
		*/	return (Integer) query.uniqueResult();
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
			logger.error("Exception occured" + e);
			return 0;
		}

	}

	public long getTotalAmount(String username) 
	{
		// TODO Auto-generated method stub
		logger.info("Starting getTotalAmount method in cartDao");
		try 
		{											
			Query query = sessionFactory.getCurrentSession().createQuery(
					"SELECT SUM(price*quantity) FROM Cart where username='" + username + "' and status = 'NEW'");
		
			if (query.uniqueResult() == null) 
			{
				return 0;
			}
			else 
			{
				long result =  (Long) query.uniqueResult();
				return result;
			}

		} catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
			logger.error("Exception occured" + e);
			return 0;
		}

	}

	public Cart getCartByUsername(String username, String productname) 
	{
		// TODO Auto-generated method stub
		try 
		{
			logger.info("Starting getcartbyusername method of cartdaoimpl");

			Query query = sessionFactory.getCurrentSession().createQuery("from Cart WHERE username='" + username
					+ "' and productname='" + productname + "' and status = 'NEW'");
			logger.info("Ending getcartbyusername method of cartdaoimpl");
			return (Cart) query.uniqueResult();
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
			logger.error("Exception occured" + e);
			return null;
		}

	}

	public long getNumberOfProducts(String username) 
	{
		// TODO Auto-generated method stub
		logger.info("Starting getNumberOfProducts method in cartDao");
		try {
			Query query = sessionFactory.getCurrentSession()
					.createQuery("SELECT SUM(quantity) FROM Cart where username='" + username + "' and status = 'NEW'");
			if (query.uniqueResult() == null) {
				return 0;
			} else {
				long result = (Long) query.uniqueResult();
				return result;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("Exception occured" + e);
			 return 0;
		}
	}

	public Cart getCartById(int id) 
	{
		// TODO Auto-generated method stub
				logger.info("Starting getCartById method in cartDao");
				try {
					return sessionFactory.getCurrentSession().get(Cart.class, id);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					logger.error("Exception occured" + e);
					return null;
				}
	}

	public int clearCart(String username) 
	{
		// TODO Auto-generated method stub
				logger.info("Starting clearCart method in cartDao");
				try 
				{
					Query query = sessionFactory.getCurrentSession()
							.createQuery("DELETE from Cart where username = '" + username + "'");
					return query.executeUpdate();

				}
				catch (Exception e) 
				{
					// TODO: handle exception
					e.printStackTrace();
					logger.error("Exception occured" + e);
					return 0;
				}
	}

	public Cart validate(int cartId) throws IOException 
	{
		logger.info("Starting validate method in cartDao");
		Cart cart = getCartById(cartId);
		if (cart == null) {
			throw new IOException(cartId + "");
		}
		update(cart);
		return cart;
	}

}
