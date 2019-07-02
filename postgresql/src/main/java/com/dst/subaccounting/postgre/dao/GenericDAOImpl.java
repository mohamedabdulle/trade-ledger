package com.dst.subaccounting.postgre.dao;

import com.dst.subaccounting.postgre.DAO;
import com.dst.subaccounting.postgre.mapper.ClientTransactionExtractor;
import com.dst.subaccounting.postgre.model.ClientTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.lang.reflect.*;

@Repository
abstract public class GenericDAOImpl<T> implements DAO<T> {

	@Autowired
	protected NamedParameterJdbcTemplate jdbcTemplate;

	protected String tableName;
	protected String tableId;
	protected String insertStatement;
	protected String deleteStatement;
	protected String deleteAllStatement;

	protected ClientTransactionExtractor clientTransactionExtractor;

	public GenericDAOImpl(String tableId, String tableName, ClientTransactionExtractor clientTransactionExtractor) {
		this.tableId = tableId;
		this.tableName = tableName;
		this.clientTransactionExtractor = clientTransactionExtractor;

		generateInsertStatement();
		generateDeleteStatement();
		generateDeleteAllStatement();
	}

	protected abstract void generateInsertStatement();

	protected abstract void generateDeleteStatement();

	protected abstract void generateDeleteAllStatement();

	@Override
	public void insert(T t) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(t);
		jdbcTemplate.update(insertStatement, namedParameters);
	}

	public void bulkInsert(List<T> ts) {
		this.jdbcTemplate.batchUpdate(insertStatement, SqlParameterSourceUtils.createBatch(ts));
	}

	public void delete(int tId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put(tableId, tId);
		jdbcTemplate.update(deleteStatement, map);
	}

	public void bulkDelete(int[] tIds) {
		HashMap<String, Integer>[] map = new HashMap[tIds.length];
		for (int i = 0; i < tIds.length; i++) {
			map[i] = new HashMap<String, Integer>();
			map[i].put(tableId, tIds[i]);
		}
		jdbcTemplate.batchUpdate(deleteStatement, map);
	}

	public void deleteAll() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		jdbcTemplate.update(deleteAllStatement, map);
	}

	@Override
	public List<ClientTransaction> getAll() {
		String getAllStatement = "select * from ClientTransaction "
				+ "left join TransactionDialog on TransactionDialog.TransactionDialogId = Any(ClientTransaction.TransactionDialogIds)"
				+ "left join RejectDialog on RejectDialog.RejectDialogId = Any(ClientTransaction.RejectDialogIds)";
		return jdbcTemplate.query(getAllStatement, clientTransactionExtractor);
	}
}
