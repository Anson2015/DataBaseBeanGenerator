package util.file.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;

public class GeneratorJavaFile {
	
	/**
	 * @param content String 
	 * @param filePath String
	 * @param fileName String 
	 * @throws IOException
	 */
	public static void translateString2File(String content,String filePath,String fileName) throws IOException{
		File file = new File(filePath);
		if(!file.exists()){
			file.mkdirs();
		}
		if(!filePath.endsWith("/")&&!filePath.endsWith("\\")){
			filePath+=File.separator;
		}
		BufferedReader br = new BufferedReader(new StringReader(content));
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath+fileName)));
		int len;
		char[] buffer = new char[1024];
		while((len=br.read(buffer))!=-1){
			bw.write(buffer, 0, len);
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
