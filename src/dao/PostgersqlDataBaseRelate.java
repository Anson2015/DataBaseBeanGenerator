package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.interfaces.DataBaseRelate;
import model.xml.XMLModel;

public class PostgersqlDataBaseRelate implements DataBaseRelate {
	

	public ResultSet getResultSet(XMLModel model,Connection conn) throws Exception{
		String tableName = model.getTableName();
//		Driver driver = (Driver) ExternClassLoader.getDataBaseDriver(driverPath, className).newInstance();
//		Class.forName("org.postgresql.Driver");
//		Connection conn = ExternClassLoader.getDataBaseDriver(model);
		String sql = " SELECT a.attnum,a.attname AS field,t.typname AS type,"
				+ " a.attlen AS length,a.atttypmod AS lengthvar,a.attnotnull AS notnull "
				+ " FROM pg_class c,pg_attribute a,pg_type t WHERE c.relname = ?"
				+ " and a.attnum > 0 and a.attrelid = c.oid and a.atttypid = t.oid  ORDER BY a.attnum ";
//		System.out.println(sql);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, tableName);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
}
