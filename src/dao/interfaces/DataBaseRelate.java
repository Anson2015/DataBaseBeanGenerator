package dao.interfaces;

import java.sql.Connection;
import java.sql.ResultSet;

import model.xml.XMLModel;

public interface DataBaseRelate {
	
	/**
	 * 根据XML内容连接数据库获取表信息
	 * @param model
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public ResultSet getResultSet(XMLModel model,Connection conn) throws Exception;
	
}
