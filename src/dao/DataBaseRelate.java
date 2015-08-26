package dao;

import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import externClassLoader.ExternClassLoader;
import model.xml.XMLModel;

public class DataBaseRelate {
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
}
