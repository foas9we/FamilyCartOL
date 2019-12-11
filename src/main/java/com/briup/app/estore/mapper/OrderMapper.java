package com.briup.app.estore.mapper;

import com.briup.app.estore.bean.Order;
import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    Order selectByPrimaryKey(Integer id);
    /**
     * 查询所有用户的所有订单
     * @return
     */
    List<Order> selectAll();

    int updateByPrimaryKey(Order record);
    /**
     * 通过用户名查询当前用户的所有订单
     * @param name
     * @return
     */
//    List<Order> selectByName(String name);
    
    /**
     * 通过用户id查找当前用户所有订单
     * @param customerId
     * @return
     */
    List<Order> selectByCustomerId(int customerId);
    
}