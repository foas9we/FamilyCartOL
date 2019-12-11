package com.briup.app.estore.web.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.briup.app.estore.bean.Book;
import com.briup.app.estore.service.impl.BookServiceImpl;
/**
 * 监听器，服务器启动，创建application对象时启动<br>
 * 将数据库中的课本信息去全部查询出来，存到application对象中
 * @author Administrator
 *
 */
@WebListener
public class applicationListener implements ServletContextListener {
	BookServiceImpl bookServiceImpl = new BookServiceImpl();
    public applicationListener() {
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	List<Book> books = bookServiceImpl.findAllBook();
    	sce.getServletContext().setAttribute("books", books);
    }
	
}
