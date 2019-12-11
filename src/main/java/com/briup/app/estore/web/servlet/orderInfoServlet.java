package com.briup.app.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.app.estore.bean.Orderline;
import com.briup.app.estore.service.impl.LineServiceImpl;

@WebServlet("/user/orderInfo")
public class orderInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String path = null; 
	LineServiceImpl lineServiceImpl = new LineServiceImpl();
    public orderInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer order_id = Integer.parseInt(req.getParameter("id"));
		List<Orderline> OrderlineList = lineServiceImpl.selectByOrderId(order_id);
		HttpSession session = req.getSession();
		session.setAttribute("myList", OrderlineList);
		path = "/user/orderinfo.jsp";
		req.getRequestDispatcher(path).forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		path = "/login.jsp";
		req.getRequestDispatcher(path).forward(req, res);
	}

}
