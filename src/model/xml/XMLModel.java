package model.xml;

public class XMLModel {
	private String beanName;
	private String beanJavaFilePath;
	private String dbUrl;
	private String dbUserName;
	private String dbPassword;
	private String tableName;
	private String packageName;
	
	public XMLModel() {
		// TODO Auto-generated constructor stub
	}

	public XMLModel(String beanName, String beanJavaFilePath, String dbUrl, String dbUserName, String dbPassword,
			String tableName, String packageName) {
		super();
		this.beanName = beanName;
		this.beanJavaFilePath = beanJavaFilePath;
		this.dbUrl = dbUrl;
		this.dbUserName = dbUserName;
		this.dbPassword = dbPassword;
		this.tableName = tableName;
		this.packageName = packageName;
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

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	
}
