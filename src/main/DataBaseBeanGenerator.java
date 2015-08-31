package main;

import java.io.File;
import java.io.FileFilter;
import java.sql.ResultSet;
import java.util.Map;

import dao.DataBaseRelate;
import externClassLoader.ExternClassLoader;
import fileUtil.java.GeneratorJavaFile;
import fileUtil.java.GeneratorJavaStr;
import fileUtil.xml.XMLFileAnalysis;
import model.xml.XMLModel;

public class DataBaseBeanGenerator {

	public static void main(String[] args) throws Exception {
		File tempFile = new File("");
		String tempPath = tempFile.getCanonicalPath();
		System.out.println(tempPath);
		tempPath = tempFile.getAbsolutePath();
		System.out.println(tempPath);
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
		ExternClassLoader.getDataBaseDriver(model.getDriverPath(), model.getDriverName());
		DataBaseRelate dbr = new DataBaseRelate();
		ResultSet rs = dbr.getResultSet(model);
		Map<String,String> map = dbr.getTableContent(rs);
		String content = GeneratorJavaStr.getJavaStr(model.getBeanName(), map, model.getBeanJavaFilePath());
		GeneratorJavaFile.translateString2File(content, model.getBeanJavaFilePath(), model.getBeanName()+".java");
	}

}
