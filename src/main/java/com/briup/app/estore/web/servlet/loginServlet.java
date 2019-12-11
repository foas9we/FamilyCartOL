package com.briup.app.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.service.impl.CustomerServiceImpl;
import com.briup.app.estore.shoppingcart.ShoppingCart;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String path = null;   
    CustomerServiceImpl customer = new CustomerServiceImpl();   
    public loginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		System.out.println("测试1");
		path = "/login.jsp";
		req.getRequestDispatcher(path).forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		System.out.println("测试2");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
//		System.out.println(name + "-" + password);
		try {
			Customer cus = customer.login(name, password);//获取到当前登录对象信息
			//将当前登录登录用户保存到session中
			HttpSession session = req.getSession();
			session.setAttribute("cus", cus);
			//获取到当前用户的购物车对象
			ShoppingCart shoppingCart = new ShoppingCart();
			//将购物车存到session中
			session.setAttribute("shoppingCart", shoppingCart);
			path = "/index.jsp";
			req.getRequestDispatcher(path).forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
