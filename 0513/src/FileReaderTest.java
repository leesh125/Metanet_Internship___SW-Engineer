import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public static void main(String[] args) {
		FileReader fis = null;
		BufferedReader br = null;
		try {
			fis = new FileReader("news.txt");
			br = new BufferedReader(fis);
			int data;
			while((data = br.read()) != -1) {
				System.out.print((char)data);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(br != null) br.close();
			}catch(IOException E) {}
		}
	}

}
