package com.briup.app.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.app.estore.bean.Order;
import com.briup.app.estore.mapper.OrderMapper;
import com.briup.app.estore.service.IOrderService;
import com.briup.app.estore.util.MyBatisSqlSessionFactory;

public class OrderServiceImpl implements IOrderService{
	static MyBatisSqlSessionFactory sqlSessionFactory = new MyBatisSqlSessionFactory();
	static SqlSession sqlSession = sqlSessionFactory.openSession();
	static OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
	private IOrderService iOderService;
	
	@Override
	public void insertOrder(Order order) {
		mapper.insert(order);
		sqlSession.commit();
	}

	@Override
	public List<Order> selectAllOrder() {
		List<Order> selectAll = mapper.selectAll();
		return selectAll;
	}

	@Override
	public List<Order> selectByCustomerId(int customerId) {
		List<Order> selectByCustomerId = mapper.selectByCustomerId(customerId);
		return selectByCustomerId;
	}

	@Override
	public void deleteById(Integer id) {
		LineServiceImpl lineServiceImpl = new LineServiceImpl();
		if(lineServiceImpl.selectByOrderId(id)!=null) {
			
			lineServiceImpl.deleteByOrderId(id);
			
		}
		mapper.deleteByPrimaryKey(id);
		sqlSession.commit();
	}

}
