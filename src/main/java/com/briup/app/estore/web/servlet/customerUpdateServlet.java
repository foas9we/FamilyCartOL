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

@WebServlet("/customerUpdate")
public class customerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
	static String path = null;    
    public customerUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		path = "user/userinfo.jsp";
		req.getRequestDispatcher(path).forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("测试1");
		HttpSession session = req.getSession();
		Customer customer = (Customer)session.getAttribute("cus");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		String zip = req.getParameter("zip");
		String telephone = req.getParameter("telephone");
		String email = req.getParameter("email");
		customer.setPassword(password);
		customer.setAddress(address);
		customer.setZip(zip);
		customer.setTelephone(telephone);
		customer.setEmail(email);
		session.setAttribute("cus", customer);
		customerServiceImpl.updateByName(customer);
		path = "/index.jsp";
		req.getRequestDispatcher(path).forward(req, res);
	}

}
