package com.briup.app.estore.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.briup.app.estore.bean.Customer;

public class CustomerTypeHandler extends BaseTypeHandler<Customer> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Customer parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setString(i, parameter.getAsString());
	}

	@Override
	public Customer getNullableResult(ResultSet rs, String columnName) throws SQLException {
		String string = rs.getString(columnName);
		return new Customer(string);
	}

	@Override
	public Customer getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		String string = rs.getString(columnIndex);
		return new Customer(string);
	}

	@Override
	public Customer getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		String string = cs.getString(columnIndex);
		return new Customer(string);
	}

}
