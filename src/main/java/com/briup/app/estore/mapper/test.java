package com.briup.app.estore.mapper;

import java.util.Map;

import com.briup.app.estore.bean.Orderline;
import com.briup.app.estore.shoppingcart.ShoppingCart;

public class test {
	public static void main(String[] args) throws Exception {
		ShoppingCart sc = new ShoppingCart();
		Orderline line = new Orderline();
		sc.add(line );
		Map<Integer, Orderline> lines = sc.getLines();
	}
}	
