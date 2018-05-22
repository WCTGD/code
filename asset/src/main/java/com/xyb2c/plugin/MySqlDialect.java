package com.xyb2c.plugin;



/**
 * MYSQL 数据库分页语句组装实现
 */
public class MySqlDialect implements IDialect {

	public String buildPaginationSql(String originalSql, int offset, int limit) {
		StringBuilder sql = new StringBuilder(originalSql);
		sql.append(" LIMIT ").append(offset).append(",").append(limit);
		return sql.toString();
	}

}
