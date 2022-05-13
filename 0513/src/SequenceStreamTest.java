import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Vector;

public class SequenceStreamTest {

	public static void main(String[] args) {
		FileInputStream fis1 = null;
		FileInputStream fis2 = null;
		FileInputStream fis3 = null;
		SequenceInputStream sis = null;
		
		FileOutputStream fos = null;
		Vector<FileInputStream> v = new Vector<>(); // 3개 이상의 파일일 경우
		try {
			fis1 = new FileInputStream("news.txt");
			fis2 = new FileInputStream("cpy_news.txt");
			fis3 = new FileInputStream("info.txt");
			v.add(fis1);   v.add(fis2);   v.add(fis3);
			
			//sis = new SequenceInputStream(fis1,fis2);
			sis = new SequenceInputStream(v.elements());
			fos = new FileOutputStream("merge.txt");
			
			byte[] buff = new byte[1024];
			int len;
			while((len = sis.read(buff)) > 0) {
				fos.write(buff,0,len);
			}
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(sis != null) sis.close();
				if(fos != null) fos.close();
			}catch(IOException e) {}
		}

	}

}
