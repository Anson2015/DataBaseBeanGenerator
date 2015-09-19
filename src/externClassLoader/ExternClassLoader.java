package externClassLoader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ExternClassLoader {
	
	@SuppressWarnings("resource")
	public static Class<?> getDataBaseDriver(String driverPath,String className) throws MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		URL url = new File(driverPath).toURI().toURL();
		URLClassLoader classLoader = new URLClassLoader(new URL[]{url});
		Class<?> clazz = classLoader.loadClass(className);//TODO
		return clazz;
	}
}
