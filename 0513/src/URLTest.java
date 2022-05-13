import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class URLTest {

	public static void main(String[] args) {
		URL url = null;
		String address = "https://ssl.pstatic.net/tveta/libs/1392/1392056/71cba20fa26c83ddc0f5_20220427155203184.jpg";
		FileOutputStream fos = null;
		InputStream is = null;
		
		try {
			url = new URL(address);
			fos = new FileOutputStream("naver.jpg");
			is = url.openStream();
			byte[] buff = new byte[1024];
			int len;
			while((len = is.read(buff)) > 0) {
				fos.write(buff,0,len);
			}
		} catch(IOException e){
			e.printStackTrace();
		} finally {
			try {
				if(fos != null) fos.close();
			} catch(IOException e) {}
		}
	}

}
