package dao.interfaces;

import java.sql.Connection;
import java.sql.ResultSet;

import model.xml.XMLModel;

public interface DataBaseRelate {
	
	/**
	 * ����XML�����������ݿ��ȡ����Ϣ
	 * @param model
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public ResultSet getResultSet(XMLModel model,Connection conn) throws Exception;
	
}
