package com.briup.app.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.app.estore.bean.Order;
import com.briup.app.estore.service.impl.OrderServiceImpl;

@WebServlet("/user/orderRemove")
public class orderRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String path = null;
	OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    public orderRemoveServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		HttpSession session = req.getSession();
		List<Order> AllOrder = (List<Order>) session.getAttribute("AllOrder");
		session.removeAttribute("AllOrder");
		for(int i = 0;i<AllOrder.size();i++) {
			if(AllOrder.get(i).getId().equals(id)) {
				AllOrder.remove(i);
			}
		}
//		System.out.println("======================这是这一次session里面所有的order======================");
//			for (Order order : AllOrder) {
//				System.out.println(order);
//			}
//		System.out.println("======================the  end======================");
		session.setAttribute("AllOrder", AllOrder);
		orderServiceImpl.deleteById(id);
		path = "/estore/user/order.jsp";
//		req.getRequestDispatcher(path).forward(req, res);
		res.sendRedirect(path);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		path = "/user/order.jsp";
		req.getRequestDispatcher(path).forward(req, res);
	}

}
