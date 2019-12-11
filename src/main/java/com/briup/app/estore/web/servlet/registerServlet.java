package com.briup.app.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.service.impl.CustomerServiceImpl;

/**
 * 注册界面Servlet<br>
 * 判断用户信息是否存在，存在，跳转到当前界面<br>
 * 不存在，将用户信息保存到数据库
 * @author Administrator
 *
 */
@WebServlet("/register")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static String path = null;   
    CustomerServiceImpl customer = new CustomerServiceImpl();
    public registerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		path = "/register.jsp";
		req.getRequestDispatcher(path).forward(req, res);
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name =  req.getParameter("name");
		String password = req.getParameter("password");
		String zip =  req.getParameter("zip");
		String address =  req.getParameter("address");
		String telephone =  req.getParameter("telephone");
		String email =  req.getParameter("email");
		Customer customer2 = new Customer(name, password, zip, address, telephone, email);
		System.out.println(customer2);
		try {
			customer.register(customer2);
			path = "login.jsp";
			req.getRequestDispatcher(path).forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
