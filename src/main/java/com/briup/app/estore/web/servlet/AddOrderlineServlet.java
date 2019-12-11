package com.briup.app.estore.web.servlet;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.app.estore.bean.Book;
import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.bean.Orderline;
import com.briup.app.estore.shoppingcart.ShoppingCart;

@WebServlet("/AddOrderlineServlet")
public class AddOrderlineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String path = null;    
    public AddOrderlineServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		path = "/index.jsp";
		req.getRequestDispatcher(path).forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("bId"));
		String name = req.getParameter("bName");
		Double price = Double.parseDouble(req.getParameter("bPrice"));
		
		HttpSession session = req.getSession();
		Customer customer = (Customer) session.getAttribute("cus");
		//当获取不到用户信息是跳转到，登录界面，让用户登录
		if(customer==null) {
			path = "/login.jsp";
			req.getRequestDispatcher(path).forward(req, res);
		}
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
		
		Orderline line = new Orderline();
		line.setBook(new Book(id, name, price));
		
		shoppingCart.add(line);
//		Map<Integer, Orderline> lines = shoppingCart.getLines();
//		
//		for (Map.Entry<Integer, Orderline> line1: lines.entrySet()) {
//			System.out.println("key="+line1.getKey()+"value="+line1.getValue());
//		}
		session.setAttribute("shoppingCart", shoppingCart);
		path = "/index.jsp";
		req.getRequestDispatcher(path).forward(req, res);
	}

}
