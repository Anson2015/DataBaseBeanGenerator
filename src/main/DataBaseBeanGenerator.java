package main;

import java.io.File;
import java.io.FileFilter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import dao.interfaces.DataBaseRelate;
import model.xml.Bean;
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
		// 过滤获取.xml文件
		FileFilter fileFilter = new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				// TODO Auto-generated method stub
				boolean acceptable = pathname.getName().toLowerCase().endsWith(".xml");
				return acceptable;
			}
		};
		File[] files = file.listFiles(fileFilter);
		//解析xml文件
		XMLModel model = XMLFileAnalysis.getXMLFileContent(files[0].getAbsolutePath());
		//获取数据库连接
		Connection conn = ExternClassLoader.getDataBaseDriver(model);
		//根据数据库，加载数据库查询
		DataBaseRelate dbr = DataBaseRelateFactory.getDataBaseRelate(model.getDriverName());
		List<Bean> beans = model.getBeans();
		for(Bean bean:beans){
			ResultSet rs = dbr.getResultSet(bean,conn);
			//解析查询结果
			Map<String,String> map = DataBaseUtil.getTableContent(rs);
			//获取java文件内容
			String content = GeneratorJavaStr.getJavaStr(bean.getBeanName(), map, bean.getBeanJavaFilePath(),bean.getPackageName());
			//生成java文件
			GeneratorJavaFile.translateString2File(content, bean.getBeanJavaFilePath(), bean.getBeanName()+".java");
		}
		System.out.println("done ");
	}

}
