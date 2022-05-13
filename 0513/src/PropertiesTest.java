import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty("age", "20");
		props.setProperty("name", "hong");
		props.setProperty("height", "184.7");
		props.setProperty("weight", "95.4");
		FileOutputStream out = null;
		
		try {
			out = new FileOutputStream("info.txt");
			props.store(out, "person info");
			
//			out = new FileOutputStream("info.xml");
//			props.storeToXML(out, "person info");
		} catch (IOException e) {
			
		} finally {
			try {
				if(out != null) out.close();				
			}catch(IOException e) {}
		}
	}

}
