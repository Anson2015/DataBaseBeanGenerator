package fileUtil.xml;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import model.xml.XMLModel;

public class XMLFileAnalysis {
	
	@SuppressWarnings("unchecked")
	public static XMLModel getXMLFileContent(String path) throws DocumentException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File(path));
		Element element = doc.getRootElement();  //get the root of xml
		List<Element> list = element.elements();
		String test = element.getQualifiedName();
		System.out.println(test);
		XMLModel xmlModel = new XMLModel();
		//通过反射调用setter方法构建model属性
		for(Element e :list){
			String propertyName = e.getName();
			String methodName = "set"+propertyName.substring(0, 1).toUpperCase()+propertyName.substring(1);
			Method m = XMLModel.class.getMethod(methodName);
			m.invoke(XMLModel.class, new Object[]{e.getText()});
		}
		return xmlModel;
	}
	
}
