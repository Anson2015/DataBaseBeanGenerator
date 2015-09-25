package util.dataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataBaseUtil {
	/**
	 * 解析ResultSet内容
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public static Map<String,String> getTableContent(ResultSet rs) throws SQLException{
		Map<String,String> map = new LinkedHashMap<String,String>();
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
	private static String changeDBType2JType(String db){
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
		}else if(db.contains("numeric")){
			return "BigDecimal";
		}else{
			return "String";
		}
	}
}
