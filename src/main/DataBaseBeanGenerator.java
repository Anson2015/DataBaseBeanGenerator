package main;

import java.io.File;
import java.io.FileFilter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Map;

import dao.interfaces.DataBaseRelate;
import model.xml.XMLModel;
import util.dataBase.DataBaseRelateFactory;
import util.dataBase.DataBaseUtil;
import util.driver.ExternClassLoader;
import util.file.java.GeneratorJavaFile;
import util.file.java.GeneratorJavaStr;
import util.file.xml.XMLFileAnalysis;

public class DataBaseBeanGenerator {

	public static void main(String[] args) throws Exception {
		System.out.println("tool is excuting...");
		File tempFile = new File("");
		String tempPath = tempFile.getAbsolutePath();
		File file = new File(tempPath+File.separator);
		FileFilter fileFilter = new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				// TODO Auto-generated method stub
				boolean acceptable = pathname.getName().toLowerCase().endsWith(".xml");
				return acceptable;
			}
		};
//		String temp =file.
		File[] files = file.listFiles(fileFilter);
		XMLModel model = XMLFileAnalysis.getXMLFileContent(files[0].getAbsolutePath());
//		ExternClassLoader.getDataBaseDriver(model.getDriverPath(), model.getDriverName());
//		Class.forName("org.postgresql.Driver");
		Connection conn = ExternClassLoader.getDataBaseDriver(model);
		DataBaseRelate dbr = DataBaseRelateFactory.getDataBaseRelate(model.getDriverName());
		ResultSet rs = dbr.getResultSet(model,conn);
		Map<String,String> map = DataBaseUtil.getTableContent(rs);
		String content = GeneratorJavaStr.getJavaStr(model.getBeanName(), map, model.getBeanJavaFilePath(),model.getPackageName());
		GeneratorJavaFile.translateString2File(content, model.getBeanJavaFilePath(), model.getBeanName()+".java");
		System.out.println("done ");
	}

}
