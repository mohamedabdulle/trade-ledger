package com.dst.subaccounting.postgre.dao;

import com.dst.subaccounting.postgre.DAO;
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
    NamedParameterJdbcTemplate jdbcTemplate;

    private String tableName;
    private String tableId;
    private String insertStatement;
    private String deleteStatement;
    
    private RowMapper<T> rowMapper;
    
    public GenericDAOImpl(String _tableId, String _tableName, Class<? extends T> cls, RowMapper<T> _rowMapper) {
    	tableId = _tableId;
    	tableName = _tableName;
    	rowMapper = _rowMapper;
    	
    	List<String> fieldNames = Stream.of(cls.getDeclaredFields()).map(Field::getName).collect(Collectors.toList());
    	generateInsertStatement(fieldNames);
    	generateDeleteStatement();
    }
    
    private void generateInsertStatement(List<String> fieldNames) {
    	insertStatement = "INSERT INTO " + tableName + 
    			"(" + fieldNames.stream().collect(Collectors.joining(", ")) + 
    			") values(" + fieldNames.stream().map(f -> ":" + f).collect(Collectors.joining(", ")) + ")";
    }
    private void generateDeleteStatement() {
    	deleteStatement = "DELETE FROM " + tableName + " WHERE " + tableName + "." + tableId + " = :" + tableId;
    }
    
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
    
    public void bulkDelete(String[] tIds) {
    	
    }
    
    @Override
    public List<T> getAll() {
        return jdbcTemplate.query("select * from " + tableName, rowMapper);
    }
}
