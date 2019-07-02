package com.dst.subaccounting.postgre.dao;

import com.dst.subaccounting.postgre.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
abstract public class GenericDAOImpl<T> implements DAO<T> {

	@Autowired
	protected NamedParameterJdbcTemplate jdbcTemplate;

	protected String tableName;
	protected String tableId;
	protected String insertStatement;
	protected String deleteStatement;
	protected String deleteAllStatement;
	protected String getAllStatement;

	protected ResultSetExtractor<List<T>> resultSetExtractor;

	public GenericDAOImpl(String tableId, String tableName, ResultSetExtractor<List<T>> resultSetExtractor) {
		this.tableId = tableId;
		this.tableName = tableName;
		this.resultSetExtractor = resultSetExtractor;

		generateInsertStatement();
		generateDeleteStatement();
		generateDeleteAllStatement();
		generateGetAllStatement();
	}

	protected abstract void generateInsertStatement();

	protected abstract void generateDeleteStatement();

	protected abstract void generateDeleteAllStatement();
	
	protected abstract void generateGetAllStatement();

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
	public List<T> getAll() {
		return jdbcTemplate.query(getAllStatement, resultSetExtractor);
	}
}
