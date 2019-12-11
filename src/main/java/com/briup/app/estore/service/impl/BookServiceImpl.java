package com.briup.app.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.app.estore.bean.Book;
import com.briup.app.estore.mapper.BookMapper;
import com.briup.app.estore.util.MyBatisSqlSessionFactory;

public class BookServiceImpl {
	static MyBatisSqlSessionFactory sqlSessionFactory = new MyBatisSqlSessionFactory();
	static SqlSession sqlSession = sqlSessionFactory.openSession();
	static BookMapper mapper = sqlSession.getMapper(BookMapper.class);
	
	public List<Book> findAllBook(){
		List<Book> books = mapper.selectAll();
		return books;
		
	}
}
