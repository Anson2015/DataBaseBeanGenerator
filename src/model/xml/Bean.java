package model.xml;

public class Bean {
	private String table;
	private String beanName;
	private String beanJavaFilePath;
	private String packageName;
	
	public Bean() {
		// TODO Auto-generated constructor stub
	}
	
	public Bean(String table, String beanName, String beanJavaFilePath, String packageName) {
		super();
		this.table = table;
		this.beanName = beanName;
		this.beanJavaFilePath = beanJavaFilePath;
		this.packageName = packageName;
	}
	
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
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
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
}
