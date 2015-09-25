package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.interfaces.DataBaseRelate;
import model.xml.Bean;

public class MySqlDataBaseRelate implements DataBaseRelate {

	@Override
	public ResultSet getResultSet(Bean bean, Connection conn) throws Exception {
		String sql = "desc "+bean.getTable()+";";
		PreparedStatement p = conn.prepareStatement(sql);
		ResultSet result = p.executeQuery();
		return result;
	}

}
