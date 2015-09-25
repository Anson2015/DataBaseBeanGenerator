package model.xml;

import java.util.List;

public class XMLModel {
	private String driverName;
	private String driverPath;
	private String dbUrl;
	private String dbUserName;
	private String dbPassword;
	private List<Bean> beans;
	
	public XMLModel() {
		// TODO Auto-generated constructor stub
	}

	public XMLModel(String driverName, String driverPath, String dbUrl, String dbUserName, String dbPassword,
			List<Bean> beans) {
		super();
		this.driverName = driverName;
		this.driverPath = driverPath;
		this.dbUrl = dbUrl;
		this.dbUserName = dbUserName;
		this.dbPassword = dbPassword;
		this.beans = beans;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverPath() {
		return driverPath;
	}

	public void setDriverPath(String driverPath) {
		this.driverPath = driverPath;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getDbUserName() {
		return dbUserName;
	}

	public void setDbUserName(String dbUserName) {
		this.dbUserName = dbUserName;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public List<Bean> getBeans() {
		return beans;
	}

	public void setBeans(List<Bean> beans) {
		this.beans = beans;
	}
}
