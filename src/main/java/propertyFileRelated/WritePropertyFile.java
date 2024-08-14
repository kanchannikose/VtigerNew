package propertyFileRelated;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WritePropertyFile {

	public static void main(String[] args) throws IOException {
		Properties pro=new Properties();
		String filepath=".\\src\\test\\resources\\CommonDataWr";
		FileOutputStream fos=new FileOutputStream(filepath);
		pro.setProperty("Organization", "L&T353");
		pro.setProperty("Leads", "Qspider44");
		
		pro.store(fos, "This is sample data of vtiger");
		fos.close();
		
		System.out.println("Data has been written successfully");

	}

}
