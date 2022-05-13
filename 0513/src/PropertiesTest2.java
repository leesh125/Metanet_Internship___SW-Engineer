import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest2 {

	public static void main(String[] args) {
		Properties props = new Properties();
		FileInputStream in = null;
		
		try {
			in = new FileInputStream("info.txt");
			props.load(in);
			System.out.println(props.get("age"));
			System.out.println(props.get("name"));
			System.out.println(props.get("height"));
			System.out.println(props.get("weight"));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null) in.close();
			} catch(Exception e) {}
		}

	}

}
