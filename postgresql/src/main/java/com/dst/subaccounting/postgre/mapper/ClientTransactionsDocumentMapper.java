package com.dst.subaccounting.postgre.mapper;

import com.dst.subaccounting.postgre.model.ClientTransactionsDocument;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.Stream;

public class ClientTransactionsDocumentMapper implements RowMapper<ClientTransactionsDocument> {

    @Override
    public ClientTransactionsDocument mapRow(ResultSet resultSet, int i) throws SQLException {
        ClientTransactionsDocument doc = new ClientTransactionsDocument();
        Stream.of(doc.getClass().getDeclaredFields()).forEach(f -> {
            	try {
					f.set(doc, resultSet.getObject(f.getName()));
				} catch (IllegalArgumentException | IllegalAccessException | SQLException e) {
					e.printStackTrace();
				}        		
        });
        return doc;
    }
}
