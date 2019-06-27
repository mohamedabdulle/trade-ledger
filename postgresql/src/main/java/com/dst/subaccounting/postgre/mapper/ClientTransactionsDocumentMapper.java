package com.dst.subaccounting.postgre.mapper;

import com.dst.subaccounting.postgre.model.ClientTransaction;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientTransactionsDocumentMapper implements RowMapper<ClientTransaction> {

	@Override
	public ClientTransaction mapRow(ResultSet resultSet, int i) throws SQLException {
		return new BeanPropertyRowMapper<ClientTransaction>().mapRow(resultSet, i);
	}
}
