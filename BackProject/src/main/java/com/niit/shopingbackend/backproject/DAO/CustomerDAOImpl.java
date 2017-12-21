package com.niit.shopingbackend.backproject.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shopingbackend.backproject.model.Authorization;
import com.niit.shopingbackend.backproject.model.Customer;
import com.niit.shopingbackend.backproject.model.User;

@Transactional
@Repository("customerDAO")
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private final Logger logger = LoggerFactory.getLogger(CustomerDAOImpl.class);

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		logger.info("Starting getAllCustomer method of customerDao");
		try {
			return sessionFactory.getCurrentSession().createQuery("from Customer").list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

	}

	public boolean save(Customer customer) {
		logger.info("Starting method save() in CustomerDaoImpl");

		try {
			Session session = sessionFactory.getCurrentSession();

			customer.getBillingAddress().setCustomer(customer);
			customer.getShippingAddress().setCustomer(customer);

			session.saveOrUpdate(customer);
			session.saveOrUpdate(customer.getBillingAddress());
			session.saveOrUpdate(customer.getShippingAddress());

			logger.info("Customer details inserted");

			Authorization authorities = new Authorization();
			authorities.setRole("ROLE_USER");
			authorities.setUsername(customer.getUsername());
			session.saveOrUpdate(authorities);
			logger.info("User role assigned");

			User users = new User();
			users.setActive(true);
			users.setUsername(customer.getUsername());
			users.setPassword(customer.getPassword());
			session.saveOrUpdate(users);
			customer.setUser(users);
			session.saveOrUpdate(customer);
			logger.info("User detail inserted");

			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}

	}

	public boolean update(Customer customer) {
		// TODO Auto-generated method stub
		logger.info("Starting update method of customerDao");
		try {
			Session session = sessionFactory.getCurrentSession();

//			customer.getBillingAddress().setCustomer(customer);
//			customer.getShippingAddress().setCustomer(customer);

			session.update(customer);
			session.update(customer.getBillingAddress());
			session.update(customer.getShippingAddress());
			
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		logger.info("Starting delete method of customerDao");
		return false;

	}

	public Customer getUserById(int id) {
		// TODO Auto-generated method stub
		logger.info("Starting getCustomerById method of customerDao");
		try {
			return (Customer) sessionFactory.getCurrentSession().get(Customer.class, id);
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}

	}

	public User getUsersById(int id) {
		// TODO Auto-generated method stub
		logger.info("Starting getUsersById method of customerDao");
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("FROM User where customerId=" + id);
			return (User) query.uniqueResult();
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	public Customer getUserByUserName(String username) {
		// TODO Auto-generated method stub
				logger.info("Starting getCustomerByUsername method of customerDao");
				try {
					Query query = sessionFactory.getCurrentSession()
							.createQuery("from Customer where username= '" + username + "'");
					Customer customer = (Customer) query.uniqueResult();

					return customer;
				} catch (HibernateException e) {
					// TODO: handle exception
					e.printStackTrace();
					throw e;
				}

	}

	public Customer getUserByCustomerName(String name) {
		// TODO Auto-generated method stub
		logger.info("Starting getCustomerByCustomerName method of customerDao");
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from Customer where name= '" + name + "'");
			Customer customer = (Customer) query.uniqueResult();

			return customer;
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}

	}

	public String getUserRole(String username) {
		// TODO Auto-generated method stub
				logger.info("Starting getUserRole method of customerDao");
				try {
					Query query = sessionFactory.getCurrentSession()
							.createQuery("from Authorization where username= '" + username + "'");
					Authorization authorities = (Authorization) query.uniqueResult();
					return authorities.getRole();

				} catch (HibernateException e) {
					// TODO: handle exception
					e.printStackTrace();
					throw e;
				}

	}

	public boolean getStatus(int id) {
		logger.info("Starting getStatus method of customerDao");
		User users = getUsersById(id);
		return users.isActive();

	}

	public int changeStatus(int id) {
		// TODO Auto-generated method stub
				logger.info("Starting changeStatus method of customerDao");
				try {
					User users = getUsersById(id);
					boolean isEnable = users.isActive();

					if (isEnable) {
						Query query = sessionFactory.getCurrentSession()
								.createQuery("UPDATE Users SET enabled = " + false + " WHERE customerId = " + id);
						return query.executeUpdate();
					} else {
						Query query = sessionFactory.getCurrentSession()
								.createQuery("UPDATE Users SET enabled = " + true + " WHERE customerId = " + id);
						return query.executeUpdate();
					}
				} catch (HibernateException e) {
					// TODO: handle exception
					e.printStackTrace();
					throw e;
				}
			}


	}


