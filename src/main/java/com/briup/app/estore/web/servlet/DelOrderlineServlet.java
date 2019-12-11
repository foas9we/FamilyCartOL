package com.briup.app.estore.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.app.estore.bean.Orderline;
import com.briup.app.estore.shoppingcart.ShoppingCart;
/**
 * 删除购物车订单项	
 * @author Administrator
 *
 */
@WebServlet("/DelOrderline")
public class DelOrderlineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String path = null;       
    public DelOrderlineServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer bookId = Integer.parseInt(req.getParameter("bookId"));
		HttpSession session = req.getSession();
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
		
		
//		System.out.println("============before===========");
//		Map<Integer, Orderline> lines = shoppingCart.getLines();
//		
//		for (Map.Entry<Integer, Orderline> line1: lines.entrySet()) {
//			System.out.println("key="+line1.getKey()+"value="+line1.getValue());
//		}
		
		shoppingCart.dropLine(bookId);
		session.setAttribute("shoppingCart", shoppingCart);
		
		
//		System.out.println("============after===========");
//		Map<Integer, Orderline> lines2 = shoppingCart.getLines();
//		
//		for (Map.Entry<Integer, Orderline> line2: lines2.entrySet()) {
//			System.out.println("key="+line2.getKey()+"value="+line2.getValue());
//		}
		path = "user/shoppingCart.jsp";
		req.getRequestDispatcher(path).forward(req, res);
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		path = "user/shoppingCart.jsp";
		req.getRequestDispatcher(path).forward(req, res);
	}

}
