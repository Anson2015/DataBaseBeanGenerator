package fileUtil.java;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class GeneratorJavaFile {
	
	
	private static final String DateImport = "Date";
	
	/**
	 * @param className 生成java文件的类名称
	 * @param map	属性及其类型
	 * @param filePath 生成文件的路径
	 * @return
	 */
	public static String getJavaStr(String className,Map<String , String> map,String filePath){
		String header = getPackage(filePath);
		String javaStr = getTempJavaStr(className,map,header);
		return javaStr;	
	}
	
	/**
	 * 获取包索引
	 * @param  filePath
	 * @return String packageContent
	 */
	private static String getPackage(String filePath){
		String packageContent = "";
		String path = filePath.replaceAll("\\\\", "/");
		if(path.contains("/src/")){     //如果包含该内容则按照生成为项目路径进行处理，此时自动导入package包
			String temp = path.substring(path.lastIndexOf("/src/")+1);
			packageContent = "package "+temp;
		}
		return packageContent+"\n";
	}
	
	/**
	 * 生成getter和setter并引入相应的包
	 * @param className
	 * @param map
	 * @param packageContent
	 * @return
	 */
	private static String getTempJavaStr(String className,Map<String,String> map,String packageContent){
		String classHeader = "public class "+className+" {\n";
		String classFootter = "";
		Iterator<Entry<String, String>> it = map.entrySet().iterator();
		Boolean flag = false;
		while(it.hasNext()){
			String key = it.next().getKey();
			String value = map.get(key);
			if(DateImport.equalsIgnoreCase(value)){
				if(!flag){
					packageContent+="import java.util.Date;\n";
					flag = true;
				}
			}
			classHeader+="\tprivate "+value+" "+key+";";
			//getter
			classFootter+="\tpublic "+value+" get"+key.substring(0,1).toUpperCase()+key.substring(1)+"(){\n";
			classFootter+="\t\treturn this."+key+"\n";
			classFootter+="\t}\n";
			//setter
			classFootter+="\tpublic void set"+key.substring(0,1).toUpperCase()+key.substring(1)+"("+value+" "+key+"){\n";
			classFootter+="\t\tthis."+key +"= "+key+";\n";
			classFootter+="\t}\n";
		}
		classFootter+="}\n";
		return packageContent+classHeader+classFootter;
	}
}
