package com.briup.app.estore.service;

import java.util.List;

import com.briup.app.estore.bean.Orderline;

public interface ILineService {
	/**
	 * 将订单项信息存入数据库
	 * @param orderline
	 */
	public void insertOrderLine(Orderline orderline);
	
	/**
	 * 通过订单id查找所有订单项
	 * @param order_id
	 * @return
	 */
	public List<Orderline> selectByOrderId(Integer order_id );
	
	/**
	 * 根据订单id，删除订单项
	 * @param order_id
	 */
	public void deleteByOrderId(Integer order_id);
}
