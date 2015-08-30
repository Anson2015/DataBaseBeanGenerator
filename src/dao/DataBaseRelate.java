package dao;

import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import externClassLoader.ExternClassLoader;
import model.xml.XMLModel;

public class DataBaseRelate {
	
	/**
	 * 根据XML内容连接数据库获取表信息
	 * @param model
	 * @return
	 * @throws MalformedURLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ResultSet getResultSet(XMLModel model) throws MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		String driverPath = model.getDriverPath();
		String className = model.getDriverName();
		String url = model.getDbUrl();
		String userName = model.getDbUserName();
		String password = model.getDbPassword();
		String tableName = model.getTableName();
		ExternClassLoader.getDataBaseDriver(driverPath, className);
		Connection conn = DriverManager.getConnection(url,userName,password);
		String sql = " SELECT a.attnum,a.attname AS field,t.typname AS type,"
				+ " a.attlen AS length,a.atttypmod AS lengthvar,a.attnotnull AS notnull "
				+ " FROM pg_class c,pg_attribute a,pg_type t WHERE c.relname = ?"
				+ " and a.attnum > 0 and a.attrelid = c.oid and a.atttypid = t.oid  ORDER BY a.attnum ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, tableName);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	
	/**
	 * 解析ResultSet内容
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public Map<String,String> getTableContent(ResultSet rs) throws SQLException{
		Map<String,String> map = new HashMap<String,String>();
		while(rs.next()){
			String field = rs.getString("field");
			String type = rs.getString("type");
			String typeb = changeDBType2JType(type);
			map.put(field, typeb);
		}
		return map;
	}
	
	/**
	 * 将db类型转换为java类型
	 * @param db
	 * @return
	 */
	private String changeDBType2JType(String db){
		if(db.contains("int")){
			if(db.contains("8")){
				return "long";
			}else{
				return "int";
			}
		}else if(db.contains("float")||db.contains("money")){
			return "float";
		}else if(db.contains("timestamp")||db.contains("date")){
			return "Date";
		}else if(db.contains("bool")){
			return "Boolean";
		}else{
			return "String";
		}
	}
	
}
