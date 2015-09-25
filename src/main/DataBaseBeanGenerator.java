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
		// ���˻�ȡ.xml�ļ�
		FileFilter fileFilter = new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				// TODO Auto-generated method stub
				boolean acceptable = pathname.getName().toLowerCase().endsWith(".xml");
				return acceptable;
			}
		};
		File[] files = file.listFiles(fileFilter);
		//����xml�ļ�
		XMLModel model = XMLFileAnalysis.getXMLFileContent(files[0].getAbsolutePath());
		//��ȡ���ݿ�����
		Connection conn = ExternClassLoader.getDataBaseDriver(model);
		//�������ݿ⣬�������ݿ��ѯ
		DataBaseRelate dbr = DataBaseRelateFactory.getDataBaseRelate(model.getDriverName());
		List<Bean> beans = model.getBeans();
		for(Bean bean:beans){
			ResultSet rs = dbr.getResultSet(bean,conn);
			//������ѯ���
			Map<String,String> map = DataBaseUtil.getTableContent(rs);
			//��ȡjava�ļ�����
			String content = GeneratorJavaStr.getJavaStr(bean.getBeanName(), map, bean.getBeanJavaFilePath(),bean.getPackageName());
			//����java�ļ�
			GeneratorJavaFile.translateString2File(content, bean.getBeanJavaFilePath(), bean.getBeanName()+".java");
		}
		System.out.println("done ");
	}

}
