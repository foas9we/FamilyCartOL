package com.briup.app.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.bean.Order;
import com.briup.app.estore.service.impl.OrderServiceImpl;
/**
 * 查询当前用户所有订单
 * @author Administrator
 *
 */
@WebServlet("/user/orderFindAll")
public class orderFindAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String path = null; 
	OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    public orderFindAllServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		System.out.println("测试1");
		HttpSession session = req.getSession();
		Customer customer = (Customer) session.getAttribute("cus");
		System.out.println(customer);
		List<Order> AllOrder = orderServiceImpl.selectByCustomerId(customer.getId());
		session.setAttribute("AllOrder", AllOrder);
//		for (Order order : AllOrder) {
//			System.out.println(order);
//		}
		path = "/user/order.jsp";
		req.getRequestDispatcher(path).forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		System.out.println("测试2");
		path = "/index.jsp";
		req.getRequestDispatcher(path).forward(req, res);
	}

}
