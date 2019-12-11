package com.briup.app.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.app.estore.bean.Orderline;
import com.briup.app.estore.mapper.OrderlineMapper;
import com.briup.app.estore.service.ILineService;
import com.briup.app.estore.util.MyBatisSqlSessionFactory;

public class LineServiceImpl implements ILineService{
	static MyBatisSqlSessionFactory sqlSessionFactory = new MyBatisSqlSessionFactory();
	static SqlSession sqlSession = sqlSessionFactory.openSession();
	static OrderlineMapper mapper = sqlSession.getMapper(OrderlineMapper.class);
	private ILineService iLineService;
	@Override
	public void insertOrderLine(Orderline orderline) {
		mapper.insert(orderline);
		sqlSession.commit();
	}
	@Override
	public List<Orderline> selectByOrderId(Integer order_id) {
		List<Orderline> selectByOrderId = mapper.selectByOrderId(order_id);
		return selectByOrderId;
	}
	@Override
	public void deleteByOrderId(Integer order_id) {
		mapper.deleteByOrderId(order_id);
		sqlSession.commit();
	}
	
	
}
