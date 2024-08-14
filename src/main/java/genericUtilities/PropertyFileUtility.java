package genericUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility {
	
	Properties pro;
	
	public PropertyFileUtility()
	{
		File src=new File(".\\src\\test\\resources\\CommonData");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("exception is "+e.getMessage());
		}
	}
	
	public String getUrl()
	{
		String baseurl = pro.getProperty("baseurl");
		return baseurl;
	}
	public String getUsername()
	{
		String username = pro.getProperty("username");
		return username;
	}
	public String getPassword()
	{
		String password = pro.getProperty("password");
		return password;
	}
	public String getFirefoxPath()
	{
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	public String getEdgePath()
	{
		String edgePath=pro.getProperty("edge");
		return edgePath;
		
	}
	

}
