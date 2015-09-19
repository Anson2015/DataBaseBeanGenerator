package fileUtil.java;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class GeneratorJavaStr {
	
	
	private static final String DateImport = "Date";
	private static final String BigDecimal = "BigDecimal";
	/**
	 * @param className ����java�ļ���������
	 * @param map	���Լ�������
	 * @param filePath �����ļ���·��
	 * @return
	 */
	public static String getJavaStr(String className,Map<String , String> map,String filePath){
		String header = getPackage(filePath);
		String javaStr = getTempJavaStr(className,map,header);
		return javaStr;	
	}
	
	/**
	 * ��ȡ������
	 * @param  filePath
	 * @return String packageContent
	 */
	private static String getPackage(String filePath){
		String packageContent = "";
		String path = filePath.replaceAll("\\\\", "/");
		if(path.contains("/src/")){     //���������������������Ϊ��Ŀ·�����д�����ʱ�Զ�����package��
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
	 * ����getter��setter��������Ӧ�İ�
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
