package com.briup.app.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.app.estore.shoppingcart.ShoppingCart;

/**
 * 修改订单项数量
 * @author Administrator
 *
 */
@WebServlet("/EditOrderline")
public class EditOrderlineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String path = null;   
    public EditOrderlineServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		path = "user/shoppingCart.jsp";
		req.getRequestDispatcher(path).forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer myKey = Integer.parseInt(req.getParameter("line"));
		Integer num = Integer.parseInt(req.getParameter("num"));
		HttpSession session = req.getSession();
		ShoppingCart shoppingCart = (ShoppingCart)session.getAttribute("shoppingCart");
		shoppingCart.updateLine(myKey, num);
		session.setAttribute("shoppingCart", shoppingCart);
		path = "user/shoppingCart.jsp";
		req.getRequestDispatcher(path).forward(req, res);
	}

}
