package dao.interfaces;

import java.sql.Connection;
import java.sql.ResultSet;

import model.xml.Bean;

public interface DataBaseRelate {
	
	/**
	 * ����XML�����������ݿ��ȡ����Ϣ
	 * @param model
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public ResultSet getResultSet(Bean bean,Connection conn) throws Exception;
	
}
