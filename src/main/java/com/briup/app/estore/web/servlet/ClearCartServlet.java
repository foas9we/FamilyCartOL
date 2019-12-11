package com.briup.app.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.app.estore.shoppingcart.ShoppingCart;

@WebServlet("/ClearCart")
public class ClearCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String path = null;    
    
    public ClearCartServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		System.out.println("测试一");
		HttpSession session = req.getSession();
		ShoppingCart shoppingCart = (ShoppingCart)session.getAttribute("shoppingCart");
		shoppingCart.clearCart();
		session.setAttribute("shoppingCart", shoppingCart);
		path = "/index.jsp";
		req.getRequestDispatcher(path).forward(req, res);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		path = "user/shoppingCart.jsp";
		req.getRequestDispatcher(path).forward(req, res);
	}

}
