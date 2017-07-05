package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	//constructor to load the config file
	Properties pro;
	public ConfigDataProvider()
	{
		
		
		File src = new File(System.getProperty("user.dir")+"/Configuration/Config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			
			pro = new Properties();
			
			pro.load(fis);
			
		} 
		catch (IOException e) {
			System.out.println("Error in loading the config file "+e.getMessage());	
		}
		
		
	}
	
	public String getAppUrl()
	{
		return pro.getProperty("url");
		
		
	}
	
	public String getValue(String key)
	{
		return pro.getProperty(key);
	}

}
