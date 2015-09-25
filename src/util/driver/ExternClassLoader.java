package util.driver;

import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

import model.xml.XMLModel;

public class ExternClassLoader {
	
	@SuppressWarnings("resource")
	public static Connection getDataBaseDriver(XMLModel model) throws Exception{
		String driverPath = model.getDriverPath();
		String driverName = model.getDriverName();
		String dbUrl = model.getDbUrl();
		String dbPasswd = model.getDbPassword();
		String dbUserName = model.getDbUserName();
		URL url = new URL("file:"+driverPath);
		URLClassLoader loader = new URLClassLoader(new URL[]{url});
		Driver driver = (Driver)loader.loadClass(driverName).newInstance();
		DriverManager.registerDriver(driver);
//		Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPasswd);
		Properties p = new Properties();
		p.setProperty("user", dbUserName);
		p.setProperty("password", dbPasswd);
		Connection conn = driver.connect(dbUrl,p);
		return conn;
	}
}
