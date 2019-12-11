package com.briup.app.estore.mapper;

import com.briup.app.estore.bean.Orderline;
import java.util.List;

public interface OrderlineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Orderline record);

    Orderline selectByPrimaryKey(Integer id);

    List<Orderline> selectAll();

    int updateByPrimaryKey(Orderline record);
    
    /**
     * 通过订单id查找所有订单项
     * @param order_id
     * @return
     */
    List<Orderline> selectByOrderId(Integer order_id);
    
    /**
	 * 根据订单id，删除订单项
	 * @param order_id
	 */
	public void deleteByOrderId(Integer order_id);
}