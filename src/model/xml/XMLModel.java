package model.xml;

public class XMLModel {
	private String driverPath;
	private String driverName;
	private String beanName;
	private String beanJavaFilePath;
	private String dbUrl;
	private String dbUserName;
	private String dbPassword;
	
	public XMLModel() {
		// TODO Auto-generated constructor stub
	}
	
	

	public XMLModel(String driverPath, String driverName, String beanName, String beanJavaFilePath, String dbUrl,
			String dbUserName, String dbPassword) {
		super();
		this.driverPath = driverPath;
		this.driverName = driverName;
		this.beanName = beanName;
		this.beanJavaFilePath = beanJavaFilePath;
		this.dbUrl = dbUrl;
		this.dbUserName = dbUserName;
		this.dbPassword = dbPassword;
	}



	public String getDriverPath() {
		return driverPath;
	}

	public void setDriverPath(String driverPath) {
		this.driverPath = driverPath;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getBeanJavaFilePath() {
		return beanJavaFilePath;
	}

	public void setBeanJavaFilePath(String beanJavaFilePath) {
		this.beanJavaFilePath = beanJavaFilePath;
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

}
