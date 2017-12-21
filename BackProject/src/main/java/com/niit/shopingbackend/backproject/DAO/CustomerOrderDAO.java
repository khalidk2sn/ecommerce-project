package com.niit.shopingbackend.backproject.DAO;

import java.util.List;
import com.niit.shopingbackend.backproject.model.CustomerOrder;


public interface CustomerOrderDAO 
{
	public boolean addCustomerOrder(CustomerOrder customerOrder);

	public List<CustomerOrder> getAllOrders();

	public CustomerOrder getCustomerOrderById(int id);

	public int changeOrderStatus(int id, String status);
}
