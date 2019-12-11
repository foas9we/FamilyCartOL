package com.briup.app.estore.service;

import com.briup.app.estore.bean.Customer;

public interface ICustomerService{
	
	/**
	 * 通过用户名查找用户信息
	 * @param name
	 * @return
	 */
	Customer selectByName(String name);
	
	/**
	 * 用户注册
	 * @param customer
	 * @throws Exception
	 */
	void register(Customer customer) throws Exception;
	
	/**
	 * 用户登录
	 * @param name
	 * @param password
	 * @return
	 * @throws Exception
	 */
	Customer login(String name,String password) throws Exception;
	
	 /**
     * 通过用户姓名更新用户信息，不可更新用户id和用户名
     * @param customer
     */
    void updateByName(Customer customer);
}
