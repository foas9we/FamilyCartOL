package com.briup.app.estore.mapper;

import com.briup.app.estore.bean.Customer;
import java.util.List;

public interface CustomerMapper {
	/**
	 * 查找所有用户信息
	 * @return
	 */
	List<Customer> selectAll();
	
	/**
     * 通过主键查找用户
     * @param id
     * @return
     */
    Customer selectByPrimaryKey(Integer id);
    
    /**
     * 通过用户姓名查找用户信息
     * @param name
     * @return
     */
    Customer selectByName(String name);
    
	/**
	 * 通过用户主键，删除用户信息
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(Integer id);
    
    /**
     * 添加用户信息
     * @param record
     * @return
     */
    int insert(Customer record);

    /**
     * 通过主键，更新用户信息
     * @param record
     * @return
     */
    
    int updateByPrimaryKey(Customer record);
    
    /**
     * 通过用户姓名更新用户信息，不可更新用户id和用户名
     * @param customer
     */
    void updateByName(Customer customer);
}