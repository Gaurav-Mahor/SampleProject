
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile
{
	static FileReader file_reader;
	protected static Properties prop = new Properties();
	
	// Static block to initialize a class variables
	static
	{
		try
		{
			file_reader = new FileReader(System.getProperty("user.dir")+"/Database/Accounts.txt");
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			prop.load(file_reader);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String Key)
	{
		return prop.getProperty(Key);
	}
}
