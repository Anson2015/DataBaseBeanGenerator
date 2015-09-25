package util.dataBase;

import dao.MySqlDataBaseRelate;
import dao.OracleDataBaseRelate;
import dao.PostgersqlDataBaseRelate;
import dao.interfaces.DataBaseRelate;

public class DataBaseRelateFactory {
	public static DataBaseRelate getDataBaseRelate(String driverName) throws Exception{
		if(driverName.toLowerCase().contains("postgresql")){
			return new PostgersqlDataBaseRelate();
		}else if(driverName.toLowerCase().contains("mysql")){
			return new MySqlDataBaseRelate();
		}else if(driverName.toLowerCase().contains("oracle")){
			return new OracleDataBaseRelate();
		}else{
			throw new Exception("暂不支持该类型的数据库，敬请期待！");
		}
	}
}
