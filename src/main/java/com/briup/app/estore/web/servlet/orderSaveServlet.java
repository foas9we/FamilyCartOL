package com.briup.app.estore.web.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.bean.Order;
import com.briup.app.estore.bean.Orderline;
import com.briup.app.estore.service.impl.LineServiceImpl;
import com.briup.app.estore.service.impl.OrderServiceImpl;
import com.briup.app.estore.shoppingcart.ShoppingCart;
/**
 * 保存订单的同时保存订单项到数据库
 * @author Administrator
 *
 */
@WebServlet("/orderSave")
public class orderSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String path = null;  
	OrderServiceImpl orderServieImpl = new OrderServiceImpl();
	LineServiceImpl lineServiceImpl = new LineServiceImpl();
    public orderSaveServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		path = "/user/confirmOrder.jsp";
		req.getRequestDispatcher(path).forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			HttpSession session = req.getSession();

			Double cost = (Double) session.getAttribute("cost");
			Map<Integer, Orderline> lines= (Map<Integer, Orderline>) session.getAttribute("lines");
			Customer customer = (Customer) session.getAttribute("cus");
			Order order = new Order();
			order.setCost(cost);
			order.setCustomer(customer);
			order.setOrderdate(new Date());
//			System.out.println("插入之前order的id："+order.getId());
			orderServieImpl.insertOrder(order);
//			System.out.println("插入之后order的id："+order.getId());
			for (Entry<Integer, Orderline> line : lines.entrySet()) {
				Orderline orderline = line.getValue();
				orderline.setOrderId(order.getId());
				System.out.println(orderline);
//				try {	
					lineServiceImpl.insertOrderLine(orderline);
					ShoppingCart shoppingCart = (ShoppingCart)session.getAttribute("shoppingCart");
					session.removeAttribute("shoppingCart");
					ShoppingCart shoppingCart2 = new ShoppingCart();
					session.setAttribute("shoppingCart", shoppingCart2);
//				} catch (Exception e) {
//					Integer id = orderline.getId();
//					System.out.println("拿到的id是："+id);
//					id += 1;
//					orderline.setId(id);
//					lineServiceImpl.insertOrderLine(orderline);
//				}
				
			}
			path = "/index.jsp";
			req.getRequestDispatcher(path).forward(req, res);
	}

}
