package dao.interfaces;

import java.sql.Connection;
import java.sql.ResultSet;

import model.xml.Bean;

public interface DataBaseRelate {
	
	/**
	 * 根据XML内容连接数据库获取表信息
	 * @param model
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public ResultSet getResultSet(Bean bean,Connection conn) throws Exception;
	
}
