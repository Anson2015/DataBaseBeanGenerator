package fileUtil.java;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class GeneratorJavaFile {
	
	
	private static final String DateImport = "Date";
	
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
			String temp = path.substring(path.lastIndexOf("/src/")+1);
			packageContent = "package "+temp;
		}
		return packageContent+"\n";
	}
	
	/**
	 * ����getter��setter��������Ӧ�İ�
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
