package propertyFileRelated;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	public static void main(String[] args) throws IOException {
	
		Properties pro=new Properties();
		String filepath=".\\src\\test\\resources\\CommonDataRe";
		
		FileInputStream fis=new FileInputStream(filepath);
		
		pro.load(fis);
		
		fis.close();
		
		String browser = pro.getProperty("browser");
		String app = pro.getProperty("app");
		String username = pro.getProperty("username");
		String password=pro.getProperty("password");
		
		for(String key :pro.stringPropertyNames())
		{
			System.out.println(key +"  "+pro.getProperty(key));
		}
		
		
		
	}

}
