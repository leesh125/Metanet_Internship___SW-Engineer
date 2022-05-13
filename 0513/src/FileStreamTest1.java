import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamTest1 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			fis = new FileInputStream("news.txt");
			bis = new BufferedInputStream(fis);
			fos = new FileOutputStream("cpy_news.txt");
			bos = new BufferedOutputStream(fos);
			
//			int data;
//			while((data=fis.read()) != -1) {
//				fos.write(data);
//			}
			
			
			byte[] buff = new byte[1024];
			int len;
			while((len=bis.read(buff)) > 0){ 
				fos.write(buff,0,len);
			}
		} catch (IOException e) {
			
		} finally {
			try {
				if(fis != null) fis.close();
				if(fos != null) fos.close();
			} catch(IOException e) {}
		}
		

	}

}
