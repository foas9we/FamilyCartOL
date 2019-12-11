package com.briup.app.estore.service.impl;


import org.apache.ibatis.session.SqlSession;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.mapper.CustomerMapper;
import com.briup.app.estore.service.ICustomerService;
import com.briup.app.estore.util.MyBatisSqlSessionFactory;

public class CustomerServiceImpl implements ICustomerService{
	
	static MyBatisSqlSessionFactory sqlSessionFactory = new MyBatisSqlSessionFactory();
	static SqlSession sqlSession = sqlSessionFactory.openSession();
	static CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
	private ICustomerService customerService;
	
	@Override
	public Customer selectByName(String name) {
		Customer selectByName = mapper.selectByName(name);
		return selectByName;
	}

	@Override
	public void register(Customer customer) throws Exception {
		if(selectByName(customer.getName())==null) {
			mapper.insert(customer);
			sqlSession.commit();
		}else {
			throw new Exception("用户名已存在");
		}
	}

	@Override
	public Customer login(String name, String password) throws Exception {
		Customer customer = mapper.selectByName(name);
		if(customer==null) {
			throw new Exception("用户不存在");
		}else {
			if(customer.getPassword().equals(password)) {
				return customer;
			}else {
//				System.out.println(customer.getPassword()+"===="+password);
				throw new Exception("密码错误");
			}
		}
	}

	@Override
	public void updateByName(Customer customer) {
		mapper.updateByName(customer);
		sqlSession.commit();
	}

	

}
