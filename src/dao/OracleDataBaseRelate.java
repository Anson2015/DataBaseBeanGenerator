package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.interfaces.DataBaseRelate;
import model.xml.XMLModel;

public class OracleDataBaseRelate implements DataBaseRelate {

	@Override
	public ResultSet getResultSet(XMLModel model, Connection conn) throws Exception {
		String sql = "select column_name as field , data_type as type from all_tab_columns where table_name = ?";
		PreparedStatement p = conn.prepareStatement(sql);
		p.setString(1, model.getTableName());
		ResultSet result = p.executeQuery();
		return result;
	}
}
