package fileUtil.java;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class GeneratorJavaStr {
	
	
	private static final String DateImport = "Date";
	private static final String BigDecimal = "BigDecimal";
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
			String temp = path.substring(path.lastIndexOf("/src/")+5);
			packageContent = "package "+temp;
		}
		packageContent = packageContent.replaceAll("/", ".");
		if(packageContent.endsWith(".")){
			packageContent = packageContent.substring(0, packageContent.length()-1);
		}
		return packageContent+";\n\n";
	}
	
	/**
	 * 生成getter和setter并引入相应的包
	 * @param className
	 * @param map
	 * @param packageContent
	 * @return
	 */
	private static String getTempJavaStr(String className,Map<String,String> map,String packageContent){
		String classHeader = "\npublic class "+className+" {\n";
		String classFootter = "";
		Iterator<Entry<String, String>> it = map.entrySet().iterator();
		while(it.hasNext()){
			String key = it.next().getKey();
			String value = map.get(key);
			if(DateImport.equalsIgnoreCase(value)&&(!packageContent.contains("import java.util.Date;\n"))){
				packageContent+="import java.util.Date;\n";	
			}else if(BigDecimal.equalsIgnoreCase(value)&&(!packageContent.contains("import java.math.BigDecimal;\n"))){
				packageContent+="import java.math.BigDecimal;\n";
			}
			classHeader+="\tprivate "+value+" "+key+";\n";
			//getter
			classFootter+="\tpublic "+value+" get"+key.substring(0,1).toUpperCase()+key.substring(1)+"(){\n";
			classFootter+="\t\treturn this."+key+";\n";
			classFootter+="\t}\n";
			//setter
			classFootter+="\tpublic void set"+key.substring(0,1).toUpperCase()+key.substring(1)+"("+value+" "+key+"){\n";
			classFootter+="\t\tthis."+key +"= "+key+";\n";
			classFootter+="\t}\n\n";
		}
		classFootter+="}\n";
		return packageContent+classHeader+"\n"+classFootter;
	}
}
