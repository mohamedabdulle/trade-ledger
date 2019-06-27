package com.dst.subaccounting.postgre.mapper;

import com.dst.subaccounting.postgre.model.ClientTransactionsDocument;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientTransactionsDocumentMapper implements RowMapper<ClientTransactionsDocument> {

	@Override
	public ClientTransactionsDocument mapRow(ResultSet resultSet, int i) throws SQLException {
		return new BeanPropertyRowMapper<ClientTransactionsDocument>().mapRow(resultSet, i);
	}
}
