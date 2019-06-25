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
    private String deleteAllStatement;
    
    private RowMapper<T> rowMapper;
    
    public GenericDAOImpl(String _tableId, String _tableName, Class<? extends T> cls, RowMapper<T> _rowMapper) {
    	tableId = _tableId;
    	tableName = _tableName;
    	rowMapper = _rowMapper;
    	
    	List<String> fieldNames = Stream.of(cls.getDeclaredFields()).map(Field::getName).filter(f -> f != tableId).collect(Collectors.toList());
    	generateInsertStatement(fieldNames);
    	generateDeleteStatement();
    	generateDeleteAllStatement();
    }
    
    private void generateInsertStatement(List<String> fieldNames) {
    	insertStatement = "INSERT INTO " + tableName + 
    			"(" + fieldNames.stream().collect(Collectors.joining(", ")) + 
    			") values(" + fieldNames.stream().map(f -> ":" + f).collect(Collectors.joining(", ")) + ")";
    }
    
    private void generateDeleteStatement() {
    	deleteStatement = "DELETE FROM " + tableName + " WHERE " + tableName + "." + tableId + " = :" + tableId;
    }
    
    private void generateDeleteAllStatement( ) {
    	deleteAllStatement = "DELETE FROM " + tableName;
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
    
    
    public void bulkDelete(int[] tIds) {
    	HashMap<String,Integer>[] map = new HashMap[tIds.length];
    	for(int i = 0; i < tIds.length;i++){
    	    map[i] = new HashMap<String,Integer>();
    	    map[i].put("commentId", tIds[i]);
        }
    	jdbcTemplate.batchUpdate(deleteStatement, map);
    }

    public void deleteAll(){
        HashMap<String,Object> map = new HashMap<String,Object>();
        jdbcTemplate.update(deleteAllStatement,map);
    }

    public List<T> getTransactionToProcess(){
        //Need to change hard coded sql statement to something that is not hardcoded
         return jdbcTemplate.query("select * from "+ tableName +" WHERE CommentDateTime = '2019-06-23' ORDER BY CommentId DESC", rowMapper);
    }
    
    @Override
    public List<T> getAll() {
        return jdbcTemplate.query("select * from " + tableName, rowMapper);
    }
}
