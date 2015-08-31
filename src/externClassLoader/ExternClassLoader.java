package externClassLoader;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ExternClassLoader {
	
	@SuppressWarnings("resource")
	public static void getDataBaseDriver(String driverPath,String className) throws MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		URL url = new URL("file://"+driverPath);
		URLClassLoader classLoader = new URLClassLoader(new URL[]{url});
		classLoader.loadClass(className+".class").newInstance();			//TODO
	}
}
