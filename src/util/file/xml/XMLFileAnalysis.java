package util.file.xml;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.DefaultAttribute;

import model.xml.Bean;
import model.xml.XMLModel;

public class XMLFileAnalysis {
	
	@SuppressWarnings("unchecked")
	public static XMLModel getXMLFileContent(String path) throws DocumentException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File(path));
		Element element = doc.getRootElement();  //get the root of xml
		List<Element> list = element.elements();
		XMLModel xmlModel = new XMLModel();
		List<Bean> beans = new ArrayList<Bean>();	
		for(Element e :list){
			String propertyName = e.getName();
			if(e.elements().size()>0){
				List<Element> _element = e.elements();
				for(Element temp:_element){	
					Bean bean = new Bean();				
					Iterator<DefaultAttribute> i = temp.attributeIterator();
					while(i.hasNext()){
						DefaultAttribute attr = i.next();
						String attrName = attr.getName();
						String method = "set" +attrName.substring(0, 1).toUpperCase()+attrName.substring(1);
						Method m = bean.getClass().getDeclaredMethod(method, String.class);
						m.invoke(bean,attr.getStringValue());
					}
					beans.add(bean);
				}	
			}else{
				//通过反射调用setter方法构建model属性
				String methodName = "set"+propertyName.substring(0, 1).toUpperCase()+propertyName.substring(1);
				Method m = xmlModel.getClass().getDeclaredMethod(methodName, String.class);
				m.invoke(xmlModel, e.getText());
			}
		}
		xmlModel.setBeans(beans);
		return xmlModel;
	}
	
}
