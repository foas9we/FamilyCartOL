package com.briup.app.estore.service;

import java.util.List;

import com.briup.app.estore.bean.Order;

public interface IOrderService {
	/**
	 * 插入订单
	 * @param order
	 */
	public void insertOrder(Order order);
	
	/**
	 * 查询所有订单
	 * @return
	 */
	public List<Order> selectAllOrder();
	
	/**
	 * 通过用户id查询当前用户所有订单
	 * @return
	 */
	public List<Order> selectByCustomerId(int customerId);
	
	/**
	 * 通过id删除订单，并将对应的订单项的订单id设置为null
	 * @param id
	 */
	public void deleteById(Integer id);
}
