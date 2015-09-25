package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.interfaces.DataBaseRelate;
import model.xml.XMLModel;

public class MySqlDataBaseRelate implements DataBaseRelate {

	@Override
	public ResultSet getResultSet(XMLModel model, Connection conn) throws Exception {
		String sql = "desc "+model.getTableName()+";";
		PreparedStatement p = conn.prepareStatement(sql);
		ResultSet result = p.executeQuery();
		return result;
	}

}
